class Point {
    protected  double x;
    protected  double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint(double x, double y) {
	this.x = x;
	this.y = y;
    }

    static public double distance(Point p1, Point p2) {
	//System.out.println("=> Point.distance()");
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public String toString() {
        return String.format("(%6.2f, %6.2f)", x, y);
    }
}
