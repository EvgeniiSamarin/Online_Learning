public class Length implements Comparable<Cars> {
    private int length;
    private int getLength(){
        return this.length;
    }


    @Override
    public int compareTo(Cars o) {
        return this.getLength() - o.getLength();
    }
}
