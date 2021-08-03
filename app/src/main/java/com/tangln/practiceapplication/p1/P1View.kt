package com.tangln.practiceapplication.p1

import android.annotation.SuppressLint
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
 * @date: 2021/5/25  下午3:32
 * des:p1练习
 */
class P1View:View {

    private var mPaint:Paint= Paint()
    private var mRectf:RectF= RectF()
    private var path=Path()

    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    //初始化
    fun init(){
        mPaint.style=Paint.Style.STROKE
        mPaint.color = resources.getColor(R.color.purple_200)

        path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        path.lineTo(400f,542f)
    }

    @SuppressLint("Range")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.let {
            /**
             * 绘制矩形
             */
            mRectf= RectF(10f, 10f, 120f, 120f)
            it.drawRect(mRectf, mPaint)

            /**
             * 绘制圆
             */
            mPaint.strokeWidth=20f
            it.drawCircle(300f, 300f, 100f, mPaint)

            /**
             * 绘制圆点
             */
            mPaint.strokeWidth=10f
            mPaint.strokeCap=Paint.Cap.ROUND
            it.drawPoint(50f, 50f, mPaint)

            /**
             * 绘制方点
             */
            mPaint.strokeWidth=20f
            mPaint.strokeCap=Paint.Cap.SQUARE
            it.drawPoint(70f, 70f, mPaint)

            /**
             * 绘制多点
             */
            val points: FloatArray = floatArrayOf(0f, 0f, 50f, 50f, 50f, 100f, 100f, 50f, 100f, 100f, 150f, 50f, 150f, 100f)
            it.drawPoints(points, 2, 8, mPaint)

            /**
             * 绘制椭圆
             */
            mPaint.style=Paint.Style.FILL
            it.drawOval(100f,300f,400f,500f,mPaint)

            /**
             * 绘制线
             */
            it.drawLine(500f,100f,700f,300f,mPaint)

            /**
             * 批量画线
             */
            var lines= floatArrayOf(20f, 20f, 120f, 20f, 70f, 20f, 70f, 120f, 20f, 120f, 120f, 120f, 150f, 20f, 250f, 20f, 150f, 20f, 150f, 120f, 250f, 20f, 250f, 120f, 150f, 120f, 250f,120f)
            it.drawLines(lines,mPaint)

            /**
             * 绘制圆角矩形
             */
            var roundRectf=RectF(100f,500f,200f,700f)
            it.drawRoundRect(roundRectf,50f,50f,mPaint)

            /**
             * 绘制扇形
             */
            var ovalRectf=RectF(200f,900f,300f,1000f)
            it.drawArc(ovalRectf,90f,140f,true,mPaint)

            /**
             * 绘制爱心
             */
            it.drawPath(path,mPaint)

            /**
             * 顺时针，逆时针绘制
             */
            var pathCW=Path()
            //addOval,addRect,addRoundRect同理
            pathCW.addCircle(500f,100f,100f,Path.Direction.CW)
            it.drawPath(pathCW,mPaint)

            /**
             * 绘制线
             */
            mPaint.style=Paint.Style.STROKE
            var pathLine=Path()
            pathLine.lineTo(100f,300f)
            pathLine.rLineTo(300f,300f)
            it.drawPath(pathLine,mPaint)

            /**
             * 贝塞尔曲线 起点从0，0开始
             */
            var pathQuad=Path()
            pathQuad.quadTo(100f,900f,300f,500f)
            it.drawPath(pathQuad,mPaint)

            /**
             * arcTo绘制弧线
             */
            var pathArcTo=Path()
            pathArcTo.lineTo(100f, 100f)
            pathArcTo.arcTo(100f, 100f, 300f, 300f, -90f, 90f, false)
            it.drawPath(pathArcTo,mPaint)

            /**
             * FillType填充类型
             */
            var pathFillType=Path()
            pathFillType.addCircle(100f,100f,100f,Path.Direction.CW)
            pathFillType.addCircle(150f,100f,100f,Path.Direction.CCW)
            pathFillType.fillType=Path.FillType.EVEN_ODD
            it.drawPath(pathFillType,mPaint)

        }
    }

}