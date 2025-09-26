// Roberto Fernández del Barrio 43232819H
package audx01;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the source file:");
        String originFile = scanner.nextLine();

        System.out.println("Enter the path of the destination file:");
        String destinationFile = scanner.nextLine();

        System.out.println("Is the file binary? (yes/no):");
        String answer = scanner.nextLine().trim().toLowerCase();
        boolean isBinary = answer.equals("yes");

        try {
            if (isBinary) {
                copyBinaryFile(originFile, destinationFile);
                System.out.println("Binary file copied successfully.");
            } else {
                copyTextFile(originFile, destinationFile);
                System.out.println("Text file copied successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }

        scanner.close();
    }

    // Method for copying binary files
    public static void copyBinaryFile(String origin, String destination) throws IOException {
        try (InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    // Method for copying text files
    public static void copyTextFile(String origin, String destination) throws IOException {
        try (Reader in = new FileReader(origin);
                Writer out = new FileWriter(destination)) {

            char[] buffer = new char[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}
