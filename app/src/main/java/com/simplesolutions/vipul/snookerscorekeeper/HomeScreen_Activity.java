package com.simplesolutions.vipul.snookerscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeScreen_Activity extends AppCompatActivity {
    static String Player1Name;
    static String Player2Name;
    static boolean gameSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void onClickSnooker(View view)
    {
       // startActivityForResult(new Intent("com.simplesolutions.vipul.snookerscorekeeper.PlayersNameActivity"),1);
        //if(gameSet)
        startActivity(new Intent("com.simplesolutions.vipul.snookerscorekeeper.PlayersNameActivity"));
        //startActivity(new Intent("com.simplesolutions.vipul.snookerscorekeeper.SnookerActivity"));
    }
    public void onClickRace(View view)
    {
        //startActivity(new Intent("com.simplesolutions.vipul.snookerscorekeeper.PlayersNameActivity"));
        startActivity(new Intent("com.simplesolutions.vipul.snookerscorekeeper.RaceActivity"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen_, menu);
        return true;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1)
        {
            if(resultCode==RESULT_OK)
            {
                Player1Name = data.getStringExtra("p1name");
                Player1Name = data.getStringExtra("p2name");
                Toast.makeText(this,Player1Name,Toast.LENGTH_SHORT).show();
                Toast.makeText(this,Player2Name,Toast.LENGTH_SHORT).show();
                gameSet=true;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
