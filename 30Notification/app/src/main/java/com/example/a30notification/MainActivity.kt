package com.example.a30notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Notification -> 애플리케이션과 별로도 관리되는 메시지이다.
    //메시지를 os에 요청하면 os는 알림창 영역에 알림 메시지를 표기한다.
    //화면을 가지지 않는 실행단위에서 메시지를 표시할때 주로 사용한다.
    //앱에 광고같은 오는 그런거임.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
//            var builder = NotificationCompat.Builder(this)


            var builder = getNotificationBuilder("channel1", "첫 번째 채널")

            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title")
            builder.setContentTitle("Content Text")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(10, notification)

            //Notification Channel을 이용하면 알림 메시지를 채널이라는 그룹으로 묶을 수 있으며
            //같은 채널 별로 메시지에 대한 설정을 따로 할 수 있게 된다.

        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder("channel1", "첫 번째 채널")

            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title 2")
            builder.setContentTitle("Content Text 2")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(20, notification)
        }

        button3.setOnClickListener { view ->
            //채널은 말그대로 그룹화 그룹화해서 노티피케이션을 보여줄것이냐 말것이냐
            var builder = getNotificationBuilder("channel2", "두 번째 채널")

            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title 3")
            builder.setContentTitle("Content Text 3")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(30, notification)
        }
    }
    
    
    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        var builder:NotificationCompat.Builder?  = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            //진동이 오게 할 것이냐
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)

        }else {
            builder = NotificationCompat.Builder(this)
        }

        return builder
    }
}
