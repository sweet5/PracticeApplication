package com.tangln.practiceapplication.p7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tangln.practiceapplication.R
import kotlinx.android.synthetic.main.activity_p7view.*

/**
 * @author: tangln
 * @date: 2021/7/22  下午3:30
 * des:
 */
class P7PracticeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p7view)

        /**
         * ViewProperty的组合动画
         */
        //viewproperty_img.animate().scaleX(2f).scaleY(2f).alpha(1f).start()
    }
}