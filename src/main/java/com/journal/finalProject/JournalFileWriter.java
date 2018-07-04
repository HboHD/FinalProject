package com.journal.finalProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class JournalFileWriter {

    public static File createFile(String fileName){
        File outputFile = null;
        try {
            File file = new  File(fileName + ".txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
                outputFile = file;
            }else{
                outputFile = file;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return outputFile;
    }

    public static void WriteFile(File file, String content) {
        try {

            String oldContent = readFromFile(file.getName()) + "\r\n";

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(oldContent+content);
            bw.close();

            System.out.println("File has been recordered with filename: " + file.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName){
        String output = null;
        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(fileName);

            File file = new File(input.nextLine());

            input = new Scanner(file);

            StringBuilder outputString = new StringBuilder("");

            while (input.hasNextLine()) {
                String line = input.nextLine();
                outputString.append(line + "\r\n");
            }
            input.close();
            output = outputString.toString();
            System.out.print(output);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public static String fileNameGenerator(int DD, int MM, int YYYY){
            String fileName;
            String separator = "-";

            fileName = String.valueOf(DD) + separator + String.valueOf(MM) + separator + String.valueOf(YYYY) + "_journal";

            return fileName;
    }

    public static void newJournal(int DD, int MM, int YYYY, String content, Weather weather){

        WriteFile(createFile(fileNameGenerator(DD, MM, YYYY)),weather.getWeather()+content);

    }
}