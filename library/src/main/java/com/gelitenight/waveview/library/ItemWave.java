package com.gelitenight.waveview.library;

import android.graphics.Color;

import java.util.Random;

/**
 * @Description: 波浪item
 * @data: 2017/8/28 17:28
 */
public class ItemWave {
    public int line_color = Color.parseColor("#28FFFFFF");//波浪颜色值
    public int line_height = 2;//波浪线的粗细

    public ItemWave(int line_color,int line_height){
        this.line_color = line_color;
        this.line_height = line_height;
    }

    public static ItemWave getRandomItemWave(){
        int color = Color.rgb(getRandom(255),getRandom(255),getRandom(255));
        int height = getRandom(10)+2;
        return new ItemWave(color,height);
    }

    private static int getRandom(int max){
        return new Random().nextInt(max);
    }

}
