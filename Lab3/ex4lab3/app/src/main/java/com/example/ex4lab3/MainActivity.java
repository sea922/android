package com.example.ex4lab3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int[] image1 = {R.drawable.g1, R.drawable.g2};
    private int currentIndex = 0;
    private Handler handler = new Handler();
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(image1[currentIndex]);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    currentIndex = (currentIndex + 1) % image1.length;
                    imageView.setImageResource(image1[currentIndex]);
                }
                return true;
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.gangnam_style);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        handler.postDelayed(changeImageRunnable, 2000);
    }

    private Runnable changeImageRunnable = new Runnable() {
        @Override
        public void run() {
            currentIndex = (currentIndex + 1) % image1.length;
            imageView.setImageResource(image1[currentIndex]);
            handler.postDelayed(changeImageRunnable, 2000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        handler.removeCallbacks(changeImageRunnable);
    }
}
