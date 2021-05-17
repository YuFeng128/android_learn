package com.example.administrator.androidlearndemo.activity.draw;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.example.administrator.androidlearndemo.R;
import com.example.administrator.androidlearndemo.bean.MyDeviceBean;
import com.example.administrator.androidlearndemo.bean.SensorValueBean;
import com.example.administrator.androidlearndemo.sql.MySqliteOpenHelper;
import com.example.administrator.androidlearndemo.view.DrawB17;

import java.util.ArrayList;

public class DrawB17Activity extends AppCompatActivity {


    private DrawB17 drawB17;
    private RadioGroup radioGroup;
    private ToggleButton toggleButton;
    private ListView listView;
    public MySqliteOpenHelper mySqliteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_b17);

        mySqliteOpenHelper = new MySqliteOpenHelper(this);

        drawB17 = findViewById(R.id.drawb17);
        radioGroup = findViewById(R.id.rg1);
        toggleButton = findViewById(R.id.tb1);
        listView = findViewById(R.id.listView);


    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            String value = "0";
            String table = "";
            String start_text = "";

            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            switch (checkedRadioButtonId) {
                case R.id.rd1:
                    value = MyDeviceBean.gas;
                    start_text = "01";
                    table = MySqliteOpenHelper.tb_gas_data;
                    break;
                case R.id.rd2:
                    value = MyDeviceBean.smooke;
                    start_text = "02";
                    table = MySqliteOpenHelper.tb_smoke_data;
                    break;
                case R.id.rd3:
                    value = MyDeviceBean.ill;
                    start_text = "03";
                    table = MySqliteOpenHelper.tb_ill_data;
                    break;
                case R.id.rd4:
                    value = MyDeviceBean.hum;
                    start_text = "04";
                    table = MySqliteOpenHelper.tb_hum_data;
                    break;
                case R.id.rd5:
                    value = MyDeviceBean.temp;
                    start_text = "05";
                    table = MySqliteOpenHelper.tb_temp_data;
                    break;
            }

            SQLiteDatabase writableDatabase = mySqliteOpenHelper.getWritableDatabase();

            ContentValues values= new ContentValues();
            values.put(MySqliteOpenHelper.mValue, value);
            writableDatabase.insert(table, null, values);


            String sql = "select * from "+table+" limit (select count(*) from "+table+")-7,7";
            Cursor cursor = writableDatabase.rawQuery(sql, null);
            ArrayList<SensorValueBean> list = new ArrayList<>();
            while (cursor.moveToNext()) {
                SensorValueBean sensorValueBean = new SensorValueBean(start_text+"-"+cursor.getString(0), Float.parseFloat(cursor.getString(1)));
                list.add(sensorValueBean);
            }

            drawB17.init(list);


            writableDatabase.close();

            handler.postDelayed(runnable, 1000);
        }
    };
    Handler handler = new Handler();

    @Override
    protected void onStart() {
        super.onStart();
        handler.post(runnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);

    }
}
