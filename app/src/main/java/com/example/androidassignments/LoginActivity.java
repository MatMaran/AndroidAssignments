package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    static final String KEY_USER = "username@gmail.com";
    static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences prefs = getSharedPreferences("SharedPrefs", MODE_PRIVATE);
        String user = prefs.getString(KEY_USER,"");
        String pass = prefs.getString(KEY_PASS,"");

        final EditText usernameEditText = (EditText)findViewById(R.id.username);
        final EditText passwordEditText = (EditText)findViewById(R.id.password);;
        final Button loginButton = (Button) findViewById(R.id.login);

        usernameEditText.setText(user);
        passwordEditText.setText(pass);

        loginButton.setEnabled(true);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(usernameEditText.getText().toString()).matches() && !passwordEditText.getText().toString().isEmpty()) {
                    SharedPreferences prefs = getSharedPreferences("SharedPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor edits = prefs.edit();
                    edits.putString(KEY_USER,usernameEditText.getText().toString());
                    edits.putString(KEY_PASS,passwordEditText.getText().toString());
                    edits.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
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