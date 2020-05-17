package com.fluper.dbtask.database


import androidx.room.*
import com.fluper.dbtask.Converters
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "Product")
class Product constructor() : Serializable {
   // @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
     var id = 0
    @SerializedName("name")
    @ColumnInfo(name = "name")
     var name: String? = null
    @SerializedName("description")
    @ColumnInfo(name = "description")
     var description: String? = null
    @SerializedName("regularPrice")
    @ColumnInfo(name = "regularPrice")
     var regularPrice: Double? = null
    @SerializedName("salePrice")
    @ColumnInfo(name = "salePrice")
     var salePrice: Double? = null
    @TypeConverters(Converters::class)
    @SerializedName("colors")
    @ColumnInfo(name = "colors")
     var colors: ArrayList<String> = ArrayList()


   /* @SerializedName("storesMap")
    @ColumnInfo(name = "storesMap")
    private var storesMap: MutableMap<Int, String>? = null*/

    @SerializedName("imageName")
    @field:ColumnInfo(name = "imageName")
    var imageName: Int? = null

    @Ignore
    constructor(
        Name: String,
        Description: String,
        RegularPrice: Double,
        SalePrice: Double,
        Colors: ArrayList<String>,
        StoresMap: MutableMap<Int, String>,
        Filename: Int
    ) : this() {

        this.imageName = Filename
        this.name = Name
        this.description = Description
        this.regularPrice = RegularPrice
        this.salePrice = SalePrice
       // this.storesMap = StoresMap
        this.colors = Colors

    }
}