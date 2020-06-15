package com.example.upr9runnable.Third;

import java.util.Random;

public class Login implements Runnable{
    FinishListener listener;
    int secs=new Random().nextInt(2)+3;
    public Login(FinishListener listener) {
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
