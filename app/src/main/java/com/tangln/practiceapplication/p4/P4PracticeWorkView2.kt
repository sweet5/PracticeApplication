package com.tangln.practiceapplication.p4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/14  下午5:05
 * des:
 */
class P4PracticeWorkView2:View {

    private var mPaint:Paint=Paint()
    private var mBitmap:Bitmap?=null
    private var mPoint= Point(200,150)
    private var mPoint2=Point(200,600)

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
        mBitmap=BitmapFactory.decodeResource(resources, R.drawable.test_bitmap3)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        mBitmap?.let { canvas.rotate(180f,mPoint.x+it.width.toFloat()/2,mPoint.y+it.height.toFloat()/2) }
        mBitmap?.let { canvas.drawBitmap(it,mPoint.x.toFloat(),mPoint.y.toFloat(),mPaint) }
        canvas.restore()

        canvas.save()
        mBitmap?.let { canvas.rotate(45f,mPoint2.x.toFloat()+150,mPoint2.y.toFloat()+200) }
        mBitmap?.let { canvas.drawBitmap(it,mPoint2.x.toFloat(),mPoint2.y.toFloat(),mPaint) }
        canvas.restore()
    }
}