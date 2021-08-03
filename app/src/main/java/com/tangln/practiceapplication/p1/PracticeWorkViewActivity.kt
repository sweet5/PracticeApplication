package com.tangln.practiceapplication.p1

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tangln.practiceapplication.R
import kotlinx.android.synthetic.main.activity_practiceview1.*

/**
 * @author: tangln
 * @date: 2021/5/26  下午6:29
 * des:p1的练习
 */
class PracticeWorkViewActivity: AppCompatActivity() {

    private var titles= arrayListOf<String>()
    private var fragments= arrayListOf<Fragment>()
    private lateinit var practiceWorkViewAdapter:PracticeWorkViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practiceview1)

        titles.add("Drawcolor")
        titles.add("DrawRect")
        titles.add("饼图")

        fragments.add(PracticeWorkView1Fragment())
        fragments.add(PracticeWorkView2Fragment())
        fragments.add(PracticeWorkView3Fragment())

        practiceWorkViewAdapter= PracticeWorkViewAdapter(this,fragments)
        vp_practiceview1.adapter=practiceWorkViewAdapter

        TabLayoutMediator(tb_practiceview1, vp_practiceview1, object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = titles[position]
            }
        }).attach()
    }
}