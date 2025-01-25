import java.util.ArrayList;
import java.util.Scanner;

public class Vokabeltrainer{
    private static ArrayList<Vokablekarte> vocabList = new ArrayList<Vokablekarte>();

    public static void addvokabelkarte(String de, String span){
        vocabList.add(new Vokablekarte(de, span));
        //add to database
    }

    public static void learnSpanishGerman(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(vocabList.get(1).getSpanishWord());
        System.out.println("Skip: 1");
        System.out.println("Delete word: 2");
        System.out.println("Enter German:");

        String selection = keyboard.nextLine();
        if(selection.equals("1")){
            learnSpanishGerman();
        }
        else if(selection.equals("2")){
            //delete word
        }
        else{
            if(keyboard.nextLine().equals(vocabList.get(1).getGermanWord())){
                System.out.println("correct");
            }else{
                System.out.println("wrong");
            }
            learnSpanishGerman();
        }
        keyboard.close();
    }

    public static void learn(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Spanish-German: 1");
        System.out.println("German-Spanish: 2");

        if(keyboard.nextInt() == 1)
        {
            learnSpanishGerman();
        }
        keyboard.close();
    }

    public static void add(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter German:");
        System.out.println("Back to main: 2");
        String input = keyboard.nextLine();
        if(input.equals("2")){
            mainpage();
        }else{
            System.out.println("Enter Spanish:");
            System.out.println("Back to main: 2");
            String input2 = keyboard.nextLine();
            if(input2.equals("2")){
                mainpage();
            }else{
                addvokabelkarte(input, input2);
                add();
            }
        }
        keyboard.close();
    }

    public static void mainpage(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("learn: 1");
        System.out.println("add: 2");
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
        mainpage();

        keyboard.close();
    }
}