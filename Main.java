package Main;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        String Grammar="VN={S,A,B,C}, VT={a,b,c,d},\n" +
                "P={\n"+
                "1. S-dA\n"+
                "2. A-aB\n"+
                "3. B-bC\n"+
                "4. C-cB\n"+
                "5. A-bA\n"+
                "6. B-aB\n"+
                "7. B-d}";

        HashMap<String, Value[]> hash=gramToHash(Grammar);

        String input="dad";
        String Nonterm="S";

        for (int i=0; i<input.length(); i++){
            Nonterm=parseValue(Nonterm, input.charAt(i),hash);
            if(Nonterm=="$" && (input.length()-1)-i!=0){
                Nonterm=null;
                break;
            }
        }
        if(Nonterm==null || !Nonterm.equals("$")) {
            System.out.println("The input string is NOT accepted");
        }
        else{
            System.out.println("The input string is accepted");
        }

    }

    static String parseValue(String Nonterm, char term , HashMap<String, Value[]> hash){
        if(Nonterm ==null){
            return null;
        }
        for (Value value: hash.get(Nonterm)){
            if(value.Term.charAt(0)==term){

                return value.Nonterm;
            }
        }
        return null;
    }

    static HashMap<String, Value[]> gramToHash(String input){
        HashMap<String, Value[]> hash=new HashMap<String, Value[]>();
        int position=input.indexOf("P");
        String[] prod=input.substring(position).split("\\.");
         for (int i=1; i<prod.length;i++){
             prod[i]=prod[i].replaceAll("\\s|[0-9]|\\{|}","");

             if (hash.containsKey(prod[i].charAt(0)+"")){
                 int len=hash.get(prod[i].charAt(0)+"").length;
                 Value[] array= hash.get(prod[i].charAt(0)+"").clone();
                 Value[] temp=new Value[len+1];
                 for (int j=0;j<len;j++){
                     temp[j]=hash.get(prod[i].charAt(0)+"")[j];
                 }
                 temp[len]=new Value(prod[i].charAt(2)+"", prod[i].length()==4?prod[i].charAt(3)+"":"$");
                 hash.put(prod[i].charAt(0)+"",temp);
             }
             else{
                 hash.put(prod[i].charAt(0)+"", new Value[]{new Value(prod[i].charAt(2)+"",prod[i].length()==4?prod[i].charAt(3)+"":"$")});
             }
         }
         return hash;
    }


}

