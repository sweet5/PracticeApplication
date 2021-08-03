package com.tangln.practiceapplication.p4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/7/14  上午10:10
 * des:用Path来add各种形状进行clip，很巧妙！
 */
class P4PracticeWorkView1: View {

    private var mPaint:Paint= Paint()
    private var mBitmap1: Bitmap?=null
    private var mPath1:Path= Path()
    private var mPath2:Path= Path()

    constructor(context: Context?) : super(context){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView()
    }

    @SuppressLint("ResourceAsColor")
    fun initView(){
        mPaint.style=Paint.Style.FILL
        mPaint.color=R.color.white
        mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)

        /**
         * 给path搞成一个圆，再来clip
         */
        mBitmap1?.let {
            mPath1.addCircle(it.width.toFloat(),it.height.toFloat(),it.width.toFloat()/2,Path.Direction.CW)
        }

        /**
         * 给path搞成一个圆，设置Path的填充样式，再来clip
         */
        mBitmap1?.let {
            mPath2.fillType=Path.FillType.INVERSE_WINDING
            mPath2.addCircle(it.width.toFloat(), it.height.toFloat()+450, it.width.toFloat() / 2, Path.Direction.CW)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.clipPath(mPath1) //重点是这句
        mBitmap1?.let { canvas.drawBitmap(it,100f,100f,mPaint) }
        canvas.restore()

        canvas.save()
        canvas.clipPath(mPath2)//重点是这句
        mBitmap1?.let { canvas.drawBitmap(it,100f,550f,mPaint) }
        canvas.restore()
    }
}