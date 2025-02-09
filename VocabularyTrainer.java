import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VocabularyTrainer {
    private static ArrayList<VocabularyCard> vocabList = new ArrayList<VocabularyCard>();
    private static String filePath;
    private static Scanner keyboard = new Scanner(System.in);

    public static void addVocabCard(String de, String span) {
        if (filePath.equals("")) {
            filePath = "basic.csv";  // Default file if not set
        }
        vocabList.add(new VocabularyCard(de, span));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(de + "," + span);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void learnGermanSpanish(int selec) {

        while (true) {
            int wordRan = new Random().nextInt(vocabList.size());

            System.out.println("");
            if (selec == 1)
                System.out.println(vocabList.get(wordRan).getGermanWord());
            else
                System.out.println(vocabList.get(wordRan).getSpanishWord());

            System.out.println("Skip: 1");
            System.out.println("Delete word: 2");

            if (selec == 1)
                System.out.println("Enter Spanish:");
            else
                System.out.println("Enter English:");

            String selection = keyboard.nextLine();

            if (selection.equals("1")) {
                continue;  // Skip and show a new word
            } else if (selection.equals("2")) {
                vocabList.remove(wordRan);
                removeWordFromFile();
                continue;
            } else if (selection.equals("q")) {
                mainPage();
                break;
            } else {
                if (selec == 1 && selection.equals(vocabList.get(wordRan).getSpanishWord())) {
                    System.out.println("correct");
                } else if (selec == 2 && selection.equals(vocabList.get(wordRan).getGermanWord())) {
                    System.out.println("correct");
                } else {
                    System.out.println("wrong");
                }
                try {
                    Thread.sleep(1000);  // Pause before showing a new word
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void learn() {

        System.out.println("Spanish-German: 1");
        System.out.println("German-Spanish: 2");

        String selection = keyboard.nextLine();
        if (selection.equals("1"))
            learnGermanSpanish(2);
        else if (selection.equals("2"))
            learnGermanSpanish(1);
        else if (selection.equals("q"))
            mainPage();
    }

    public static void add() {
        System.out.println("Enter German:");
        String input = keyboard.nextLine();
        if (input.equals("q"))
            mainPage();
        else {
            System.out.println("Enter Spanish:");
            String input2 = keyboard.nextLine();
            if (input2.equals("q"))
                mainPage();
            else {
                addVocabCard(input, input2);
                add();
            }
        }
    }

    public static void readFromCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String german = parts[0].trim();
                    String spanish = parts[1].trim();

                    vocabList.add(new VocabularyCard(german, spanish));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeWordFromFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (VocabularyCard card : vocabList) {
                writer.write(card.getGermanWord() + "," + card.getSpanishWord());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mainPage() {
        System.out.println("learn: 1");
        System.out.println("add: 2");
        System.out.println("load: 3");
        System.out.println("Press q at anytime to go back.");
        int selection = keyboard.nextInt();
        keyboard.nextLine(); 

        if (selection == 1)
            learn();

        if (selection == 2)
            add();
        if (selection == 3) {
            System.out.println("Enter Filepath:");
            filePath = keyboard.nextLine();
            readFromCsv(filePath);
            mainPage();
        }
    }

    public static void main(String args[]) {
        System.out.println("Hello!");
        mainPage();
        keyboard.close();
    }
}