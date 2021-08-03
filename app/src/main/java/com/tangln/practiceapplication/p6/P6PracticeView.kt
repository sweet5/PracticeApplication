package com.tangln.practiceapplication.p6

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.*
import androidx.core.animation.addListener
import com.tangln.practiceapplication.R
import kotlinx.android.synthetic.main.activity_p6view.*
import kotlinx.android.synthetic.main.activity_practiceview1.*

/**
 * @author: tangln
 * @date: 2021/7/20  下午3:54
 * des:
 */
class P6PracticeView:View {

    private var progress=0f
    private var mPaint=Paint()
    private var mPenPaint=Paint()
    private var mRectF=RectF()

    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    private fun initView(){
        mPaint.style=Paint.Style.STROKE
        mPaint.strokeWidth=10f
        mPenPaint.style=Paint.Style.FILL
        mPenPaint.color = Color.BLUE
        mPenPaint.isAntiAlias=true
        mRectF= RectF(10f,10f,200f,200f)
    }

    fun getProgress():Float{
        return progress
    }

    fun setProgress(progress:Float){
        this.progress=progress
        invalidate()
    }

    var mObjectAnimator= ObjectAnimator.ofFloat(this,"progress",0f,100f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(mRectF,180f,progress*1.78f,false,mPaint)
        mPenPaint.textSize=20f
        canvas.drawText(getProgress().toInt().toString()+"%",85f,100f,mPenPaint)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mObjectAnimator.duration = 5000
        /**
         * 有个回弹效果
         */
        //mObjectAnimator.interpolator= OvershootInterpolator()

        /**
         * 反方向走一下，又返回，到末点又弹回来
         */
        //mObjectAnimator.interpolator=AnticipateOvershootInterpolator()

        /**
         * 在末端弹跳
         */
        //mObjectAnimator.interpolator=BounceInterpolator()

        /**
         * 回弹原位(效果原位)，可设置回弹次数;此处为回弹2次
         */
        //mObjectAnimator.interpolator=CycleInterpolator(2f)

        /**
         * 自定义动画完成度
         */
        /*var pathInterpolator=Path()
        pathInterpolator.lineTo(0.25f,0.25f)
        pathInterpolator.moveTo(0.25f,1.5f)
        pathInterpolator.lineTo(1f,1f)
        mObjectAnimator.interpolator=PathInterpolator(pathInterpolator)*/

        mObjectAnimator.interpolator=AccelerateDecelerateInterpolator()

        mObjectAnimator.addListener(object :AnimatorListener{
            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                super.onAnimationStart(animation, isReverse)
            }

            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                super.onAnimationEnd(animation, isReverse)
            }

            override fun onAnimationEnd(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })

        mObjectAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener {

        })

        mObjectAnimator.start()
    }
}