public class Coord {

    private int x,z;

    public Coord(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    /**
     * Gets the distance bertween two {@link Coord}s.
     * @param coord
     * @return
     */
    public double distance(Coord coord) {
        float dx = (float) (x - coord.x);
        float dz = (float) (z - coord.z);
        return Math.sqrt(dx * dx + dz * dz);
    }

    /**
     * {@see https://stackoverflow.com/a/9970297}
     * @param target
     * @return
     */
    public float direction(Coord target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.z - z, target.x - x));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }

    public boolean isZero() {
        return x == 0 && z == 0;
    }

    public boolean equals(Coord coord) {
        return x == coord.x && z == coord.z;
    }

    @Override
    public String toString() {
        return "x: " + x + ", z: " + z;
    }
}
