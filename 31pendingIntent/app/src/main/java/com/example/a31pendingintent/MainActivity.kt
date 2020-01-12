package com.example.a31pendingintent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //노티피케이션을 통해 원하는 액티비티를 실행하게 만드는것.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notification 1")
            builder.setContentText("알림 메시지입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메시지 누르면 자동으로 없어지게.
            builder.setAutoCancel(true)

            //실행할 액티비티를.
            var intent1 = Intent(this, TestActivity1::class.java)

            intent1.putExtra("data1", "문자열 데이터2")
            intent1.putExtra("data2", 200)

            //리쿼스트코드를 다르게 준다면 같은 엑티비티를 실행시킨다해도 데이터를 다르게 나타낼수 있다.
            var pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)

            //알림 메시지 밑에 액션 추가.
            var intent2 = Intent(this, TestActivity2::class.java)
            intent2.putExtra("data2", "TestActivity2 실행")
            var pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            var builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action 1", pending2)
            var action2 = builder2.build()
            builder.addAction(action2)


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notification 2")
            builder.setContentText("알림 메시지 2입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메시지 누르면 자동으로 없어지게.
            builder.setAutoCancel(true)

            //실행할 액티비티를.
            var intent1 = Intent(this, TestActivity2::class.java)

            //데이터를 전달하고자 할때는 인텐트1을 이용하면 된다.
            intent1.putExtra("data1", "문자열 데이터1")
            intent1.putExtra("data2", 100)

            //데이터를 보내겠다 할때는 마지막 플래그 값 세팅을 반드시 해야 한다.
//            var pending1 = PendingIntent.getActivity(this, 0, intent1, 0)
            var pending1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notification 1")
            builder.setContentText("알림 메시지입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            //메시지 누르면 자동으로 없어지게.
            builder.setAutoCancel(true)

            //실행할 액티비티를.
            var intent1 = Intent(this, TestActivity1::class.java)

            intent1.putExtra("data1", "문자열 데이터3")
            intent1.putExtra("data2", 300)

            var pending1 = PendingIntent.getActivity(this, 30, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //아이디가 똑같은경우 전의 메시지가 캔슬되므로 메시지값을 구분한다.
            manager.notify(30, notification)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        var builder : NotificationCompat.Builder? = null

        //버전이 오레어 버전 이상이냐 ?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)
        } else { // 안드로이드 7.1.1 이하.
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }

}
