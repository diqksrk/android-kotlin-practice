package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //두번째 매개변수 레이아웃 안에서 나옴. 그걸 볼려면 ctrl + 클릭하면 됨. simple_list_item1을 컨트롤 + 클릭하면 됨.
        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        //우리가 만듬 layout -> row1을 리스트뷰가 나타날 레이아웃으로 설정한다. 3번째는 2번째 레이아웃에 3번째 녀석에게 데이터를 지정하겠다의 뜻이다.
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, data) //안드로이드 어플리케이션 오류 발생하면 강제 종료 된다. -> 로그캣에 오류 메시지가 표시 된다. 안드로이드가 알고 있는 아이디로 해야함.
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = data[position]
        }
    }
}
