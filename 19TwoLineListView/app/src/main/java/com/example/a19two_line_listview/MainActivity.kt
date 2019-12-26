package com.example.a19two_line_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("문자열1","문자열2" ,"문자열3" ,"문자열4","문자열5" ,"문자열6")
    var data2 = arrayOf("String1","String2","String3","String4","String5","String6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String, Any>>()

        var idx = 0
        while (idx < data1.size) {
            var map = HashMap<String, Any>()
            map.put("str1", data1[idx])
            map.put("str2", data2[idx])
            list.add(map)

            idx++
        }

        //전에 한거 보기 다 주석처리 해놈 전에
        var key = arrayOf("str1", "str2")
        var ids = intArrayOf(android.R.id.text1, android.R.id.text2) //우리가 만든건 그냥 R.하면 되는데 android os가 가지고 있는건 android를 꼭해야 한다.
        var adapter = SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_2, key, ids)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = data1[position]
        }

    }
}
