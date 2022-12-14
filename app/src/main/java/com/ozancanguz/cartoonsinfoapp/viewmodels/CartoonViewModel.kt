package com.ozancanguz.cartoonsinfoapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.cartoonsinfoapp.data.Repository
import com.ozancanguz.cartoonsinfoapp.data.db.CartoonEntity
import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartoonViewModel @Inject constructor(private val repository:Repository,

                       application: Application):AndroidViewModel(application){

    //   ------------------------for room---------------------
    var listcartoons:LiveData<List<CartoonEntity>> = repository.local.listAllCartons().asLiveData()


    // for room insert db fun

    private fun insertCartoon(cartoonEntity: CartoonEntity){
        viewModelScope.launch(Dispatchers.IO) {
                  repository.local.insertCartoon(cartoonEntity)
        }
    }



 //   -------------------------for retrofit------------------

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