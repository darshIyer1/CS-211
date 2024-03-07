// NO imports allowed as LinkedIntList is just int data
// copyright 2024 Bellevue College
public class Quiz16 {
   public static void main(String[] arg327) {
      LinkedIntList quiz16 = new LinkedIntList();
      quiz16.add(1);
      quiz16.add(8);
      quiz16.add(7);
      quiz16.add(2);
      quiz16.add(9);
      quiz16.add(18);
      quiz16.add(2 * 6);
      quiz16.add(0);

      System.out.println(quiz16);
      quiz16.removeEvenNumbers();
      System.out.println(quiz16);
   }
}