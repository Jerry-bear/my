package com.example.myapplication;

import android.app.DownloadManager;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jerry on 2020/2/15.
 */

public class Fragment4 extends Fragment {


    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,container,false);

        Button buttonsetin= (Button) view.findViewById(R.id.baidulianjie);
        buttonsetin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getActivity(),internat.class);

                startActivity(intent2);
            }
        });
        return view;
    }
}


