package com.trb.kotlinandroid.android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.trb.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_android0001.*

class Android0001Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android0001)
    }

    //xml中所有View的onClick属性都可以绑定同一个方法，然后Activity中通过参数与id进行判断区别
    fun handleButtonClickedInAndroid0001Activity(view: View) {
        if (view == baseViewWidget_Button_Android0001Activity) {
            startActivity(Intent(Android0001Activity@ this, Android0002Activity::class.java))
        }
    }
}
