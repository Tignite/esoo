
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Bank abzockBank = new Bank("abzockBank", 1000000);
		 Bank meineBank = new Bank("meineBank", 7000000);
		 Bank investmentBank = new Bank("investmentBank", 20000000);
		 //System.out.println(testKonto);
		 //System.out.println(testKonto.erstelleAuszug());
		 Object kontoMin = abzockBank.kontoErstellen("Investor", "Gro�er");
		 Object kontoNorm = meineBank.kontoErstellen("Investor", "Gro�er");
		 Object kontoMax = investmentBank.kontoErstellen("Investor", "Gro�er");
		 abzockBank.einzahlen(kontoMin, 8000000);
		 meineBank.einzahlen(kontoNorm, 8000000);
		 investmentBank.einzahlen(kontoMax, 8000000);
		 //System.out.println(meineBank);
		 //System.out.println(abzockBank);
		 //System.out.println(meineBank.kapitalErmitteln());
		 //meineBank.kontoTransferieren(abzockBank, kontoMax);
		 //meineBank.kontoTransferieren(abzockBank, 301174348);
		 //System.out.println(abzockBank);
		 //System.out.println(meineBank);
		 //System.out.println(investmentBank);
		 for(int i = 0; i < 100; i++) {
			 abzockBank.invest();
			 meineBank.invest();
			 investmentBank.invest();
		 }
		 //System.out.println(meineBank);
		 abzockBank.jahresBericht();
		 meineBank.jahresBericht();
		 investmentBank.jahresBericht();
	}

}
