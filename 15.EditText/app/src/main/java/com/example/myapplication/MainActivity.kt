package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            textView.text = editText.text
        }

        button3.setOnClickListener { view ->
//            editText.setText("문자열")
            editText.setText("")
        }

//        var listener1 = EnterListener()
//        editText.setOnEditorActionListener(listener1)

        editText.setOnEditorActionListener { tv, i, keyEvent ->
            textView.text = editText.text
            false
        }//람다식 구현일 경우 수식일 경우 마지막 수식의 결과값이 반환되지만 뭔가 값을 반환해야 한다면 마지막에 그냥 반환값을 적어주면 된다.

        /*
        var watcher = EditWatcher()
        editText.addTextChangedListener(watcher) //TextChangedListener에 설정 후 텍스트가 변화할때마다 onTextChanged를 호출한다. 이 경우 오바리이딩 할 메소드가
        //3개가 존재하므로 람다식은 존재하지 않는다.
         */

        editText.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textView.text = s
            }
        }) //리스너에 오브젝트를 직접적으로 넣어준다.
    }

    inner class EnterListener: TextView.OnEditorActionListener {
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
            textView.text = editText.text
            return true  //enter key 여부, true일 경우 자동으로 키보드가 내려가지 않고 false일 경우 내려간다.
        }
    }

    inner class EditWatcher:TextWatcher {
        //문자열이 바뀐 후.
        override fun afterTextChanged(s: Editable?) {

        }

        //문자열이 바뀌기 전.
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        //문자열이 바뀌는 중간.
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textView.text = s
        }
    }

    //로직 1. 먼저 이너클래스 조작 후 리스너 작성.
    //     2. 람다식을 사용해서 리스너 작성.
    //     3. 리스너로 인너클래스를 작성해서 해당 인너클래스를 사용
    //     4. 오브젝트를 사용해서 리스너를 넣어준다.
}
