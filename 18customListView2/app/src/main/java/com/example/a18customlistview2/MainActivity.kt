package com.example.a18customlistview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //정수값 인트 배열
    var imgRes = intArrayOf(R.drawable.ion, R.drawable.ion, R.drawable.ion, R.drawable.ion, R.drawable.ion, R.drawable.ion, R.drawable.ion, R.drawable.ion)
    var data1 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    var data2 = arrayOf("togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //세팅할 데이타가 1개가 아닌 2개 이상일 경우 simpleadapter을 사용한다.
        var list = ArrayList<HashMap<String, Any>>()

        var idx = 0
        while (idx < data1.size) {
            var map = HashMap<String ,Any>()

            map.put("flag", imgRes[idx])
            map.put("data1", data1[idx])
            map.put("data2", data2[idx])

            list.add(map)
            idx++
        }

        //데이터를 넣어주기 위한 세팅.
        var keys = arrayOf("flag", "data1", "data2")
        var ids = intArrayOf(R.id.imageView, R.id.textView2, R.id.textView3)

        //keys이름으로 데이터를 뽑아내서 ids에 넣어준다.
        var adapter = SimpleAdapter(this, list, R.layout.row, keys, ids)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            textView2.text=data1[position]
        }

    }
}
