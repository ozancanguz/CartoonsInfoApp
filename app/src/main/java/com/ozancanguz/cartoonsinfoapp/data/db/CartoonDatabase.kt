package com.ozancanguz.cartoonsinfoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CartoonEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CartoonTypeConverter::class)
abstract class CartoonDatabase: RoomDatabase() {

    abstract fun cartoonDao(): CartoonDao

}