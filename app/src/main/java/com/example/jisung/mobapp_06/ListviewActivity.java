package com.example.jisung.mobapp_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        init();
        setListView();
    }
    public void init(){
        e1 = (EditText)findViewById(R.id.e1);
    }
    public void setListView(){
        listView = (ListView)findViewById(R.id.list1);
        data.add("사과");
        data.add("포도");
        data.add("복숭아");
        //어뎁터 마들기
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);//2번째 레이아웃, 데이터
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //position 은 위치
                data.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });//내용을 길게 눌렀을때 이밴트
    }
    public void LonClick(View v){
        data.add(e1.getText().toString());
        adapter.notifyDataSetChanged();

    }
}
