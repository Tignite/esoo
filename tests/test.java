class test {
    static void langform() {
        int[] array = {1, 2, 3, 4};
        int i = 0;
        array[i++] = array[i++] + 1;

        System.out.print("langform: ");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static void kurzform() {
        int[] array = {1, 2, 3, 4};
        int i = 0;
        array[i++] += 1;

        System.out.print("kurzform: ");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static class Auto {

    }

    public static void main (String[] args) {
        Auto auto = new Auto();

        langform();
        kurzform();

        System.out.println(-1 >> 1);
        System.out.println(-1 << 1);
        System.out.println(-1/2 == 0);
        System.out.println((byte) 127);
        System.out.println((byte) 128);
        System.out.println((byte) 129);

        final int a = 4;

        switch (3) {
        case 3: {System.out.println(3); break;}
        case a: {System.out.println(3); break;}
        }


        int[] array = {1,2,3};
        System.out.println(array.length + "test".length());
    }
}
