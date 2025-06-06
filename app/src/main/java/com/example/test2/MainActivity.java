package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText editName = findViewById(R.id.nameText);
        btnSubmit.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
            } else {
                int luckyNumber = generateLuckyNumber();
                Intent intent = new Intent(MainActivity.this, RandomActivity.class);
                intent.putExtra("lucky_number", luckyNumber);
                startActivity(intent);
            }
        });
    }

    private int generateLuckyNumber() {
        return new Random().nextInt(1000);
    }
}