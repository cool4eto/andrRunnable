package com.example.upr9runnable.Second;

import android.os.Handler;

public class TimerTask implements Runnable {
    int passedTime;
    secsChanged listener;
    android.os.Handler handler=new Handler();
    public TimerTask(int passedTime, com.example.upr9runnable.Second.secsChanged secsChanged,Handler handler1) {
        this.passedTime = passedTime;
        this.listener = secsChanged;
        this.handler=handler1;
    }

    public void run() {
        passedTime++;
        handler.postDelayed(this, 1000);
        listener.change(passedTime);

    }
}
