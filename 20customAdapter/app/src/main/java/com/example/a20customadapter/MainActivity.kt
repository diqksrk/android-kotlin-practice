package com.example.a20customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var data = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5","데이터6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.textView2, data)
        var adapter = ListAdapter()
        listView.adapter = adapter

        //버튼마다 이벤트를 처리하기 위해서 어뎁터를 만들어야 함.
    }

    inner class ListAdapter : BaseAdapter() {

        var listener = BtnListener()
        //이 메소드가 반환하는 정수값으로 리스트뷰의 갯수를 정함.
        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any? { //?의 의미 -> 널도 반환할수 있다.
            return null
        }

        //항목을 구성하기 위해 만든 뷰객체를 반환하기 위해 사용. 항목을 대표하는 id값을 반환하는 값으로 사용
        override fun getItemId(position: Int): Long {
            return 0
        }

        //중요한 메소드.
        override fun getView(position: Int, p1: View?, parent: ViewGroup?): View? {
            var convertView:View? = p1//:View클래스 타입이라는 것과 ? 은 널값도 반환한다는 것.

            if (p1 == null) { // 2번째 매개변수가 재사용 가능한 뷰인데 이게 널값이라는것은 재사용 가능한 뷰가 없다는 것으으므로 row.xml을 가지고 view를 만든다.
                convertView = layoutInflater.inflate(R.layout.row, null)
            }

            //아이디가 이거인 텍스트 뷰를 추출한다.
            var text:TextView? = convertView?.findViewById<TextView>(R.id.textView2)
            var button1:Button? = convertView?.findViewById<Button>(R.id.button1)
            var button2:Button? = convertView?.findViewById<Button>(R.id.button2)

            button1?.setOnClickListener(listener)
            button2?.setOnClickListener(listener)

            //tag를 이용해서 객체를 세팅해서 몇번째 로우 버튼인지 알아낸다. -> 버튼 인덱스를 저장하고 나중에 추출해서 처리한다.
            button1?.tag = position
            button2?.tag = position

            //그리고 문자열을 세팅한다.
            text?.text = data[position]

            //반환한다.
            return convertView
        }
    }

    inner class BtnListener : View.OnClickListener {
        override fun onClick(v: View?) {

            var position = v?.tag as Int

            when (v?.id) {
                R.id.button1 ->
                    textView.text = "${position} : 첫 번째 버튼을 눌렀습니다\n"
                R.id.button2 ->
                    textView.text = "${position} : 두 번째 버튼을 눌렀습니다\n"
            }
        }
    }
}
