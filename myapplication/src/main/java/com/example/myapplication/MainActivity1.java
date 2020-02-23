package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity1 extends AppCompatActivity {
    String password="123456";
    String word="123123123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        final EditText editTextword= (EditText) findViewById(R.id.word);
        final EditText editTextpassword= (EditText) findViewById(R.id.password);
        Button buttonsetin= (Button) findViewById(R.id.buttonsetin);

        buttonsetin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(MainActivity1.this,first.class);
                startActivity(intent1);
            }

        });
    }
}
