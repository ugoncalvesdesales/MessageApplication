package com.example.messageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MessageApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText messageText = (EditText) findViewById(R.id.messageText);

        //Focus
        messageText.requestFocus();
        messageText.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(messageText, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 500);

    }

    public void onClickSendMessage(View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        EditText messageText = (EditText) findViewById(R.id.messageText);
        String message = messageText.getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT, message);

        Intent chosenIntent = Intent.createChooser(intent, "Send message via...");


        startActivity(chosenIntent);
    }

    public void onClickShareMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        EditText messageText = (EditText) findViewById(R.id.messageText);
        String message = messageText.getText().toString();

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(intent);
    }
}