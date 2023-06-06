package com.example.test01;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFName, etLName, etPhoneNb, etPass, etConfPass;
    private RadioButton rbMale, rbFemale;
    private CheckBox chBoxAr, chBoxEn, chBoxFr;
    private Button btnSubmit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        etFName = findViewById(R.id.etFName);
        etLName = findViewById(R.id.etLName);
        etPhoneNb = findViewById(R.id.etPhoneNb);
        etPass = findViewById(R.id.etPass);
        etConfPass = findViewById(R.id.etConfPass);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        chBoxAr = findViewById(R.id.chBoxAr);
        chBoxEn = findViewById(R.id.chBoxEn);
        chBoxFr = findViewById(R.id.chBoxFr);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);

        // Set click listener for the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from the input fields
                String firstName = etFName.getText().toString();
                String lastName = etLName.getText().toString();
                String phoneNumber = etPhoneNb.getText().toString();
                String password = etPass.getText().toString();
                String confirmPassword = etConfPass.getText().toString();
                String gender = rbMale.isChecked() ? "Male" : "Female";
                StringBuilder languages = new StringBuilder();
                if (chBoxAr.isChecked()) {
                    languages.append("Arabic, ");
                }
                if (chBoxEn.isChecked()) {
                    languages.append("English, ");
                }
                if (chBoxFr.isChecked()) {
                    languages.append("French, ");
                }

                // Remove the trailing comma and space from the languages
                if (languages.length() > 0) {
                    languages.deleteCharAt(languages.length() - 2);
                }

                // Check if password and confirm password match
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this, "Passwords do not match!", Toast.LENGTH_LONG).show();
                    return;
                }

                // Display a toast message
                Toast.makeText(MainActivity.this, "Welcome " + firstName + " " + lastName, Toast.LENGTH_LONG).show();

                // Open the second activity and pass the data as extras
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("gender", gender);
                intent.putExtra("languages", languages.toString());
                startActivity(intent);
            }
        });

        // Set click listener for the clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset all input fields and clear the data
                etFName.setText("");
                etLName.setText("");
                etPhoneNb.setText("");
                etPass.setText("");
                etConfPass.setText("");
                rbMale.setChecked(false);
                rbFemale.setChecked(false);
                chBoxAr.setChecked(false);
                chBoxEn.setChecked(false);
                chBoxFr.setChecked(false);
            }
        });
    }
}
