package com.example.a25popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //popup menu는 개발자가 원할때 원하는 곳에 메뉴를 띄울 수 있다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var pop = PopupMenu(this, textView)

            menuInflater.inflate(R.menu.popup_menu, pop.menu)

//            var listener = PopupListener()
//            pop.setOnMenuItemClickListener(listener)

            pop.setOnMenuItemClickListener { item->
                when (item.itemId) {
                    R.id.item1 ->
                        textView.text = "메뉴 1번을 눌렀습니다"
                    R.id.item2 ->
                        textView.text = "메뉴 2번을 눌렀습니다"
                    R.id.item3 ->
                        textView.text = "메뉴 3번을 눌렀습니다"
                }
                false //람다식일 경우 리턴값을 리턴 안 적고 값만 적으면 리턴이 된다.
            }

            pop.show()
        }
    }

    inner class PopupListener:PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.item1 ->
                    textView.text = "메뉴 1번을 눌렀습니다."
                R.id.item2 ->
                    textView.text = "메뉴 2번을 눌렀습니다."
                R.id.item3 ->
                    textView.text = "메뉴 3번을 눌렀습니다."
            }
            return false
        }
    }


}
