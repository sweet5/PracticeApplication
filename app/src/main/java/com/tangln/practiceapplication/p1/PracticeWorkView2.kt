package com.tangln.practiceapplication.p1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/27  下午3:43
 * des:p1练习-画圆
 */
class PracticeWorkView2:View {

    private var mPaintCircle=Paint()

    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    fun initView(){
        mPaintCircle= Paint()
        mPaintCircle.color=context.getColor(R.color.design_default_color_secondary)
        mPaintCircle.isAntiAlias=true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            mPaintCircle.style=Paint.Style.FILL
            it.drawCircle(200f,200f,170f,mPaintCircle)

            mPaintCircle.style=Paint.Style.STROKE
            mPaintCircle.strokeWidth=5f
            it.drawCircle(540f,200f,170f,mPaintCircle)

            mPaintCircle.style=Paint.Style.FILL
            mPaintCircle.color=context.getColor(R.color.design_default_color_primary_dark)
            it.drawCircle(200f,540f,170f,mPaintCircle)

            mPaintCircle.style=Paint.Style.STROKE
            mPaintCircle.strokeWidth=20f
            mPaintCircle.color=context.getColor(R.color.black)
            it.drawCircle(560f,540f,170f,mPaintCircle)

            //it.restore()
        }
    }
}