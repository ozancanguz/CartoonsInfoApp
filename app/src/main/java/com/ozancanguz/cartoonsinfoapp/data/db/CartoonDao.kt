package com.ozancanguz.cartoonsinfoapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CartoonDao {

    // insert cartoons to db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartoon(cartoonEntity: CartoonEntity)

    // list all data
    @Query("select *from cartoon_table order by id asc")
    fun listAllCartoons(): Flow<List<CartoonEntity>>






}