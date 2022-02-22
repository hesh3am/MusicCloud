package com.example.hesham.musiccloud;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hesham on 02-Jul-18.
 */

public class Bioshock extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bioshock);

        ///////////////////backword
        ImageView imageview2 = findViewById(R.id.imageView2);
        imageview2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Bioshock.this, Bioshock_Burial_at_the_sea.class);
                startActivity(intent);
                mediaPlayer.pause();
                finish();
            }
        });

        ////////////////////forword
        ImageView imageview3 = findViewById(R.id.imageView3);
        imageview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Bioshock.this, Bioshock_infinite.class);
                startActivity(intent);
                mediaPlayer.pause();
                finish();
            }
        });
        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);
        mediaPlayer = MediaPlayer.create(this, R.raw.sierialbythesea);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                playCycle();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if (input) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.bioshock2);
        ImageView play = findViewById(R.id.imageView4);
        play.setOnClickListener(new View.OnClickListener() {
            Boolean playPause = true;

            @Override
            public void onClick(View v) {

                if (playPause) {
                    mediaPlayer.start();
                    playPause = false;
                    ImageView m = findViewById(R.id.imageView4);
                    m.setImageResource(R.drawable.pause);
                } else {
                    mediaPlayer.pause();
                    playPause = true;
                    ImageView m = findViewById(R.id.imageView4);
                    m.setImageResource(R.drawable.play_button);
                }
            }
        });
    }

    public void playCycle() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if (mediaPlayer.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
    }
}