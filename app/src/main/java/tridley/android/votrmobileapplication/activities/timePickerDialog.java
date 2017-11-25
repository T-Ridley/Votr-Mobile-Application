package tridley.android.votrmobileapplication.activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TimePicker;

import tridley.android.votrmobileapplication.R;

/**
 * Created by vondrinho on 11/24/17.
 */

public class timePickerDialog extends Dialog implements View.OnClickListener {

    public Activity a;
    public Dialog d;

    public timePickerDialog (Activity a){
        super(a);

        this.a = a;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.timepicker);

        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Button select = (Button) findViewById(R.id.selectButton);
    }


    @Override
    public void onClick (View v){

    }
}
