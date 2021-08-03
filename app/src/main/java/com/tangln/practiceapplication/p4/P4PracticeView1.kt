package com.tangln.practiceapplication.p4

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * @author: tangln
 * @date: 2021/7/13  下午5:49
 * des:
 */
class P4PracticeView1:View {

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

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}