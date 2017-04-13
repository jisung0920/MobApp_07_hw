package com.example.jisung.mobapp_06;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<MetZip> data = new ArrayList<MetZip>();
    ListView listView;
    MetAdapter adapter;
    EditText e1;
    Button Del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] str = {"saer","Asersaer","aser"};
        data.add(new MetZip("10","0104",str,"wrewer","werwer",6));
        data.add(new MetZip("1","0104",str,"wrewer","werwer",4));
        data.add(new MetZip("2","0104",str,"wrewer","werwer",5));
        e1 = (EditText)findViewById(R.id.e1);
        Del = (Button)findViewById(R.id.b4);
        adapter = new MetAdapter(this,data);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("mat",data.get(position));
                startActivityForResult(intent,20);
            }
        });

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                if(search.length() >0)
                    listView.setFilterText(search);//리스트 뷰 내에서 검색 - 데이터 상이 아니다.
                else
                    listView.clearTextFilter();

            }
        });


    }
    public void MonClick(View v){
        if(v.getId()==R.id.b1) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent,10);
        }
        else if(v.getId()==R.id.b2) {
            adapter.setAsc(0);
            adapter.notifyDataSetChanged();
            Log.d("button","click");
        }
        else if(v.getId()==R.id.b3) {
            adapter.setAsc(1);
            adapter.notifyDataSetChanged();
        }
        else{
            if(Del.getText().toString().equals("선택"))
                Del.setText("삭제");
            else
                Del.setText("선택");
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent tdata) {
        if(resultCode==RESULT_OK) {
            MetZip D = tdata.getParcelableExtra("mdata");
            data.add(D);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, tdata);
    }
}
