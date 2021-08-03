package com.tangln.practiceapplication.p1

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/5/26  下午6:24
 * des:自定义View，练习1
 */
class PracticeWorkView :View{

    private var mPaint:Paint= Paint()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun init(){
        mPaint= Paint()
        mPaint.color=resources.getColor(R.color.purple_200)
    }
}