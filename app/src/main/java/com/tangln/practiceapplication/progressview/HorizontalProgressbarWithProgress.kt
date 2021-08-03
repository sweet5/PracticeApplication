package com.tangln.practiceapplication.progressview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ProgressBar
import com.tangln.practiceapplication.R
import com.tangln.practiceapplication.utils.UIUtils
import kotlin.math.abs

/**
 * @author: tangln
 * @date: 2021/5/16  下午4:54
 * des:
 */
open class HorizontalProgressbarWithProgress(context: Context?) : ProgressBar(context) {

    /*private val DEFAULT_TEXT_SIZE = 10 //sp
    private val DEFAULT_TEXT_COLOR= 0xFFFC00D1
    private val DEFAULT_TEXT_OFFSET = 10 //dp
    private val DEFAULT_COLOR_UNREACH =0xFFD3D6DA
    private val DEFAULT_COLOR_REACH=DEFAULT_TEXT_COLOR
    private val DEFAULT_HEIGHT_REACH = 2 //dp
    private val DEFAULT_HEIGHT_UNREACH = 2 //dp


    private lateinit var mContext:Context

    private var uiUtils=UIUtils()
    private var mTextSize= uiUtils.sp2px(mContext, DEFAULT_TEXT_SIZE)
    private var mTextColor=DEFAULT_TEXT_COLOR
    private var mTextOffset= uiUtils.dp2px(mContext, DEFAULT_TEXT_OFFSET)
    private var mUnReachColor=DEFAULT_COLOR_UNREACH
    private var mUnReachHeight: Float = uiUtils.dp2px(mContext,DEFAULT_HEIGHT_UNREACH)
    private var mReachColor=DEFAULT_COLOR_REACH
    private var mReachHeight= uiUtils.dp2px(mContext, DEFAULT_HEIGHT_REACH)


    private var mPaint=Paint()
    private var mRealWidth = 0


    constructor(context: Context?) : super(context){
        if (context != null) {
            mContext=context
        }
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){

    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){

    }

    fun obtainStyleAttrs(attrs: AttributeSet){
        var ta=mContext.obtainStyledAttributes(attrs, R.styleable.HorizontalProgressbarWithProgress)
        mTextSize=ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_text_size, mTextSize)
        mTextColor= ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_text_color, mTextColor.toInt()).toLong()
        mUnReachColor= ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_reach_color, mUnReachColor.toInt()).toLong()
        mUnReachHeight=ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_unreach_height, DEFAULT_HEIGHT_UNREACH.toFloat())
        mReachColor= ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_reach_color, DEFAULT_COLOR_REACH.toInt()).toLong()
        mReachHeight=ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_reach_height, DEFAULT_HEIGHT_REACH.toFloat())
        mTextOffset=ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_text_offset, DEFAULT_TEXT_OFFSET.toFloat())
        ta.recycle()
        mPaint.textSize=mTextSize

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var widthVal=MeasureSpec.getSize(widthMeasureSpec)
        var height=measureHeight(heightMeasureSpec)
        setMeasuredDimension(widthVal,height)

        //实际绘制区域宽度=view宽度-padding
        mRealWidth=measuredWidth-paddingLeft-paddingRight
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { mCanvas->
            mCanvas.save()
            //移动到需要绘制未知的起始中间未知
            mCanvas.translate(paddingLeft.toFloat(), (height/2).toFloat())
            //是否需要绘制右边区域
            var noNeedUnReach=false
            var text:String= "$progress%"
            var textWidth=mPaint.measureText(text)
            //绘制百分比 当前进度/最大进度
            //绘制起始位置x
            var radio=progress*1.0f/max
            var progressX=radio*mRealWidth
            if (progressX+textWidth>mRealWidth){
                progressX=mRealWidth-textWidth
                noNeedUnReach=true
            }
            //绘制结束位置x
            var endX=progressX-mTextOffset/2
            if (endX>0){
                mPaint.color= mReachColor.toInt()
                mPaint.strokeWidth=mReachHeight
                mCanvas.drawLine(0f,0f,endX,0f,mPaint)
            }
            mPaint.color= mTextColor.toInt()
            var y=(mPaint.descent()+mPaint.ascent())/2
            mCanvas.drawText(text,progressX,y,mPaint)

            //绘制unRecahBar
            if (!noNeedUnReach){
                //右边进度条起始点
                var startX=progressX+textWidth+mTextOffset/2
                mPaint.color= mUnReachColor.toInt()
                mPaint.strokeWidth=mUnReachHeight
                mCanvas.drawLine(startX,0f, mRealWidth.toFloat(),0f,mPaint)
            }
            mCanvas.restore()
        }
    }

    private fun measureHeight(heightMeasureSpec: Int):Int{
        var result:Int
        var mode=MeasureSpec.getMode(heightMeasureSpec)
        var size=MeasureSpec.getSize(heightMeasureSpec)

        if (mode==MeasureSpec.EXACTLY){
            result=size
        }else{
            //进度条中最高的为默认高度-字体的高度
            //测量字体高度
            var textHeight=mPaint.descent()-mPaint.ascent()
            result= (paddingTop+paddingBottom+Math.max(mReachHeight.coerceAtLeast(mUnReachHeight), abs(textHeight))).toInt()

            if (mode==MeasureSpec.AT_MOST){
                //最大不能超过父类的size，取两者中较小的
                result= result.coerceAtMost(size)
            }
        }
        return result
    }*/

}