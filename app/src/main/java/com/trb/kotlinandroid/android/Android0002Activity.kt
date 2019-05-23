package com.trb.kotlinandroid.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trb.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_android0002.*

/**
 * @author 唐荣兵
 * @date 2019-5-22
 *
 * 知识点：
 * 1.Button的点击事件和长按点击事件，以及函数的返回值的问题。
 * 2.CheckBox的onCheckedChange事件，以及lambda表达式中函数的参数的使用示例
 * 3.RadioGroup&RadioButton的onCheckedChange事件，以及字符模板的使用示例
 */
class Android0002Activity : AppCompatActivity() {
    val TAG = Android0002Activity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android0002)
        buttonClickEventDemo()
        checkBoxCheckEventDemo()
        radioGroupAndRadioButtonDemo()
    }

    //Button的点击事件和长按点击事件，以及函数的返回值的问题
    private fun buttonClickEventDemo() {
        clickEvent_Button_Android0002Activity.setOnClickListener {
            Log.d(TAG, "buttonClickEventDemo: onClick")
        }

        clickEvent_Button_Android0002Activity.setOnLongClickListener {
            Log.d(TAG, "buttonClickEventDemo: onLongClick")
            //返回值按照实际需要去进行处理，这里只是演示
            false
        }
    }

    //CheckBox的onCheckedChange事件，以及lambda表达式中函数的参数的使用示例
    private fun checkBoxCheckEventDemo() {
        //lambda表达式中函数参数的示例
        onCheckedChang_CheckBox_Android0002Activity.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d(TAG, "checkBoxCheckEventDemo: " + buttonView.text.toString() + ": isChecked ? " + isChecked)
        }
    }

    //RadioGroup&RadioButton的onCheckedChange事件，以及字符模板的使用示例
    private fun radioGroupAndRadioButtonDemo() {
        radioGroup_Android0002Activity.setOnCheckedChangeListener { group, checkedId ->
            if (group == radioGroup_Android0002Activity) {
                if (checkedId == radio0_RadioButton_Android0002Activity.id && radio0_RadioButton_Android0002Activity.isChecked) {
                    var text = radio0_RadioButton_Android0002Activity.text;
                    //字符模板的使用示例
                    Log.d(TAG, "radioGroupAndRadioButtonDemo: $text: isChecked ? true")
                } else if (checkedId == radio1_RadioButton_Android0002Activity.id && radio1_RadioButton_Android0002Activity.isChecked) {
                    var text = radio1_RadioButton_Android0002Activity.text;
                    Log.d(TAG, "radioGroupAndRadioButtonDemo: $text: isChecked ? true")
                }
            }
        }
    }
}
