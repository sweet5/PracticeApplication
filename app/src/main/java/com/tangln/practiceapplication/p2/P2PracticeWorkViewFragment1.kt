package com.tangln.practiceapplication.p2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/6/10  下午4:24
 * des:
 */
class P2PracticeWorkViewFragment1:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflaterView=inflater.inflate(R.layout.activity_practiceview1_f1,null)
        return inflaterView
    }
}