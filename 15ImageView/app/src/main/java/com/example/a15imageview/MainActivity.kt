package com.example.a15imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /* 초기 설명
    src : 기본적으로 보여줄 이미지를 지정하는 속성.
    srcCompat : 안드로이드 5.0 이후에 추가된 속성으로 기본적으로 src와 같지만 벡터방식의 이미지(SVG, PSD 등)--기본적으로 자원을 더 먹지만 이미지가 늘어나거나 줄어들 경우
      뭉개지지 않는 특징을 지닌다, 이미지 자체를 그리기위한 코드가 들어가 있다-- 을 처리할 수 있는 기능이 추가된 속성.

      res 내의 drawable vs mipmap
      -- 안드로이드 런처에 따라서 해당 이미지의 크기가 다 다른데 이를 해결 하기 위해 해상도가 아닌 백터방식으로 이미지를 그리게 된다. 그리고 이러한 이미지는 mipmap폴더에 담기게 되는데 mipmap은
      런처 아이콘용 이미지를 넣는 폴더로 사용한다. 어플 내부에서 사용하는 이미지 폴더는 drawble 폴더에 넣는다.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //res 폴더에 drawble폴더의 ion이미지를 설정한다.
        imageView4.setImageResource(R.drawable.ion)
    }
}
