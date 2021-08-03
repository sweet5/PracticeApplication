package com.tangln.practiceapplication.p7

import android.animation.TypeEvaluator
import android.graphics.Color


/**
 * @author: tangln
 * @date: 2021/7/22  下午6:04
 * des:自定义Evaluator
 */
class HsvEvaluator:TypeEvaluator<Int> {
    var startHsv =FloatArray(3)
    var endHsv=FloatArray(3)
    var outHsv=FloatArray(3)

     override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
         //把ARGB转换成HSV
         Color.colorToHSV(startValue, startHsv)
         Color.colorToHSV(endValue, endHsv)
         //计算动画完成度所对应的颜色值
         if (endHsv[0]-startHsv[0]>180){
             endHsv[0]=endHsv[0]-360
         }else if(endHsv[0]-startHsv[0]<-180){
             endHsv[0]=endHsv[0]+360
         }
         outHsv[0]=startHsv[0]+(endHsv[0]-startHsv[0])*fraction
         if (outHsv[0]>360){
             outHsv[0]=outHsv[0]-360
         }else{
             outHsv[0]=outHsv[0]+360
         }
         outHsv[1]=startHsv[1]+(endHsv[1]-startHsv[1])*fraction
         outHsv[2]=startHsv[2]+(endHsv[2]-startHsv[2])*fraction

         var alpha = startValue shr 24 + ((endValue shr 24- startValue shr 24) * fraction.toInt())
         //把Hsv转为ARGB
         return Color.HSVToColor(alpha,outHsv)
     }
}