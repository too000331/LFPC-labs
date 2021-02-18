package Main;

public class Value {
    public String Term;
    public String Nonterm;

    public Value(String term, String nonterm) {
        Term = term;
        Nonterm=nonterm;
    }

    public Value(String term){
        Term=term;
        Nonterm="$";
    }
}
