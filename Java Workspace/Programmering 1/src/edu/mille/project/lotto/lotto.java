package edu.mille.project.lotto;


//FIX CONSTANT!!
public class lotto
{
    public static int maxNum;
    public static int guessNum;
    public static double[] RatioX;
    public static long total = 0;


    public static void CalculateResults(int max, int _guessNum)
    {
        maxNum = max;
        guessNum = _guessNum;
        RatioX = new double[guessNum];
        total = (long)(1/(CalculateNumerator(6)/CalculateDenominator()));
        /*
        * to calculate P(6 rätt)
        * we take ((n(n+1))/2) * P(1:a fel) * P(2:a rätt) ...
         */

        for (int i = 0; i < guessNum; i++)
        {
            if(i == (guessNum-1))
            {
                RatioX[i] = CalculateNumerator(i)/CalculateDenominator();
            }
            else
            {

                RatioX[i] = CalculateConstant(guessNum - i-1) * (CalculateNumerator(i)/CalculateDenominator());
            }
            System.out.println(RatioX[i]);
        }
    }
    public static void ShowResults()
    {
        for (int i = 0; i < RatioX.length; i++)
        {
            System.out.println("Wow");
            System.out.println((1/RatioX[i]));
        }
    }

    public static double CalculateNumerator (long n)
    {
        //n = what iteration we are on
        long n2 = (guessNum-n-1);
        double product = 1;
        for (int i = 1; i<=guessNum; i++)
        {
            if(i <= n2) {
                product *= (maxNum - i);
            }
            else {
                product *= i;
            }
        }
        return product;
    }

    public static double CalculateDenominator()
    {
        double product = 1;
        for (long i = maxNum; i > (maxNum-guessNum); i--)
        {
            product *= i;
        }
        return product;
    }

    public static double CalculateConstant(long numOfMisses)
    {
        //Formula
        //(n(n+1))/2

        long n = guessNum+1-numOfMisses;
        if(numOfMisses == 1)
            return 7;
        else {
            System.out.println("Misses: " + numOfMisses);
            System.out.println("consst: " + (n * (n + 1) / 2));
            return n * (n + 1) / 2;
        }
    }

    public static double CalculateFaculty(long f)
    {
        if(f == 0)
            return 1;
        else if(f == 1)
            return 1;
        else
            return f * CalculateFaculty(f-1);
    }
}
