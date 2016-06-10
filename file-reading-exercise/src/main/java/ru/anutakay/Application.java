package ru.anutakay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akaygorodova@issart.com on 10.06.2016.
 */
public class Application {

    public Application() {}

    public void start(String inputPath, String outputPath) throws FileNotFoundException {
        List<String> data = readFile(inputPath);
        EmailFinder emailFinder = new EmailFinder();
        List<String> result = findEmails(data, emailFinder);
        writeFile(outputPath, result);
    }

    private void writeFile(String outputPath, List<String> result) throws FileNotFoundException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputPath);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            for (String line: result) {
                bufferedWriter.append(line + "\n");
            }
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private List<String> readFile(String inputPath) throws FileNotFoundException {
        List<String> result = new ArrayList<String>();
        FileReader reader = new FileReader(inputPath);
        try {

            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<String> findEmails(List<String> data, EmailFinder emailFinder) {
        List<String> result = new ArrayList<String>();
        for (String line: data) {
            String[] emails  = emailFinder.findEmailByCandidate(line);
            for (String email: emails) {
                result.add(email);
                System.out.println(email);
            }
        }
        return result;
    }
}
