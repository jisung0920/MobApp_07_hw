package com.example.jisung.mobapp_06;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    RadioButton r1,r2,r3;
    MetZip data;
    int catNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    void init(){
        e1 =(EditText)findViewById(R.id.etname);
        e2 =(EditText)findViewById(R.id.ettel);
        e3 =(EditText)findViewById(R.id.etmenu1);
        e4 =(EditText)findViewById(R.id.etmenu2);
        e5 =(EditText)findViewById(R.id.etmenu3);
        e6 =(EditText)findViewById(R.id.etaddr);
        r1= (RadioButton)findViewById(R.id.radio1);
        r2= (RadioButton)findViewById(R.id.radio2);
        r3= (RadioButton)findViewById(R.id.radio3);

    }

    public void onClick(View v){
        if(v.getId()==R.id.btnAdd){
            if(r1.isChecked())
                catNum=1;
            else if(r2.isChecked())
                catNum=2;
            else
                catNum=3;

            String menu[] = {e3.getText().toString(),e4.getText().toString(),e5.getText().toString()};
            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .format(new Date(System.currentTimeMillis()));

            data = new MetZip(e1.getText().toString(),
                    e2.getText().toString(),
                    menu,e6.getText().toString(),
                    time,catNum);

            Intent intent = getIntent();
            intent.putExtra("mdata",data);
            setResult(RESULT_OK,intent);
            //엑티비티 호출 후 종료
            Toast.makeText(getApplicationContext(),"등록되었습니다.",Toast.LENGTH_SHORT).show();

            finish();
        }
        else{
            finish();
        }
    }
}
