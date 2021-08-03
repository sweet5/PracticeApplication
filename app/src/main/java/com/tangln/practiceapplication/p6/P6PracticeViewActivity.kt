package com.tangln.practiceapplication.p6

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.ViewAnimator
import androidx.appcompat.app.AppCompatActivity
import com.tangln.practiceapplication.R
import kotlinx.android.synthetic.main.activity_p6view.*
import kotlinx.android.synthetic.main.activity_p6view.view.*

/**
 * @author: tangln
 * @date: 2021/7/20  下午3:54
 * des:
 */
class P6PracticeViewActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p6view)

        /**
         * valuePropertyAnimator的用法
         * 平移500f，耗时5000ms
         */
        /*img_p6view.animate().translationX(500f).setDuration(5000).setInterpolator(AnticipateInterpolator()).setListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }

        })*/

    }
}