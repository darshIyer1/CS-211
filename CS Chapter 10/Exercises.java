import java.util.*;

public class Exercises {
    public static void main(String[] arg166) {
      ArrayList <String> test = new ArrayList <String> ();
      test.add("four");
      // {"four", "score", "and", "seven", "years", "ago"} 
      test.add("score");
      test.add("and");
      test.add("seven");
      test.add("years");
      printList(test);
      removeEvenLength(test);
      printList(test);
            
    } 
    
    public static void printList(ArrayList <String> y){
      System.out.println(y);
    }
    
    public static void swapPairs(ArrayList <String> x) {
         int len = 0;
         
         if(x.size() % 2 == 0){
            len = x.size();
         } else{
            len = x.size() -1;
         }
         
         String elementOne = "";
         String elementTwo = "";         
         for(int i = 0; i<len; i += 2){
            elementOne = x.get(i);
            elementTwo = x.get(i+1);
            x.set(i, elementTwo);
            x.set(i+1, elementOne);
         }
    }
    
    public static void removeEvenLength(ArrayList <String> x) {                  
         for(int i = 0; i<x.size();){
            String element = x.get(i);
            int elementSize = element.length();
            if(elementSize % 2 == 0){
               x.remove(i);
            } else {
               i++;
            }
            
         }
    }

}
