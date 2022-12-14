package com.ozancanguz.cartoonsinfoapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartoonItem(
    @SerializedName("audio")
    val audio: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("designation")
    val designation: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("lorem")
    val lorem: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double
):Parcelable