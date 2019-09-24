import java.util.Date;

public class Membership {
    private Date creationDate;
    private double earnedPoints;

    public Membership() {
        this.earnedPoints = 0;
        this.creationDate = new Date();
    }
}
