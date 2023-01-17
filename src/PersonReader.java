import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) throws IOException {
        //counter
        Scanner fileScanner = null;
        File selectedFile = null;

        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            fileScanner = new Scanner(selectedFile);
        }


        System.out.println("ID#    Firstname   Lastname  Title    YOB");
        System.out.println("============================================\n");

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                System.out.print(word + "   ");
            }
            System.out.print("\n");


            lineScanner.close();
        }
        fileScanner.close();
    }
}
