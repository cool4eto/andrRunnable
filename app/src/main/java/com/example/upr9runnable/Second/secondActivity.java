package com.example.upr9runnable.Second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.upr9runnable.R;

import java.sql.Time;

public class secondActivity extends AppCompatActivity implements secsChanged{

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.textView2);
        button=findViewById(R.id.button5);
        final Handler handler = new Handler();
        final TimerTask timerTask = new TimerTask(Integer.parseInt(textView.getText().toString()), secondActivity.this, handler);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button.getText().toString().equals("Start")) {
                    handler.post(timerTask);
                    button.setText("Pause");
                }
                else
                {
                    handler.removeCallbacks(timerTask);
                    button.setText("Start");
                }

            }
        });
    }

    @Override
    public void change(int secs) {
        textView.setText(Integer.toString(secs));
    }
}
