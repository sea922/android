package com.example.ex3lab3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private int[] image1 = {R.drawable.g1, R.drawable.g2};

    private ImageView imageView;
    private int[] images = {R.drawable.g1, R.drawable.g2};
    private int currentIndex = 0;
    private float initialX, initialY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[currentIndex]);
        imageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                initialY = event.getY();
                return true;
            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                float finalY = event.getY();
                if (initialX < finalX) {
                    // Move to the previous image
                    currentIndex = (currentIndex == 0) ? (images.length - 1) : (currentIndex - 1);
                } else {
                    // Move to the next image
                    currentIndex = (currentIndex + 1) % images.length;
                }
                imageView.setImageResource(images[currentIndex]);
                return true;
        }
        return false;
    }
}

