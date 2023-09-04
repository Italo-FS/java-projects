import java.util.Scanner;

public class ListaDinamica {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		NameNodeLineArray nameNodeLineArray = new NameNodeLineArray();

		int numberOfInputs = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < numberOfInputs; i++) {
			nameNodeLineArray.addNameString(scanner.nextLine());
		}

		scanner.close();

		System.out.println();
		System.out.println("===============================================");

		nameNodeLineArray.printLines();
	}

	public static class NameNodeLineArray {
		NameNodeLine firstNameNodeLine;
		NameNodeLine lastNameNodeLine;

		public NameNodeLineArray() {
			firstNameNodeLine = null;
			lastNameNodeLine = null;
		}

		public void addNameString(String name) {
			NameNode nameNode = new NameNode(name);

			if (firstNameNodeLine == null)
				addFirstString(nameNode);
			else {
				if (!lastNameNodeLine.addNameNode(nameNode)) {
					addNameNodeLine(new NameNodeLine(nameNode));
				}
			}
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