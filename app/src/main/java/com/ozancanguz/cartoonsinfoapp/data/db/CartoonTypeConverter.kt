package com.ozancanguz.cartoonsinfoapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon

class CartoonTypeConverter {


    var gson = Gson()

    @TypeConverter
    fun CartoonToString(cartoon: Cartoon): String {
        return gson.toJson(cartoon)
    }

    @TypeConverter
    fun stringToCartoon(data: String): Cartoon {
        val listType = object : TypeToken<Cartoon>() {}.type
        return gson.fromJson(data, listType)
    }
}