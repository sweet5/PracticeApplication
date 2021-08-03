package com.tangln.practiceapplication.p1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/27  下午3:36
 * des:p1练习-1
 */
class PracticeWorkView1:View {

    private var mPaintColor=Paint()

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
        mPaintColor= Paint()
        mPaintColor.color= context.getColor(R.color.design_default_color_secondary_variant)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            it.drawColor(context.getColor(R.color.design_default_color_secondary_variant))
        }
    }
}