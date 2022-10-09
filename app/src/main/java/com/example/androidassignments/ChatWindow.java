package com.example.androidassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    private Button sendBtn;
    private EditText txtBoxEdit;
    private ListView listViewThing;
    ArrayList<String> chatmsg = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        sendBtn = (Button)findViewById(R.id.sendbtn);
        txtBoxEdit = (EditText) findViewById(R.id.txtboxedit);
        listViewThing = (ListView)findViewById(R.id.listview);

        ChatAdapter messageAdapter = new ChatAdapter( this );
        listViewThing.setAdapter( messageAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtBoxEdit.getText().toString() != "") {
                    chatmsg.add(txtBoxEdit.getText().toString());
                    messageAdapter.notifyDataSetChanged();
                    txtBoxEdit.setText("");
                }
            }
        });



    }

    public void onBackPressed() {
        //super.onBackPressed();
    }

    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(@NonNull Context context) {
            super(context, 0);
        }

        public int getCount() {
            return chatmsg.size();
        }

        public String getItem(int position) {
            return chatmsg.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if (position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming,null);
            } else {
                result = inflater.inflate(R.layout.chat_row_outgoing,null);
            }
            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position));
            return result;
        }
    }

}