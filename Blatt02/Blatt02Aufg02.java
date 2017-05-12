
class Blatt02Aufg02
{
    private static String ieee754BitPattern (float f)
    {
        String zero32 = "00000000000000000000000000000000";
        String unpadded = Integer.toBinaryString(Float.floatToRawIntBits(f));
        return zero32.substring(unpadded.length()) + unpadded;
    }

    private static String ieee754BitPattern (double d)
    {
        String zero64 ="0000000000000000000000000000000000000000000000000000000000000000";
        String unpadded = Long.toBinaryString(Double.doubleToRawLongBits(d));
        return zero64.substring(unpadded.length()) + unpadded;
    }

    public static void main(String args[])
    {
        System.out.printf("6.5f %s 6.5d\n", 6.5f == 6.5 ? "==" : "!=");
        System.out.printf("6.4f %s 6.4d\n", 6.4f == 6.4 ? "==" : "!=");

        /* Erklärung: Floating-Point Literale mit einem Dezimalpunkt
         * ohne Suffix 'f' oder 'd' werden als double Typ
         * interpretiert, Floating-Point Literale mit Suffix 'f' als
         * float.
         *
         * Zum Vergleichen wird nun der Float Wert zu einem Double
         * Wert erweitert (widening). Da die Mantisse in der IEEE 754
         * Double Precision größer ist als im Single Precision Format,
         * wird der periodische Teil der Mantisse (im Fall von 6.4f ->
         * 6.4d) abgeschnitten, während er bei 6.4 entsprechend länger
         * ist. Somit sind beide Zahlen unterschiedlich.
         */
        System.out.println("\nIEEE 754 Bit-Repräsentation von '6.5d':");
        System.out.println(ieee754BitPattern (6.5d));

        System.out.println("\nIEEE 754 Bit-Repräsentation von '6.5f':");
        System.out.println(ieee754BitPattern (6.5f));

        System.out.println("\nIEEE 754 Bit-Repräsentation von '(double) 6.5f':");
        System.out.println(ieee754BitPattern ((double) 6.5f));

        System.out.println("\nIEEE 754 Bit-Repräsentation von '6.4d':");
        System.out.println(ieee754BitPattern (6.4d));

        System.out.println("\nIEEE 754 Bit-Repräsentation von '6.4f':");
        System.out.println(ieee754BitPattern (6.4f));

        System.out.println("\nIEEE 754 Bit-Repräsentation von '(double) 6.4f':");
        System.out.println(ieee754BitPattern ((double) 6.4f));
    }
}
