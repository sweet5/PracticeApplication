package com.tangln.practiceapplication.p1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/27  下午3:41
 * des:p1的各种圆
 */
class PracticeWorkView2Fragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.activity_practiceview1_f2,null)
        return view
    }
}