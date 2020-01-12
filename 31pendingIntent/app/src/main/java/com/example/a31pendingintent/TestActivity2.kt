package com.example.a31pendingintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test2.*

class TestActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getIntExtra("data2", 0)

        textView2.text = "data1 : ${data1}\n"
        textView2.append("data2 : ${data2}")
    }
}
