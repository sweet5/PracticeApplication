package com.tangln.practiceapplication

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tangln.practiceapplication.progressview.RingProgressView
import com.tangln.practiceapplication.utils.UIUtils


class MainActivity : AppCompatActivity() {

    private lateinit var rpv_view:RingProgressView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rpv_view=findViewById(R.id.rpv_view)
        rpv_view.setOnProgressChangedListener(object : RingProgressView.OnProgressChangedListener {
            override fun onProgressChanged(currentProgress: Float) {

            }

        })
        rpv_view.setStartAngle(1)
        rpv_view.setProgressColor(resources.getColor(R.color.teal_700))
        rpv_view.setBackgroundCircleColor(resources.getColor(R.color.purple_200))
        rpv_view.setProgressWidth(UIUtils.dp2px(this@MainActivity, Integer.valueOf(10)))
        rpv_view.setDuration(5000)
        rpv_view.setEndAngle(360)
        //setData(20, 3f)
        rpv_view.setProgressType(RingProgressView.TYPE_CLIP)
        rpv_view.setCap(Paint.Cap.ROUND)
        rpv_view.setProgress(100f, true)
        //progressTv.setVisibility(if (animCb.isChecked()) View.VISIBLE else View.GONE)
        //rpv_view.setProgressWidth(10f)
        //rpv_view.setProgress(30f)
    }

    var ANIMATOR_DURATION = 1000
    @SuppressLint("ObjectAnimatorBinding")
    private fun setData(max: Int, current: Float) {
        var percentage = 100f * current / max
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(rpv_view, "percentage", 0f, percentage)
        animator.duration = ANIMATOR_DURATION.toLong()
        animator.start()
    }

}