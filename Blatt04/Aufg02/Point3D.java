class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z) {
        // Rufe Konstruktor der Oberklasse (Point) auf
        super(x, y);
        this.z = z;
    }

    static public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2)
                         + Math.pow(p2.y - p1.y, 2)
                         + Math.pow(p2.y - p1.y, 2));
    }

    public String toString() {
        return String.format("(%6.2f, %6.2f, %6.2f)", x, y, z);
    }

}
