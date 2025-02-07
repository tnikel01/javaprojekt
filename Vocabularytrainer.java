import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Vocabularytrainer{
    private static ArrayList<Vokablekarte> vocabList = new ArrayList<Vokablekarte>();

    public static void addvokabelkarte(String de, String span){
        String filePath = "basic.csv";
        vocabList.add(new Vokablekarte(de, span));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(de + "," + span);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void learnGermanSpanish(){
        Scanner keyboard = new Scanner(System.in);
        int wordRan = new Random().nextInt(vocabList.size());

        System.out.println("");
        System.out.println(vocabList.get(wordRan).getGermanWord());
        System.out.println("Skip: 1");
        System.out.println("Delete word: 2");
        System.out.println("Enter Spanish:");

        String selection = keyboard.nextLine();
        if(selection.equals("1")){
            learnGermanSpanish();
        }
        else if(selection.equals("2")){
            vocabList.remove(wordRan);
            learnGermanSpanish();
            //remove
        }
        else if(selection.equals("q")){
            mainpage();
        }
        else{
            if(selection.equals(vocabList.get(wordRan).getSpanishWord())){
                System.out.println("correct");
            }else{
                System.out.println("wrong");
            }
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            learnGermanSpanish();
        }
        keyboard.close();
    }

    public static void learnSpanishGerman(){
        Scanner keyboard = new Scanner(System.in);
        int wordRan = new Random().nextInt(vocabList.size());

        System.out.println("");
        System.out.println(vocabList.get(wordRan).getSpanishWord());
        System.out.println("Skip: 1");
        System.out.println("Delete word: 2");
        System.out.println("Enter German:");

        String selection = keyboard.nextLine();
        if(selection.equals("1")){
            learnSpanishGerman();
        }
        else if(selection.equals("2")){
            vocabList.remove(wordRan);
            learnSpanishGerman();
            //delete word
        }else if(selection.equals("q")){
            mainpage();
        }
        else{
            if(selection.equals(vocabList.get(wordRan).getGermanWord())){
                System.out.println("correct");
            }else{
                System.out.println("wrong");
            }
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            learnSpanishGerman();
        }
        keyboard.close();
    }

    public static void learn(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Spanish-German: 1");
        System.out.println("German-Spanish: 2");
        String selection = keyboard.nextLine();
        if(selection.equals("1"))
        {
            learnSpanishGerman();
        }else if(selection.equals("2")) {
            learnGermanSpanish();
        }else if(selection.equals("q")){
            mainpage();
        }
        keyboard.close();
    }

    public static void add(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter German:");
        String input = keyboard.nextLine();
        if(input.equals("q")){
            mainpage();
        }else{
            System.out.println("Enter Spanish:");
            String input2 = keyboard.nextLine();
            if(input2.equals("q")){
                mainpage();
            }else{
                addvokabelkarte(input, input2);
                add();
            }
        }
        keyboard.close();
    }

    public static void readFromCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String german = parts[0].trim();  // German word
                    String spanish = parts[1].trim(); // Spanish word

                    vocabList.add(new Vokablekarte(german, spanish));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void mainpage(){
        readFromCsv("basic.csv");



        Scanner keyboard = new Scanner(System.in);
        System.out.println("learn: 1");
        System.out.println("add: 2");
        System.out.println("Press q at anytime to go back.");
        int selection = keyboard.nextInt();
        keyboard.nextLine(); 

        if (selection == 1)
        {
            learn();
        }
        if (selection == 2)
        {
            add();
        }
        keyboard.close();
    }

    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello!");
        /* 
        System.out.println("Login: 1");
        System.out.println("Register: 2");

        int selection = keyboard.nextInt();
        keyboard.nextLine(); 

        if (selection == 1)
        {
            System.out.println("Enter username:");
            String username = keyboard.nextLine(); 
            if(username.equals("t")) //not working
            {
                System.out.println("Enter password:");
                String password = keyboard.nextLine(); 
                if(password.equals("t")) //not working
                {
                    System.out.println("LogedIn");
                }
            }
        }
        if(selection == 2){
            System.out.println("Create username:");
            String username = keyboard.nextLine(); 
            
        }
            */
        mainpage();

        keyboard.close();
    }
}