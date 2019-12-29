package com.example.a21spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

//AppCompatActivity -> 안드로이드 낮은 버전에서도 활용하기 위해 오버라이딩 하는것.
class MainActivity : AppCompatActivity() {

    //spinner -> 누르면 팝업처럼 리스트가 밑으로 나오는 그것 -> 효율적으로 화면을 관리할 수 있다. -> 2개의 레이아웃을 만들어야 한다.
    var data1 = arrayOf("스피너1-1", "스피너1-2","스피너1-3","스피너1-4","스피너1-5")
    var data2 = arrayOf("스피너2-1", "스피너2-2","스피너2-3","스피너2-4","스피너2-5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //화면 세팅.
        setContentView(R.layout.activity_main)

        //리스트뷰 활용을 위한 어뎁터 설정.
        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        //스피너를 위해 기본 세팅해줘야 하는것.
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        var listener = SpinnerListener()
        spinner.onItemSelectedListener = listener

        //위의 인너클래스 오버라이딩 메소드가 2개이므로 람다식 구성은 불가능하기 때문에 중첩식으로 구성한다.
        spinner2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textView.text = data2[position]
            }
        }

        //버튼으로 스피너값을 활용해보자.
        button.setOnClickListener { view ->
            textView.text = data1[spinner.selectedItemPosition]
            textView.append(data2[spinner2.selectedItemPosition])
        }

    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener {
        //세번째 매개변수 -> 사용자가 선택한 매개변수.
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data1[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}
