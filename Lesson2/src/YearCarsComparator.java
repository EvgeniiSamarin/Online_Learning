import java.util.Comparator;

public class YearCarsComparator implements Comparator<Cars> {


    @Override
    public int compare(Cars o1, Cars o2) {
        int diff = o1.getYear() - o2.getYear();
        if (diff != 0) {
            return diff;
        }
        return o1.getModel().compareTo(o2.getModel());


    }
}
