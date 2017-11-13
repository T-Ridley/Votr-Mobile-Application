package tridley.android.votrmobileapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import tridley.android.votrmobileapplication.R;

public class CreateAPollScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apoll_screen);

        Button createPoll;

        createPoll = (Button) findViewById(R.id.createPoll);
        createPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(CreateAPollScreen.this, AccessAPollScreen.class);
                startActivity(nextScreen);
            }
        });

    }
}
