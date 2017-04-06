package com.example.jisung.mobapp_06;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView title,t1,t2,t3,t4,t5,t6;
    ImageView i1;
    Button b1;
    MetZip mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        Intent intent = getIntent();
        mdata =intent.getParcelableExtra("mat");
        Log.d("mdata",mdata.toString());
        title.setText(mdata.getName());
        t1.setText(mdata.getMenu(0));
        t2.setText(mdata.getMenu(1));
        t3.setText(mdata.getMenu(2));
        t4.setText(mdata.getNumber());
        t5.setText(mdata.getHomepage());
        t6.setText(mdata.getRegitD().substring(0,10));
        int i = mdata.getCatNum();
        if(i==1)
            i1.setImageResource(R.drawable.chicken);
        else if(i==2)
            i1.setImageResource(R.drawable.pizza);
        else
            i1.setImageResource(R.drawable.hamburger);


        //textSetting();
    }
    void init(){
        title = (TextView)findViewById(R.id.txtname);
        i1 = (ImageView)findViewById(R.id.imgno);
        t1 = (TextView)findViewById(R.id.etmenu1);
        t2 = (TextView)findViewById(R.id.etmenu2);
        t3 = (TextView)findViewById(R.id.etmenu3);
        t4 = (TextView)findViewById(R.id.tvTel);
        t5 = (TextView)findViewById(R.id.tvURL);
        t6 = (TextView)findViewById(R.id.tvRegdate);


    }


    public void onClick(View v){
        if(v.getId() == R.id.btnback)
            finish();
        else if(v.getId()==R.id.imageView2){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mdata.getNumber()));
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+mdata.getHomepage()));
            startActivity(intent);
        }
    }

}
