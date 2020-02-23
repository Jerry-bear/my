package com.example.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2020/2/15.
 */

public class Fragment3 extends Fragment {
    private List<Fruit> fruitList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3,container,false);



        initFruits();
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
       recyclerView.setAdapter(adapter);
        return view;
    }
    public class Fruit{
        private String name;
        private int imageId;
        public Fruit (String name,int imgerId){
            this.name=name;
            this.imageId=imageId;

        }
        public String getName(){
            return name;
        }
        public int getImageId(){
            return imageId;
        }
    }
    public  class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{
        private List<Fragment3.Fruit> mFruitList;
         class ViewHolder extends RecyclerView.ViewHolder{
            ImageView fruitImage;
            TextView fruitName;
            public ViewHolder(View view){
                super(view);
                fruitImage= (ImageView) view.findViewById(R.id.fruit_image);
                fruitName= (TextView) view.findViewById(R.id.fruit_name);
            }
        }
        public FruitAdapter(List<Fruit> fruitList){


            mFruitList=fruitList;
        }
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
            RecyclerView.ViewHolder holder=new ViewHolder(view);
            return (ViewHolder) holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Fruit fruit=mFruitList.get(position);
            holder.fruitImage.setImageResource(fruit.getImageId());
            holder.fruitName.setText(fruit.getName());
        }
        public int getItemCount(){
            return mFruitList.size();
        }
    }
    private void initFruits(){
       Fruit apple=new Fruit("apple",R.mipmap.home);
        fruitList.add(apple);
        Fruit hahaha=new Fruit("3dfor",R.mipmap.img1);
        fruitList.add(hahaha);
        Fruit dfse=new Fruit("adfsee",R.mipmap.img1);
        fruitList.add(dfse);
        Fruit asdfple=new Fruit("adfele",R.mipmap.img1);
        fruitList.add(apple);
        Fruit fgae=new Fruit("adfsele",R.mipmap.img1);
        fruitList.add(fgae);
        Fruit adfse=new Fruit("aasdee",R.mipmap.img1);
        fruitList.add(adfse);
        Fruit appssee=new Fruit("awdfe",R.mipmap.img1);
        fruitList.add(appssee);
        Fruit pear=new Fruit("pear",R.mipmap.img1);
        fruitList.add(pear);
    }
}
