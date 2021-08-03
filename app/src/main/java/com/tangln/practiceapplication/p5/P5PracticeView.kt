package com.tangln.practiceapplication.p5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/19  下午3:05
 * des:
 */
@SuppressLint("AppCompatCustomView")
class P5PracticeView:ImageView {

    private var mPaint:Paint= Paint()
    private var mBitmap:Bitmap?=null
    private var mBitmap2:Bitmap?=null

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
        mPaint= Paint()
        mPaint.style=Paint.Style.STROKE
        mBitmap=BitmapFactory.decodeResource(resources, R.drawable.kaodoufu)
        mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        mBitmap2?.let { canvas.drawBitmap(it,10f,10f,mPaint) }
        canvas.restore()
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        /**
         * 当父容器的绘制内容被子view遮挡时，将父容器的绘制放置于此；将父绘制放在子view绘制之后，这样会使得父的绘制覆盖在子之上
         */
        /*canvas.save()
        mBitmap?.let { canvas.drawBitmap(it,10f,10f,mPaint) }
        canvas.restore()*/
    }

    override fun onDrawForeground(canvas: Canvas) {
        mBitmap?.let { canvas.drawBitmap(it,10f,10f,mPaint) }
        super.onDrawForeground(canvas)
    }

}