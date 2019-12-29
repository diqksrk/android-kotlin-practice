package com.example.a23optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //res폴더에 menu를 만들어주고 옵션메뉴를 오버라이딩 후 세팅한다.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.option_menu, menu)
        menu?.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드메뉴1")
        menu?.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드메뉴2")
//        menu?.add(Menu.NONE, Menu.FIRST + 3, Menu.NONE, "코드메뉴3")

        var sub:Menu? = menu?.addSubMenu("메뉴3")
        sub?.add(Menu.NONE, Menu.FIRST + 3, Menu.NONE, "코드메뉴 3-1")
        sub?.add(Menu.NONE, Menu.FIRST + 3, Menu.NONE, "코드메뉴 3-2")

        //return false면 메뉴가 나타나질 않는다
        return true
    }

    //메뉴를 선택하면 그 선택한 객체가 첫번째 item인자로 오게 되고 그 인자에서 아이디를 뽑아내서 아이디에 맞게 처리.
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        /*
        when (item?.itemId) {
            R.id.item1 ->
                textView.text = "메뉴1을 눌렀습니다"
            R.id.item2_1 ->
                textView.text = "메뉴2-1을 눌렀습니다"
            R.id.item2_2 ->
                textView.text = "메뉴2-2을 눌렀습니다"
            R.id.item3 ->
                textView.text = "메뉴3을 눌렀습니다"
        }
        */
        when (item?.itemId) {
            Menu.FIRST+1 ->
                textView.text = "메뉴1을 눌렀습니다"
            Menu.FIRST+2 ->
                textView.text = "메뉴2을 눌렀습니다"
            Menu.FIRST+3 ->
                textView.text = "메뉴3-1을 눌렀습니다"
            Menu.FIRST+4 ->
                textView.text = "메뉴3-2을 눌렀습니다"
        }

        return super.onOptionsItemSelected(item)
    }
}
