package com.example.administrator.androidlearndemo.activity.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.androidlearndemo.R;

public class ProgressBarActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        handler.post(runnable);
        progressBar = findViewById(R.id.progressBar2);


    }

    private int progress;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (progress < 100) {
                progress++;
                ((TextView) findViewById(R.id.textView2)).setText(String.valueOf(progress));
                progressBar.setProgress(progress);
                if (progress == 100) {
                    Toast.makeText(ProgressBarActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                }
            }

            handler.postDelayed(runnable, 100);

        }
    };

    private Handler handler = new Handler();
}
