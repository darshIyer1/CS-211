// Basic tests for Chapter 17 Exercises
// upgraded into generic Search Tree use
// CS211, January 2024, W.P. Iverson, instructor
public class Post {

	public static void main(String[] args) {

		SearchTree<Double> empty = new SearchTree<Double>();
		SearchTree<CalendarDate> test = new SearchTree<CalendarDate>();
		SearchTree<CalendarDate> other = new SearchTree<CalendarDate>();
		test.add(new CalendarDate(1,1,2021));  test.add(new CalendarDate(12,12,2016));
		// just 2 nodes for now, many more needed for rigorous testing
		
//		A.  Exercise #7   isFull();		
		System.out.println(test.isFull());	// false
		System.out.println(empty.isFull());	// true
		System.out.println(test);	// 2 nodes using toString()
		
//		B.  Exercise #9   equals2(t2);		
		System.out.println(test.equals2(test));	// true
		System.out.println(test.equals2(other)); // false
		other.add(new CalendarDate(1,1,2021));  other.add(new CalendarDate(12,12,2016));
		System.out.println(test.equals2(other)); // true
		
//		D.  Exercise #12    removeLeaves();
		empty.removeLeaves();	empty.print();	// nothing to print
		test.removeLeaves();	test.print();// [1/1/2021]
		
//		C.  remove process explained in detail via PowerPoint at BJP site		
		empty.remove(42.);  empty.print();	// nothing to print
		test.remove(new CalendarDate(1,1,2021));  test.print(); // all gone
	}
}
