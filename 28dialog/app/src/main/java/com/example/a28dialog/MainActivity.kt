package com.example.a28dialog

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //Deprecated -> 안드로이드 8.0이상부터는 사용을 권장하지 않기때문에 선이 그어져 있다.
    var pro:ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            //안드로이드 하위버전까지 지원하기 위한 라이브러리 -> support, appcompat
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("다이얼로그 본문입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            var listener = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when (which){
                        DialogInterface.BUTTON_POSITIVE ->
                            textView.text = "기본 다이얼로그 : positive"
                        DialogInterface.BUTTON_NEUTRAL ->
                            textView.text = "기본 다이얼로그 : neutral"
                        DialogInterface.BUTTON_NEGATIVE ->
                            textView.text = "기본 다이얼로그 : negative"
                    }
                }
            }

            //버튼을 표시하는것., 버튼 동작은 마지막 매개변수에 리스너를 넣어주면 된다.
            builder.setPositiveButton("Positive", listener)
            builder.setNeutralButton("Neutral", listener)
            builder.setNegativeButton("Negative", listener)

            builder.show()
        }

        button2.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            var listener = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    var alert = dialog as AlertDialog
                    var edit1:EditText? = alert.findViewById<EditText>(R.id.editText)
                    var edit2:EditText? = alert.findViewById<EditText>(R.id.editText2)

                    textView.text = "Edit1 : ${edit1?.text}"
                    textView.append(" edt2 : ${edit2?.text}")
                }
            }

            builder.setPositiveButton("확인", listener)
            //네거티브는 취소니까 리스터를 따로 세팅을 안한다.
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        button3.setOnClickListener { view ->
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listener = object:DatePickerDialog.OnDateSetListener {
                //월은 0월부터 출력되니 더하기 +1해야 한다.
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    textView.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
                }
            }

            var picker = DatePickerDialog(this, listener, year,month,day)
            picker.show()
        }

        button4.setOnClickListener { view ->
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    textView.text = "${hourOfDay}시 ${minute}분"
                }
            }
            //마지막 변수가 false면 12시간제로 트루면 24시간제로 나온다.
            var picker = TimePickerDialog(this, listener, hour, minute, false)
            picker.show()
        }

        button5.setOnClickListener { view ->
            pro = ProgressDialog.show(this, "타이틀입니다", "메시지입니다.")

            var handler = Handler()
            var thread = object:Runnable{
                override fun run() {
                    pro?.cancel()
                }
            }
            handler.postDelayed(thread, 5000) //5초후에 thread가 가지고 있는 런 메소드를 호출해라.
        }
    }
}
