import java.util.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Exercises extends ArrayList<Integer> {
    public static void main(String[] args) {
      ArrayList <Integer> test = new ArrayList <Integer> ();
      test.add(5);
      // {"four", "score", "and", "seven", "years", "ago"} 
      test.add(5);
      test.add(3);
      test.add(2);
      test.add(1);
      System.out.println(test);
      System.out.println(lastIndexOf(test, 1));
      System.out.println(test);
            
    } 
    
    /* 1. Write a method called lastIndexOf that 
    accepts an integer as a parameter and returns 
    the index in the list of the last occurrence 
    of that value, or if the value is not found 
    in the list. For example, if the list stores 
    [1, 18, 2, 7, 18, 39, 18, 40] , then the 
    last index of 18 is 6 and the last index of 
    3 is -1.
    */
   public static int lastIndexOf(ArrayList<Integer> list, int x) {
      for (int i = list.size() - 1; i >= 0; i--) {
         if (list.get(i) == x) {
            return i;
         }
      }
      return -1;
   }
   
   
   /*
   Write a method called indexOfSubList that 
   accepts another list L as a parameter and 
   returns the starting index of where L first 
   appears in this list, or -1 if it is not 
   found. All elements of L must appear in 
   sequence and in the same order. For example, 
   if variables called list1 and list2 store 
   [11, -7, 3, 42, 0, 14] and [3, 42, 0], 
   respectively, the call of 
   list1.indexOfSubList(list2) should return 2.
   */
   public static int indexOfSubList(ArrayList < Integer > list1, ArrayList < Integer > list2) {
       for (int i = 0; i < list1.size() - list2.size() + 1; i++) {
           boolean result = true;
           for (int x = 0; x < list2.size(); x++) {
               if (list1.get(i + x) != list2.get(x)) {
                   result = false;
                   break;
               }
           }
           if (result) {
               return i;
           }
       }
       return -1;
   }
   
   
   
   /*
   3. Write a method called replaceAll that 
   accepts two integer values as parameters 
   and replaces all occurrences of the first 
   value in the list with the second value. 
   For example, if a variable called list 
   stores [11, –7, 3, 42, 3, 0, 14, 3] , 
   the call of list.replaceAll(3, 999); 
   should change the list to store 
   [11, –7, 999, 42, 999, 0, 14, 999] .
   */
   public void replaceAll(int x, int y) {
      for (int i = 0; i < this.size(); i++) {
         if (this.get(i) == x) {
            this.set(i, y);
         }
      }
   }
   
   
   
   
   /*
   4. Write a method called reverse that 
   reverses the order of the elements in 
   the array list. For example, if a 
   variable called list stores 
   [11, –7, 3, 42, 0, 14, 56] , the call 
   of list.reverse(); should change the 
   list to store [56, 14, 0, 42, 3, –7, 11] . 
   An empty or one-element list is not 
   changed by a call to this method.
   */
   public void reverse() {
      ArrayList < Integer > placeholder = new ArrayList < Integer > ();
   
      for (int i = this.size() - 1; i >= 0; i--) {
         placeholder.add(this.get(i));
      }
      for (int y = 0; y < this.size(); y++) {
         this.set(y, placeholder.get(y));
      }
   }   
   
   
   
   
   
   
   /*
   5. Write a method called runningTotal 
   that returns a new ArrayIntList that 
   contains a running total of the original 
   list. In other words, the i'th value in 
   the new list should store the sum of 
   elements 0 through of the original list. 
   For example, given a variable list that 
   stores [2, 3, 5, 4, 7, 15, 20, 7] , 
   consider what happens when the following 
   call is made: 
   ArrayIntList list2 = list.runningTotal(); 
   The variable list2 should store 
   [2, 5, 10, 14, 21, 36, 56, 63] . 
   The original list should not be changed 
   by the method. If the original list is empty, 
   the result should be an empty list. 
   The new list should have the same capacity 
   as the original. Remember that there is a 
   list constructor that accepts a capacity 
   as a parameter.
   */
   public ArrayList<Integer> runningTotal() {
       ArrayList<Integer> runningTotalList = new ArrayList<>(this.size());
       int runningTotal = 0;
   
       for (int i = 0; i < this.size(); i++) {
           runningTotal += this.get(i);
           runningTotalList.add(runningTotal);
       }
   
       return runningTotalList;
   }   
   
   
   /*
   6. Write a method called fill that accepts an 
   integer value as a parameter and replaces 
   every value in the list with that value. 
   For example, if a variable called list 
   initially stores [42, –7, 3, 0, 15] and 
   the call of list.fill(2); is made, the list 
   will be changed to store [2, 2, 2, 2, 2] .
   */
   public void fill(int value) {
       for(int i = 0; i < this.size(); i++) {
           this.set(i, value);
       }
   }
   
   
   /*
   7. Write a method called isPairwiseSorted that 
   returns whether or not a list of integers is 
   pairwise sorted. A list is considered pairwise 
   sorted if each successive pair of numbers is 
   in nondecreasing order. For example, if a 
   variable called list stores 
   [3, 8, 2, 5, 19, 24, –3, 0, 4, 4, 8, 205, 42] , 
   then the call of list.isPairwiseSorted() should 
   return true because the successive pairs of 
   this list are all sorted: 
   (3, 8), (2, 5), (19, 24), (–3, 0), (4, 4), (8, 205) . 
   The extra value 42 at the end had no effect on the 
   result because it is not part of a pair. If the list 
   had instead stored [7, 42, 308, 409, 19, 17, 2] , 
   then the method should return false because the pair 
   (19, 17) is not in sorted order. If a list is so 
   short that it has no pairs, then it is considered 
   to be pairwise sorted.
   */
   
   public boolean isPairwiseSorted() {
      if (this.size() < 2) {
         return true;
      }
      for (int i = 0; i < this.size() - 1; i += 2) {
         if (this.get(i) > this.get(i + 1)) {
            return false;
         }
      }
      return true;
   }
   
   
   
   /*
   8. Write a method called count that accepts an 
   element value as a parameter and returns the 
   number of occurrences of that value in the list. 
   For example, suppose a variable named list stores 
   [2, -3, 2, 0, 5, 2, 2, 6] . A call of list.count(2) 
   should return 4 because there are four occurrences 
   of that value in the list.
   */
   
   public int count(int x){
      int reps = 0;
      for(int i = 0; i<this.size(); i++){
         if(this.get(i) == x){
            reps++;            
         }
      }
      return reps;
   }
   
   
   
   /*
   Write a method called maxCount that returns the 
   number of occurrences of the most frequently 
   occurring value in a sorted list of integers. 
   Because the list will be sorted, all duplicates 
   will be grouped together, which will make it 
   easier to count duplicates. For example, if a 
   variable called list stores 
   [1, 3, 4, 7, 7, 7, 7, 9, 9, 11, 13, 14, 14, 14, 16, 16, 18, 19, 19, 19] , 
   the call of list.maxCount() should return 4 because the most frequently 
   occurring value ( 7 ) occurs four times. It is possible that there will 
   be a tie for the most frequently occurring value, but that doesn’t affect 
   the outcome because you are just returning the count, not the value. 
   If there are no duplicates in the list, then every value will occur 
   exactly once and the max count is 1 . If the list is empty, the method 
   should return 0.
   */
   
   public int maxCount() {
      if(this.size() == 0){
         return 0;
      }
      int currentMax = 1;
      int actualMax = 1;
      for(int i = 1; i<this.size(); i++){
         if(this.get(i) == this.get(i-1)){
            currentMax ++;
         }
         if(currentMax > actualMax){
            actualMax = currentMax;
         }
         if(i<this.size()-1){
            if(this.get(i) != this.get(i+1)){
               currentMax = 1;
            }
         }
      }
      return actualMax;
   }

   
   
   /*
   10. Write a method called longestSortedSequence 
   that returns the length of the longest sorted 
   sequence within a list of integers. For example, 
   if a variable called list stores 
   [1, 3, 5, 2, 9, 7, –3, 0, 42, 308, 17] , then 
   the call of list.longestSortedSequence() would 
   return 4 because it is the length of the longest 
   sorted sequence within this list 
   (the sequence –3, 0, 42, 308 ). If the list is 
   empty, your method should return 0 . Notice that 
   for a nonempty list the method will always return 
   a value of at least 1 because any individual 
   element constitutes a sorted sequence.
   */
   
   public int longestSortedSequence() {
      int longestSortedSequence = 1;
      int currentSortedSequence = 1;
      for(int i = 1; i<this.size(); i++){
         if(this.get(i) > this.get(i-1)){
            currentSortedSequence++;
         }
         if(currentSortedSequence > longestSortedSequence){
            longestSortedSequence = currentSortedSequence;
         }
         if(this.get(i) <= this.get(i-1)){
            currentSortedSequence = 1;
         }
      }
      return longestSortedSequence;
   }
   
   
   
   /*
   11. Write a method called removeLast that removes 
   and returns the last value from a list of integers. 
   For example, if a variable called list stores 
   [8, 17, 42, 3, 8] , a call of list.removeLast(); 
   should return 8 and change the list’s state to 
   [8, 17, 42, 3] . The next call would return 3 and 
   remove 3 from the list, and so on. If the list is 
   empty, throw a NoSuchElementException .
   */
   public Integer removeLast() {
       if (this.isEmpty()) {
           throw new NoSuchElementException();
       }
       int lastIndex = this.size() - 1;
       int last = this.get(lastIndex);
       this.remove(lastIndex);
       return last;
   }
   
   
   
   /*
   12. Write a method called removeFront that takes 
   an integer as a parameter and that removes the 
   first values from a list of n n integers. For 
   example, if a variable called list stores 
   [8, 17, 9, 24, 42, 3, 8] and a call of 
   list.removeFront(4); is made, the list’s contents 
   should become [42, 3, 8] . You may assume that the 
   parameter value passed is between 0 and the size 
   of the list inclusive.
   */
   
   public void removeFront(int n) {
       for (int i = 1; i <= n; i++) {
           this.remove(0);
       }
   }
   
   
   
   
   
   /*
   13. Write a method removeAll that accepts an 
   integer value as a parameter and that removes 
   all occurrences of the given value from the list.
   */
   
   public void removeAll(int value) {
       for (int i = 0; i < this.size(); i++) {
           if (this.get(i) == value) {
               this.remove(i);
               i--;
           }
       }
   }
   
   
   
   
   /*
   14. Write a method called printInversions that 
   lists all inversions in a list of integers. An 
   inversion is a pair of numbers in which the first 
   appears before the second in the list, but the 
   first is greater than the second. Thus, for a 
   sorted list such as [1, 2, 3, 4] there are no 
   inversions at all, and the method would produce 
   no output. Suppose that a variable called list 
   stores the values [4, 3, 2, 1] . The call of 
   list.printInversions(); would print many inversions:
   (4, 3)
   (4, 2)
   (4, 1)
   (3, 2)
   (3, 1)
   (2, 1)
   
   The inversions can appear in any order, so this 
   is just one possible correct output. You must 
   reproduce this format exactly, but the inversions 
   can appear in any order. You may assume that 
   the list has no duplicates.
   */
   public void printInversions() {
       for (int i = 0; i < this.size(); i++) {
           for (int j = i + 1; j < this.size(); j++) {
               if (this.get(i) > this.get(j)) {
                   System.out.println("(" + this.get(i) + ", " + this.get(j) + ")");
               }
           }
       }
   }   
   
   
   
   
   /*
   17. Write a method called stretch that takes an 
   integer n as a parameter and that increases a list 
   of integers by a factor of n by replacing each 
   integer in the original list with n copies of that 
   integer. For example, if a variable called list 
   stores [18, 7, 4, 24, 11] and we make the call of 
   list.stretch(3); the list should be changed to store 
   [18, 18, 18, 7, 7, 7, 4, 4, 4, 24, 24, 24, 11, 11, 11] . 
   If is zero or negative, the list should become empty.
   */
   public void stretch(int n) {
      if (n <= 0) {
         this.clear();
      } else {
         for (int i = this.size() - 1; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
               this.add(i, this.get(i));
            }
         }
      }
   }
   
   
   /*
   18. Write a method called doubleList that doubles the size 
   of a list by appending a copy of the original sequence to 
   the end of the list. For example, if the list stores [1, 8, 2, 7] , 
   your method should change it to store [1, 8, 2, 7, 1, 8, 2, 7] .
   */
   public void doubleList(){
      int size = this.size();
      for(int i=0; i<size; i++){
         this.add(this.get(i));
      }
   }
   
   /*
   19. Write a method called compress that replaces every pair of elements 
   in the list with a single element equal to the sum of the pair. If the 
   list is of odd size, leave the last element unchanged. For example, if 
   the list stores [1, 7, 3, 9, 4, 6, 5] , your method should change it to 
   store [8, 12, 10, 5] (1+7, then 3+9, then 4+6, then 5).
   */
   public void compress() {
      ArrayList < Integer > myList = new ArrayList < Integer > ();
      int last = 0;
      int size = this.size();
      if (size % 2 != 0) {
         last = this.get(size - 2) + this.get(size - 1);
      }
      for (int i = 0; i < size - 1; i += 2) {
         myList.add(this.get(i) + this.get(i + 1));
      }
      this.clear();
      for (int x = 0; x < myList.size(); x++) {
         this.add(myList.get(x));
      }
      if (size % 2 != 0) {
         this.add(last);
      }
   }   
 
 
   /*
   20. Write a method called rotate that moves the value at the front of a 
   list of integers to the end of the list. For example, if a variable called 
   list stores [8, 23, 19, 7, 12, 4] , the call of list.rotate(); should move 
   the value 8 from the front of the list to the back of the list, producing 
   [23, 19, 7, 12, 4, 8] .
   */
   public void rotate(){
      int number = this.get(0);
      this.remove(0);
      this.add(number);
   }
   
   
   /*
   21. Write a method called switchPairs that switches the order of values in the 
   list in a pairwise fashion. Your method should switch the order of the first two 
   values, then switch the order of the next two, switch the order of the next two, 
   and so on. If the list contains an odd number of values, the final element is 
   not moved. For example, if the list initially stores [10, 25, 31, 47, 52, 68, 77] , 
   your method should switch the first pair ( 10 and 25 ), the second pair ( 31 and 47 ), 
   and the third pair ( 5 2 and 68 ) to yield [25, 10, 47, 31, 68, 52, 77] .
   */
   public void switchPairs(){
      int size = this.size()
      if(size %2 != 0){
         size-=1;
      }
      for(int i = 0; i<size; i+=2){
         int first = this.get(i);
         int second = this.get(i+1);
         this.set(i, second);
         this.set(i+1, first);
      }
   }
   
   /*
   22. Write a method called fromCounts that converts an ArrayIntList of counts into a new 
   ArrayIntList of values as follows. Assume that the list stores a sequence of integer 
   pairs that each pair indicates a count and a number. For example, suppose that an 
   ArrayIntList called list stores [5, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17] . 
   We will interpret 1 + 7, 3 + 9, 4 + 6, this sequence of pairs to mean that you have 5 
   occurrences of 2, followed by two occurrences of followed by 4 occurrences of 3, 
   and so on. So the call of: ArrayIntList list2 = list.fromCounts(); should cause the 
   variable list2 to store [2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 1, 0, 17, 17] .
   */   
   public ArrayIntList fromCounts() {
      ArrayIntList list2 = new ArrayIntList();
      for (int i = 0; i < this.size(); i += 2) {
         int count = this.get(i);
         int value = this.get(i + 1);
         for (int j = 0; j < count; j++) {
            list2.add(value);
         }
      }
      return list2;
   }
}
   
