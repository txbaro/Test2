package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomnum);

        TextView textView3 = findViewById(R.id.textView3);
        int luckyNumber = getIntent().getIntExtra("lucky_number", 0); // 0 là giá trị mặc định
        textView3.setText(String.valueOf(luckyNumber));

        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(v -> {
            String message = "My lucky number is " + luckyNumber + "!";
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(shareIntent, "Share using"));
        });
    }
}

