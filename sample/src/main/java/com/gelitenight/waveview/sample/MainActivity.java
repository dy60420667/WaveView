package com.gelitenight.waveview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.SeekBar;

import com.gelitenight.waveview.library.ItemWave;
import com.gelitenight.waveview.library.WaveHelper;
import com.gelitenight.waveview.library.WaveView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WaveHelper mWaveHelper;
    private WaveView waveView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         waveView = (WaveView) findViewById(R.id.wave);
        ArrayList<ItemWave> list = new ArrayList<>();
        list.add(ItemWave.getRandomItemWave());
        list.add(ItemWave.getRandomItemWave());
        list.add(ItemWave.getRandomItemWave());
        list.add(ItemWave.getRandomItemWave());
        waveView.setWaveColor(list);

        mWaveHelper = new WaveHelper(waveView);

        initView();
    }

    private SeekBar seekBar;
    private void initView() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                waveView.setAmplitudeRatio(Float.valueOf(i)*0.1f/100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWaveHelper.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWaveHelper.start();
    }
}
