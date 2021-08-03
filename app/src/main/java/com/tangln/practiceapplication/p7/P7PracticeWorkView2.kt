package com.tangln.practiceapplication.p7

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.provider.Settings
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/27  下午4:50
 * des:
 */
class P7PracticeWorkView2:View {

    private var mPaint=Paint()
    private var mBitmap:Bitmap?=null

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
        var viewholder1=PropertyValuesHolder.ofFloat("translationX",100f)
        var viewholder2=PropertyValuesHolder.ofFloat("rotation",180f)
        var viewholder3=PropertyValuesHolder.ofFloat("scaleX",1.5f)
        var objectAnimator=ObjectAnimator.ofPropertyValuesHolder(this,viewholder1,viewholder2,viewholder3)
        objectAnimator.start()
    }

    private fun initView(){
        mPaint.style=Paint.Style.STROKE
        mBitmap=BitmapFactory.decodeResource(resources, R.drawable.test_bitmap3)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            mBitmap?.let { it1 -> it.drawBitmap(it1,200f,200f,mPaint) }
        }
    }
}