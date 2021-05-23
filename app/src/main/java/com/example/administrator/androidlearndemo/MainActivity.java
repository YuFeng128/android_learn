package com.example.administrator.androidlearndemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.androidlearndemo.activity.draw.DrawB17Activity;
import com.example.administrator.androidlearndemo.activity.draw.DrawC17Activity;
import com.example.administrator.androidlearndemo.activity.layout.LayoutRelativeLayoutActivity;
import com.example.administrator.androidlearndemo.activity.socket.SocketClientActivity;
import com.example.administrator.androidlearndemo.activity.socket.SocketGetClientActivity;
import com.example.administrator.androidlearndemo.activity.view.FragmentRadioGuop2Activity;
import com.example.administrator.androidlearndemo.activity.view.FragmentRadioGuopActivity;
import com.example.administrator.androidlearndemo.activity.view.FragmentTab2Activity;
import com.example.administrator.androidlearndemo.activity.view.FragmentTitleStripeActivity;
import com.example.administrator.androidlearndemo.activity.view.ProgressBarActivity;
import com.example.administrator.androidlearndemo.activity.view.ViewActivity;
import com.example.administrator.androidlearndemo.activity.view.WebViewActivity;
import com.example.administrator.androidlearndemo.window.WindowActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ActivityInfoBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        listView = findViewById(R.id.listView);
        list.add(new ActivityInfoBean("RelativeLayout-00%", LayoutRelativeLayoutActivity.class));
        list.add(new ActivityInfoBean("SocketClientActivity", SocketClientActivity.class));
        list.add(new ActivityInfoBean("SocketGetClientActivity", SocketGetClientActivity.class));
        list.add(new ActivityInfoBean("FragmentTitleStripeActivity", FragmentTitleStripeActivity.class));
        list.add(new ActivityInfoBean("FragmentTab2Activity", FragmentTab2Activity.class));
        list.add(new ActivityInfoBean("FragmentRadioGuopActivity", FragmentRadioGuopActivity.class));
        list.add(new ActivityInfoBean("FragmentRadioGuop2Activity", FragmentRadioGuop2Activity.class));
        list.add(new ActivityInfoBean("ProgressBarActivity", ProgressBarActivity.class));
        list.add(new ActivityInfoBean("DrawB17Activity", DrawB17Activity.class));
        list.add(new ActivityInfoBean("WindowActivity", WindowActivity.class));
        list.add(new ActivityInfoBean("DrawC17Activity", DrawC17Activity.class));
        list.add(new ActivityInfoBean("ViewActivity", ViewActivity.class));
        list.add(new ActivityInfoBean("WebViewActivity", WebViewActivity.class));
        listView.setAdapter(new ActivityListViewAdapter(MainActivity.this,list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, list.get(position).getActivityClass()));
            }
        });
    }

    //自定义适配器
    public class ActivityListViewAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<ActivityInfoBean> activityInfoBeanArrayList;

        public ActivityListViewAdapter(Context context, ArrayList<ActivityInfoBean> list) {
            this.context = context;
            this.activityInfoBeanArrayList = list;
        }

        @Override
        public int getCount() {
            return activityInfoBeanArrayList.size();
        }

        @Override
        public ActivityInfoBean getItem(int position) {
            return activityInfoBeanArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_simple, null);
                holder = new Holder();
                holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.tv_name.setText(getItem(position).getmName());
            return convertView;
        }

        public class Holder {
            private TextView tv_name;
        }
    }

    //列表_数据结构
    public class ActivityInfoBean {
        private String mName;
        private Class activityClass;

        public ActivityInfoBean(String mName, Class activityClass) {
            this.mName = mName;
            this.activityClass = activityClass;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public Class getActivityClass() {
            return activityClass;
        }

        public void setActivityClass(Class activityClass) {
            this.activityClass = activityClass;
        }
    }
}
