package ru.bender.dartscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Intent intent = getIntent();
        String playerName = intent.getStringExtra(MainActivity.EXTRA_TEXTVIEW);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(playerName);
    }
}

