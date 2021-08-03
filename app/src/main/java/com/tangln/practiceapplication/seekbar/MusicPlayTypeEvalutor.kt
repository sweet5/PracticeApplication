
package com.tangln.practiceapplication.seekbar

import android.animation.TypeEvaluator
import android.content.Context
import android.util.Log

/**
 * @author: tangln
 * @date: 2021/8/2  下午10:54
 * des:音乐播放插值器 把这个音乐播放的动画的值，传给view，让它调用scroll去修改相应的值
 */
class MusicPlayTypeEvalutor:TypeEvaluator<Int> {

    private var currentPlayValue:Int=0
    private var mScrollViewListener:ScrollViewListener?=null

    fun setScrollViewListener(mScrollViewListener:ScrollViewListener){
        this.mScrollViewListener=mScrollViewListener
    }

    //fraction是动画完成度
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        //（结束值-初始值）*动画完成度=当前的动画值
        var currentFractionValue=startValue+(endValue-startValue)*fraction
        Log.i("tang","当前动画值=${currentFractionValue.toInt()}")
        currentPlayValue=currentFractionValue.toInt()
        //设值给ScrollView
        mScrollViewListener?.getScrollViewListener(currentPlayValue)
        return currentFractionValue.toInt()
    }

}