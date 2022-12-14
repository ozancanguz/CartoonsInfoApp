package com.ozancanguz.cartoonsinfoapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.cartoonsinfoapp.data.Repository
import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@HiltViewModel
class CartoonViewModel(private val repository:Repository,

                       application: Application):AndroidViewModel(application){


       var cartoonList=MutableLiveData<Cartoon>()
       var job: Job?=null


    fun requestApiData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getCartoons()
            if(response.isSuccessful){
                cartoonList.postValue(response.body())
            }else{
                Log.d("viewmodel","veri cekilemedi")
            }
        }
    }





}