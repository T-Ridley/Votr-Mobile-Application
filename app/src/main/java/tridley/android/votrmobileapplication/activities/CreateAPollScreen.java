package tridley.android.votrmobileapplication.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tridley.android.votrmobileapplication.R;

public class CreateAPollScreen extends AppCompatActivity {

    Button createPoll;
    EditText date,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apoll_screen);


        createPoll = (Button) findViewById(R.id.currentPollBtn);
        date = (EditText) findViewById(R.id.dateInsert);
        time = (EditText) findViewById(R.id.timeInsert);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog dialog = new datePickerDialog(CreateAPollScreen.this);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog dialog = new timePickerDialog(CreateAPollScreen.this);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        createPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(CreateAPollScreen.this, PollScreen.class);
                startActivity(nextScreen);
            }
        });

    }

}
