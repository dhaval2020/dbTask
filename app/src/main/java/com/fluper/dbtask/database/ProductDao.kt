package com.fluper.dbtask.database

import androidx.room.*


@Dao
interface ProductDao {
    @get:Query("SELECT * FROM Product")
    val productList: List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product?)

    @Delete
    fun delete(product: Product?)

    @Update
    fun update(product: Product?)
}