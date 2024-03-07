/* No imports required, we're writing our own
 * optional iterator import if your curious
 * 
 * CS211, W.P. Iverson, instructor and author
 * This is a start at test code for Chapter 15 Assignment
 * Other tests can and will happen....
 * version 2024
 */
public class Test {

// Testing for Exercises in Chapter 15
	
	
   
   public static void main(String[] args) {
		ArrayIntList test = new ArrayIntList();		// my data structure
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		int[] a = {2,9,6,1,3,9,0};	// sample data
		for (int i: a) {		// use for each 
			test.add(i);
			test2.add(i);
		}
       LinkedList<String> A = new LinkedList<String>();
       LinkedList<Integer> B = new LinkedList<Integer>();
       B.add(1); B.add(19); B.add(4); B.add(17);
       B.stutter();
       System.out.println(B.toString());  //[1, 1, 19, 19, 4, 4, 17, 17] 
       System.out.println(B.backwards()); //[17, 17, 4, 4, 19, 19, 1, 1]
       A.removeAll("nothing");
				
		System.out.print("\nLearning about iterators:\n[");
		ArrayIntList.ArrayIntListIterator itr =  test.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
		System.out.println();

		// modified Programming Project #2, to make Class Iterable 
		System.out.println();
		for (Integer i: test2) System.out.print(i + ", ");	// requires Oracle Iterable<E>
		System.out.print("\n\nTextbook Project #2 using our own ArrayList<E>:\n[");
		for (Integer data: test2) System.out.print(data+", "); // Oracle generic Java API Iterator<E>
	}
   

}