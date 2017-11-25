package tridley.android.votrmobileapplication.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tridley.android.votrmobileapplication.R;

public class WelcomeScreen extends AppCompatActivity {
    Dialog accessDialog;
    Button accessAPoll, createAPoll, currentPolls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        accessAPoll = (Button) findViewById(R.id.accessPollBtn);
        createAPoll = (Button) findViewById(R.id.createPollBtn);
        currentPolls = (Button) findViewById(R.id.currentPollBtn);

        accessAPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    accessDialog dialog = new accessDialog(WelcomeScreen.this);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
            }
        });
        createAPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createAPoll = new Intent(WelcomeScreen.this, CreateAPollScreen.class);
                startActivity(createAPoll);
            }
        });
        currentPolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentPolls = new Intent(WelcomeScreen.this, CurrentPollScreen.class);
                startActivity(currentPolls);
            }
        });

    }
}

