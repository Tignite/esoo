class Aufgabe2 {
    public static void main(String[] args) {
        Point p1 = new Point(2,2);
        Point p2 = new Point(-2,0);
        Point3D p3 = new Point3D(1,2,3);
        Point3D p4 = new Point3D(1,2,4);

	System.out.println("Distanz zwischen " + p1 + " und " + p2 + ": " + Point.distance(p1, p2));
	// Gibt nur den Abstand in der x-y-Ebene aus:
	System.out.println("Distanz zwischen " + p3 + " und " + p4 + ": " + Point.distance(p3, p4));
	// Gibt tatsächlichen Abstand zwischen den Punkten im Raum aus:
	System.out.println("Distanz zwischen " + p3 + " und " + p4 + ": " + Point3D.distance(p3, p4));
    }
}
