package com.rakurai.howfastareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView Clickme;
    Button Start;
    TextView textView;
    ProgressBar progressBar;
    int count = 0;
    int rand = 0, prevRand = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Clickme = findViewById(R.id.clickbutton);
        Start = findViewById(R.id.startbutton);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        Clickme.setVisibility(View.INVISIBLE);
        Clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                textView.setText(String.valueOf(count));
                Random r = new Random();


                while(rand == prevRand)
                    rand = r.nextInt(5);
                switch (rand)
                {
                    case 0: Clickme.setX(20);break;
                    case 1: Clickme.setX(200);break;
                    case 2: Clickme.setX(420);break;
                    case 3: Clickme.setX(620);break;
                    case 4: Clickme.setX(800);break;
                }
                textView.setText("Your score is " + String.valueOf(count));
                prevRand = rand;
            }
        }
        );
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textView.setText("Your score is " + "0");
                Random r = new Random();
                rand = r.nextInt(5);
                Clickme.setVisibility(View.VISIBLE);
                Start.setVisibility(View.INVISIBLE);
                progressBar.setProgress(0);


                new SimpleAsyncTask(textView, Start, Clickme, progressBar).execute(); // Timer depend on count.
            }
        });
    }

}
