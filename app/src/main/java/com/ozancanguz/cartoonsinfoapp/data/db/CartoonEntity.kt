package com.ozancanguz.cartoonsinfoapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon


@Entity(tableName = "cartoon_table")
class CartoonEntity (
    var cartoon:Cartoon
        ){
    @PrimaryKey(autoGenerate = false)
    var id:Int=0
}