package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {


    Button share_button;
    TextView textView2,luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView2 = findViewById(R.id.textView2);
        luckyNumber = findViewById(R.id.textView_lucky_number);
        share_button = findViewById(R.id.btn2);

        //receiving strings from Intents from main activity

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //Generate a random number
        int randomNum = generarteRandomNumber();

        luckyNumber.setText(""+randomNum);

        //share data

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,randomNum);
            }
        });

    }

    public void shareData(String username, int randomNum){

        //Implicit Intent

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //add additional info
        i.putExtra(Intent.EXTRA_SUBJECT,username+" got lukcy today!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+randomNum);

        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }

    public int generarteRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;
    }
}