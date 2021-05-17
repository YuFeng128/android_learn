package com.example.administrator.androidlearndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.androidlearndemo.bean.SensorValueBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2021/5/5 0005.
 */

public class DrawB17 extends View {

    private int w;
    private int h;
    private int x;
    private int y;
    private Paint paint = new Paint();
    private ArrayList<SensorValueBean> map = new ArrayList<>();
    private int aw;
    private int ah;


    public DrawB17(Context context) {
        super(context);
    }

    public DrawB17(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStrokeWidth(5f);
        paint.setTextAlign(Paint.Align.CENTER);
        map.add(new SensorValueBean("01-01", (float) 20));
        map.add(new SensorValueBean("01-02", (float) 200));
        map.add(new SensorValueBean("01-03", (float) 140));
        map.add(new SensorValueBean("01-04", (float) 110));
        map.add(new SensorValueBean("01-05", (float) 700));
        map.add(new SensorValueBean("01-06", (float) 700));
        map.add(new SensorValueBean("01-07", (float) 700));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
        x = w / 20;
        y = h - h / 10;
        aw = w - x - x;
        ah = y - y / 7;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(x, 0, x, h, paint);
        canvas.drawLine(0, y, w, y, paint);



        float max = 100 ;
        for (int i = 0; i < map.size(); i++) {
            SensorValueBean sensorValueBean = map.get(i);
            max = Math.max(max, sensorValueBean.getValue());
        }

        canvas.translate(x, y);
        for (int i = 0; i < 5; i++) {
            canvas.drawText(String.valueOf(max/4*i), -x/2, -ah/4*i, paint);
        }

        for (int i = 0; i < map.size(); i++) {
            SensorValueBean sensorValueBean = map.get(i);
            canvas.drawText(sensorValueBean.getIndex(), aw / 8 *(i+1), (h-y)*3/4, paint);
            canvas.drawText(String.valueOf(sensorValueBean.getValue()), aw / 8 * (i+1), -ah * map.get(i).getValue() / max-y/16, paint);
            canvas.drawCircle( aw / 8 * (i+1), -ah * sensorValueBean.getValue() / max, 10f, paint);

            if (i > 0) {
                canvas.drawLine(aw / 8 * (i), -ah * map.get(i-1).getValue() / max,  aw / 8 * (i+1), -ah * sensorValueBean.getValue() / max, paint);

            }
        }

    }


    public void init(ArrayList<SensorValueBean> list) {
        this.map = list;
        postInvalidate();
    }
}
