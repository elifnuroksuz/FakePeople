package com.elifnuroksuz.busonolsun.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.elifnuroksuz.busonolsun.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM profils")
    suspend fun getAll(): List<Product>

    @Query("SELECT * FROM profils WHERE name = :countryName")
    suspend fun findByName(countryName: String): Product

    @Insert
    suspend fun insertAll(list: List<Product>)

}

/*
package com.huawei.countryapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.huawei.countryapp.model.Country
@Dao
interface CountryDao {
    @Query("SELECT * FROM countries")
    suspend fun getAll(): List<Country>

    @Query("SELECT * FROM countries WHERE name = :countryName")
    suspend fun findByName(countryName: String): Country

    @Insert
    suspend fun insertAll(list: List<Country>)

}
 */