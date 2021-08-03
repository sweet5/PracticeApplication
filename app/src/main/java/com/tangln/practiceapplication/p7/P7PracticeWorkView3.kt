package com.tangln.practiceapplication.p7

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * @author: tangln
 * @date: 2021/7/27  下午5:35
 * des:KeyFrame，使得帧
 */
class P7PracticeWorkView3:View {

    private var progress=0
    private var mPaint=Paint()
    private var mRectF=RectF()

    set(value) {
        field=value
        invalidate()
    }

    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        var keyFrame1=Keyframe.ofFloat(0f,0f)
        var keyFrame2=Keyframe.ofFloat(0.5f,180f)
        var keyFrame3=Keyframe.ofFloat(1f,80f)
        var holder=PropertyValuesHolder.ofKeyframe("progress",keyFrame1,keyFrame2,keyFrame3)
        var objectAnimator=ObjectAnimator.ofPropertyValuesHolder(this,holder)
        objectAnimator.start()
    }

    private fun initView(){
        mPaint.style=Paint.Style.STROKE
        mPaint.strokeWidth=10f
        mPaint.color=Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            it.drawArc(mRectF,180f,progress*2f,false,mPaint)
        }
    }
}