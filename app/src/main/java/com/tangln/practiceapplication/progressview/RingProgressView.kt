package com.tangln.practiceapplication.progressview

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import com.tangln.practiceapplication.R
import com.tangln.practiceapplication.utils.UIUtils

/**
 * @author: tangln
 * @date: 2021/5/16  下午1:54
 * des:圆形进度
 */
class RingProgressView : View {

    //进度条类型
    private var mProgressType:Int=0
    //进度条动画持续时间
    private var mDuration:Int=0
    //是否显示进度条动画
    private var mShowAnimation:Boolean=false
    //进度条颜色
    private var mProgressColor:Int=0
    //当前进度
    private var mProgress:Float=0f
    //进度条宽度
    private var mProgressWidth:Int=0
    //进度条起始角度
    private var mStartAngle:Int=0
    //进度条终止角度
    private var mEndAngle:Int=0
    //进度条背景颜色
    private var mBackgroundColor:Int=0
    private var mViewWidth:Int=0
    private var mDefaultWidth= UIUtils.dp2px(context, 10)
    private var mRectf:RectF= RectF()
    private lateinit var mListener:OnProgressChangedListener
    private var mValueAnimator:ValueAnimator= ValueAnimator()
    private var mProgressPaint:Paint=Paint()
    private var mBackgroundPaint:Paint=Paint()
    private var mTotalProgress:Float =0f

    companion object{
        //整圆进度条
        var TYPE_CIRCLE=0
        //切割进度条
        var TYPE_CLIP=1
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initPaint()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initPaint()
        var typedArray:TypedArray=getContext().obtainStyledAttributes(attrs, R.styleable.CircleProgressView, defStyleAttr, 0)
        mProgressWidth= typedArray.getDimension(R.styleable.CircleProgressView_progressWidth, mDefaultWidth.toFloat()).toInt()
        mProgressColor= typedArray.getDimension(R.styleable.CircleProgressView_progressColor, ContextCompat.getColor(getContext(), R.color.purple_200).toFloat()).toInt()
        mStartAngle=typedArray.getInt(R.styleable.CircleProgressView_startAngle, 0)
        mEndAngle=typedArray.getInt(R.styleable.CircleProgressView_startAngle, 360)
        mBackgroundColor= typedArray.getDimension(R.styleable.CircleProgressView_backgroundColor, ContextCompat.getColor(getContext(), R.color.teal_700).toFloat()).toInt()
        mShowAnimation=typedArray.getBoolean(R.styleable.CircleProgressView_animation, false)
        mDuration=typedArray.getInt(R.styleable.CircleProgressView_duration, 1000)
        typedArray.recycle()

        mProgressPaint.strokeWidth= mProgressWidth.toFloat()
        mProgressPaint.color = mProgressColor

        mBackgroundPaint.strokeWidth= mProgressWidth.toFloat()
        mBackgroundPaint.color=mBackgroundColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width=measureWidth(widthMeasureSpec)
        var height=measureHeight(heightMeasureSpec)
        mViewWidth= width.coerceAtMost(height)
        setMeasuredDimension(mViewWidth, mViewWidth)
    }

    fun measureWidth(widthMeasureSpec: Int):Int{
        var width=0
        var size=MeasureSpec.getSize(widthMeasureSpec)
        var mode=MeasureSpec.getMode(widthMeasureSpec)
        when(mode){
            MeasureSpec.EXACTLY -> {
                width = if (size < mProgressWidth) {
                    mProgressWidth
                } else {
                    size
                }
            }
            MeasureSpec.AT_MOST -> {
                width = mDefaultWidth * 2
            }
            else->{
                width=UIUtils.getScreenWidthInPx(context)
            }
        }
        return width
    }

    fun measureHeight(heightMeasureSpec: Int):Int{
        var height=0
        var size=MeasureSpec.getSize(heightMeasureSpec)
        var mode=MeasureSpec.getMode(heightMeasureSpec)
        when(mode){
            MeasureSpec.EXACTLY -> {
                height = if (size < mProgressWidth) {
                    mProgressWidth
                } else {
                    size
                }
            }
            MeasureSpec.AT_MOST -> {
                height = mDefaultWidth * 2
            }
            else->{
                height=UIUtils.getScreenHeightInPx(context)
            }
        }
        return height
    }

