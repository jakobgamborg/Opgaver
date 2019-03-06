package vop.lektion3;

import java.util.Comparator;

public class MountainRangeComperator implements Comparator<Mountain> {
    @Override
    public int compare(Mountain o1, Mountain o2) {
       return o1.getRange().compareToIgnoreCase(o2.getRange());
    }
}
