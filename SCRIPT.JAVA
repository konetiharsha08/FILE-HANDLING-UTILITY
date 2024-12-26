import java.io.*;

/**
 * This class demonstrates basic file operations in Java:
 * 1. Reading from a file.
 * 2. Writing to a file.
 * 3. Appending to a file.
 * 4. Handling potential file-related exceptions.
 */
public class FileOperations {

    public static void main(String args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Read file content
        String fileContent = readFile(inputFile);
        if (fileContent != null) {
            System.out.println("File content:\n" + fileContent);
        }

        // Write to file
        String contentToWrite = "This is the content to be written.";
        writeFile(outputFile, contentToWrite);

        // Append to file
        String contentToAppend = "\nThis is appended content.";
        appendToFile(outputFile, contentToAppend);
    }

    /**
     * Reads the contents of a file.
     *
     * @param filename The name of the file to read.
     * @return The contents of the file as a String, or null if an error occurs.
     */
    private static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }

    /**
     * Writes content to a file, overwriting existing content.
     *
     * @param filename The name of the file to write to.
     * @param content The content to write to the file.
     */
    private static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Appends content to an existing file.
     *
     * @param filename The name of the file to append to.
     * @param content The content to append to the file.
     */
    private static void appendToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}