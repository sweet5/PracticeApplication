package com.tangln.practiceapplication.seekbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.WindowManager
import java.util.*
import kotlin.collections.ArrayList


/**
 * @author: tangln
 * @date: 2021/7/28  下午5:38
 * des: 规定1s的音乐画10根线，一根线为4dp的宽度；画线的话，一组的x轴都是相同的，变化的只有y轴的值
 */
class MusicPlayView: View {

    private var mLinePaint=Paint() //竖线的paint
    private var test=ArrayList<Float>()

    init {
        mLinePaint.style=Paint.Style.STROKE
        mLinePaint.color=Color.RED
        mLinePaint.strokeWidth=2f
        setRandomNum()
    }

    constructor(context: Context) : this(context,null)
    constructor(context: Context, attrs: AttributeSet?) :  this(context,attrs,0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLines(test.toFloatArray(), mLinePaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //todo 此处正常逻辑是，每个点的间隔为4dp，-200为前面的时间显示器的宽度
        var widthSpec = MeasureSpec.makeMeasureSpec((test.size / 4) * 4+getScreenWidth(context)-200, MeasureSpec.UNSPECIFIED)
        setMeasuredDimension(widthSpec, 100)
    }

    fun getMusicPlayViewWidth():Float{
        return (test.size / 4) * 4+getScreenWidth(context)-200.toFloat()
    }

    /**
     * 获取屏幕宽度 由宽度-tv的宽度，就是
     */
    private fun getScreenWidth(mContext: Context):Int{
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val width = wm.defaultDisplay.width
        return width
    }

    /**
     * 设置分贝的随机数
     */
    private var x=10
    private var y=0
    private var mX=0
    private fun setRandomNum(){
       var r = Random(1)
        for(index in 0..900){
            //添加x
            if (index==0){
                mX=x+4
            }else{
                mX=(index*4)+x
            }
            test.add(mX.toFloat())
            //添加y
            var num=r.nextInt(100)
            test.add(num.toFloat())
            //添加x2
            test.add(mX.toFloat())
            //添加y2
            var num2=r.nextInt(100)
            test.add(num2.toFloat())
        }
    }

}