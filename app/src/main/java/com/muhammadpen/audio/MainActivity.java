package com.muhammadpen.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer audioPlayer;
    AudioManager volumeManager;

    public void play (View view){


        audioPlayer.start();

    }

    public void pause (View view){

        audioPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioPlayer = MediaPlayer.create(this , R.raw.german_radio_audio_sample);

        volumeManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = volumeManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = volumeManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        final SeekBar volumeSlider = findViewById(R.id.volumeSlider);
        volumeSlider.setMax(maxVolume);
        volumeSlider.setProgress(currentVolume);

        volumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            System.out.println("Current Status Number" + progress);
            volumeManager.setStreamVolume(volumeManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
