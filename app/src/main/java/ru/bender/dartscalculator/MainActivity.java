package ru.bender.dartscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTVIEW = "ru.bender.dartscalculator.PLAYERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doStepByPlayer(View view) {
        Intent intent = new Intent(this, AddPlayerActivity.class);
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        String playerName = textView.getText().toString();
        intent.putExtra(EXTRA_TEXTVIEW, playerName);
        startActivity(intent);
    }
}
