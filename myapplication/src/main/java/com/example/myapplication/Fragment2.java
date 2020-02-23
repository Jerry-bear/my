package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jerry on 2020/2/15.
 */

public class Fragment2 extends Fragment {

    private String[]data={"123","jam","cob","123","jam","cob","123","jam","cob","123","jam","cob","123","jam","cob"};
    private SwipeRefreshLayout swipeRefresh;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(container.getContext(),android.R.layout.simple_list_item_1,data);
        ListView listView= (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        swipeRefresh= (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            public void onRefresh(){
                refreshplayers();
            }
        });
        return view;
    }
    private void refreshplayers(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable(){
                    public void run(){
                        Toast.makeText(getActivity().getApplicationContext(),"刷新了",Toast.LENGTH_LONG).show();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}

