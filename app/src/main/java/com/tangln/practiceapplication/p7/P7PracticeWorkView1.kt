package com.tangln.practiceapplication.p7

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author: tangln
 * @date: 2021/7/27  下午3:54
 * des:颜色渐变填充
 */
class P7PracticeWorkView1: View {

    private var mPaint= Paint()

    private var mColorObjectAnimator=ObjectAnimator.ofArgb(this,"color",(0xffff0000).toInt(),(0xff00ff00).toInt())

    private var color=0
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
        mColorObjectAnimator.duration=5000
        mColorObjectAnimator.start()
    }

    fun initView(){
        mPaint.style=Paint.Style.FILL
        mPaint.color= Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            mPaint.color=color
            it.drawCircle(200f,200f,100f,mPaint)
        }
    }
}