import java.util.Iterator;
import java.util.NoSuchElementException; 
/** 
 * The DoubleLinkedList class contains methods to manipulate a DoubleLinkedList object 
 * 
 * @author <em>Jaiden Borowski</em> 
 * @version 1.0
 */ 
class DoubleLinkedList<T> implements Iterable<T> {
  /** The reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** The reference to the last node of a double linked list */
  private DLNode<T> back; 
  
  /** A constructor to create an empty double linked list object */
  public DoubleLinkedList() {
    front = back = null;
  }
  
  /** 
   * Determines if the list is empty by checking the front node 
   * @return true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null); 
  }
  
  /** 
   * Determines the length of the DoubleLinkedList 
   * @return The length/number of nodes in the DoubleLinkedList 
   */ 
  public int getLength() { 
    /** Counts the number of nodes in the list */ 
    int counter = 0; 
    /** A nodeptr to iterate through the list */ 
    DLNode<T> nodeptr = this.getFront(); 
    
    // iterates through the list and counts the number of nodes 
    while (nodeptr != null) { 
      counter++; 
      nodeptr = nodeptr.getNext(); 
    } 
    
    return counter; 
  } 
  
  /**
   * Returns the reference to the first node of the linked list.
   * @return The first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  } 
  
  /**
   * Sets the first node of the linked list.
   * @param node The node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return The last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * @param node The node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  }
  
  /**
   * Adds an element to the front of the linked list.
   * @param element The element to add to the front of the linked list
   */
  public void addToFront(T element) {
    /** The input element as a DLNode */ 
    DLNode<T> newNode = new DLNode<T>(element, null, null); 
    
    // if "this" list is empty (has no nodes), sets front and back to the new node 
    if (isEmpty()) { 
      setFront(newNode); 
      setBack(newNode); 
      getFront().setPrevious(null); 
      getBack().setNext(null); 
    // if "this" list is not empty (has at least one node), sets front to the new node 
    } else { 
      getFront().setPrevious(newNode); 
      newNode.setNext(getFront()); 
      setFront(newNode); 
      getFront().setPrevious(null); 
    } 
  } 
  
  /**
   * Adds an element to the back of the linked list.
   * @param element The element to add to the back of the linked list
   */
  public void addToBack(T element) { 
    /** The input element as a DLNode */ 
    DLNode<T> newNode = new DLNode<T>(element, null, null); 
    
    // if "this" list is empty (has no nodes), sets front and back to the new node 
    if (isEmpty()) { 
      setFront(newNode); 
      setBack(newNode); 
      getFront().setPrevious(null); 
      getBack().setNext(null); 
    // if "this" list is not empty (has at least one node), sets back to the new node 
    } else { 
      getBack().setNext(newNode); 
      newNode.setPrevious(getBack()); 
      setBack(newNode); 
      getBack().setNext(null); 
    } 
  }
  
  /**
   * Compares two lists if their elements are the same and in the same order 
   * @param o The object to compare to 
   * @return true if the lists are equal 
   */ 
  @Override 
  public boolean equals(Object o) {
    // determines if o is a DoubleLinkedList object 
    if (o instanceof DoubleLinkedList) { 
      /** A nodeptr for the input DoubleLinkedList */ 
      DLNode inputNode = ((DoubleLinkedList)o).getFront(); 
      /** A nodeptr for "this" DoubleLinkedList */ 
      DLNode thisNode = this.getFront(); 
      
      // if the list lengths are unequal, returns false since they do no have all the same items 
      if (((DoubleLinkedList)o).getLength() != this.getLength()) { 
        return false; 
      } 
      
      // increments through both lists 
      while (thisNode != null && inputNode != null) { 
        // determines if the current elements in the lists are unequal 
        if (!thisNode.getElement().equals(inputNode.getElement())) { 
          return false; 
        } 
        thisNode = thisNode.getNext(); 
        inputNode = inputNode.getNext(); 
      } 
      return true; 
    } 
    return false; 
  } 
  
  /**
   * Adds input list's elements to the end of "this" list 
   * @param inputList The list of elements to add to the end of "this" list 
   */ 
  public void append(DoubleLinkedList<T> inputList) { 
    /** A nodeptr for the input list */ 
    DLNode<T> inputNode = inputList.getFront(); 
    
    // increments through each node in the input list 
    while (inputNode != null) {
      // if "this" list is empty (has no nodes), sets front and back to the currentnode 
      if (this.isEmpty()) { 
        setFront(inputNode); 
        setBack(inputNode); 
        getFront().setPrevious(null); 
        getBack().setNext(null); 
      // if "this" list is not empty (has at least one node), sets back to the current node 
      } else { 
        setBack(new DLNode<T>(inputNode.getElement(), this.getBack(), null)); 
      } 
      
      inputNode = inputNode.getNext(); 
    } 
  } 
  
