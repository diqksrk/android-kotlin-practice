package com.example.a26actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //ActionBar -> 화면 상단에 배치 된 바 부분을 의미하며 optionmenu의 항목의 일부를 배치할수 있다.
    //showAsAction -> never(기본) 메뉴 액션바 표기 x 그 외..
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        //search... 글자 바꾸기
        var search_item:MenuItem? = menu?.findItem(R.id.Item5)
//        var search_view:SearchView = search_item?.actionView as SearchView
        //원래라면 support.v7으로 해야 한다.
        var search_view:android.widget.SearchView = search_item?.actionView as android.widget.SearchView

        search_view.queryHint = "검색어를 입력해주세요."

        search_view.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                textView.text = newText
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                textView2.text = query
                //return true일 경우 검색을 눌렀을때 키보드가 내려가지 않게 된다.
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.Item1 ->
                textView.text = "메뉴1을 눌렀습니다"
            R.id.Item2 ->
                textView.text = "메뉴2을 눌렀습니다"
            R.id.Item3 ->
                textView.text = "메뉴3을 눌렀습니다"
            R.id.Item4 ->
                textView.text = "메뉴4을 눌렀습니다"
        }
        return super.onOptionsItemSelected(item)
    }
}
