public class Mileage implements Comparable<Mileage> {
    private int mile;
    private int getMile(){
        return this.mile;
    }

    @Override
    public int compareTo(Mileage o) {

        return this.getMile() - o.getMile();
    }


}
