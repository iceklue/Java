package edu.mille.Project.Yatzy;

public class Player
{
    public int score = 0;
    boolean[] diceComboChecks;


    public Player()
    {
        diceComboChecks = new boolean[15];
        for(boolean b : diceComboChecks)
        {
            b = true;
        }
    }
}