package com.tangln.practiceapplication.p4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/13  下午5:31
 * des:
 */
class P4PracticeWorkView2Fragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflaterView=inflater.inflate(R.layout.activity_practiceview4_f2,null)
        return inflaterView
    }
}