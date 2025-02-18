import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VocabularyTrainerWeb {
    private static ArrayList<VocabularyCard> vocabList = new ArrayList<VocabularyCard>();
    private static String filePath = "basic.csv";

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
        ArrayList<VocabularyCard> actualList = vocabList;
        while (true) {
            int wordRan = new Random().nextInt(actualList.size());

            System.out.println("");
            if (selec == 1)
                System.out.println(actualList.get(wordRan).getGermanWord());
            else
                System.out.println(actualList.get(wordRan).getSpanishWord());

            System.out.println("Skip: 1");
            System.out.println("Delete word: 2");

            if (selec == 1)
                System.out.println("Enter Spanish:");
            else
                System.out.println("Enter English:");

            String selection = "";

            if (selection.equals("1")) {
                continue;
            } else if (selection.equals("2")) {
                actualList.remove(wordRan);
                vocabList.remove(wordRan);
                removeWordFromFile();
                continue;
            } else if (selection.equals("q")) {
                //mainPage();
                break;
            } else {
                if (selec == 1 && selection.equals(actualList.get(wordRan).getSpanishWord())) {
                    System.out.println("correct");
                    actualList.remove(wordRan);
                } else if (selec == 2 && selection.equals(actualList.get(wordRan).getGermanWord())) {
                    System.out.println("correct");
                    actualList.remove(wordRan);
                } else {
                    System.out.println("wrong");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFromCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String english = parts[0].trim();
                    String spanish = parts[1].trim();

                    vocabList.add(new VocabularyCard(english, spanish));
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
}