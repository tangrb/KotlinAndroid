package com.trb.kotlinandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.trb.kotlinandroid.android.Android0001Activity
import com.trb.kotlinandroid.kotlin.Kotlin0001Activity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author 唐荣兵
 * @date 2019-5-22
 *
 * 知识点：
 * 1.Kotlin的语句的尾部可以跟分号“;”，如果跟分号，那么可以在一行书写多条语句；
 * 如果不跟分号，那么一行只能书写一条语句。
 * 2.Kotlin的注释的用法。
 * 3.在Kotlin代码中可以直接调用Java代码。
 * 4.xml布局文件中的View的onClick属性，可以映射为Activity中的函数。
 * 5.在Activity中，可以直接通过xml中View的id属性来直接操作View。
 * 6.展示Java类View.setOnClickListener(View.OnClickListener listener)方法在Kotlin中的用法。
 * 7.展示Activity跳转时Intent的若干种用法。
 * 8.展示在Kotlin中声明Java类的对象的方法。
 * 9.Kotlin的变量（var）和常量（val）声明。
 * 10.Kotlin函数的参数的使用示例。
 * 11.Kotlin中if语句以及逻辑运算的示例。
 *
 * 槽点：
 * 1.目前在Kotlin中还不能像在Java那样的使用android.util.Log的智能提示、创建功能，类似的不足存在很多，
 * Kotlin的插件还需要继续完善。
 */
class MainActivity : AppCompatActivity() {
    //Kotlin中的常量声明
    val TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        /*Java类View.setOnClickListener(View.OnClickListener listener)*/
        button2_MainActivity.setOnClickListener {
            //this的3种用法（槽点：茴香豆的茴的几种写法）
            //使用Java类的class属性的方法
            //Intent的匿名实例化的用法
            startActivity(Intent(MainActivity@ this, Kotlin0001Activity::class.java))
//            startActivity(Intent(this@MainActivity, Kotlin0001Activity::class.java))
//            startActivity(Intent(this, Kotlin0001Activity::class.java))
        }

        button3_MainActivity.setOnClickListener(View.OnClickListener {
            //Intent的局部变量的实例化的用法，可以类推到在Kotlin需要Java类的对象的使用
            var activityIntent = Intent(MainActivity@ this, Android0001Activity::class.java)
            startActivity(activityIntent)
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent: ")
    }

    override fun onBackPressed() {
        super.onBackPressed(); System.exit(0)
    }

    //xml布局文件中的View的onClick属性，可以映射为Activity中的函数
    fun button1MainActivityOnClicked(view: View?) {
        //if语句，逻辑运算
        if (view == button1_MainActivity) {
            Toast.makeText(this, button1_MainActivity.text, Toast.LENGTH_SHORT).show()
        }
    }
}
