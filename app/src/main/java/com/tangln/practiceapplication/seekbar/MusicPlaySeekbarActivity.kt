package com.tangln.practiceapplication.seekbar

import android.animation.FloatEvaluator
import android.animation.IntEvaluator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.tangln.practiceapplication.R
import kotlinx.android.synthetic.main.activity_music_seekbar.*

/**
 * @author: tangln
 * @date: 2021/7/29  上午10:14
 * des:todo 遗留问题：1.sc滑动到最后的时候也让他继续滑动  2.滑动的秒数过快，会闪动 3.动画播放和时间的一致
 */
class MusicPlaySeekbarActivity:AppCompatActivity(),MyHorizontalScrollView.setPlayTimeListener {

    private var isStop=false //是否拦截
    private var moldX=0
    private var mcurrentX=0
    private var isUp=false
    var oldTime=0
    private lateinit var mMusicPlayViewWidth:MusicPlayView

    private var mObjectAnimator=ObjectAnimator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_seekbar)
        mMusicPlayViewWidth =MusicPlayView(this)
        mMusicPlayViewWidth=sb_music_bar2
        hsv_musicview.setMyPlayTimeListener(this)

        cb_isPlay.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(view: CompoundButton?, isCheck: Boolean) {
                if (isCheck){
                    //开始动画，并且播放
                    //hsv_musicview.scrollTo(-mMusicPlayViewWidth.getMusicPlayViewWidth().toInt(),0)
                    playMusic()
                }else{
                    //暂停动画
                    hsv_musicview.stopPlayMusicAnimator()
                }
            }
        })

        hsv_musicview.setOnScrollChangeListener(object : View.OnScrollChangeListener {
            override fun onScrollChange(p0: View?, x: Int, y: Int, oldx: Int, oldy: Int) {
                if (hsv_musicview.isfinishScroll()) {
                    //完成滚动，开始播放
                    //playMusic()
                }
                var moveSize = x

                var time = moveSize / 4 / 10
                if (oldTime==time){
                }else{
                    oldTime=time
                    //todo 有闪烁问题
                    tv_music_currenttime.text = transfom(time.toLong())
                }
                // Log.i("tang", "移动的距离=$moveSize"+"移动秒数="+moveSize/4/10)
                // }
            }
        })
    }

    fun transfom(time: Long): String? {
        val shi = time / 3600
        val fen = time % 3600 / 60
        val miao = time % 3600 % 60
        //shi< 10 ? ("0" + shi) : shi)判断时否大于10时的话就执行shi,否则执行括号中的
        return (if (shi < 10) "0$shi" else shi).toString() + ":" + (if (fen < 10) "0$fen" else fen) + ":" + if (miao < 10) "0$miao" else miao
    }

    fun playMusic(){
        hsv_musicview.playMusicAnimator(sb_music_bar2,oldTime,-mMusicPlayViewWidth.getMusicPlayViewWidth().toInt())
    }

    /**
     * 获取现在播放时间
     */
    override fun getPlayTime(playTime: Int) {
        var time = playTime / 4 / 10
        if (oldTime==time){
        }else{
            oldTime=time
            //todo 有闪烁问题
            tv_music_currenttime.text = transfom(time.toLong())
        }
    }

}