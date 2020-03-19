public class Price implements Comparable<Cars> {
    private int price;

    @Override
    public int compareTo(Cars o) {
        return this.price - o.price;
    }
}
