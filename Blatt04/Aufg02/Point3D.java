class Point3D extends Point {
    protected double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
	this.z = z;
    }

    public void movePoint(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    static public double distance(Point3D p1, Point3D p2) {
	//System.out.println("=> Point3D.distance()");
        return Math.sqrt(Math.pow(p2.x - p1.x, 2)
                         + Math.pow(p2.y - p1.y, 2)
                         + Math.pow(p2.z - p1.z, 2));
    }

    public String toString() {
        return String.format("(%6.2f, %6.2f, %6.2f)", x, y, z);
    }
}
