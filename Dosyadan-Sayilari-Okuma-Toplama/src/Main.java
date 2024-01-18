import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("dosya.txt");
            BufferedReader bReader = new BufferedReader(fileReader);
            String line;
            int total = 0;
            while ((line = bReader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            System.out.println("Sayıların Toplamı : " + total);
            fileReader.close();
            bReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}