package com.example.jisung.mobapp_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1 = (EditText)findViewById(R.id.e1);
        t1 = (TextView)findViewById(R.id.t1);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        String sss= intent.getParcelableExtra("student1");
        String str = sss.toString();
        int num1 = intent.getIntExtra("num1",0);//두번째는 디폴트값으로 설정

        t1.setText(str);

    }
    public void BonClick(View v){
        Intent intent = new Intent();
        intent.putExtra("remakemsg",e1.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
