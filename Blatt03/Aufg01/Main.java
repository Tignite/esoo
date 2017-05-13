
class Main {
    public static void main(String[] argv) {
        Sheep sheep = new Sheep("Harry", new Fur(10));
        Sheep clonedSheep = sheep.clone();
        Sheep shallowcloneSheep = sheep.shallowclone();
        Sheep deepcloneSheep = sheep.deepclone();

        // Aufgabe 1a)
        System.out.println("sheep             : " + sheep);
        System.out.println("clonedSheep       : " + clonedSheep);
        System.out.println("shallowcloneSheep : " + shallowcloneSheep);
        System.out.println("deepcloneSheep    : " + deepcloneSheep);

        System.out.println("\nWeise jetzt sheep (oder clonedSheep, da beide\n" +
                           "die selbe Sheep Instanz referenzieren) den Namen\n" +
                           "\"Hardy\" zu und scheere es!");
        // Sheep und clonedSheep heißen jetzt _beide_ Hardy und sind
        // _beide_ geschoren.  Dies liegt daran, dass die
        // Sheep.clone() methode @this zurückgibt, also eine Referenz
        // auf das Shaaf, das geklont werden soll. Es wird also nichts
        // 'geklont', sondern lediglich eine weitere Variable vom Typ
        // clonedSheep initialisiert, die wieder auf das zu klonende
        // Shaaf verweist.
        //
        clonedSheep.name = "Hardy";
        clonedSheep.shear();

        System.out.println("sheep             : " + sheep);
        System.out.println("clonedSheep       : " + clonedSheep);
        System.out.println("shallowcloneSheep : " + shallowcloneSheep);
        System.out.println("deepcloneSheep    : " + deepcloneSheep);

        System.out.println("\nLasse das Fell von sheep um 10 wachsen:");
        sheep.fur.length = 10;
        System.out.println("sheep             : " + sheep);
        System.out.println("clonedSheep       : " + clonedSheep);
        System.out.println("shallowcloneSheep : " + shallowcloneSheep);
        System.out.println("deepcloneSheep    : " + deepcloneSheep);

        System.out.println("\nBenenne sheep um in Howdy:");
        sheep.name = "Howdy";
        sheep.fur.length = 10;
        System.out.println("sheep             : " + sheep);
        System.out.println("clonedSheep       : " + clonedSheep);
        System.out.println("shallowcloneSheep : " + shallowcloneSheep);
        System.out.println("deepcloneSheep    : " + deepcloneSheep);


        // Vergleiche paarweise alle Schaafe mit .equal() auf Gleicheit
        System.out.println("\nVergleiche paarweise alle Schaafe mittles der .equal() Methode:");

        Sheep[] herd = {sheep, clonedSheep, shallowcloneSheep, deepcloneSheep};
        String[] variableNames = {"sheep", "clonedSheep",
                                  "shallowcloneSheep", "deepcloneSheep"};

        for (int i = 0; i < herd.length - 1; i++) {
            for (int j = i; j < herd.length; j++)
                System.out.println(variableNames[i] +
                                   ".equals(" + variableNames[j] + "): " +
                                   herd[i].equals(herd[j]));
        }


    }
}
