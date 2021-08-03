package com.tangln.practiceapplication.p2

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tangln.practiceapplication.R
import com.tangln.practiceapplication.p1.PracticeWorkView1Fragment

/**
 * @author: tangln
 * @date: 2021/6/10  下午3:24
 * des:p2章节的练习题
 */
class PracticeWorkViewActivity :Activity(){

    private var titles2= arrayListOf<String>()
    private var fragment2= arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practiceview2)

        titles2.add("渐变圆")
        titles2.add("混合")
        titles2.add("对图片过滤")

        fragment2.add(P2PracticeWorkViewFragment1())
        fragment2.add(P2PracticeWorkViewFragment2())
        fragment2.add(P2PracticeWorkViewFragment3())
    }

    fun initView(){

    }
}