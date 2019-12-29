package com.example.a22viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 1. viewPager : 좌우로 스와프하면 view를 전환하는 adapterview
    // 2. 화면이 바뀌는 것이 아닌 화면만한 뷰들이 전환되는 개념이다.

    //뷰들을 담을 리스트를 만든다.
    var view_list = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //보여줄 뷰들을 담는다.
        view_list.add(layoutInflater.inflate(R.layout.view1, null))
        view_list.add(layoutInflater.inflate(R.layout.view2, null))
        view_list.add(layoutInflater.inflate(R.layout.view3, null))

        pager.adapter = CustomAdater()

        pager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            //스크롤 될때
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                textView.text = "${position} 번째 뷰가 나타났습니다"
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            //페이지를 클릭하면 반응하는 애.
            override fun onPageSelected(position: Int) {

            }
        })
    }

    inner class CustomAdater : PagerAdapter() {
        override fun getCount(): Int {
            return view_list.size
        }

        //첫번째 보여줄 뷰 객체 주소값, 두번째 -> 안드로이드 os가 자기필요에 의해 만드는 여러가지 객체들이 넘어오게 된다.
        //object가 키워드인데 작은 따움표를 묶으면 키워드를 가지고 변수명을 지을수 있다.
        //이 두 객체 view와 objet가 일치할때만 뷰객체에 보여주겠다는 의미이다.
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        //이 메소드가 항목을 구성하기 위해 호출하는 뷰 -> 여기 안에서 보여주고자 하는 뷰를 페이저 객체에 집어넣고 반환하면 됨.
        //이 메소드의 페이저 에드가 위 메소드(isViewFromObject)의 첫번째 인자값 그리고 return 값이 두번째 인자값으로 들어간다. 그리고 그 외에 안드로이드가 자기 필요에 의해 생성한 메소드를 넘겨줌.
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            pager.addView(view_list[position])

            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            pager.removeView(`object` as View)
        }
    }
}

//로직 1. 뷰페이저를 만들고 담을 3개의 레이아웃을 만든다.
//     2. 뷰리스트를 만들고 담을 뷰들을 넣어준다.