  /**
   * Remove and return the element at the front of the linked list.
   * @return the element that was at the front of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */ 
  public T removeFromFront()  {
    /**if(!isEmpty()){
      T store = getFront().getElement();
      setFront(getFront().getNext());
      return store;
    } 
    throw new NoSuchElementException(); */ 
    return null; 
  } 
  
  /**
   * Remove and return the element at the back of the linked list.
   * @return the element that was at the back of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromBack() {
    /**if(!isEmpty()){
      T store = getBack().getElement();
      setBack(getBack().getPrevious());
      return store;
    } 
    throw new NoSuchElementException(); */ 
    return null; 
  }
  
  /**
   * Returns an iterator for the linked list that starts at the head of the list 
and runs to the tail.
   * @return  the iterator that runs through the list from the head to the tail
   */ 
  @Override 
  public DoubleLinkedListIterator<T> iterator() {
    return new DoubleLinkedListIterator<T>(this);
  } 
} 
     
  // Iterator class 
  class DoubleLinkedListIterator<T> implements Iterator<T> {
    /** 
     * The nodeptr for the Double Linked List Iterator 
     */ 
    private DLNode<T> current; 
    private DoubleLinkedList<T> list; 
        
    /** 
     * The constructor to create a new DoubleLinkedListIterator object 
     * @param inputList the list to be iterated through 
     */ 
    public DoubleLinkedListIterator(DoubleLinkedList<T> inputList) {
      current = inputList.getFront(); 
    } 
    
    /** 
     * Retrieves the value of <code>current</code> 
     * @return the value of <code>current</code> 
     */ 
    public DLNode<T> getCurrent() { 
      return this.current; 
    } 
    
    /** 
     * Changes the value of <code>current</code> to be equal to the input value 
     * @param current The new value of <code>current</code> 
     */ 
    public void setCurrent(DLNode<T> current) { 
      this.current = current; 
    } 
    
    /** 
     * Adds an element to the current spot of the double linked list 
     * @param element The element to add to the double linked list 
     */ 
    public void add(T element) { 
      /** The input element as a DLNode */ 
      DLNode<T> newNode = new DLNode<T>(element, current, current.getNext()); 
      
      // if "this" list is empty (has no nodes), sets front and back to the new node 
      if (!hasNext() && !hasPrevious()) { 
        current.setNext(newNode); 
        current.setPrevious(newNode); 
      // if no next, then make input final element  
      } else if (!hasNext()) { 
        list.addToBack(element); 
      // if no previous, then make input first element 
      } else if (!hasNext()) { 
        list.addToFront(element);  
      } else { 
        current.setPrevious(newNode); 
      } 
    } 
    
    /** 
     * Determines if "this" list has a next node 
     * @return true if there is a next node 
     */ 
    @Override 
    public boolean hasNext() {
      // if the current node is not null 
      if(!current.equals(null)) {
        return current.getNext() != null;
      // if the current node is null 
      } else {
        return false;
      } 
    } 
    
    /** 
     * Determines if the double linked list has a previous node 
     * @return true if there is a previous node 
     */ 
    public boolean hasPrevious() { 
      // if the current node is not null 
      if (!current.equals(null)) { 
        return current.getPrevious() != null; 
      // if the current node is null 
      } else { 
        return false; 
      } 
    } 
    
    /** 
     * Retrieves the next element in the list 
     * @return The next element in the list 
     */ 
    @Override 
    public T next() { 
      // if the current node is not null, returns the next element 
      if (hasNext()) { 
        current = current.getNext(); 
        return current.getElement(); 
      // if the current node is null, returns null 
      } else { 
        return null; 
      } 
    } 
    
    /** 
     * Non-implemented method 
     */ 
    public int nextIndex() {
      throw new UnsupportedOperationException(); 
    } 
    
    /** 
     * Retrieves the previous element in the list 
     * @return The previous element in the list 
     */ 
    public T previous() { 
      // if the current node is not null, returns the previous element 
      if (hasPrevious()) { 
        current = current.getPrevious(); 
        return current.getElement(); 
      // if the current node is null, returns null
      } else { 
        return null; 
      } 
    } 
    
    /** 
     * Non-implemented method 
     */ 
    public int previousIndex() {
      throw new UnsupportedOperationException();
    } 
    
    /** 
     * Non-implemented method 
     */ 
    @Override 
    public void remove() {
      throw new UnsupportedOperationException(); 
    } 
    
    /** 
     * This method sets the current element to the input value 
     * @param element The new value of the current element 
     */ 
    public void set(T element) { 
      setCurrent(new DLNode<T>(element, current.getPrevious(), current.getNext()));
    } 
  } 
