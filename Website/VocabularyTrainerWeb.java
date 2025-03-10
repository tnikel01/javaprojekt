import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import cards.*;

public class VocabularyTrainerWeb {
    private static ArrayList<VocabularyCard> vocabList = new ArrayList<VocabularyCard>();
    private static String filePath = "basic.csv";
    private static ArrayList<VocabularyCard> actualList = vocabList;

    public static void addVocabCard(String de, String span) {
        if (filePath.equals("")) {
            filePath = "basic.csv";
        }
        vocabList.add(new VocabularyCard(de, span));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(de + "," + span);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //1 = German-Spanish
    //2 = Spanish-German
    public String getWord(int selec){
        int wordRan = new Random().nextInt(actualList.size());
        if (selec == 1)
            return actualList.get(wordRan).getGermanWord();
        else if(selec == 2)
            return actualList.get(wordRan).getSpanishWord();
        else
            return "wrond id";
    }
    //1 = German-Spanish
    //2 = Spanish-German
    public String isCorrect(String word, int id, int selec){
        if(selec == 1){
            if(word.equals(actualList.get(id).getSpanishWord())){
                actualList.remove(id);
                return "correct";
            }else
                return "Wrong " + actualList.get(id).getSpanishWord();
        }else if(selec == 2){
            if(word.equals(actualList.get(id).getGermanWord())){
                actualList.remove(id);
                return "correct";
            }else
                return "Wrong " + actualList.get(id).getGermanWord();
        }else{
            return "wrong id";
        }
    }

    public void deleteWord(int id){
        actualList.remove(id);
        vocabList.remove(id);
        removeWordFromFile();
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