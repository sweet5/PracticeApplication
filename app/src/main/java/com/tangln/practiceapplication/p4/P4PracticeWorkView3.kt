package com.tangln.practiceapplication.p4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/14  下午5:30
 * des:
 */
class P4PracticeWorkView3:View {

    private var mPaint=Paint(Paint.ANTI_ALIAS_FLAG)
    private var mBitmap:Bitmap?=null
    private var mCenterX=0
    private var mCenterY=0
    private var bitmapWidth=0
    private var bitmapHeight=0
    private var x=0
    private var y=0
    private var mCamera=Camera()
    private var degree:Int?=0
    @SuppressLint("ObjectAnimatorBinding")
    private var mAnimator=ObjectAnimator.ofInt(this, "degree", 0, 180)


    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    @SuppressLint("ObjectAnimatorBinding")
    fun initView(){
        mBitmap=BitmapFactory.decodeResource(resources, R.drawable.test_bitmap3)
        mAnimator.duration = 2500
        mAnimator.interpolator=LinearInterpolator()
        mAnimator.repeatCount=ValueAnimator.INFINITE
        mAnimator.repeatMode=ValueAnimator.REVERSE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mAnimator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mAnimator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            mBitmap?.let { bitmap->
                bitmapWidth=bitmap.width
                bitmapHeight=bitmap.height
            }
            mCenterX=width/2
            mCenterY=height/2
            x=mCenterX-bitmapWidth/2
            y=mCenterY-bitmapHeight/2

            //绘制上半部分不动的图片
            it.save()
            it.clipRect(0f, 0f, width.toFloat(), mCenterY.toFloat())
            mBitmap?.let { it1 -> it.drawBitmap(it1, x.toFloat(), y.toFloat(), mPaint) }
            it.restore()

            //绘制下半部分的
            it.save()
            //当动画的旋转度数>90度
            if (degree!! < 90) {
                it.clipRect(0, mCenterY, width, height)
            } else {
                it.clipRect(0, 0, width, mCenterY)
            }

            mCamera.save()
            mCamera.rotateX(degree!!.toFloat())
            it.translate(mCenterX.toFloat(), mCenterY.toFloat())
            mCamera.applyToCanvas(it)
            it.translate(-mCenterX.toFloat(), -mCenterY.toFloat())
            mCamera.restore()

            mBitmap?.let { it1 -> it.drawBitmap(it1, x.toFloat(), y.toFloat(), mPaint) }
            it.restore()
        }

    }
}