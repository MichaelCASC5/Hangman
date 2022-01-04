public class Word{
    private String word;
    private String hint;
    private String topic;
    
    private char[] letters;
    
    public Word(String a, String b, String c){
        word = a.toLowerCase();
        hint = b;
        topic = c;
        
        letters = word.toCharArray();
    }
    public String getWord(){
        return word;
    }
    public String getHint(){
        return hint;
    }
    public String getTopic(){
        return topic;
    }
    public char getLetter(int i){
        return letters[i];
    }
    public boolean check(char c){
        boolean output = false;
        for(int i=0;i<letters.length;i++){
            if(c == letters[i]){
                output = true;
            }
        }
        return output;
    }
}