package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();

        t1.setText(bundle.getString("username"));
        t2.setText(bundle.getString("password"));
    }
}
