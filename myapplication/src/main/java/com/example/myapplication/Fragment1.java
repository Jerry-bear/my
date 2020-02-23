package com.example.myapplication;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by Jerry on 2020/2/17.
 */

public class Fragment1 extends Fragment implements View.OnClickListener{
    @Nullable
    private int [] arrayPicture=new int []{R.mipmap.img1,R.mipmap.img2,R.mipmap.img3
            ,R.mipmap.img4,R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,};
    private ImageSwitcher imageSwitcher;
    private  int index;
    private float touchdownx;
    private float touchupx;
    public ProgressBar progressBar;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,container,false);
        progressBar= (ProgressBar) view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        Button button= (Button) view.findViewById(R.id.cobButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog=new ProgressDialog(getActivity());
                progressDialog.setTitle("正在跳转");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                new Thread(){
                    public void run(){
                        SystemClock.sleep(3000);
                        progressDialog.dismiss();
                    }
                }.start();
                Intent intenttocob=new Intent(getActivity(),Kob.class);
                startActivity(intenttocob);
            }
        });
        Button button2= (Button) view.findViewById(R.id.jamesButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog=new ProgressDialog(getActivity());
                progressDialog.setTitle("正在跳转");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                new Thread(){
                    public void run(){
                        SystemClock.sleep(3000);
                        progressDialog.dismiss();
                    }
                }.start();
                Intent intenttojames=new Intent(getActivity(),James.class);
                startActivity(intenttojames);
            }
        });
        imageSwitcher = (ImageSwitcher) view.findViewById(R.id.imageswitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView=new ImageView(container.getContext());
                imageView.setImageResource(arrayPicture[index]);
                return imageView;
            }
        });
        imageSwitcher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(index==1){
                    Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();
                }else if(index==2){
                    Toast.makeText(getActivity(),"2",Toast.LENGTH_SHORT).show();
                }else if(index==3){
                    Toast.makeText(getActivity(),"3",Toast.LENGTH_SHORT).show();
                }else if(index==4){
                    Toast.makeText(getActivity(),"4",Toast.LENGTH_SHORT).show();
                }else if(index==5){
                    Toast.makeText(getActivity(),"5",Toast.LENGTH_SHORT).show();
                }else if(index==6){
                    Toast.makeText(getActivity(),"6",Toast.LENGTH_SHORT).show();
                }else if(index==7){
                    Toast.makeText(getActivity(),"7",Toast.LENGTH_SHORT).show();
                }
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    touchdownx=event.getX();
                    return true;
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    touchupx=event.getX();
                    if(touchupx-touchdownx>100){
                        index=index==0?arrayPicture.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(container.getContext(),android.R.anim.fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(container.getContext(),android.R.anim.fade_out  ));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if(touchdownx-touchupx>100){
                        index=index==arrayPicture.length-1?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(container.getContext(),android.R.anim.fade_in ));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(container.getContext(),android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }
                    return true;
                }
                return false;
            }
        });

        return view;
    }

    @Override

        public void onClick(View v){
            switch (v.getId()){
                case R.id.cobButton:
                    ProgressDialog progressDialog=new ProgressDialog(getActivity());
                    progressDialog.setTitle("正在跳转");
                    progressDialog.setMessage("Loading...");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                    break;
                default:
                    break;
            }
        }
}
