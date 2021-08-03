package com.tangln.practiceapplication.p1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/28  下午2:23
 * des:p1-饼状图
 */
class PracticeWorkView3:View {

    private lateinit var mPaintOval:Paint
    private lateinit var mPaintLine:Paint
    private lateinit var mRectfOval:RectF
    private lateinit var mRectfOval5:RectF
    private lateinit var mPath1:Path
    private lateinit var mPath2:Path
    private lateinit var mPath3:Path
    private lateinit var mPath4:Path
    private lateinit var mPath5:Path

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
        mPaintOval= Paint()
        mPaintOval.isAntiAlias=true
        mPaintOval.style=Paint.Style.FILL
        mPath1= Path()
        mPath2= Path()
        mPath3= Path()
        mPath4= Path()
        mPath5= Path()

        mPaintLine= Paint()
        mPaintLine.isAntiAlias=true
        mPaintLine.style=Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.let {
            mRectfOval= RectF(200f,200f,600f,600f)
            //圆弧1
            mPaintOval.color=context.getColor(R.color.design_default_color_primary_dark)
            it.drawArc(mRectfOval,0f,15f,true,mPaintOval)
            //圆弧外的线和字
            mPaintLine.style=Paint.Style.STROKE
            mPath1.moveTo(600f,400f)
            mPath1.lineTo(630f,400f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath1,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v1",633f,400f,mPaintLine)
            //圆弧2
            mPaintOval.color=context.getColor(R.color.teal_700)
            it.drawArc(mRectfOval,18f,7f,true,mPaintOval)
            mPaintLine.style=Paint.Style.STROKE
            mPath2.moveTo(588f,468f)
            mPath2.lineTo(605f,468f)
            mPath2.rLineTo(10f,10f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath2,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v2",620f,470f,mPaintLine)
            //圆弧3
            mPaintOval.color=context.getColor(R.color.design_default_color_secondary)
            it.drawArc(mRectfOval,28f,48f,true,mPaintOval)
            mPaintLine.style=Paint.Style.STROKE
            mPath3.moveTo(540f,540f)
            mPath3.lineTo(555f,540f)
            mPath3.rLineTo(10f,10f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath3,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v3",570f,555f,mPaintLine)
            //圆弧4
            mPaintOval.color=context.getColor(R.color.purple_200)
            it.drawArc(mRectfOval,80f,100f,true,mPaintOval)
            mPaintLine.style=Paint.Style.STROKE
            mPath4.moveTo(260f,540f)
            mPath4.lineTo(230f,540f)
            mPath4.rLineTo(-10f,10f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath4,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v4",185f,560f,mPaintLine)
            //圆弧5
            mPaintOval.color=context.getColor(R.color.design_default_color_error)
            mRectfOval5= RectF(195f,195f,595f,595f)
            it.drawArc(mRectfOval5,180f,140f,true,mPaintOval)
            mPaintLine.style=Paint.Style.STROKE
            mPath4.moveTo(290f,200f)
            mPath4.lineTo(310f,200f)
            mPath4.rLineTo(10f,10f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath4,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v5",255f,200f,mPaintLine)
            //圆弧6
            mPaintOval.color=context.getColor(R.color.design_default_color_primary)
            it.drawArc(mRectfOval,320f,36f,true,mPaintOval)
            mPaintLine.style=Paint.Style.STROKE
            mPath5.moveTo(585f,330f)
            mPath5.lineTo(620f,330f)
            mPath5.rLineTo(10f,10f)
            mPaintLine.strokeWidth=3f
            it.drawPath(mPath5,mPaintLine)
            mPaintLine.textSize=25f
            it.drawText("v6",630f,360f,mPaintLine)
        }
    }
}