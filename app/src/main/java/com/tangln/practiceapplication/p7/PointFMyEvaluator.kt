package com.tangln.practiceapplication.p7

import android.animation.TypeEvaluator
import android.graphics.PointF

/**
 * @author: tangln
 * @date: 2021/7/26  下午3:32
 * des:
 */
class PointFMyEvaluator:TypeEvaluator<PointF> {

    var newPoint = PointF()

    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF? {
        val x = startValue.x + fraction * (endValue.x - startValue.x)
        val y = startValue.y + fraction * (endValue.y - startValue.y)
        newPoint[x] = y
        return newPoint
    }
}