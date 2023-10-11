package com.example.myfootappv1

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myfootappv1.api.PlayerApi
import com.example.myfootappv1.api.RetrofitClient
import com.example.myfootappv1.api.models.Player
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class PlayerViewModel(client : Retrofit) : ViewModel() {

    private val api = client.create(PlayerApi::class.java)
    private val _player : MutableLiveData<Player> = MutableLiveData()


    val player : LiveData<Player>
        get() = _player

    fun getPlayer(id : Int){
        viewModelScope.launch {
            _player.value = api.findById(id)
//            Log.d("View model", "getPlayer: iL est la ou pas ? ${_player.value} ")
        }
    }
}

class PlayerViewModelFactory(val context : Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayerViewModel(RetrofitClient.getClient(context)) as T
    }

}