package com.tangln.practiceapplication.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * @author: tangln
 * @date: 2021/5/17  上午10:50
 * des:
 */
class UIUtils {
    constructor()

    companion object{
        /**
         * dp转成px
         */
        fun dp2px(context: Context, dp: Int): Int {
            val metrics = context.resources.displayMetrics
            return (dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
        }

        fun getScreenWidthInPx(context: Context): Int {
            return context.resources.displayMetrics.widthPixels
        }

        fun getScreenHeightInPx(context: Context): Int {
            return context.resources.displayMetrics.heightPixels
        }
    }
}