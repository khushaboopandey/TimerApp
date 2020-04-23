package com.chandan.simpletimerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab,fab2;
    TextView textView;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        textView = findViewById(R.id.text);

        counter = 0;

        textView.setText("0");
        Toast.makeText(getApplicationContext(),"Click The Button To Start Timings",Toast.LENGTH_LONG).show();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"testing",Toast.LENGTH_LONG).show();

                final Handler handler = new Handler();

               final Runnable runnable = new Runnable()
               {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(counter));
                        counter++;

                        handler.postDelayed(this,1000);

                    }
                }; handler.post(runnable);
                fab2=findViewById(R.id.fab2);
                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        handler.removeCallbacks(runnable);

                    }
                });
            }
        });
    }


}
