package com.gelitenight.waveview.library;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.gelitenight.waveview.library.WaveView;

import java.util.ArrayList;
import java.util.List;

public class WaveHelper {
    private WaveView mWaveView;

    private AnimatorSet mAnimatorSet;

    public WaveHelper(WaveView waveView) {
        mWaveView = waveView;
        initAnimation();
    }

    public void start() {
        mWaveView.setShowWave(true);
        if (mAnimatorSet != null) {
            mAnimatorSet.start();
        }
    }

    public void cancel() {
        if (mAnimatorSet != null) {
//            mAnimatorSet.cancel();
            mAnimatorSet.end();
        }
    }

    private void initAnimation() {
        // horizontal animation. 平移动画，实现波浪效果
        // wave waves infinitely.
        ObjectAnimator waveShiftAnim = ObjectAnimator.ofFloat(
                mWaveView, "waveShiftRatio", 0f, 1f);
        waveShiftAnim.setRepeatCount(ValueAnimator.INFINITE);//Animation.INFINITE 表示重复多次
        waveShiftAnim.setDuration(1000);
        waveShiftAnim.setInterpolator(new LinearInterpolator());

        // vertical animation. 水位动画，
        // water level increases from 0 to center of WaveView
        ObjectAnimator waterLevelAnim = ObjectAnimator.ofFloat(
                mWaveView, "waterLevelRatio", 0f, 0.5f);
        waterLevelAnim.setDuration(10000);
        waterLevelAnim.setInterpolator(new DecelerateInterpolator());
//        animators.add(waterLevelAnim);

        // amplitude animation.  大小动画
        // wave grows big then grows small, repeatedly
        ObjectAnimator amplitudeAnim = ObjectAnimator.ofFloat(
                mWaveView, "amplitudeRatio", 0.0001f, 0.05f);
        amplitudeAnim.setRepeatCount(ValueAnimator.INFINITE);
        amplitudeAnim.setRepeatMode(ValueAnimator.REVERSE);
        amplitudeAnim.setDuration(5000);
        amplitudeAnim.setInterpolator(new LinearInterpolator());
//        animators.add(amplitudeAnim);

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(waveShiftAnim);
    }

//
//    private float default_initAmplitudeAnim = WaveView.DEFAULT_AMPLITUDE_RATIO;
//    private float initAmp
//    //初始化波峰动画
//    private void initAmplitudeAnim(){
//        // amplitude animation.  大小动画
//        // wave grows big then grows small, repeatedly
//        ObjectAnimator amplitudeAnim = ObjectAnimator.ofFloat(
//                mWaveView, "amplitudeRatio", 0.0001f, 0.05f);
//        amplitudeAnim.setRepeatCount(ValueAnimator.INFINITE);
//        amplitudeAnim.setRepeatMode(ValueAnimator.REVERSE);
//        amplitudeAnim.setDuration(5000);
//        amplitudeAnim.setInterpolator(new LinearInterpolator());
//    }




}
