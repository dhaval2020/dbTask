package com.fluper.dbtask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fluper.dbtask.database.Product
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var btnCreateProduct1: Button
    private lateinit var btnCreateProduct2: Button
    private lateinit var btnCreateProduct3: Button
    private lateinit var btnShowProduct: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fileData = "[{\"name\":\"mobile\",\"description\":\"android phones\",\"regularPrice\":40000,\"salePrice\":20500,\"colors\":[red, blue, green],\"storesMap\":\"{1=kalagi stores, 3=bharat store, 2=azad stores}\",\"imageName\":2131427332},{\"name\":\"car\",\"description\":\"maruti cars\",\"regularPrice\":400000,\"salePrice\":1200000,\"colors\":[red, blue, green],\"imageName\":2131427328},{\"name\":\"laptop\",\"description\":\"branded laptops\",\"regularPrice\":40000,\"salePrice\":50000,\"colors\":[red, blue, green],\"imageName\":2131427331}]"
        Log.e("test",fileData)
        val gson = GsonBuilder().create()
        val productList = gson.fromJson(fileData , Array<Product>::class.java).toList()

        // Toast.makeText(this@MainActivity,jsonArray.toString(),Toast.LENGTH_LONG).show()
        btnCreateProduct1 = findViewById(R.id.btncpd1) as Button
        btnCreateProduct1.setOnClickListener {
            for (i in 0..productList.size-1) {
                if (productList.get(i).name.equals("mobile"))
                    DatabaseClient.getInstance(getApplicationContext())!!.appDatabase!!.productDao()!!.insert(
                        productList.get(i)
                    )
            }


        }
        btnCreateProduct2 = findViewById(R.id.btncpd2) as Button
        btnCreateProduct2.setOnClickListener {
            for (i in 0..productList.size-1) {
                if (productList.get(i).name.equals("car"))
                    DatabaseClient.getInstance(getApplicationContext())!!.appDatabase!!.productDao()!!.insert(
                        productList.get(i)
                    )
            }
        }
        btnCreateProduct3 = findViewById(R.id.btncpd3) as Button
        btnCreateProduct3.setOnClickListener {
            for (i in 0..productList.size-1) {
                if (productList.get(i).name.equals("laptop"))
                    DatabaseClient.getInstance(getApplicationContext())!!.appDatabase!!.productDao()!!.insert(
                        productList.get(i)
                    )
            }
        }
        btnShowProduct = findViewById(R.id.btnshowproduct) as Button
        btnShowProduct.setOnClickListener {
           startActivity(Intent(this@MainActivity,ShowProductActivity::class.java))
        }

    }

   /* fun getJsonData(): JSONArray {
        val product1 = JSONObject()
        try {
            //  product1.put("id", 1)
            product1.put("name", "mobile")
            product1.put("description", "android phones")
            product1.put("regularPrice", 40000)
            product1.put("salePrice", 50000)
             var colorArray: ArrayList<String> = ArrayList()
            colorArray.add("red")
            colorArray.add("blue")
            colorArray.add("green")



         //   val colorArray=arrayOf("blue","red","black")
          *//*  val colorObject1 = JSONObject()
            val colorObject2 = JSONObject()
            val colorObject3 = JSONObject()
            colorObject1.put("color1", "blue")
            colorObject2.put("color2", "red")
            colorObject3.put("color3", "black")
            colorArray.put(colorObject1)
            colorArray.put(colorObject2)
            colorArray.put(colorObject3)*//*

       //     val gson = Gson()
          //  val json = gson.toJson(listOf("red", "blue","green"))
            product1.put("colors",listOf("red", "blue","green"))
            val storesMap: MutableMap<Int, String> =
                HashMap()
            storesMap.put(1, "kalagi stores")
            storesMap.put(2, "azad stores")
            storesMap.put(3, "bharat store")
            product1.put("storesMap", storesMap)
            product1.put("imageName", R.mipmap.mobile)
        } catch (e: JSONException) { // TODO Auto-generated catch block
            e.printStackTrace()
        }
        val product2 = JSONObject()
        try {
            //  product2.put("id", 2)
            product2.put("name", "car")
            product2.put("description", "maruti cars")
            product2.put("regularPrice", 400000)
            product2.put("salePrice", 500000)
           *//* var colorArray: ArrayList<String> = ArrayList()
            colorArray.add("red")
            colorArray.add("blue")
            colorArray.add("green")*//*
            product2.put("colors",listOf("red", "blue","green"))
            val storesMap: MutableMap<Int, String> =
                HashMap()
            storesMap.put(1, "kiran motors")
            storesMap.put(2, "abhi motors")
            storesMap.put(3, "kabhi motors")
          //  product2.put("storesMap", storesMap)
            product2.put("imageName", R.mipmap.car)
        } catch (e: JSONException) { // TODO Auto-generated catch block
            e.printStackTrace()
        }
        val product3 = JSONObject()
        try {
            // product3.put("id", 3)
            product3.put("name", "laptop")
            product3.put("description", "branded laptops")
            product3.put("regularPrice", 40000)
            product3.put("salePrice", 50000)
           *//* val gson = Gson()
            val json = gson.toJson(listOf("red", "blue","green"))*//*
            product3.put("colors",listOf("red", "blue","green"))
            val storesMap: MutableMap<Int, String> =
                HashMap()
            storesMap.put(1, "akshay computers")
            storesMap.put(2, "salman computers")
            storesMap.put(3, "shahrukh computers")
         //   product3.put("storesMap", storesMap)
            product3.put("imageName", R.mipmap.laptop)
        } catch (e: JSONException) { // TODO Auto-generated catch block
            e.printStackTrace()
        }
        val jsonArray = JSONArray()

        jsonArray.put(product1)
        jsonArray.put(product2)
        jsonArray.put(product3)
        return jsonArray
    }*/
}
