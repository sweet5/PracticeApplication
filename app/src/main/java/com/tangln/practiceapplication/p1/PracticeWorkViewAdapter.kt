package com.tangln.practiceapplication.p1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @author: tangln
 * @date: 2021/5/26  下午11:12
 * des:p1练习的Vp的Fragment
 */
class PracticeWorkViewAdapter: FragmentStateAdapter {

    private var fragments:ArrayList<Fragment>

    constructor(fragmentActivity: FragmentActivity, fragments: ArrayList<Fragment>) : super(fragmentActivity) {
        this.fragments = fragments
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}