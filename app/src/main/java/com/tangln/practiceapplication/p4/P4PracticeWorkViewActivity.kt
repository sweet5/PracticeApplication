package com.tangln.practiceapplication.p4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tangln.practiceapplication.R
import com.tangln.practiceapplication.p1.PracticeWorkView1Fragment
import com.tangln.practiceapplication.p1.PracticeWorkView2Fragment
import com.tangln.practiceapplication.p1.PracticeWorkView3Fragment
import com.tangln.practiceapplication.p1.PracticeWorkViewAdapter
import kotlinx.android.synthetic.main.activity_p4work_view.*
import kotlinx.android.synthetic.main.activity_practiceview1.*

/**
 * @author: tangln
 * @date: 2021/7/13  下午4:56
 * des:p4练习题
 */
class P4PracticeWorkViewActivity :AppCompatActivity(){

    private var titles= arrayListOf<String>()
    private var fragments= arrayListOf<Fragment>()
    private lateinit var practiceWorkViewAdapter: PracticeWorkViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p4work_view)

        titles.add("ClipPath")
        titles.add("rotate")
        titles.add("翻页效果")

        fragments.add(P4PracticeWorkView1Fragment())
        fragments.add(P4PracticeWorkView2Fragment())
        fragments.add(P4PracticeWorkView3Fragment())

        practiceWorkViewAdapter= PracticeWorkViewAdapter(this,fragments)
        vp_practiceview4.adapter=practiceWorkViewAdapter

        TabLayoutMediator(tb_practiceview4, vp_practiceview4, object : TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = titles[position]
            }
        }).attach()
    }
}