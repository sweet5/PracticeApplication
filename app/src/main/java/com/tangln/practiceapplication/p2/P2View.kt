package com.tangln.practiceapplication.p2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/6/1  下午1:40
 * des:p2的demo
 */
class P2View: View {

    private lateinit var mPaint:Paint
    private lateinit var mShader:Shader

    private lateinit var mShader1:Shader
    private lateinit var mShader2:Shader
    private lateinit var mShader3:Shader

    private lateinit var mBitmap:Bitmap
    private lateinit var mBitmap1:Bitmap
    private lateinit var mBitmap2:Bitmap
    private lateinit var mBitmap3:Bitmap

    private lateinit var composeShader: Shader
    private lateinit var porterDuffColorFilter: PorterDuffColorFilter
    private lateinit var xfermode:Xfermode

    /**
     * 光照效果
     */
    private lateinit var colorFilter:ColorFilter

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
        mPaint=Paint()
        colorFilter=LightingColorFilter(0x00ffff,0x000000)
        porterDuffColorFilter= PorterDuffColorFilter(Color.parseColor("#FFC1E0"),PorterDuff.Mode.DST_IN)
        xfermode=PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            //CLAMP:在端点之外延续端点的颜色
            mShader=LinearGradient(100f,100f,200f,200f,
                    Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)

            mPaint.shader = mShader
            it.drawCircle(100f,100f,50f,mPaint)

            //MIRROR镜子模式
            /*mShader=LinearGradient(100f,100f,500f,500f,
            Color.parseColor("#F75000"),Color.parseColor("#FFF3EE"),Shader.TileMode.MIRROR)
            mPaint.shader = mShader
            it.drawCircle(300f,800f,200f,mPaint)*/

            //REPEAT重复模式
            mShader=LinearGradient(100f,400f,300f,300f,
                    Color.parseColor("#F75000"),Color.parseColor("#FFF3EE"),Shader.TileMode.REPEAT)
            mPaint.shader = mShader
            it.drawCircle(100f,240f,50f,mPaint)

            /**
             * 辐射渐变
             */
            mShader=RadialGradient(100f,340f,100f,Color.parseColor("#E91E63"),
                    Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
            mPaint.shader=mShader
            it.drawCircle(100f,340f,100f,mPaint)

            /**
             * 扫描渐变
             */
            mShader=SweepGradient(100f,540f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"))
            mPaint.shader=mShader
            it.drawCircle(100f,540f,100f,mPaint)

            /**
             * Bitmap着色
             */
            /*mBitmap=BitmapFactory.decodeResource(resources, R.drawable.test_bitmap3)
            mShader=BitmapShader(mBitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            mPaint.shader=mShader*/
            //it.drawCircle(200f,200f,200f,mPaint)

            /**
             * 混合着色器
             * Alpha合成=SRC_OVER
             */
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap4)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.SRC_OVER)
            mPaint.shader=composeShader
            it.drawCircle(200f,200f,200f,mPaint)*/

