package TA1Test;


public class UrbanPopulation implements Comparable<UrbanPopulation>{

    private String country;
    private int percent1980;
    private int percent2008;

    public UrbanPopulation (String country, int percent1980, int percent2008) {
        this.country = country;
        this.percent1980 = percent1980;
        this.percent2008 = percent2008;
    }

    private int getDiff() {
        return percent2008-percent1980;
    }

    @Override
    public String toString() {
    return country + " : " + "1980: " + percent1980 + " 2008: " + percent2008 + " Dif: " + getDiff() + "\n";
    }

    
    @Override
    public int compareTo(UrbanPopulation o) {
        if (o.getDiff() == getDiff())
            return country.compareTo(o.country);
        return o.getDiff() > getDiff() ? -1 : 1;
    }


    
 }
