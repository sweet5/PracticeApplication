package com.tangln.practiceapplication.p1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/28  下午2:20
 * des:p1-饼状图
 */
class PracticeWorkView3Fragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflaterView=inflater.inflate(R.layout.activity_practiceview1_f3,null)
        return inflaterView
    }
}