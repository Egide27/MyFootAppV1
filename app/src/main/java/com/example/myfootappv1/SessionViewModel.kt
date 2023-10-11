package com.example.myfootappv1

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myfootappv1.api.RetrofitClient
import com.example.myfootappv1.api.SessionApi
import com.example.myfootappv1.api.models.Session
import com.example.myfootappv1.api.models.Team
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.Exception

class SessionViewModel(client : Retrofit) : ViewModel() {

    private val api = client.create(SessionApi::class.java)
    private val _sessions: MutableLiveData<List<Session>> = MutableLiveData(mutableListOf())
    private val error : MutableLiveData<Int?> = MutableLiveData(null)
    val sessions : LiveData<List<Session>>
        get() = _sessions

    fun getTeams(){
        viewModelScope.launch {
            try {
                val result = api.getAll()
                _sessions.value = result
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

class SessionViewModelFactory(val context : Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SessionViewModel(RetrofitClient.getClient(context)) as T
    }

}