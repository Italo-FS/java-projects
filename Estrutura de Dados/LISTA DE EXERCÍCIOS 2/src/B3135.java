import java.util.Scanner;

public class B3135 {
	public static void main(String[] args) {
		String[] names = getInputs();
		orderArray(names);
		NameNodeLineArray nameNodeLineArray = new NameNodeLineArray(names);
		nameNodeLineArray.printLines();
	}

	public static String[] getInputs() {
		Scanner scanner = new Scanner(System.in);

		int numberOfInputs = Integer.parseInt(scanner.nextLine());
		String[] names = new String[numberOfInputs];

		for (int i = 0; i < numberOfInputs; i++) {
			names[i] = scanner.nextLine();
		}

		scanner.close();
		return names;
	}

	public static void orderArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].length() > array[j + 1].length()) {
					String holder = array[j];
					array[j] = array[j + 1];
					array[j + 1] = holder;
				}
			}
		}
	}

	public static class NameNodeLineArray {
		NameNodeLine firstNameNodeLine;
		NameNodeLine lastNameNodeLine;

		public NameNodeLineArray(String[] array) {
			firstNameNodeLine = null;
			lastNameNodeLine = null;

			for (int i = 0; i < array.length; i++) {
				addNameString(array[i]);
			}
		}

		public void addNameString(String name) {
			NameNode nameNode = new NameNode(name);

			if (firstNameNodeLine == null)
				addFirstString(nameNode);
			else
				addNameNodeOnFirstLinePossible(nameNode);
		}

		private void addNameNodeOnFirstLinePossible(NameNode nameNode) {
			NameNodeLine nameNodeLine = firstNameNodeLine;

			while (nameNodeLine != null) {
				if (nameNodeLine.addNameNode(nameNode))
					return;
				nameNodeLine = nameNodeLine.nextLineNode;
			}
			addNameNodeLine(new NameNodeLine(nameNode));
		}

		private void addFirstString(NameNode nameNode) {
			NameNodeLine nameNodeLine = new NameNodeLine(nameNode);
			this.firstNameNodeLine = nameNodeLine;
			this.lastNameNodeLine = nameNodeLine;
		}

		public void addNameNodeLine(NameNodeLine nameNodeLine) {
			lastNameNodeLine.nextLineNode = nameNodeLine;
			lastNameNodeLine = nameNodeLine;
		}

		public void printLines() {
			NameNodeLine nameNodeLine = firstNameNodeLine;
			do {
				nameNodeLine.printNames();
				nameNodeLine = nameNodeLine.nextLineNode;
			} while (nameNodeLine != null);
		}
	}

	public static class NameNodeLine {
		NameNode firstNameNode;
		NameNode lastNameNode;
		NameNodeLine nextLineNode;

		public NameNodeLine(NameNode nameNode) {
			this.firstNameNode = nameNode;
			this.lastNameNode = nameNode;
			this.nextLineNode = null;
		}

		public boolean addNameNode(NameNode nameNode) {
			if (nameNode.lenght <= lastNameNode.lenght)
				return false;
			lastNameNode.nextNameNode = nameNode;
			lastNameNode = nameNode;
			return true;
		}

		public void printNames() {
			NameNode nameNode = firstNameNode;
			do {
				System.out.printf("%s%s", nameNode.value, nameNode.nextNameNode != null ? ", " : "");
				nameNode = nameNode.nextNameNode;
			} while (nameNode != null);
			System.out.println();
		}
	}

	public static class NameNode {
		String value;
		int lenght;
		NameNode nextNameNode;

		public NameNode(String value) {
			this.value = value;
			this.lenght = value.length();
			this.nextNameNode = null;
		}
	}
}
