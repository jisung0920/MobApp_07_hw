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
        setTitle("MobApp");

        e1 = (EditText)findViewById(R.id.e1);
        Del = (Button)findViewById(R.id.b4);
        adapter = new MetAdapter(this,data);
        listView = (ListView)findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("mat",data.get(position));
                startActivityForResult(intent,20);
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
            if(Del.getText().toString().equals("선택")) {
                Del.setText("삭제");
                adapter.checked=1;
            }
            else {
                adapter.checked=0;
                Del.setText("선택");
                adapter.notifyDataSetChanged();

                Boolean count=false;
                for(int i=0;i<data.size();i++){
                    if(data.get(i).getChecked()) {
                        data.remove(i--);
                        count=true;
                    }
                }
                if(count)
                    Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();

            }
            adapter.notifyDataSetChanged();
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
