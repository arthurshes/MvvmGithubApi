package com.example.newskotlin2023.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newskotlin2023.Models.RepoData
import com.example.newskotlin2023.Models.RepoList
import com.example.newskotlin2023.network.ApiService
import com.example.newskotlin2023.network.RetroInstanse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
     lateinit var repoLiveData:MutableLiveData<RepoList>

    init {
        repoLiveData= MutableLiveData()

    }

    fun getLiveData():MutableLiveData<RepoList>{
        return repoLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
         val retroInstanse = RetroInstanse.getRetroInstanse().create(ApiService::class.java)

        val response = retroInstanse.getDataFromApi("ny")
            repoLiveData.postValue(response)
        }
    }
}