package com.example.ex1lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvasView = new CanvasView(this);
        setContentView(canvasView);
    }

    public class CanvasView extends View {

        private Paint paint;
        private RectF rect;
        private float x, y;

        public CanvasView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.RED);
            rect = new RectF();
        }

        @Override
        protected void onDraw(Canvas canvas) {
//            canvas.drawColor(Color.WHITE);
            canvas.drawRect(rect, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();
            rect.set(x - 100, y - 50, x + 100, y + 50);
            invalidate();
            return true;
        }
    }
}







