package com.tangln.practiceapplication.p2

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/6/1  下午1:45
 * des:
 */
class P2ViewActivity:AppCompatActivity() {

    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p2view)
    }
}