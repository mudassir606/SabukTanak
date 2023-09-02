package com.example.sobutenak;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView1 = findViewById(R.id.txt1);
        final TextView textView2 = findViewById(R.id.txt2);
        Switch customSwitch = findViewById(R.id.switchbtn);
        textView2.setTextColor(getResources().getColor(R.color.white));

        customSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Switch is ON, change text view 2 color to black and text view 1 to gray
                    textView1.setTextColor(getResources().getColor(R.color.white)); // Change to your desired gray color
                    textView2.setTextColor(Color.parseColor("#AB8AF8")); // Change to your desired black color
                } else {
                    // Switch is OFF, change text view 1 color to black and text view 2 to gray
                    textView1.setTextColor(Color.parseColor("#AB8AF8")); // Change to your desired black color
                    textView2.setTextColor(getResources().getColor(R.color.white)); // Change to your desired gray color
                }
            }
        });
    }


}