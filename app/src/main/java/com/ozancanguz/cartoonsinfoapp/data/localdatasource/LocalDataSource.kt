package com.ozancanguz.cartoonsinfoapp.data.localdatasource

import com.ozancanguz.cartoonsinfoapp.data.db.CartoonDao
import com.ozancanguz.cartoonsinfoapp.data.db.CartoonEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val cartoonDao: CartoonDao) {


    // list all cartoons
    fun listAllCartons(): Flow<List<CartoonEntity>> {

        return cartoonDao.listAllCartoons()
    }

    // insert cartoon to db
    suspend fun insertCartoon(cartoonEntity: CartoonEntity){
        return cartoonDao.insertCartoon(cartoonEntity)
    }


}