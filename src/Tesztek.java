import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tesztek {

    public static void Create(String teszteset)
    {
        try {
            File file = new File(teszteset);
            if (file.createNewFile()) {
              System.out.println("File created: " + file.getName());
            } else {
              System.out.println("A File már létezik.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void Read(String teszteset)
    {
        try {

            File file = new File(teszteset);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
              String data = scanner.nextLine();
              System.out.println(data);
            }
            scanner.close();
  
          } catch (FileNotFoundException e) {
  
            System.out.println("Fájl nem beolvasható.");
            e.printStackTrace();
  
        }
    } 

    public static void Write(String teszteset, String sor)
    {
        try {
            FileWriter writer = new FileWriter(teszteset);
            writer.write(sor);
            writer.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void Delete(String teszteset)
    {
        File myObj = new File(teszteset); 
        if (myObj.delete()) { 
            System.out.println("TÖRÖLT FILE: " + myObj.getName());
        } else {
            System.out.println("Nem sikerült törölni a fájlt.");
        } 
    } 

    public static void main(String[] args) 
    {
        System.out.println("Szeretem a pelyhet! Nagyon! Remélem te is!");
    }
}
