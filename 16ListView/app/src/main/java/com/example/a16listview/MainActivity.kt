package com.example.a16listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //어떤 항목들을 보여줄지 리스트나 문자열 배열을 준비해야 한다. 리스트 뷰를 사용하기 위해서.

    var data = arrayOf("리스트1","리스트2","리스트3","리스트4","리스트5","리스트6","리스트7",
                        "리스트8","리스트9","리스트10","리스트11","리스트12")
    /*
    1. adapter view : 뷰를 구성하기 위해 개발자가 코드를 통해 결정해 줘야 하는 항목이 있는 뷰를 통칭해서 AdapterView라고 한다. -> 이러하 것들이 리스트 뷰이다.
       adapter property : 리스트뷰를 구성하기 위한 어뎁터 객체를 설정한다.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //context : 어떠하 작업을 하기 위해서 필요한 정보가 담겨있는 객체.
        //안드로이드 -> 화면 or os and application 정보가 담겨 있는.
        //어뎁터에 설정해줘야 해당 리스트에 배열이 표현된다.
        //매개변수 : 첫번째 컨텍스트 : 지금 배열 정보를 담고 있는 객체, 어떻게 표현할것인가의 디자인 양식, 표현할 데이터를 담고 있는 객체
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        //xml에 리스트뷰를 불러와서 해당 어뎁터를 세팅해준다.
        listVew.adapter = adapter

        /*
        //리스너 설정.
        var listener = ListListener()
        listVew.setOnItemClickListener(listener)
         */

        //밑에 보면 리스너가 오버라이딩한 메소드가 1개이므로 람다식 설정이 가능하다.
        listVew.setOnItemClickListener { parent, view, position, id ->
            textView.text = data[position]
        }
    }

    inner class ListListener : AdapterView.OnItemClickListener {
        //posiotion 매개변수 -> 사용자가 터치한 인덱스가 몇번째인지 이걸 이용해서 작업 진행.
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data[position]
        }
    }
}
