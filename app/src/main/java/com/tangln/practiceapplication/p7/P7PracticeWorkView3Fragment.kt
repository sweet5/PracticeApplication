package com.tangln.practiceapplication.p7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/27  下午3:22
 * des:拆分动画的帧Frame
 */
class P7PracticeWorkView3Fragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.activty_practiceview7_f3,null)
        return view
    }
}