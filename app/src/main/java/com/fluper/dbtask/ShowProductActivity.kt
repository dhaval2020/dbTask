package com.fluper.dbtask

import android.content.Context
import android.icu.lang.UCharacter
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fluper.dbtask.database.Product
import com.passport.employee.DataAdapter


class ShowProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product)
        recyclerView = findViewById(R.id.RecyclerView) as RecyclerView
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setLayoutManager(mLayoutManager)
        val productListFromDb=        DatabaseClient.getInstance(getApplicationContext())!!.appDatabase!!.productDao()!!.productList
        loadList(productListFromDb,this)

    }
    companion object{
        lateinit var recyclerView: RecyclerView
        lateinit var adapter: DataAdapter
        fun loadList(productList: List<Product>,context: Context)
        {
            adapter = DataAdapter(context, productList)
            val itemDecor = DividerItemDecoration(context,VERTICAL)
            recyclerView.addItemDecoration(itemDecor)
            recyclerView.setAdapter(adapter)
        }
    }
}
