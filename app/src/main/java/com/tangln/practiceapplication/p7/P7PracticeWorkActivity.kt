package com.tangln.practiceapplication.p7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tangln.practiceapplication.R
import com.tangln.practiceapplication.p1.PracticeWorkViewAdapter
import kotlinx.android.synthetic.main.activity_p7work_view.*

/**
 * @author: tangln
 * @date: 2021/7/27  下午3:04
 * des:属性动画的使用
 */
class P7PracticeWorkActivity:AppCompatActivity() {

    private var titles=ArrayList<String>()
    private var fragments=ArrayList<Fragment>()
    private val practiceWorkViewAdapter by lazy { PracticeWorkViewAdapter(this,fragments) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p7work_view)

        titles.add("ARGB颜色渐变")
        titles.add("ValueHolder")
        titles.add("拆分动画的帧KeyFrame")

        fragments.add(P7PracticeWorkView1Fragment())
        fragments.add(P7PracticeWorkView2Fragment())
        fragments.add(P7PracticeWorkView3Fragment())

        vp_practiceview7.adapter=practiceWorkViewAdapter

        TabLayoutMediator(tb_practiceview7,vp_practiceview7,object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = titles[position]
            }
        }).attach()
    }
}