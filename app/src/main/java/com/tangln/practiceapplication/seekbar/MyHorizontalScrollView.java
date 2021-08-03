package com.tangln.practiceapplication.seekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: tangln
 * @date: 2021/8/1  下午5:43
 * des:
 */
public class MyHorizontalScrollView extends HorizontalScrollView implements ScrollViewListener {


    public MyHorizontalScrollView(Context context) {
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        isfinishScroll();
    }

    public boolean isfinishScroll() {

        boolean isfinish=false;
        Class scrollview=HorizontalScrollView.class;
        try {
            Field scrollField=scrollview.getDeclaredField("mScroller");
            scrollField.setAccessible(true);
            Object scroller=scrollField.get(this);
            Class overscroller= scrollField.getType();
            Method finishField=overscroller.getMethod("isFinished");
            finishField.setAccessible(true);
            isfinish= (boolean) finishField.invoke(scroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return isfinish;

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    /**
     * 开始动画播放
     */
    private ObjectAnimator mObjectAnimator=new ObjectAnimator();
    private MusicPlayTypeEvalutor musicPlayTypeEvalutor=new MusicPlayTypeEvalutor();
    private float maxPlaySize=0f;
    public void playMusicAnimator(View moveObjeView,int oldTime,int musicPlayViewWidth){
        musicPlayTypeEvalutor.setScrollViewListener(this);
        maxPlaySize=musicPlayViewWidth;

        mObjectAnimator= ObjectAnimator.ofObject(moveObjeView,"translationX",musicPlayTypeEvalutor,oldTime,musicPlayViewWidth);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        //todo setDuration=总时间长度-已经播放的时间长度
        mObjectAnimator.setDuration(13400);

        mObjectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
                Log.i("tang","暂停了");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
                Log.i("tang","重新开始了");
            }
        });

        mObjectAnimator.start();


    }

    public void stopPlayMusicAnimator(){
        mObjectAnimator.pause();
    }

    /**
     * 获取此时的播放移动值
     * @param currentPlayValue
     */
    @Override
    public void getScrollViewListener(int currentPlayValue) {
        msetPlayTimeListener.getPlayTime(-currentPlayValue);
    }

    private setPlayTimeListener msetPlayTimeListener;

    public interface setPlayTimeListener{
        void getPlayTime(int playTime);
    }

    public void setMyPlayTimeListener(setPlayTimeListener mySetPlayTimeListener){
        this.msetPlayTimeListener=mySetPlayTimeListener;
    }
}
