package com.fluper.dbtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
lateinit var btnClose:Button
    lateinit var ivImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        btnClose=findViewById(R.id.btnclose)
        btnClose.setOnClickListener { finish() }
        ivImage=findViewById(R.id.ivlageimage)
        val name = intent.getIntExtra("image",R.drawable.ic_launcher_background)
        ivImage.setImageResource(name)

    }
}
