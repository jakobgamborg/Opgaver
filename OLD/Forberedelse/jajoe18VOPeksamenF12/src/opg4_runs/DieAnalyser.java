package opg4_runs;

public class DieAnalyser {
    private int max;
    private int length;
    private int[] ints;

    public DieAnalyser (int max, int length){
    this.max = max;
    ints = new int[length];
    }

    public void fillArray() {
        Die die = new Die(max);
        for(int i = 0; i< ints.length; i++){
            ints[i] = die.throwDie();
        }
    }
    public String toString() {
        boolean inRun = false;
        String r = "[";
        for(int i = 0; i < ints.length; i++){
            if(inRun){
                if (ints[i] != ints[i-1]) {
                r = r + ")";
                inRun = false;
                }
            }
            if ( i> 0)
                r = r+", ";
            if(!inRun) {
                if (i < ints.length - 1 && ints[i] == ints[i+1]) {
                    r = r+"(";
                    inRun = true;
                }
            }
            r = r + ints[i];
        }
        if (inRun){
            r = r+")";
        }
        return r + "]";
    }

    public static void main(String[] args){
        DieAnalyser da = new DieAnalyser(5,50);
        da.fillArray();
        System.out.println(da);

    }

}
