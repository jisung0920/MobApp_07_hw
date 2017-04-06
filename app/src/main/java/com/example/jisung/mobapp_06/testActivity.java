package com.example.jisung.mobapp_06;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class testActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;
    final int MSG_CODE = 100;
    final int PICK_CODE = 110;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        t1 = (TextView)findViewById(R.id.t1);



    }
    public void BonClick(View v){
        if(v.getId()==R.id.b2){
            startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),PICK_CODE);
        }
        else if(v.getId()==R.id.b3){
            Intent intent = new Intent(this,SecondActivity.class);
            Student s1 = new Student("홍길동","201302423",20,1);
            intent.putExtra("student1",s1);
            startActivityForResult(intent,MSG_CODE);
        }
        else if(v.getId()==R.id.b4){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:114"));
            startActivity(intent);
        }
        else if(v.getId()==R.id.b5){
            Intent intent = new Intent(this,ListviewActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("msg", t1.getText().toString());
            //startActivity(intent);정보를 받아오기 떄문에
            startActivityForResult(intent, MSG_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==MSG_CODE) {// 여기서 보낸 코드
            if(resultCode==RESULT_OK){//저번에서 보낸 정보
                String msg = data.getStringExtra("remakemsg");
                t1.setText(msg);
            }
        }
        else if(requestCode==0)
        super.onActivityResult(requestCode, resultCode, data);
    }
}
