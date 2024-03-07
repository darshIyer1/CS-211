/* BJP code modified (by W.P. Iverson, 2024) to import only what's needed
 * to learn about an int array list data structure, like no imports.
 * 
 * Most of this code from 
 * http://practiceit.cs.washington.edu/problems/shared/ArrayIntList.java
 * Reges and Stepp provided inner class iterator (see end of file)
 * and also provided (...) arguments as used in constructor
 * 
*/
import java.util.NoSuchElementException;
public class ArrayIntList {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the list
    
    public static final int DEFAULT_CAPACITY = 10;

 // EXERCISE CODE GOES HERE, to keep it organized, might be on a Quiz some day???
    
    // Exercise #1
    // solution modified from github.com/Creede15/practice-it/blob/master/chapter-7
    // DO NOT just copy/paste all the code, as you likely will learn nothing!
    // if you get stuck on an exercise, maybe peek at "a solution", close, then write your own
    public int lastIndexOf(int value) {  // changed to non-static, used as member method now
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i] == value) { // changed array to elementData
                return i;
            }
        }
        return -1;
    }
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
   // EXERCISE END.  Class structure below from BJP textbook www.buildingjavaprograms.com
    
    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }
    
    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }
    
    // for creating test cases more easily, Reges provided ... arg
    public ArrayIntList(int... elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            add(n);
        }
    }
    
    // for creating test cases more easily (a dupe of the above constructor)
    public static ArrayIntList withValues(int... elements) {
        ArrayIntList list = new ArrayIntList(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            list.add(n);
        }
        return list;
    }
    
    // for creating test cases more easily
    public ArrayIntList(int element, boolean notCapacity) {
        this();
        add(element);
    }
    
    // copy constructor; for creating test cases more easily
    public ArrayIntList(ArrayIntList list) {
        this(Math.max(DEFAULT_CAPACITY, list.size() * 2));
        addAll(list);
    }
    
    // pre : size() < capacity (elementData.length)
    // post: appends the given value to the end of the list
    public void add(int value) {
        add(size, value);
    }
    
    // pre: size() < capacity (elementData.length) && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //     values right
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        ensureCapacity(size + 1);
        
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }
    
    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }
    
    // post: list is empty
    public void clear() {
        size = 0;
    } 
    
    // post: returns true if the given value is contained in the list, false otherwise
    public boolean contains(int value) {
        return indexOf(value) != -1;
    } 
    
    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            int[] newList = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = elementData[i];
            }
            elementData = newList;
        }
    }
    
    // returns true if o is an ArrayIntList with the same size and elements as this one
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIntList)) {
            return false;
        }

        ArrayIntList other = (ArrayIntList) o;
        if (this.size != other.size) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            if (elementData[i] != other.elementData[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }
    
    // post: returns capacity of this list's underlying array
    public int getCapacity() {
        return elementData.length;
    }
    
    // post : returns the position of the first occurence of the given
    //      value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    // post: returns an iterator for this list
    public ArrayIntListIterator iterator() {
        return new ArrayIntListIterator(this);
    } 
    
    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }
    
    // post: removes all occurrences of the values in the given list from this list
public void mirror() {
    int size = this.size;
    for (int i = size - 1; i >= 0; i--) {
        this.add(this.get(i));
    }
}
public void printInversions() {
    for (int i = 0; i < this.size; i++) {
        for (int j = i + 1; j < this.size; j++) {
            if (this.get(i) > this.get(j)) {
                System.out.println("(" + this.get(i) + ", " + this.get(j) + ")");
            }
        }
    }
}
public void removeAll(int value) {
    for (int i = 0; i < this.size; i++) {
        if (this.get(i) == value) {
            this.remove(i);
            i--;
        }
    }
}
public void removeEvenNumbers() {
    for (int i = 0; i < this.size;) {
        if (this.get(i) % 2 == 0) {
            this.remove(i);
        } else {
            i++;
        }
    }
}
public void removeFront(int n) {
    for (int i = 1; i <= n; i++) {
        this.remove(0);
    }
}
public void stutter() {
    for (int i = 0; i < this.size; i += 2) {
        this.add(i, this.get(i));
    }
}


    
    // pre : 0 <= index < size()
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    } 
    
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }
    
    // post: returns an array version of the contents of this list
    public int[] toArray() {
	int[] result = new int[size];
	for (int i = 0; i < size; i++) {
	    result[i] = elementData[i];
	}
        return result;
    }
    
    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }
    
    // helpers to make sure indexes do not fall out of bounds
    private void checkIndex(int index) {
        checkIndex(index, 0, size - 1);
    }
    
    private void checkIndex(int index, int min, int max) {
        if (!(min <= index && index <= max)) {
            throw new ArrayIndexOutOfBoundsException("Illegal index " + index + 
                    "; must be between " + min + " and " + max + "\n");
        }
    }
    
    
    // Stuart Reges
    // 4/4/05
    //
    // The ArrayIntListIterator class provides a set of utilities for iterating
    // over an ArrayIntList and possibly removing values from the list.
    
      
    public static class ArrayIntListIterator {
        private ArrayIntList list;    // list to iterate over
        private int position;          // current position within the list
        private boolean removeOK;      // whether it's okay to remove now
        
        // pre : list != null
        // post: constructs an iterator for the given list
        public ArrayIntListIterator(ArrayIntList list) {
            this.list = list;
            position = 0;
            removeOK = false;
        }
        
        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < list.size();
        }
        
        // pre : hasNext()
        // post: returns the next element in the iteration
        public int next() {
            if (!hasNext())
                throw new IllegalArgumentException();
            int result = list.get(position);
            position++;
            removeOK = true;
            return result;
        }
        
        // pre : next() has been called without a call on remove (i.e., at most one
        //     call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK)
                throw new IllegalStateException();
            list.remove(position - 1);
            position--;
            removeOK = false;
        }
    }    

   
}
