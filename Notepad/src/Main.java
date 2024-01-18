import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Bir metin girin: ");
            String metin = scanner.nextLine();

            fileSave("not.txt", metin);

            String lastSave = fileRead("not.txt");
            System.out.println("En son kaydedilen metin: " + lastSave);

        } catch (IOException e) {
            System.err.println("HATA!!  " + e.getMessage());
        }
    }
    private static void fileSave(String fileName, String metin) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            printWriter.print(metin);
        }
    }
    private static String fileRead(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        }
    }
}