package com.nurde.getresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Intent intent_send;
    private EditText inMsgObj;
    public String strMsg;
    private TextView txtReplyObj;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identifikasi edit text input message
        inMsgObj = (EditText) findViewById(R.id.inMsg);
        txtReplyObj = (TextView) findViewById(R.id.txtReply);
    }
    public void sendMsg (View v){
        intent_send = new Intent(this, SecoundActivity.class);
        strMsg = inMsgObj.getText().toString();

        intent_send.putExtra("msg",strMsg);
        startActivityForResult(intent_send,TEXT_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
       // Intent replyIntent = getIntent();
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK) {
                String replyMsg = data.getStringExtra("replyMsg");

                txtReplyObj.setText(replyMsg);
                txtReplyObj.setVisibility(View.VISIBLE);
            }
    }
}
}
