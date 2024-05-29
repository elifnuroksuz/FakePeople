package com.elifnuroksuz.busonolsun.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "profils")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "username")
    @SerializedName("username")
    val username: String,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    val email: String,

    @ColumnInfo(name = "website")
    @SerializedName("website")
    val website: String,

) : Parcelable

//"name": "Algeria",
//"capital": "Algiers",
//"region": "Africa",
//"currency": "DZD",
//"flag": "https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/dza.png",
//"language": "Arabic"


/*
import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    )
*/
