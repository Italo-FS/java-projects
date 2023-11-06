import java.util.Scanner;

public class B1257 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfTests; i++) {
            int caseSize = Integer.parseInt(sc.nextLine());
            String[] strings = new String[caseSize];
            for (int j = 0; j < caseSize; j++) {
                strings[j] = sc.nextLine();
            }
            System.out.println(hash(strings));
        }

        sc.close();
    }

    public static int hash(String[] string) {
        int hash = 0;
        int base = 65;
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < string[i].length(); j++) {
                hash = hash + string[i].charAt(j) - base + i + j;
            }
        }
        return hash;
    }
}
