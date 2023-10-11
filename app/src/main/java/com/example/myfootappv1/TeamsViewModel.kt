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
import com.example.myfootappv1.api.models.Team
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.Exception

class TeamsViewModel(client : Retrofit) : ViewModel(){

    private val api = client.create(TeamsApi::class.java)
    private val _teams: MutableLiveData<List<Team>> = MutableLiveData(listOf())
    private val error : MutableLiveData<Int?> = MutableLiveData(null)
    val teams : LiveData<List<Team>>
        get() = _teams


    fun getTeams(){
        viewModelScope.launch {
            try {
                val result = api.getAll()
                _teams.value = result
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