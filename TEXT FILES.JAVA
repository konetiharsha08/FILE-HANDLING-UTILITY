import java.io.*;
import java.util.Scanner;

public class FileReadWriteModify {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "example.txt"; // Name of the file to work with

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Modify the file");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    writeToFile(fileName, scanner);
                    break;
                case 2:
                    readFromFile(fileName);
                    break;
                case 3:
                    modifyFile(fileName, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to write to the file
    private static void writeToFile(String fileName, Scanner scanner) {
        System.out.println("Enter text to write to the file:");
        String content = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Content written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read from the file
    private static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Reading content from " + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to modify the file
    private static void modifyFile(String fileName, Scanner scanner) {
        System.out.println("Enter the new content to replace the current file content:");
        String newContent = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(newContent);
            System.out.println("The file content has been replaced successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}