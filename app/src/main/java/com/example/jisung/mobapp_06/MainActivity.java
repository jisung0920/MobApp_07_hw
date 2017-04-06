package com.example.jisung.mobapp_06;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<MetZip> mdata = new ArrayList<MetZip>();
    ArrayAdapter<MetZip> adapter;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("mat",mdata.get(position));
                startActivityForResult(intent,20);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //정보삭제 대화상자
                AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                dlg.setTitle("삭제하시겠습니까?").setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("취소",null)//null 이벤트 내용
                        .setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mdata.remove(position);
                                adapter.notifyDataSetChanged();
                                t1.setText("맛집 리스티("+mdata.size()+"개)");
                                Toast.makeText(getApplicationContext(),"삭제하였습니다.",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();

                return false;
            }
        });
    }
    public void MonClick(View v){
        if(v.getId()==R.id.b1) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent,10);
        }
    }
    void init(){
        t1 = (TextView)findViewById(R.id.tv);
        listView = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<MetZip>(this,android.R.layout.simple_list_item_1,mdata);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK) {
            MetZip D = data.getParcelableExtra("mdata");
            mdata.add(D);
            t1.setText("맛집 리스트("+mdata.size()+"개)");
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
