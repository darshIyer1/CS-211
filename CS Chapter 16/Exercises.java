import java.util.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Exercises extends LinkedList<Integer> {
   /*
   1. Write a method called set that accepts an index and a value
   and sets the list’s element at that index to have the given
   value. You may assume that the index is between 0 (inclusive)
   and the size of the list (exclusive).
   */
   public void set(int index, int value) {
      if (index < 0 || index >= size()) {
         throw new IndexOutOfBoundsException("Index out of range");
      }
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      current.data = value;
   }
 
   /*
   2. Write a method called min that returns the minimum value in a
   list of integers. If the list is empty, it should throw a
   NoSuchElementException .
   */
    public int min() {
       if (front == null) {
          throw new NoSuchElementException("List is empty");
       }
       int minValue = front.data;
       ListNode current = front.next;
       while (current != null) {
          if (current.data < minValue) {
             minValue = current.data;
          }
          current = current.next;
       }
       return minValue;
    }
   
   /*
   3. Write a method called isSorted that returns true if the list is
   in sorted (nondecreasing) order and returns false otherwise.
   An empty list is considered to be sorted.
   */
   public boolean isSorted() {
       if (front == null) {
           return true;
       }
       ListNode current = front;
       while (current.next != null) {
           if (current.data > current.next.data) {
               return false;
           }
           current = current.next;
       }
       return true;
   }   
   /*
   4. Write a method called lastIndexOf that accepts an integer
   value as a parameter and that returns the index in the list of
   the last occurrence of that value, or −1 if the value is not
   found in the list. For example, if a variable list stores the
   values [1, 18, 2, 7, 18, 39, 18, 40] , then the call of
   list.lastIndexOf(18) should return 6 . If the call had instead
   been list.lastIndexOf(3) , the method would return –1 .
   */
   public int lastIndexOf(int value) {
       int index = -1;
       ListNode current = front;
       for (int i = 0; i < size(); i++) {
           if (current.data == value) {
               index = i;
           }
           current = current.next;
       }
       return index;
   }
   
   /*
   5. Write a method called countDuplicates that returns the
   number of duplicates in a sorted list. The list will be in sorted
   order, so all of the duplicates will be grouped together. For
   example, if a variable list stores the values [1, 1, 1, 3, 3,
   6, 9, 15, 15, 23, 23, 23, 40, 40] , the call of
   list.countDuplicates() should return 7 because there are 2
   duplicates of 1 , 1 duplicate of 3 , 1 duplicate of 15 , 2
   duplicates of 23 , and 1 duplicate of 40 .
   */
   public int countDuplicates() {
       if (front == null) {
           return 0;
       }
       int duplicates = 0;
       ListNode current = front;
       while (current.next != null) {
           if (current.data == current.next.data) {
               duplicates++;
           }
           current = current.next;
       }
       return duplicates;
   }   
   /*
   6. Write a method called hasTwoConsecutive that returns whether
   or not a list of integers has two adjacent numbers that are
   consecutive integers ( true if such a pair exists and false
   otherwise). For example, if a variable list stores the values
   [1, 18, 2, 7, 8, 39, 18, 40] , then the call
   list.hasTwoConsecutive() should return true because the list
   contains the adjacent numbers ( 7, 8 ), which are a pair of
   consecutive numbers.
   */
   public boolean hasTwoConsecutive() {
       if (front == null || front.next == null) {
           return false;
       }
       ListNode current = front;
       while (current.next != null) {
           if (current.data + 1 == current.next.data) {
               return true;
           }
           current = current.next;
       }
       return false;
   }   
   /*
   7. Write a method called deleteBack that deletes the last value
   (the value at the back of the list) and returns the deleted
   value. If the list is empty, throw a NoSuchElementException .
   */
   public int deleteBack() {
       if (front == null) {
           throw new NoSuchElementException("List is empty");
       }
       if (front.next == null) {
           int value = front.data;
           front = null;
           return value;
       }
       ListNode current = front;
       while (current.next.next != null) {
           current = current.next;
       }
       int value = current.next.data;
       current.next = null;
       return value;
   }   
   /*
   8. Write a method called switchPairs that switches the order of
   values in the list in a pairwise fashion. Your method should
   switch the order of the first two values, then switch the order
   of the next two, switch the order of the next two, and so on. If
   the list contains an odd number of values, the final element is
   not moved. For example, if the list initially stores [10, 25, 31,
   47, 52, 68, 77] , your method should switch the first pair ( 10
   and 25 ), the second pair ( 31 and 47 ), and the third pair ( 52
   and 68 ) to yield [25, 10, 47, 31, 68, 52, 77] .
   */
   public void switchPairs() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode current = front;
       while (current != null && current.next != null) {
           int temp = current.data;
           current.data = current.next.data;
           current.next.data = temp;
           current = current.next.next;
       }
   }   
   /*
   9. Write a method called stutter that doubles the size of a list
   by replacing every integer in the list with two of that integer.
   For example, suppose a variable list stores the values [1,
   8, 19, 4, 17] , after a call of list.stutter() , it should store
   [1, 1, 8, 8, 19, 19, 4, 4, 17, 17] .
   */
   public void stutter() {
       if (front == null) {
           return;
       }
       ListNode current = front;
       while (current != null) {
           ListNode newNode = new ListNode(current.data, current.next);
           current.next = newNode;
           current = current.next.next;
       }
   }   
   /*
   10. Write a method called stretch that takes an integer as a
   parameter and that increases a list of integers by a factor of 
   by replacing each integer in the original list with copies of
   that integer. For example, if a variable called list stores [18,
   7, 4, 24, 11] and we make the call of list.stretch(3); the
   list should be changed to store [18, 18, 18, 7, 7, 7, 4, 4, 4,
   24, 24, 24, 11, 11, 11] . If is zero or negative, the list
   should become empty.
   */
   public void stretch(int n) {
       if (n <= 0) {
           front = null;
       } else {
           ListNode current = front;
           while (current != null) {
               for (int i = 1; i < n; i++) {
                   ListNode newNode = new ListNode(current.data, current.next);
                   current.next = newNode;
                   current = current.next;
               }
               current = current.next;
           }
       }
   }   
   /*
   11. Write a method called compress that replaces every pair of
   elements in the list with a single element equal to the sum of
   the pair. If the list is of odd size, leave the last element
   unchanged. For example, if the list stores [1, 7, 3, 9, 4, 6,
   5] , your method should change it to store [8, 12, 10, 5] (
    then then then 5).
   */
   public void compress() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode current = front;
       while (current != null && current.next != null) {
           current.data += current.next.data;
           current.next = current.next.next;
           current = current.next;
       }
   }   
   /*
   12. Write a method called split that rearranges the elements of a
   list so that all of the negative values appear before all of the
   nonnegatives. For example, suppose a variable list stores
   the values [8, 7, -4, 19, 0, 43, -8, -7, 2] . The call of
   list.split(); should rearrange the list to put the negatives
   first: [-4, -8, -7, 8, 7, 19, 0, 43, 2] . It doesn’t matter what
   order the numbers are in, only that the negatives appear
   n
   n
   n
   n
   1 + 7, 3 + 9, 4 + 6,
   before the nonnegatives, so this is only one possible solution.
   You must solve the problem by rearranging the links of the list,
   not by swapping data values or creating new nodes. You also
   may not use auxiliary structures like arrays or ArrayLists to
   solve this problem.
   */
   public void split() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode negatives = null;
       ListNode positives = null;
       ListNode current = front;
       while (current != null) {
           ListNode next = current.next;
           if (current.data < 0) {
               current.next = negatives;
               negatives = current;
           } else {
               current.next = positives;
               positives = current;
           }
           current = next;
       }
       front = negatives;
       if (negatives != null) {
           while (negatives.next != null) {
               negatives = negatives.next;
           }
           negatives.next = positives;
       } else {
           front = positives;
       }
   }   
   /*
   13. Write a method called transferFrom that accepts a second
   linked list as a parameter and that moves values from the
   second list to this list. You are to attach the second list’s
   elements to the end of this list. You are also to empty the
   second list. For example, suppose two lists called list1 and
   list2 store [8, 17, 2, 4] and [1, 2, 3] , respectively. The
   call of list1.transferFrom(list2); should change list1 to [8,
   17, 2, 4, 1, 2, 3] and list2 to an empty list, [] . The order
   of the arguments matters; list2.transferFrom(list1); should
   change list1 to an empty list, [] , and list2 to [1, 2, 3, 8,
   17, 2, 4] . Either of the two lists could be empty, but you can
   assume that neither list is null . You are not to create any new
   nodes. Your method should simply change links of the lists to
   join them together.
   */
   public void transferFrom(LinkedIntList list2) {
       if (front == null) {
           front = list2.front;
       } else {
           ListNode current = front;
           while (current.next != null) {
               current = current.next;
           }
           current.next = list2.front;
       }
       list2.front = null;
   }   
   /*
   14. Write a method called removeAll that removes all occurrences
   of a particular value. For example, if a variable list stores
   the values [3, 9, 4, 2, 3, 8, 17, 4, 3, 18] , the call of
   list.removeAll(3); would change the list to store [9, 4, 2, 8,
   17, 4, 18] .
   */
   public void removeAll(int value) {
       while (front != null && front.data == value) {
           front = front.next;
       }
       if (front != null) {
           ListNode current = front;
           while (current.next != null) {
               if (current.next.data == value) {
                   current.next = current.next.next;
               } else {
                   current = current.next;
               }
           }
       }
   }      
   /*
   15. Write a method called equals that accepts a second list as a
   parameter, returns true if the two lists are equal, and returns
   false otherwise. Two lists are considered equal if they store
   exactly the same values in exactly the same order and have
   exactly the same length.
   */
   public boolean equals(LinkedIntList list2) {
       ListNode current1 = front;
       ListNode current2 = list2.front;
       while (current1 != null && current2 != null) {
           if (current1.data != current2.data) {
               return false;
           }
           current1 = current1.next;
           current2 = current2.next;
       }
       return current1 == null && current2 == null;
   }

   /*
   16. Write a method called removeEvens that removes the values in
   even-numbered indexes from a list, returning a new list that
   contains those values in their original order. For example,
   consider a variable list1 that stores the values [8, 13, 17,
   4, 9, 12, 98, 41, 7, 23, 0, 92] and imagine that the
   following call is made:
   LinkedIntList list2 = list1.removeEvens();
   After the call, list1 should store [13, 4, 12, 41, 23, 92] and
   list2 should store [8, 17, 9, 98, 7, 0] . You may not call
   any methods of the class other than the constructor to solve
   this problem. You may not create any new nodes nor change
   the values stored in data fields to solve this problem. You
   must solve it by rearranging the links of the list.
   */
   public LinkedIntList removeEvens() {
       if (front == null) {
           return null;
       }
       LinkedIntList list2 = new LinkedIntList();
       list2.front = front;
       front = front.next;
       ListNode current1 = front;
       ListNode current2 = list2.front;
       while (current1 != null && current1.next != null) {
           current2.next = current1.next;
           current1.next = current1.next.next;
           current1 = current1.next;
           current2 = current2.next;
       }
       current2.next = null;
       return list2;
   }
   /*
   17. Write a method called removeRange that accepts a starting and
   ending index as parameters and removes the elements at
   those indexes (inclusive) from the list. For example, if a
   variable list stores the values [8, 13, 17, 4, 9, 12, 98, 41,
   7, 23, 0, 92] , the call of listRange.removeRange(3, 8); should
   remove values between index 3 and index 8 (the values 4
   and 7 ), leaving the list of [8, 13, 17, 23, 0, 92] . The method
   should throw an IllegalArgumentException if either of the
   positions is negative. Otherwise you may assume that the
   positions represent a legal range of the list (
   ).
   */
   public void removeRange(int start, int end) {
       if (start < 0 || end >= size() || start > end) {
           throw new IllegalArgumentException("Invalid range");
       }
       if (start == 0) {
           for (int i = 0; i <= end; i++) {
               front = front.next;
           }
       } else {
           ListNode current = front;
           for (int i = 0; i < start - 1; i++) {
               current = current.next;
           }
           for (int i = 0; i <= end - start + 1; i++) {
               current.next = current.next.next;
           }
       }
   }   
   /*
   18. Write a method called doubleList that doubles the size of a
   list by appending a copy of the original sequence to the end of
   the list. For example, if a variable list stores the values [1,
   3, 2, 7] and we make the call of list.doubleList(); then
   after the call it should store [1, 3, 2, 7, 1, 3, 2, 7] . Notice
   that the list has been doubled in size by having the original
   sequence appear twice in a row. You may not make
   assumptions about how many elements are in the list. You
   may not call any methods of the class to solve this problem. If
   the original list contains nodes, then you should construct
   exactly nodes to be added. You may not use any auxiliary
   data structures such as arrays or ArrayLists to solve this
   problem. Your method should run in O( ) time where is
   the number of nodes in the list.
   */
   public void doubleList() {
       if (front == null) {
           return;
       }
       ListNode current = front;
       while (current != null) {
           ListNode newNode = new ListNode(current.data, current.next);
           current.next = newNode;
           current = current.next.next;
       }
   }
   
   /*
   19. Write a method called rotate that moves the value at the front
   of a list of integers to the end of the list. For example, if a
   variable called list stores the values [8, 23, 19, 7, 45, 98,
   102, 4] , then the call of list.rotate(); should move the
   value 8 from the front of the list to the back of the list,
   changing the list to store [23, 19, 7, 45, 98, 102, 4, 8] . If
   the method is called for a list of 0 elements or 1 element, it
   should have no effect on the list. You may neither construct
   any new nodes to solve this problem nor change any of the
   0 ≤ start ≤ end < size
   N
   N
   N N
   data values stored in the nodes. You must solve the problem
   by rearranging the links of the list.
   */
   public void rotate() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode current = front;
       while (current.next != null) {
           current = current.next;
       }
       current.next = front;
       front = front.next;
       current.next.next = null;
   }   
   /*
   20. Write a method called shift that rearranges the elements of a
   list of integers by moving to the end of the list all values that
   are in odd-numbered positions and otherwise preserving list
   order. For example, suppose that a variable list stores the
   values [10, 31, 42, 23, 44, 75, 86] . The call of
   list.shift(); should rearrange the list to store [10, 42, 44,
   86, 31, 23, 75] . It doesn’t matter whether the value itself is
   odd or even; what matters is whether the value appears in an
   odd index (index 1, 3, 5, etc.). Also notice that the original
   order of the list is otherwise preserved. You may not construct
   any new nodes nor use any auxiliary data structures to solve
   this problem. You also may not change any data fields of the
   nodes; you must solve this problem by rearranging the links of
   the list.
   */
   public void shift() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode current = front;
       while (current != null && current.next != null) {
           ListNode temp = current.next;
           current.next = current.next.next;
           temp.next = null;
           if (current.next != null) {
               current = current.next;
           }
           ListNode current2 = front;
           while (current2.next != null) {
               current2 = current2.next;
           }
           current2.next = temp;
       }
   }   
   /*
   21. Write a method called surroundWith that takes an integer x
   and an integer y as parameters and surrounds all nodes in
   the list containing the value x with new nodes containing the
   value y . In particular, each node that contains the value x as
   data should have a new node just before it and just after it
   that each contain the value y . If no nodes in the list contain
   the value x , then the list should not be modified. For example,
   suppose that the variables list1 , list2 , and list3 store the
   following sequences of values:
   [0, 1, 2, 1] // stored in list1
   [0, 1, 0] // stored in list2
   [0, 1, 2] // stored in list3
   and we make the following calls:
   list1.surroundWith(1, 4); // surround 1s with 4s
   list2.surroundWith(1, 1); // surround 1s with 1s
   list3.surroundWith(3, 4); // surround 3s with 4s
   then the variables will now store these sequences:
   [0, 4, 1, 4, 2, 4, 1, 4] // stored in list1
   [0, 1, 1, 1, 0] // stored in list2
   [0, 1, 2] // stored in list3
   */
   public void surroundWith(int x, int y) {
       if (front == null) {
           return;
       }
       if (front.data == x) {
           front = new ListNode(y, front);
           front.next.next = new ListNode(y, front.next.next);
       }
       ListNode current = front;
       while (current.next != null) {
           if (current.next.data == x) {
               current.next = new ListNode(y, current.next);
               current.next.next.next = new ListNode(y, current.next.next.next);
           }
           current = current.next.next;
       }
   }   
   /*
   22. Write a method called reverse that reverses the order of the
   elements in the list. (This is very challenging!) For example, if
   the variable list initially stores the values [1, 8, 19, 4, 17] ,
   the call of list.reverse(); should change the list to store [17,
   4, 19, 8, 1] 
   */
   public void reverse() {
       if (front == null || front.next == null) {
           return;
       }
       ListNode current = front;
       ListNode prev = null;
       while (current != null) {
           ListNode next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       front = prev;
   }
}