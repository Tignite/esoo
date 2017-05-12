
class Blatt02Aufg01
{
    // Aufgabe 1a)
    // fac(21) überschreitet den Wertebereich von Long
    static long fac(long n)
    {
        if (n < 0 || n > 20)
            return -1;
        if (n == 0)
            return 1;
        else
            return n * fac (n - 1);
    }

    // Aufgabe 1b) Rückgabewert: -1 Bei Fehler, sonst: n über
    // k. Liefert schnell flasche Werte, z.B bino(49,6) ist nicht mehr
    // machbar, da schon fac(21) den Wertebereich von Long überschreitet
    static long bino(long n, long k)
    {
        // Wenn k oder n > 20, dann ist das Ergebnis sicher falsch,
        // da fac() für Zahlen > 20 immer -1 zurückgibt
        if (0 <= k && k <= n && k <= 20 && n <= 20)
            return fac(n)/(fac(k)*fac(n-k));
        else return -1;
    }

    // Bessere Variante zur Berechnung von n über k, die auch mit
    // großen n und k zurecht kommt (Siehe Bemerkung Aufgabe 1b)
    // Rückgabewert: -1 Bei unzulässigen Werten für n und k,
    // sonst: n über k
    static long binoOptimized(long n, long k)
    {
        long result;

        if (0 <= k && k <= n) {
            result = 1;
            for (long i = 1; i <= k; i++) {
                result *= (n + 1 - i);
                result /= i;
            }
        } else {
            result = -1; // -1 bedeutet Fehler
        }

        return result;
    }

    // Aufgabe 1c
    static long modLotto (long n, long k) {
        return (binoOptimized(n, k) * fac(k));
    }

    public static void main(String[] args)
    {
        int n;
        int k;

        if (args.length > 1) {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        } else {
            // Default Werte, falls keine Parameter angegeben
            n = 49;
            k = 6;
        }

        System.out.println ("fac(" + n + ") = " + fac(n));
        System.out.println ("bino(" + n + ", " + k + ") = " + bino(n,k));
        System.out.println ("binoOptimized(" + n + ", " + k + ") = " +
                            binoOptimized(n, k));
        System.out.println ("modLotto(" + n + ", " + k + ") = " +
                            modLotto(n, k));
    }
}