            /**
             * Alpha合成
             */
            //1.SRC_IN 2图和1图的交叉内容，显示2的交叉的内容点
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.SRC_IN)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/
            //it.drawCircle(200f,200f,200f,mPaint)

            //2.SRC_ATOP 显示1图内容，2图和1的交叉部分的内容会覆盖1之上
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.SRC_ATOP)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //3.DST 全显示1图，2图不显示
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap2)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.DST)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //4.DST_OVER 1图显示在2图之上
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.DST_OVER)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //5.DST_IN 只留下1，2交叉的部分，1图的交叉内容注意和SRC_IN的区别
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.DST_IN)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //6.DST_ATOP 显示2图的部分，一图交叉的2的内容会覆盖显示在2上
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.DST_ATOP)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //7.SRC_OUT 显示2图，2图片除去和1图片交叉的部分
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.SRC_OUT)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            //8.XOR 去除交叉部分
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            mShader1=BitmapShader(mBitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            mShader2=BitmapShader(mBitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            composeShader=ComposeShader(mShader1,mShader2,PorterDuff.Mode.XOR)
            mPaint.shader=composeShader
            it.drawRect(0f,0f,300f,300f,mPaint)*/

            /**
             * 光照效果
             */
            /*mPaint.colorFilter = colorFilter
            mBitmap3=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            it.drawBitmap(mBitmap3,0f,0f,mPaint)*/
            /**
             * PorterDuffColorFilter
             * 使用指定的颜色和指定的PoterDuff.Mode来对绘制对象进行合成
             */
            /*mPaint.colorFilter=porterDuffColorFilter
            mBitmap3=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            it.drawBitmap(mBitmap3,0f,0f,mPaint)*/

            /**
             *Xformed:xf和canvas结合计算出最终的颜色
             */
            /*mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            it.drawBitmap(mBitmap1,0f,0f,mPaint)
            mPaint.xfermode = xfermode
            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            it.drawBitmap(mBitmap2,0f,0f,mPaint)
            mPaint.xfermode=null*/

            /**
             * 离屏缓冲
             * 把绘制的内容单独绘制在缓冲层，再将绘制好的内容贴到view上
             */
            /*var saved=it.saveLayer(null,null,Canvas.ALL_SAVE_FLAG)
            mBitmap1=BitmapFactory.decodeResource(resources,R.drawable.kaodoufu)
            it.drawBitmap(mBitmap1,0f,0f,mPaint)
            mPaint.xfermode=xfermode
            mBitmap2=BitmapFactory.decodeResource(resources,R.drawable.shouji)
            it.drawBitmap(mBitmap2,0f,0f,mPaint)
            //用完及时清理xfermode
            mPaint.xfermode=null
            it.restoreToCount(saved)*/

            /**
             * 设置拐角的形状
             */
            /*var mPath=Path()
            mPath.moveTo(10f,10f)
            mPath.lineTo(100f,20f)
            mPath.rLineTo(-100f,100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.strokeJoin=Paint.Join.MITER
            mPaint.strokeWidth=10f
            mPaint.color=resources.getColor(R.color.design_default_color_primary)
            it.drawPath(mPath,mPaint)*/

            /**
             * 设置拐角的长度
             */
            /*var mLengthPath=Path()
            mLengthPath.moveTo(10f,10f)
            mLengthPath.lineTo(100f,20f)
            mLengthPath.rLineTo(-100f,100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.strokeJoin=Paint.Join.MITER
            mPaint.strokeWidth=10f
            mPaint.strokeMiter=40f
            mPaint.color=resources.getColor(R.color.teal_700)
            it.drawPath(mLengthPath,mPaint)*/

            /**
             * 给图形的轮廓设置样式---DashPathEffect虚线
             */
            /*var mPathEffect=DashPathEffect(floatArrayOf(10f,5f),10f)
            mPaint.pathEffect = mPathEffect
            mPaint.style=Paint.Style.STROKE
            it.drawCircle(300f,300f,200f,mPaint)*/

            /**
             * 给图形的轮廓设置样式---CornerPathEffect让折线所有拐角都成圆角
             */
            /*var mCornerEffect=CornerPathEffect(20f) //圆角半径20f
            var mPath=Path()
            mPath.moveTo(10f,10f)
            mPath.lineTo(100f,20f)
            mPath.rLineTo(-100f,100f)
            mPath.rLineTo(120f,100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.strokeJoin=Paint.Join.MITER
            mPaint.strokeWidth=10f
            mPaint.color=resources.getColor(R.color.design_default_color_primary)
            mPaint.pathEffect=mCornerEffect
            it.drawPath(mPath,mPaint)*/

            /**
             * 让线条随机偏离（效果：看起来像帕金森病人画的折线图一样）
             */
            /*var mDiscretePathEffect=DiscretePathEffect(20f,5f) //拼接每个线段的长度，偏离量
            var mDisPath=Path()
            mDisPath.moveTo(10f,10f)
            mDisPath.lineTo(100f,20f)
            mDisPath.rLineTo(-100f,100f)
            mDisPath.rLineTo(120f,100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.strokeJoin=Paint.Join.MITER
            mPaint.strokeWidth=10f
            mPaint.color=resources.getColor(R.color.design_default_color_primary)
            mPaint.pathEffect=mDiscretePathEffect
            it.drawPath(mDisPath,mPaint)*/

            /**
             * 用虚线在绘制折线
             */
            /*var mDashPathEffect2=DashPathEffect(floatArrayOf(10f,5f,20f,5f),2f) //第一个参数：画线长度，空白长度，数字必须是偶数  第二个参数：虚线偏移量
            var mDashPath=Path()
            mDashPath.moveTo(20f,20f)
            mDashPath.lineTo(200f,300f)
            mDashPath.rLineTo(300f,-100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.pathEffect = mDashPathEffect2
            it.drawPath(mDashPath,mPaint)*/

            /**
             * 用path作为虚线 这里用path画了一个三角形作为虚线点
             */
            /*var mPathEff=Path()
            mPathEff.moveTo(30f,10f)
            mPathEff.lineTo(-29f,29f)
            mPathEff.rLineTo(29f,0f)
            mPathEff.close()
            var mPathDashPathEffect=PathDashPathEffect(mPathEff,10f,0f,PathDashPathEffect.Style.TRANSLATE)
            var mDashPath2=Path()
            mDashPath2.moveTo(20f,20f)
            mDashPath2.lineTo(200f,300f)
            mDashPath2.rLineTo(300f,-100f)
            mPaint.pathEffect = mPathDashPathEffect
            it.drawPath(mDashPath2,mPaint)*/

            /**
             * 组合效果(喝醉酒的帕金森画出来的)
             * 分别按照两种 PathEffect 分别对目标进行绘制。两种效果叠加画
             */
            /*var mCompose=Path()
            var dashPathEffect=DashPathEffect(floatArrayOf(20f,10f),0f)
            var discreteComp=DiscretePathEffect(20f,5f)
            var pathEffect=SumPathEffect(dashPathEffect,discreteComp)
            mCompose.moveTo(20f,20f)
            mCompose.lineTo(200f,300f)
            mCompose.rLineTo(300f,-100f)
            mPaint.style=Paint.Style.STROKE
            mPaint.pathEffect = pathEffect
            it.drawPath(mCompose,mPaint)*/

            /**
             * 组合效果类（即两种效果一起使用在一个图形上）两种效果混合
             */
            /*var composeDashPathEffect=DashPathEffect(floatArrayOf(20f,10f),0f)
            var discreateEffect=DiscretePathEffect(20f,5f)
            var composePathEffect=ComposePathEffect(composeDashPathEffect,discreateEffect)
            var mPathEff=Path()
            mPathEff.moveTo(20f,20f)
            mPathEff.lineTo(200f,300f)
            mPathEff.rLineTo(300f,-100f)
            mPaint.pathEffect = composePathEffect
            mPaint.style=Paint.Style.STROKE
            it.drawPath(mPathEff,mPaint)*/

            /**
             * 在绘制内容下加上阴影
             */
            /*mPaint.setShadowLayer(20f,0f,0f,Color.RED) //阴影范围
            mPaint.textSize=30f
            it.drawText("Hello World",380f,300f,mPaint)*/

            /**
             * 基于画面进行过滤
             */
            /*mPaint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.NORMAL) //参数1.模糊的范围 2.模糊类型
            mBitmap3=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)
            it.drawBitmap(mBitmap3,100f,100f,mPaint)*/

            /*mPaint.maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.OUTER) //参数1.模糊的范围 2.模糊类型
            mBitmap3=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)
            it.drawBitmap(mBitmap3,100f,100f,mPaint)*/

            /**
             * 浮雕效果(讲真，我看不出任何差异，离谱)
             */
            mPaint.maskFilter = EmbossMaskFilter(floatArrayOf(0f,1f,1f),0.2f,8f,10f)
            mBitmap3=BitmapFactory.decodeResource(resources,R.drawable.test_bitmap3)
            it.drawBitmap(mBitmap3,100f,100f,mPaint)
        }
    }
}