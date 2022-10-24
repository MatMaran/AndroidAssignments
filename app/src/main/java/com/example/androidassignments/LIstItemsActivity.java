package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LIstItemsActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    private ImageButton imbtn;
    private Switch swtch;
    private CheckBox chbox;
    protected Integer REQUEST_IMAGE_CAPTURE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME,"In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        imbtn = (ImageButton)findViewById(R.id.imagebtn);
        swtch = (Switch)findViewById(R.id.switchclick);
        chbox = (CheckBox)findViewById(R.id.checkbx);

        imbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imbtn.setBackgroundColor(Color.TRANSPARENT);
                startActivityForResult(intent, 10);
            }
        });
        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                CharSequence txt;
                int dur;
                if (isChecked == true) {
                    txt = getString(R.string.t_on);
                    dur = Toast.LENGTH_LONG;
                } else {
                    txt = getString(R.string.t_off);
                    dur = Toast.LENGTH_SHORT;
                }
                Toast toast = Toast.makeText(LIstItemsActivity.this, txt, dur);
                toast.show();
            }
        });
        chbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    new AlertDialog.Builder(LIstItemsActivity.this)
                            .setTitle(R.string.dlg_title)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", R.string.response);
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
            }
        });
    }
    protected void print(String str) {
        Toast toast = Toast.makeText(LIstItemsActivity.this, str, Toast.LENGTH_SHORT);
        toast.show();
    }
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }
}