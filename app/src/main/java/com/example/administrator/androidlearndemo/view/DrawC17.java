package com.example.administrator.androidlearndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.androidlearndemo.bean.SensorValueBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2021/5/7 0007.
 */

public class DrawC17 extends View {


    private ArrayList<SensorValueBean> map = new ArrayList<>();
    private Paint paint = new Paint();
    public int w;
    public int h;
    public int y;
    public int x;
    private int aw;
    private int ah;

    public DrawC17(Context context) {
        super(context);
    }

    public DrawC17(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStrokeWidth(5f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.STROKE);
        map.add(new SensorValueBean("01-01", (float) 20));
        map.add(new SensorValueBean("01-02", (float) 200));
        map.add(new SensorValueBean("01-03", (float) 140));
        map.add(new SensorValueBean("01-04", (float) 110));
        map.add(new SensorValueBean("01-05", (float) 700));
        map.add(new SensorValueBean("01-06", (float) 200));
        map.add(new SensorValueBean("01-07", (float) 1000));
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

//        Path path = new Path();
////        path.moveTo(0, 0);
//        for (int i = 0; i < map.size(); i++) {
//            SensorValueBean sensorValueBean = map.get(i);
//            canvas.drawText(sensorValueBean.getIndex(), aw / 8 *(i+1), (h-y)*3/4, paint);
//            canvas.drawText(String.valueOf(sensorValueBean.getValue()), aw / 8 * (i+1), -ah * map.get(i).getValue() / max-y/16, paint);
////            canvas.drawCircle( aw / 8 * (i+1), -ah * sensorValueBean.getValue() / max, 10f, paint);
//
//            if (i == 0) {
//                path.moveTo(aw / 8 * (i + 1), -ah * sensorValueBean.getValue() / max);
//            } else {
//                path.quadTo(aw / 8 * (i + 1)-60, -ah * sensorValueBean.getValue() / max-10, aw / 8 * (i + 1), -ah * sensorValueBean.getValue() / max);
//            }
//
//
//
//        }
//        canvas.drawPath(path, paint);


        Path mPath=new Path();
        for (int i = 0; i < map.size(); i++) {
            Point startp = new Point(aw / 8 * (i + 1), (int) (-ah * map.get(i).getValue() / max));
            canvas.drawCircle(startp.x, startp.y, 10f, paint);
            Point endp;
            if (i != map.size() - 1) {
                endp = new Point(aw / 8 * (i + 2), (int) (-ah * map.get(i + 1).getValue() / max));
                int wt = (startp.x + endp.x) / 2;
                Point p3 = new Point();
                Point p4 = new Point();
                p3.y = startp.y;
                p3.x = wt;
                p4.y = endp.y;
                p4.x = wt;
                if (i == 0) {
                    mPath.moveTo(startp.x, startp.y);
                }
                mPath.cubicTo(p3.x, p3.y, p4.x, p4.y, endp.x, endp.y);
            }

        }
        /**这里直接使用了折线的画笔，你也可以在此类在定义一个画笔*/
        canvas.drawPath(mPath,paint);

    }



//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.translate(x, y);
//        Path path = new Path();
//        canvas.drawCircle(50, -80, 3f, paint);
//        canvas.drawCircle(150, -100, 3f, paint);
//        canvas.drawCircle(230, -230, 3f, paint);
//        path.moveTo(0, 0);
//        path.quadTo(50,-80,100,-100);
//        path.quadTo(150,-100,200,-50);
//        path.quadTo(230,-230,300,-250);
//        canvas.drawPath(path,paint);
//    }
}
