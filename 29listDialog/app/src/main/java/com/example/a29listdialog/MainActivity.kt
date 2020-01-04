package com.example.a29listdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //리스트 다이얼로그 -> 3개이상 존재시 다이얼로그에 리스트를 사용한다.

    var data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6")

    //어레이 리스트를 만들고 그걸 맵에 담고 그걸 어레이로 담아서 심플 어뎁터에 적용시켜주면 된다.
    var data2 = arrayOf("토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국")
    var data3 = arrayOf(R.drawable.ion,R.drawable.ion,R.drawable.ion,R.drawable.ion,R.drawable.ion,R.drawable.ion,R.drawable.ion,R.drawable.ion)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            var listener = object:DialogInterface.OnClickListener {
                //첫번째 어떤 버튼을 눌렀느냐 두번째 인덱스 번호.
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    textView.text = "기본 리스트 다이얼로그 : ${data1[which]}"
                }
            }

            //모양만 커스터마이즈 -> 심플 어댑터.


            builder.setItems(data1, listener)
            builder.show()
        }

        button2.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            var list = ArrayList<HashMap<String, Any>>()

            var idx=0
            while (idx < data2.size) {
                var map = HashMap<String, Any>()
                map.put("data2", data2[idx])
                map.put("data3", data3[idx])

                list.add(map)
                idx++
            }

            var keys = arrayOf("data2", "data3")
            var ids = intArrayOf(R.id.textView2, R.id.imageView)

            var adapter = SimpleAdapter(this, list, R.layout.custom_dialog, keys, ids)

            var listener = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    textView.text = "커스텀 리스트 다이얼로그 : ${data2[which]}"
                }
            }

            builder.setAdapter(adapter, listener)

            builder.setNegativeButton("취소", null)
            builder.show()

        }

    }
}
