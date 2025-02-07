public class VocabularyCard{
    private String germanWord;
    private String SpanishWord;
    public VocabularyCard(String german, String spanish){
        germanWord = german;
        SpanishWord = spanish;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public String getSpanishWord() {
        return SpanishWord;
    }
}