package com.example.jisung.mobapp_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void S_onClick(View view){
        Intent intent;
        if(view.getId()==R.id.s1)
            intent = new Intent(StartActivity.this,testActivity.class);
        else
            intent = new Intent(StartActivity.this,fragActivity.class);
        startActivity(intent);
    }
}
