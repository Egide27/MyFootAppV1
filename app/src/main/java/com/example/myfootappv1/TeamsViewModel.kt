package com.example.myfootappv1

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myfootappv1.api.RetrofitClient
import com.example.myfootappv1.api.TeamsApi
import com.example.myfootappv1.api.models.Player
import com.example.myfootappv1.api.models.Team
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.Exception

class TeamsViewModel(client : Retrofit) : ViewModel(){

    private val api = client.create(TeamsApi::class.java)
    private val error : MutableLiveData<Int?> = MutableLiveData(null)
    private val _teams: MutableLiveData<List<Team>> = MutableLiveData(listOf())
    val teams : LiveData<List<Team>>
        get() = _teams

    private val _team: MutableLiveData<Team> = MutableLiveData()
    val team : LiveData<Team>
        get() = _team

    private val _players: MutableLiveData<List<Player>> = MutableLiveData(listOf())
    val players : LiveData<List<Player>>
        get() = _players

    fun getTeams(){
        viewModelScope.launch {
            try {
                val result = api.getAll()
                _teams.value = result
                Log.i("ICI", "getTeams: ${teams.value!!.size}s")
            }
            catch (e : HttpException){
                error.value = e.code()
            }
            catch (e: Exception){
                Log.d("ERROR", e.message.toString())
            }

        }
    }
    fun getPlayersByTeam(id : Int){
        viewModelScope.launch {
            try {
                val result = api.getPlayersByTeam(id)
                _players.value = result
                Log.i("ICI", "getPlayersByTeam: ${players.value!!.size}")
            }
            catch (e : HttpException){
                error.value = e.code()
            }
            catch (e: Exception){
                Log.d("ERROR", e.message.toString())
            }

        }
    }

    fun getTeam(id : Int){
        viewModelScope.launch {
            try {
                val result = api.getTeam(id)
                _team.value = result
                Log.i("ICI", "getTeam : ${team.value}")
            }
            catch (e : HttpException){
                error.value = e.code()
            }
            catch (e: Exception){
                Log.d("ERROR", e.message.toString())
            }

        }
    }
}

class TeamsViewModelFactory(val context : Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamsViewModel(RetrofitClient.getClient(context)) as T
    }

}