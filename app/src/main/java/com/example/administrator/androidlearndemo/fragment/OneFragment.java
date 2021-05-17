package com.example.administrator.androidlearndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.androidlearndemo.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2021/5/5 0005.
 */

public class OneFragment extends Fragment {

    private View view;
    private static String value = "";

    public static Fragment getInterface(String value) {

        OneFragment oneFragment = new OneFragment();

        Bundle bunndle = new Bundle();
        bunndle.putString("content", value);
        oneFragment.setArguments(bunndle);

        return oneFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            this.value = getArguments().getString("content" , "no");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "=========onViewCreated: " + value + "【】界面创建完毕");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, null);
        ((TextView)view.findViewById(R.id.textView)).setText(value);
        return view;
    }

}
