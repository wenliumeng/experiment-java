package temp;

class tempobj {
    private static int counter;
    private  int id = counter++;

    @Override
    public String toString() {
        return "temp.tempobj " + id;
    }
}
