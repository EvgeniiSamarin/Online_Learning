import java.util.Comparator;

public class HpCarsComparator implements Comparator<Cars> {


    @Override
    public int compare(Cars o1, Cars o2) {
        return o1.getHp() - o2.getHp();
    }
}
