package com.tangln.practiceapplication.p4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tangln.practiceapplication.R

/**
 * @author: tangln
 * @date: 2021/6/23  下午5:15
 * des:
 */
class P4PracticeView: View {

    private var mPaint:Paint=Paint()
    private var mBitmap1:Bitmap?=null
    private var mPath1=Path()
    private var mPath2=Path()
    private var mPoint1=Point()
    private var mPoint2=Point()

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
        mPaint.color=resources.getColor(R.color.design_default_color_primary)
        mPaint.style=Paint.Style.STROKE
        mBitmap1=BitmapFactory.decodeResource(resources, R.drawable.test_bitmap3)

        mPath1.addCircle(10f,10f,30f,Path.Direction.CCW)
        mPoint1= Point(20,20)
        mPath2.addCircle(10f,10f,30f,Path.Direction.CW)
        mPoint2= Point(20,20)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.let {
            /**
             * clipRect：范围裁剪
             */
            it.save() //及时恢复绘制范围
            it.clipRect(100f,100f,200f,200f)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,100f,100f,mPaint) }
            it.restore() //及时恢复绘制范围

            /**
             * clipPath：形状裁剪
             */
            //var shader:Shader=BitmapShader()
            it.save()
            it.clipPath(mPath1)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,mPoint1.x.toFloat(),mPoint1.y.toFloat(),mPaint) }
            it.restore()

            /*it.save()
            it.clipPath(mPath2)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,mPoint2.x.toFloat(),mPoint2.y.toFloat(),mPaint) }
            it.restore()*/

            /**
             * 平移
             */
            /*it.save()
            it.translate(200f,0f)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * 旋转 (正数是顺时间旋转；负数是逆时针旋转)
             */
            /*it.save()
            it.rotate(10f)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * 缩放
             */
            /*it.save()
            it.scale(1.3f,1.3f,x+ (mBitmap1?.width ?: 0) /2,y+(mBitmap1?.height?:0)/2)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * 错切 y轴错切了
             */
            /*it.save()
            it.skew(0f,0.5f)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * 用Matrix做变换
             */
            /*var matrix:Matrix= Matrix()
            matrix.reset()
            matrix.postTranslate(200f,0f) //x轴平移200
            matrix.postRotate(1.3f) //旋转1.3f

            it.save()
            it.concat(matrix) //将matrix应用到canvas，还可以使用canvas.setMatrix(matrix);而不同系统的setMatrix(matrix)行为不同，所以尽量使用canvas.concat(matrix)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * matrix做自定义变换
             */
            /*var matrix2:Matrix= Matrix()
            var pointsSrc= floatArrayOf(left.toFloat(), top.toFloat(), right.toFloat(), top.toFloat(), left.toFloat(), bottom.toFloat(), right.toFloat(), bottom.toFloat())
            var pointDst= floatArrayOf(left-10.toFloat(),top+50.toFloat(),right+120.toFloat(),top-90.toFloat(),left+20.toFloat(),bottom + 30.toFloat(), (right + 20).toFloat(), (bottom + 60).toFloat())
            matrix2.reset()
            matrix2.setPolyToPoly(pointsSrc,0,pointDst,0,4) //pointCount只能<=4，否则无法计算变换

            it.save()
            it.concat(matrix2)
            mBitmap1?.let { it1 -> it.drawBitmap(it1,x,y,mPaint) }
            it.restore()*/

            /**
             * canvas做三维变换 ；沿X轴旋转
             */
            /*it.save()
            var camera=Camera()
            camera.save() //camera也需要save()
            camera.rotateX(25f)
            camera.applyToCanvas(it)
            camera.restore() //camera也需要restore()

            mBitmap1?.let { it1 -> it.drawBitmap(it1,0f,10f,mPaint) }
            it.restore()*/

            /**
             * 让图形左右对称
             */

            var mCenterX= (mBitmap1?.width ?: 0) /2
            var mCenterY= (mBitmap1?.height?:0)/2

            it.save()
            var camera2=Camera()
            camera2.save()
            it.translate(mCenterX.toFloat(), mCenterY.toFloat())
            camera2.rotateX(35f)
            camera2.applyToCanvas(it)
            it.translate(-mCenterX.toFloat(),-mCenterY.toFloat())
            camera2.restore()
            mBitmap1?.let { it1 -> it.drawBitmap(it1,100f,10f,mPaint) }
            it.restore()
        }
    }
}

