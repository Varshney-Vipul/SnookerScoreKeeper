package com.simplesolutions.vipul.snookerscorekeeper;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Rohit on 6/24/2017.
 */

public class SnookerGame
{
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;
    final static int s1 = 1;
    final static int s2 = 2;
    final static int s3 = 3;
    final static int s4 = 4;
    final static int s5 = 5;
    final static int s6 = 6;
    final static int s7 = 7;
    final static int f4 = -4;
    final static int f5 = -5;
    final static int f6 = -6;
    private static int ptsOnTable=147;
    private static boolean finalYellow = true;
    private static boolean finalGreen = true;
    static int pTurn;

    private static boolean finalBrown = true;
    private static boolean finalBlue = true;
    private static boolean finalPink = true;
    private static boolean finalBlack = true;
    private static boolean gameFinish = false;
    private static int lastSum = 0;

    final static int f7 = -7;
     int numRB = 15;
    static boolean redBallPot = false;
    static ArrayList<String> playStack = new ArrayList<String>();

    public  void setNumRB(int numRB) {
        this.numRB = numRB;
    }

    public static boolean isFinalYellow() {
        return finalYellow;
    }

    public static boolean isFinalGreen() {
        return finalGreen;
    }

    public static boolean isFinalBrown() {
        return finalBrown;
    }

    public static boolean isFinalBlue() {
        return finalBlue;
    }

    public static boolean isFinalPink() {
        return finalPink;
    }

    public static boolean isFinalBlack() {
        return finalBlack;
    }

    public static boolean isGameFinish() {
        return gameFinish;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }
    public  int getNumRB() {
        return numRB;
    }

    public void updateP1Score(int scoreValue)
    {
        anyFinalColor(scoreValue);
       if(scoreValue>0)
       {
           if(scoreValue==1)
           {
               decreasePointsRemaining();
               numRB--;
               Log.d("thisBalls","1p 1st if"+getNumRB());
           }
           player1Score+=scoreValue;
           if(numRB==0 && scoreValue!=1)
           {
               numRB--;
               Log.d("thisBalls","1p 2nd if"+getNumRB());
           }
       }
       else
       {

           player2Score+=(-scoreValue);
       }
       gameFinish=gameFinish();
        Log.d("this game finish?",""+gameFinish());
    }
    public void updateP2Score(int scoreValue)
    {
        anyFinalColor(scoreValue);
        if(scoreValue>0)
        {
            if(scoreValue==1)
            {
                decreasePointsRemaining();
                numRB--;
                Log.d("thisBalls","2p 1st if"+getNumRB());
            }
            player2Score+=scoreValue;
            if(numRB==0 && scoreValue!=1)
            {
                numRB--;
                Log.d("thisBalls","2p 2nd if"+getNumRB());
            }
        }
        else
        {

            player1Score+=(-scoreValue);
        }
        gameFinish=gameFinish();
        Log.d("this game finish?",""+gameFinish());
    }
    public  boolean gameFinish()
    {
        if(gameFinish==false)
        {
            if(player1Score>player2Score+7 && ptsOnTable==7)
                return true;
            else if(player2Score>player1Score+7  && ptsOnTable==7)
                return true;
            else
                return false;
        }
        else
            return true;
    }
    public void decreasePointsRemaining()
    {
        ptsOnTable-=8;
    }
    public  void anyFinalColor(int k)
    {
        if(numRB<0)
        {
            if(k==2)
            {
                finalYellow = false;
                ptsOnTable-=2;
            }
            if(k==3)
            {
                finalGreen = false;
                ptsOnTable-=3;
            }
            if(k==4)
            {
                finalBrown = false;
                ptsOnTable-=4;
            }
            if(k==5)
            {
                finalBlue = false;
                ptsOnTable-=5;
            }
            if(k==6)
            {
                finalPink = false;
                ptsOnTable-=6;
            }
            if(k==7)
            {
                finalBlack = false;
                ptsOnTable-=7;
            }
        }
    }
    public String snookers()
    {
        int leadScore = player1Score>player2Score?player1Score:player2Score;
        int followScore = player1Score>player2Score?player2Score:player1Score;
        String losingPlayer = player1Score>player2Score?player2Name:player1Name;
        String temp;
        int rem,NOS;
        if(areSnookersRequired())
        {
            rem = (leadScore-ptsOnTable-followScore)%4;
            NOS = rem==0? ((leadScore-ptsOnTable-followScore)/4): ((leadScore-ptsOnTable-followScore)/4) + 1;
            temp = losingPlayer + " needs " + NOS + " 4 point snookers";
        }
        else
            temp = "no snookers required";
        return temp;
    }
    public Boolean areSnookersRequired()
    {
        int score1 = player1Score;
        int score2= player2Score;
        if(score1>score2+ptsOnTable)
        {

                return true;

        }
        else if(score2>score1+ptsOnTable)
        {

                return true;

        }
        else
            return false;
    }
}
