package com.tangln.practiceapplication.p7

import android.animation.ObjectAnimator
import android.animation.PointFEvaluator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * @author: tangln
 * @date: 2021/7/22  下午3:22
 * des:
 */
class P7PracticeView:View {

    private var mPaint=Paint()

    /**
     * 颜色渐变1
     */
    //private var mObjectAnimator=ObjectAnimator.ofArgb(this,"color",(0xffff0000).toInt(),(0xff00ff00).toInt())
    /**
     * 颜色渐变2
     */
    //private var mObjectAnimator=ObjectAnimator.ofInt(this,"color",Color.RED,Color.GREEN)
    var position=PointF()

    /**
     * 点移动的动画1
     */
   // private var mObjectAnimator=ObjectAnimator.ofObject(this,"position",PointFEvaluator(position),PointF(0f,0f),PointF(100f,100f))
    /**
     * 点移动的动画2
     */
    private var mObjectAnimator=ObjectAnimator.ofObject(this,"position",PointFMyEvaluator(),PointF(0f,0f),PointF(100f,100f))

    var color=0

    set(value) {
        //kt默认get set都是不用写方法的，如果要干预默认就要像这样写
        //field代表color这个变量本身，value就是java里面set方法外面传进来人值
        //这行就是默认set方法
        field = value
        //这里通知重绘，下行是新增代码
        invalidate()
    }


    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mObjectAnimator.duration = 5000
        /**
         * 设置估值器
         */
        //mObjectAnimator.setEvaluator(HsvEvaluator())
        //mObjectAnimator.setEvaluator(PointFEvaluator())
       // mObjectAnimator.start()
    }

    fun initView(){
        mPaint.style=Paint.Style.FILL
        mPaint.color=Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //mPaint.color=color
        canvas.also { it.drawCircle(100f,100f,10f,mPaint) }
    }
}