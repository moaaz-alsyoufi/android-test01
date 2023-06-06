package com.example.test01;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve the passed data from the intent
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        String gender = getIntent().getStringExtra("gender");
        String languages = getIntent().getStringExtra("languages");

        // Display the retrieved data
        TextView tvFullName = findViewById(R.id.tvFullName);
        TextView tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvLanguages = findViewById(R.id.tvLanguages);

        tvFullName.setText(firstName + " " + lastName);
        tvPhoneNumber.setText(phoneNumber);
        tvGender.setText(gender);
        tvLanguages.setText(languages);

        // Set click listener for the back button
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Call finish() if you want to close MainActivity2
            }
        });
    }
}
