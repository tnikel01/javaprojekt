public class VocabularyCard{
    private String germanWord;
    private String SpanishWord;
    private int correctcount = 0;

    public VocabularyCard(String german, String spanish){
        germanWord = german;
        SpanishWord = spanish;
    }

    public int getCorrect() {
        return correctcount;
    }

    public void incrementCorrect() {
        correctcount++;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getSpanishWord() {
        return SpanishWord;
    }
}