package com.simplesolutions.vipul.snookerscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class PlayersName_Activity extends AppCompatActivity {
    static EditText player1Name;
    static EditText player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onClick(View view)
    {
        Intent data = new Intent("com.simplesolutions.vipul.snookerscorekeeper.SnookerActivity");
       player1Name = (EditText)findViewById(R.id.P1Name);
       player2Name = (EditText)findViewById(R.id.P2Name);
        String p1 = player1Name.getText().toString();
        String p2 = player2Name.getText().toString();
        data.putExtra("p1name",p1);
        data.putExtra("p2name",p2);
        startActivity(data);

        finish();
    }

}
