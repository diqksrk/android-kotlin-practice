package com.example.a31pendingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test1.*

class TestActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getIntExtra("data2", 0)

        textView.text = "data1 : ${data1}\n"
        textView.append("data 2 : ${data2}\n")
    }
}
