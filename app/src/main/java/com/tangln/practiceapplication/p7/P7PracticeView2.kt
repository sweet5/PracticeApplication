package com.tangln.practiceapplication.p7

import android.animation.*
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator

/**
 * @author: tangln
 * @date: 2021/7/26  下午4:54
 * des:
 */
class P7PracticeView2:View {

    private var progress=0
    private var position=PointF()
        set(value) {
            field=value
            invalidate()
        }

        get() {
            return field
        }

    private var mPaint=Paint()

    private var mObjectAnimator=ObjectAnimator.ofObject(this,"position",PointFEvaluator(),PointF(0f,0f),PointF(200f,100f))
    /**
     * 多动画组合
     */
    var holder1=PropertyValuesHolder.ofFloat("scaleX",2f)
    var holder2=PropertyValuesHolder.ofFloat("scaleY",2f)
    var holder3=PropertyValuesHolder.ofFloat("alpha",1f)
    private var mObjectAnimatorMore=ObjectAnimator.ofPropertyValuesHolder(this,holder1,holder2,holder3)
    /**
     * 多个动画配合执行
     */
    var objectAnimatorMoreDo1=ObjectAnimator.ofFloat(this,"translationX",0f,200f)
    var objectAnimatorMoreDo2=ObjectAnimator.ofFloat(this,"rotation",0f,200f)

    private var animatorSet=AnimatorSet()



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
        //mObjectAnimator.duration=5000
        //mObjectAnimator.start()

        //多属性修改，按顺序组合来执行动画
        //morePropertyChangeByOrder()

        // 方法1.playSequentially让两个动画依次执行
        //setAnimator1()

        //方法2 paly/with/before/after控制动画执行顺序
        //setAnimator2()

        //多组合动画
        //moreMixAnimator()

        //将一个属性进行拆分
        keyFrame()
    }

    private fun morePropertyChangeByOrder(){
        objectAnimatorMoreDo1.duration=5000
        objectAnimatorMoreDo1.interpolator=LinearInterpolator()

        objectAnimatorMoreDo2.duration=5000
        objectAnimatorMoreDo2.interpolator=AccelerateInterpolator()
    }

    private fun moreMixAnimator(){
        mObjectAnimator.duration=5000
        mObjectAnimatorMore.start()
    }

    private fun setAnimator1(){
        animatorSet.playSequentially(objectAnimatorMoreDo1,objectAnimatorMoreDo2)
        animatorSet.start()
    }

    private fun setAnimator2(){
        //animatorSet.play(objectAnimatorMoreDo1).with(objectAnimatorMoreDo2) //1,2动画属性一起放
        animatorSet.play(objectAnimatorMoreDo1).before(objectAnimatorMoreDo2) //1动画完了之后，2才开始
        //animatorSet.play(objectAnimatorMoreDo1).after(objectAnimatorMoreDo2) //2动画完成后，1动画开始
        animatorSet.start()
    }

    /**
     * 把同一动画属性拆分成多个阶段
     */
    private fun keyFrame(){
        //在0%处开始
        var keyFrame1=Keyframe.ofFloat(0f,0f)
        //经过50%的时候，动画完成度100%
        var keyFrame2=Keyframe.ofFloat(0.5f,100f)
        //时间经过100%的时候，动画完成度倒退至80%，即反弹20%
        var keyFrame3=Keyframe.ofFloat(1f,80f)
        var propertyHolder=PropertyValuesHolder.ofKeyframe("progress",keyFrame1,keyFrame2,keyFrame3)
        var objectAnimatorFrame=ObjectAnimator.ofPropertyValuesHolder(this,propertyHolder)
        objectAnimatorFrame.start()
    }

    fun initView(){
        mPaint.style=Paint.Style.STROKE
        mPaint.color=Color.BLUE
        mPaint.strokeWidth=10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.also {
            var rectF=RectF(200f,400f,400f,600f)
            //it.drawArc(rectF,180f,270f,true,mPaint)

            it.drawArc(rectF,0f,progress*2.7f,false,mPaint)
        }
    }
}