package com.simplesolutions.vipul.snookerscorekeeper;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Snooker_Activity extends AppCompatActivity implements View.OnClickListener
{
    static int snookerFrameOn = 1;

    static SnookerGame sg;
    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;
    static int playerTurn = 2;
    private static Button s1;
    private static Button s2;
    private static Button s3;
    private static Button s4;
    private static Button s5;
    private static Button s6;
    private static Button s7;
    private static Button noPoints; // when after a potting a red, respective player doesn't pot a color
    private static Button f4;
    private static Button f5;
    private static Button f6;
    private static Button f7;
    private static Button snookersButton;
    private static Button finishButton;
    private static TextView p1TV;
    private static TextView p2TV;
    private static TextView scoreTV1;
    private static TextView scoreTV2;
    private static TextView breakTV;
    private static ImageView p1bar;
    private static ImageView p2bar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snooker_);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sg = new SnookerGame();

        Intent fromPNA = this.getIntent(); // intent from players name activity

            sg.setPlayer1Name(fromPNA.getStringExtra("p1name"));
            sg.setPlayer2Name(fromPNA.getStringExtra("p2name"));


        p1TV = (TextView)findViewById(R.id.p1namelabel);
        p2TV = (TextView)findViewById(R.id.p2namelabel);
        scoreTV1 = (TextView)findViewById(R.id.P1Score);
        scoreTV2 = (TextView)findViewById(R.id.P2Score);
        breakTV = (TextView)findViewById(R.id.breakview);
        p1TV.setText(sg.getPlayer1Name());
        p2TV.setText(sg.getPlayer2Name());
        s1 = (Button)findViewById(R.id.score1);
        s2 = (Button)findViewById(R.id.score2);
        s3 = (Button)findViewById(R.id.score3);
        s4 = (Button)findViewById(R.id.score4);
        s5 = (Button)findViewById(R.id.score5);
        s6 = (Button)findViewById(R.id.score6);
        s7 = (Button)findViewById(R.id.score7);
        f4 = (Button)findViewById(R.id.foul4);
        f5 = (Button)findViewById(R.id.foul5);
        f6 = (Button)findViewById(R.id.foul6);
        f7 = (Button)findViewById(R.id.foul7);
        snookersButton=(Button)findViewById(R.id.snookers);
        noPoints = (Button)findViewById(R.id.nopoints);
        finishButton= (Button)findViewById(R.id.gameOver) ;
        p1bar = (ImageView)findViewById(R.id.p1bar);
        p2bar = (ImageView)findViewById(R.id.p2bar);
        p1TV.setOnClickListener(this);
        p2TV.setOnClickListener(this);
        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        s6.setOnClickListener(this);
        s7.setOnClickListener(this);
        f4.setOnClickListener(this);
        f5.setOnClickListener(this);
        f6.setOnClickListener(this);
        f7.setOnClickListener(this);
        noPoints.setOnClickListener(this);
        snookersButton.setOnClickListener(this);
        finishButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });
        p2bar.setVisibility(View.INVISIBLE);
        p1bar.setVisibility(View.INVISIBLE);
        finishButton.setVisibility(View.GONE);
        hideButtons();

    }
    public static void hideButtons()
    {
        if(sg.getNumRB()>0)
        {
            s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.GONE);
            s3.setVisibility(View.GONE);
            s4.setVisibility(View.GONE);
            s5.setVisibility(View.GONE);
            s6.setVisibility(View.GONE);
            s7.setVisibility(View.GONE);
            noPoints.setVisibility(View.GONE);
        }
        if(sg.getNumRB()<=0)
        {
          /*  noPoints.setVisibility(View.GONE);
            if(!sg.isFinalYellow())
            {
                s2.setVisibility(View.GONE);
            }
            if(!sg.isFinalGreen())
            {
                s3.setVisibility(View.GONE);
            }
            if(!sg.isFinalBrown())
            {
                s4.setVisibility(View.GONE);
            }
            if(!sg.isFinalBlue())
            {
                s5.setVisibility(View.GONE);

            }
            if(!sg.isFinalPink())
            {
                s6.setVisibility(View.GONE);
            }
            if(!sg.isFinalBlack())
            {
                s7.setVisibility(View.GONE);
                thisGameFinished();
                finishButton.setVisibility(View.VISIBLE);
            }*/
          finalColors();
        }


    }
    public static void finalColors()
    {
        noPoints.setVisibility(View.GONE);
        if(!sg.isFinalYellow())
        {
            s2.setVisibility(View.GONE);
            if(!sg.isFinalGreen())
            {
                s3.setVisibility(View.GONE);
                if(!sg.isFinalBrown())
                {
                    s4.setVisibility(View.GONE);
                    if(!sg.isFinalBlue())
                    {
                        s5.setVisibility(View.GONE);
                        if(!sg.isFinalPink())
                        {
                            s6.setVisibility(View.GONE);
                            if(!sg.isFinalBlack())
                            {
                                s7.setVisibility(View.GONE);
                                thisGameFinished();
                                finishButton.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                s7.setVisibility(View.VISIBLE);
                            }
                        }
                        else
                        {
                            s6.setVisibility(View.VISIBLE);
                        }
                    }
                    else
                    {
                        s5.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    s4.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                s3.setVisibility(View.VISIBLE);
            }
        }
        else
        {
            s2.setVisibility(View.VISIBLE);
        }
    }
    public static void viewButtons()
    {
        if(sg.getNumRB()>=0)
        {
            s1.setVisibility(View.INVISIBLE);
            s2.setVisibility(View.VISIBLE);
            s3.setVisibility(View.VISIBLE);
            s4.setVisibility(View.VISIBLE);
            s5.setVisibility(View.VISIBLE);
            s6.setVisibility(View.VISIBLE);
            s7.setVisibility(View.VISIBLE);
            noPoints.setVisibility(View.VISIBLE);
        }


    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.score1:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s1);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    viewButtons();
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s1);
                    scoreTV2.setText(""+sg.getPlayer2Score());
                    viewButtons();
                }
                break;

            }
            case R.id.score2:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s2);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s2);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.score3:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s3);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s3);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.score4:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s4);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s4);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.score5:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s5);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s5);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.score6:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s6);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s6);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.score7:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.s7);
                    hideButtons();
                    scoreTV1.setText(""+sg.getPlayer1Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.s7);
                    hideButtons();
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.nopoints:
            {
               // Log.d("thisaintWorking","this game button works");
                //sg.setNumRB(sg.numRB--);
                //Log.d("thisBalls",""+sg.getNumRB());
                p1bar.setVisibility(View.GONE);
                p2bar.setVisibility(View.GONE);
                playerTurn=2;
                hideButtons();
                break;
            }
            case R.id.foul4:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.f4);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.f4);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.foul5:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.f5);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.f5);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.foul6:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.f6);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.f6);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.foul7:
            {
                if(playerTurn==0)
                {
                    sg.updateP1Score(SnookerGame.f7);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                if(playerTurn==1)
                {
                    sg.updateP2Score(SnookerGame.f7);
                    scoreTV1.setText(""+sg.getPlayer1Score());
                    scoreTV2.setText(""+sg.getPlayer2Score());
                }
                break;

            }
            case R.id.p1namelabel:
            {
                if(playerTurn==2 || playerTurn==1)
                {
                    //thisGameFinished();
                    playerTurn = 0;
                    sg.pTurn = 0;
                    p1bar.setVisibility(View.VISIBLE);
                    p2bar.setVisibility(View.INVISIBLE);
                }
                else
                {
                    playerTurn=2;
                    sg.pTurn=2;
                    p1bar.setVisibility(View.INVISIBLE);
                }
                break;
            }
            case R.id.p2namelabel:{
                if(playerTurn==2 || playerTurn==0)
                {
                    //thisGameFinished();
                    playerTurn = 1;
                    sg.pTurn=1;
                    p1bar.setVisibility(View.INVISIBLE);
                    p2bar.setVisibility(View.VISIBLE);
                }
                else
                {
                    //thisGameFinished();
                    playerTurn=2;
                    sg.pTurn=2;
                    p2bar.setVisibility(View.INVISIBLE);
                }
                break;
            }
            case R.id.snookers:
            {

;                String temp = sg.snookers();
                Bundle tBund = new Bundle();
                tBund.putString("snookerString",temp);
                SnookersFragment newSf = new SnookersFragment();
                newSf.setArguments(tBund);
                newSf.show(getFragmentManager(),"123");
            }
        }

    }
    public static void thisGameFinished()
    {
        if(sg.isGameFinish())
        {
            s1.setVisibility(View.GONE);
            s2.setVisibility(View.GONE);
            s3.setVisibility(View.GONE);
            s4.setVisibility(View.GONE);
            s5.setVisibility(View.GONE);
            s6.setVisibility(View.GONE);
            s7.setVisibility(View.GONE);
            noPoints.setVisibility(View.GONE);
            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);
            f7.setVisibility(View.GONE);
            snookersButton.setVisibility(View.GONE);
            p1bar.setVisibility(View.GONE);
            p2bar.setVisibility(View.GONE);
            if(sg.getPlayer1Score()>sg.getPlayer2Score())
            {
                scoreTV1.setText("wins");
                p2TV.setText(""+sg.getPlayer1Score());
                breakTV.setText(""+sg.getPlayer2Score());

            }
            else
            {
                scoreTV2.setText("wins");
                p1TV.setText(""+sg.getPlayer2Score());
                breakTV.setText(""+sg.getPlayer1Score());

            }

        }
    }

}
