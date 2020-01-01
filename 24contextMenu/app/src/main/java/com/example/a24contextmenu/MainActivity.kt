package com.example.a24contextmenu

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("리스트1","리스트2","리스트3","리스트4","리스트5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${position}번째 항목을 터치했습니다."
        }

        //뷰객체를 넣어주면 됨
        registerForContextMenu(textView)
        //리스트뷰에 컨텍스를 세팅한다.
        registerForContextMenu(listView)
    }

    //목적 : 컨텍스트 메뉴 사용
    //왜 사용 ? -> 뷰를 길게 누르면 메뉴가 나오게 하려고.  -> 위에서 정의한 텍스트뷰를 길게 누르면 팝업창처럼 메뉴 선택창이 뜬다.
    //사용자가 길게 누른 뷰의 객체가 2번째 변수로 들어온다
    // 어떻게 ? -> 해당 메소드를 오버라이딩해서..
    //어떤 뷰든지 상관없이 길게 누른 뷰를 컨텍스트에서 가져오므로 listview_menu.xml과 textview_menu.xml을 컨텍스트에 등록해서 이 메소드에 같이 사용할수 있다.
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id){
            R.id.textView ->{
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.textview_menu, menu)
            }

            R.id.listView ->{
                menu?.setHeaderTitle("리스트뷰의 메뉴")
                menuInflater.inflate(R.menu.listview_menu, menu)

                //몇번째를 누른지 알기 위해서 어덱터컨텍스트메뉴인포로 형변환해서 사용해야 한다.(메뉴인포를 활용한다)
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
                //사용자가 길게누른 항목의 인덱스 번호에 따라서 다르게 가야 하겠다 할때 사용해면 된다.
                if (info.position % 2 == 0) {
                    menu?.add(Menu.NONE, Menu.FIRST + 100, Menu.NONE, "리스트뷰 메뉴3")
                }
            }
        }
    }

    //선택창을 나타내게 하기 위해서.
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.textview_item1 ->
                textView.text = "텍스트뷰의 컨텍스트 메뉴1"
            R.id.textview_item2 ->
                textView.text = "텍스트뷰의 컨텍스트 메뉴2"
            R.id.listview_item1 -> {
                textView.text = "리스트뷰의 컨텍스트 메뉴1\n"

                //mp3에서 해당항목 삭제를 눌렀을때 몇번째 항목인지 알아야 하므로.
                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position}번째 항목")
            }

            R.id.listview_item2 -> {
                textView.text = "리스트뷰의 컨텍스트 메뉴2\n"
                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position}번째 항목")
            }
        }

        return super.onContextItemSelected(item)
    }
}
