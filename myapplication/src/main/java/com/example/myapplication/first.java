package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class first extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    private String [] data={"Phone","Time","Emmmm"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.reditt1);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        navView.setCheckedItem(R.id.nav_call);
        ImageView imageView1= (ImageView) findViewById(R.id.bottombutton1);
        ImageView imageView2= (ImageView) findViewById(R.id.bottombutton2);
        ImageView imageView3= (ImageView) findViewById(R.id.bottombutton3);
        ImageView imageView4= (ImageView) findViewById(R.id.bottombutton4);
        imageView1.setOnClickListener(l);
        imageView2.setOnClickListener(l);
        imageView3.setOnClickListener(l);
        imageView4.setOnClickListener(l);
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        Fragment1 f1=new Fragment1();
        ft.replace(R.id.fragment,f1);
        ft.commit();
    }



    View.OnClickListener l=new View.OnClickListener(){
        public void onClick(View v){
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            switch (v.getId()){
                case R.id.bottombutton1:
                    Fragment1 f1=new Fragment1();
                    ft.replace(R.id.fragment,f1);
                    ft.commit();
                    break;
                case R.id.bottombutton2:
                    Fragment2 f2=new Fragment2();
                    ft.replace(R.id.fragment,f2);
                    ft.commit();
                    break;
                case R.id.bottombutton3:
                    Fragment3 f3=new Fragment3();
                    ft.replace(R.id.fragment,f3);
                    ft.commit();
                    break;
                case R.id.bottombutton4:
                    Fragment4 f4=new Fragment4();
                    ft.replace(R.id.fragment,f4);
                    ft.commit();
                    break;
                default:break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"seach",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }


}
