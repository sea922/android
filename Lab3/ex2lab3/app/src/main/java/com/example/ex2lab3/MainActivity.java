package com.example.ex2lab3;



import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TouchView(this));
    }

    public class TouchView extends View {
        private Paint paint = new Paint();
        private Rect rect = new Rect(0, 0, 0, 0);

        public TouchView(MainActivity context) {
            super(context);
            paint.setColor(Color.RED);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawRect(rect, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    rect.left = (int) event.getX();
                    rect.top = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    rect.right = (int) event.getX();
                    rect.bottom = (int) event.getY();
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    rect.right = (int) event.getX();
                    rect.bottom = (int) event.getY();
                    invalidate();
                    break;
            }
            return true;
        }
    }
}

