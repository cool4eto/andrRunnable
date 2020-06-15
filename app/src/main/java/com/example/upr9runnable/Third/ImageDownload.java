package com.example.upr9runnable.Third;

import android.util.Log;

import java.util.Random;

public class ImageDownload implements Runnable {
    FinishListener listener;
    int secs=new Random().nextInt(3)+2;

    public ImageDownload(FinishListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        for(int i=secs;i>=0;i--)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        listener.finishResult( Math.random() < 0.5);
    }
}
