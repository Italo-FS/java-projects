import java.util.Scanner;

public class B2729 {
	public static void main(String[] args) {
		new Test();
	}

	public static class Test {
		int numberOfTests;
		String[][] testInputs;

		public Test() {
			Scanner input = new Scanner(System.in);

			readNumberOfTests(input);
			defineSizeOfArrayTestInputs();
			storeUniqueSplittedTestInputs(input);
			orderTestInputs();
			printTestInputValues();

			input.close();
		}

		private void readNumberOfTests(Scanner input) {
			numberOfTests = Integer.parseInt(input.nextLine());
		}

		private void defineSizeOfArrayTestInputs() {
			testInputs = new String[numberOfTests][];
		}

		private void storeUniqueSplittedTestInputs(Scanner input) {
			for (int i = 0; i < numberOfTests; i++)
				testInputs[i] = getUniqueWordsOnArray(input.nextLine().split(" "));
		}

		private void orderTestInputs() {
			for (int i = 0; i < (testInputs.length); i++) {
				for (int j = 0; j < (testInputs[i].length - 1); j++) {
					for (int k = 0; k < testInputs[i].length - j - 1; k++) {
						if (testInputs[i][k].compareTo(testInputs[i][k + 1]) > 0) {
							swapTestInputValues(new int[] { i, k }, new int[] { i, k + 1 });
						}
					}
				}
			}
		}

		private void swapTestInputValues(int[] firstCoord, int[] secondCoord) {
			String holder = testInputs[firstCoord[0]][firstCoord[1]];
			testInputs[firstCoord[0]][firstCoord[1]] = testInputs[secondCoord[0]][secondCoord[1]];
			testInputs[secondCoord[0]][secondCoord[1]] = holder;
		}

		public static String[] getUniqueWordsOnArray(String[] array) {
			nullRepeatedWordsInArray(array);
			return fiterNullElementsFromArray(array);
		}

		private static void nullRepeatedWordsInArray(String[] array) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == null)
					continue;
				for (int j = i + 1; j < array.length; j++) {
					if (array[i].equals(array[j]))
						array[j] = null;
				}
			}
		}

		private static int countNotNullElementsInArray(String[] array) {
			int notNullElementsCount = 0;
			for (int i = 0; i < array.length; i++)
				if (array[i] != null)
					notNullElementsCount++;
			return notNullElementsCount;
		}

		private static String[] fiterNullElementsFromArray(String[] array) {
			int filteredArraySize = countNotNullElementsInArray(array);
			String[] filteredArray = new String[filteredArraySize];
			int notNullElementsStored = 0;

			int i = 0;
			while (notNullElementsStored < filteredArraySize) {
				if (array[i] != null) {
					filteredArray[notNullElementsStored] = array[i];
					notNullElementsStored++;
				}
				i++;
			}

			return filteredArray;
		}

		private void printTestInputValues() {
			for (int i = 0; i < testInputs.length; i++) {
				System.out.println(String.join(" ", testInputs[i]));
			}
		}
	}
}
