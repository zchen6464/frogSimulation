package com.company;

public class FrogSimulation {
    private int goalDistance;
    private int maxHops;
    public int[] testHops;
    public int nextHopIndex;

    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        if(nextHopIndex < testHops.length)
        {
            int x = testHops[nextHopIndex];
            nextHopIndex++;
            return x;
        }
        else
        {
            return 0;
        }
    }

    public boolean simulate()
    {
        int currHops = 0;
        int currDist = 0;
        while(currHops <= maxHops && currDist >= 0 && currDist <= goalDistance)
        {
            currDist += hopDistance();
            currHops++;
        }
        return(currDist >= goalDistance);
    }

    public double runSimulations(int num)
    {
        int numtrue = 0;
        for(int i = 0; i < num; i ++)
        {
            if(simulate())
            {
                numtrue ++;
            }
        }
        return (double)(numtrue/num);
    }
}
