package com.example.android.historyapp.data;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.MediaController;


//Implemented my own MediaController class and over-ride hide() so android does not hide the controller after 3 seconds.
public class MyMediaController extends MediaController {

    public MyMediaController(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        show(0);
        return true;
    }

    @Override
    public void hide() {
        this.show();
    }
}
