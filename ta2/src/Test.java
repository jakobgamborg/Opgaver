import java.util.ArrayList;
import java.util.List;

public class Test {

    ArrayList<int> list = new ArrayList<>() ;

    public ArrayList<int> getList() {
        return list;
    }

    public void inset() {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
    }


    public static void main(String[] args) {

        Test test = new Test();
        ArrayList list = test.getList();
        Integer sum = 0;

        for (int i = 0; i < list.size(); i++)
            sum += list.get(i);

        System.out.println();
        for (int i : list)
            sum += i;

    }
        }