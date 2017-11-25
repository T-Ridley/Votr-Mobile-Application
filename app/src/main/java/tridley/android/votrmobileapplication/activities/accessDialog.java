package tridley.android.votrmobileapplication.activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import tridley.android.votrmobileapplication.R;

public class accessDialog extends Dialog implements View.OnClickListener {

    public Activity a;
    public Dialog d;


    public accessDialog (Activity a){
        super(a);

        this.a = a;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.accessdialog);

        Button access = (Button) findViewById(R.id.accessPollBtn);
        Button cancel = (Button) findViewById(R.id.cancelPollBtn);
        EditText accessCode = (EditText) findViewById(R.id.accessCodeEditText);
    }


    @Override
    public void onClick (View v){

    }

}