    fun initPaint(){
        mProgressPaint=Paint(Paint.ANTI_ALIAS_FLAG)
        mProgressPaint.style=Paint.Style.STROKE
        mBackgroundPaint= Paint(Paint.ANTI_ALIAS_FLAG)
        mBackgroundPaint.style=Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mRectf= RectF((mProgressWidth / 2).toFloat(), (mProgressWidth / 2).toFloat(), (mViewWidth - mProgressWidth / 2).toFloat(), (mViewWidth - mProgressWidth / 2).toFloat())
        canvas?.let {
            if (mProgressType== TYPE_CIRCLE){
                it.drawCircle((mViewWidth / 2).toFloat(), (mViewWidth / 2).toFloat(), (mViewWidth / 2 - mProgressWidth / 2).toFloat(), mBackgroundPaint)
                it.drawArc(mRectf, mStartAngle.toFloat(), mProgress * 360 / 100, false, mProgressPaint)
            }else if (mProgressType== TYPE_CLIP){
                //mProgressPaint.style=Paint.Style.STROKE
                //mBackgroundPaint.style=Paint.Style.STROKE
                it.drawArc(mRectf, mStartAngle.toFloat(), (mEndAngle-mStartAngle).toFloat(),false,mBackgroundPaint)
                it.drawArc(mRectf, mStartAngle.toFloat(), mProgress * 360 / 100, false, mProgressPaint)
            }
        }
    }

    /**
     * 设置进度条颜色
     */
    fun setProgressColor(progressColor: Int){
        mProgressColor=progressColor
        mProgressPaint.color = mProgressColor
    }

    /**
     * 设置进度
     */
    fun setProgress(progress: Float, showAnimation: Boolean){
        mShowAnimation=showAnimation
        if (mProgressType== TYPE_CLIP){
            mTotalProgress=(mEndAngle-mStartAngle)*100/360f
        }else{
            mTotalProgress=100f
        }
        if (mValueAnimator!=null&&mValueAnimator.isRunning){
            mValueAnimator.cancel()
        }
        if (mShowAnimation){
            mValueAnimator=ValueAnimator.ofFloat(progress)
            mValueAnimator.duration = mDuration.toLong()
            mValueAnimator.interpolator = LinearInterpolator()
            mValueAnimator.addUpdateListener {
                mProgress= it.animatedValue as Float
                if (null!=mListener){
                    mListener.onProgressChanged(mProgress * 100 / mTotalProgress)
                }
                invalidate()
            }
            mValueAnimator.start()
        }else{
            mProgress=progress
            invalidate()
        }
    }

    /**
     * 设置动画持续时间
     */
    fun setDuration(duration: Int){
        mDuration=duration
    }

    /**
     * 设置进度进度条宽度
     */
    fun setProgressWidth(progressWidth: Int){
        mProgressWidth=progressWidth
        mBackgroundPaint.strokeWidth= progressWidth.toFloat()
        mProgressPaint.strokeWidth= progressWidth.toFloat()
    }

    /**
     * 设置进度起始角度
     */
    fun setStartAngle(startAngle: Int){
        mStartAngle=startAngle
    }

    /**
     * 设置进度条类型
     */
    fun setProgressType(progressType: Int){
        mProgressType=progressType
    }

    /**
     * 设置切割圆结束角度
     */
    fun setEndAngle(endAngle: Int){
        mEndAngle=endAngle
    }

    /**
     * 进度条开始，结束形状
     */
    fun setCap(cap: Paint.Cap){
        mProgressPaint.strokeCap=cap
        mBackgroundPaint.strokeCap=cap
    }

    /**
     * 设置背景圆颜色
     */
    fun setBackgroundCircleColor(backgroundColor: Int){
        mBackgroundColor=backgroundColor
        mBackgroundPaint.color = mBackgroundColor
        invalidate()
    }

    fun setOnProgressChangedListener(listener: OnProgressChangedListener){
        mListener=listener
    }

    interface OnProgressChangedListener {
        fun onProgressChanged(currentProgress: Float)
    }

}