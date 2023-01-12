import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        boolean done = false;

        ArrayList<String> personsData = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        do {
            ID = SafeInput.getRegExString(in, "Enter a 4-digit id", "" + "\\d{4}");
            firstName = SafeInput.getNonZeroLenString(in, "What is your first name");
            lastName = SafeInput.getNonZeroLenString(in, "What is your last name");
            title = SafeInput.getNonZeroLenString(in, "What is your title");
            yearOfBirth = SafeInput.getInt(in, "What is your birth year");
            done = SafeInput.getYNConfirm(in, "Are you done entering prompts?");

            personsData.add(ID + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);
        } while(!done);

        try {
            FileWriter myWriter = new FileWriter("PersonsDataFile.txt");
            for(int i = 0; i < personsData.size(); i++) {
                myWriter.write(personsData.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
