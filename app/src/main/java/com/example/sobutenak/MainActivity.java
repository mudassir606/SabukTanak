package com.example.sobutenak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String VALID_USERNAME = "admin";
    final String VALID_PASSWORD = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView1 = findViewById(R.id.txt1);
        final TextView textView2 = findViewById(R.id.txt2);
        Switch customSwitch = findViewById(R.id.switchbtn);
        EditText usernameEditText = findViewById(R.id.userEdit);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button loginbtn = findViewById(R.id.btn);
        EditText emailEditText = findViewById(R.id.emailedit);
        EditText passwordEditText = findViewById(R.id.pswrdedit);
        EditText confirmPasswordEditText = findViewById(R.id.cnfrmpswd);
        TextView forgotPasswordTextView = findViewById(R.id.frgtpswd);
        TextView orrTextView = findViewById(R.id.orrr);
        // Replace these with actual credentials for validation


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ConstraintLayout constraintLayout = findViewById(R.id.cnsly);


        textView2.setTextColor(getResources().getColor(R.color.white));


        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();


        customSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    textView1.setTextColor(getResources().getColor(R.color.white));
                    textView2.setTextColor(Color.parseColor("#AB8AF8"));

                    // Switch is ON, show email and confirm password fields
                    emailEditText.setVisibility(View.VISIBLE);
                    confirmPasswordEditText.setVisibility(View.VISIBLE);
                    forgotPasswordTextView.setVisibility(View.GONE);
                    orrTextView.setVisibility(View.GONE);
                    constraintLayout.setVisibility(View.GONE);
                    loginbtn.setText("Register");
                } else {

                    textView1.setTextColor(Color.parseColor("#AB8AF8"));
                    textView2.setTextColor(getResources().getColor(R.color.white));

                    // Switch is OFF, hide email and confirm password fields
                    emailEditText.setVisibility(View.GONE);
                    confirmPasswordEditText.setVisibility(View.GONE);

                    forgotPasswordTextView.setVisibility(View.VISIBLE);
                    orrTextView.setVisibility(View.VISIBLE);
                    constraintLayout.setVisibility(View.VISIBLE);
                    loginbtn.setText("Login");

                    loginbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String username = usernameEditText.getText().toString();
                            String password = passwordEditText.getText().toString();

                            if (isValidCredentials(username, password)) {
                                // Credentials are valid, navigate to the next activity
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish(); // Optional: Close the login activity to prevent going back
                            } else {
                                // Invalid credentials, show a toast message
                                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


    }

    public boolean isValidCredentials(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

}