package com.tangln.practiceapplication.p7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/27  下午3:21
 * des:
 */
class P7PracticeWorkView1Fragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflaterView=inflater.inflate(R.layout.activity_practiceview7_f1,null)
        return inflaterView
    }
}