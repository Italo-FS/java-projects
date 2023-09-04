import java.util.Scanner;

public class B2174 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pomedex pomedex = new Pomedex();

		pomedex.readNumberOfCapturedPomekons(sc);
		pomedex.createUniqueCapturedPomekonsArray();
		pomedex.storeUniqueCapturedPomekons(sc);
		pomedex.printRemainingNumberOfPomekons();

		sc.close();
	}

	static class Pomedex {
		int TOTAL_OF_POMEKONS = 151;
		int numberOfUniqueCapturedPomekons = 0;
		int numberOfCapturedPomekons;
		String[] capturedPomekons;

		public int readNumberOfCapturedPomekons(Scanner sc) {
			numberOfCapturedPomekons = Integer.parseInt(sc.nextLine());
			return numberOfCapturedPomekons;
		}

		protected void createUniqueCapturedPomekonsArray() {
			capturedPomekons = new String[numberOfCapturedPomekons];
		}

		protected void storeUniqueCapturedPomekons(Scanner sc) {
			for (int i = 0; i < numberOfCapturedPomekons; i++) {
				String pomekonName = sc.nextLine();
				addNewPomekonIfNotRepeated(pomekonName);
			}
		}

		protected void addNewPomekonIfNotRepeated(String pomekonName) {
			if (checkIfPomekonAlredyWasCaptured(pomekonName))
				return;
			addPomekonToCapturedList(pomekonName);
		}

		protected boolean checkIfPomekonAlredyWasCaptured(String pomekonName) {
			for (int i = 0; i < numberOfUniqueCapturedPomekons; i++) {
				if (capturedPomekons[i].equals(pomekonName))
					return true;

			}
			return false;
		}

		protected void addPomekonToCapturedList(String pomekonName) {
			capturedPomekons[numberOfUniqueCapturedPomekons] = pomekonName;
			numberOfUniqueCapturedPomekons++;
		}

		protected void printRemainingNumberOfPomekons() {
			int remainingPomekons = TOTAL_OF_POMEKONS - numberOfUniqueCapturedPomekons;
			System.out.printf("Falta(m) %d pomekon(s).%n", remainingPomekons);
		}
	}

}
