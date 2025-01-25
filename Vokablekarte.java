public class Vokablekarte{
    private String germanWord;
    private String SpanishWord;
    public Vokablekarte(String german, String spanish){
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