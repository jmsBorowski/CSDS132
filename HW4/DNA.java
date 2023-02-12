/** 
 * The DNA class contains methods to manipulate a DNA object 
 * 
 * @author <em>Jaiden Borowski</em> 
 * @version 1.0
 */ 
public class DNA implements Comparable<DNA> { 
  
  /** 
   * The Double Linked List of Bases which represents a string of DNA 
   */ 
  private DoubleLinkedList<Base> dnaList = null;   
  
  /** 
   * A public constructor to create a new DNA object 
   */ 
  public DNA() { 
    dnaList = new DoubleLinkedList<Base>(); 
  } 
  
  /** 
   * Base enum to hold DNA letters 
   */ 
  enum Base {
    A("A"), C("C"), G("G"), T("T");
    
    /** 
     * The name of the Base object 
     */ 
    private final String name; 
    
    /** 
     * A private constructor to create a new Base object 
     */ 
    private Base(String name) { 
      this.name = name; 
    } 
    
    /** 
     * This method retrieves the Base name 
     * @return The name of the Base 
     */ 
    public String getName() {
      return this.name; 
    } 
  } 
     
  /** 
   * Retrieves the double linked list 
   * @return The double linked list of the DNA 
   */ 
  public DoubleLinkedList<Base> getDNAList() { 
    return dnaList; 
  } 
  
  /** 
   * Sets the double linked list to the input value 
   * @param dnaList The new double linked list value 
   */ 
  public void setDNAList(DoubleLinkedList<Base> dnaList) { 
    this.dnaList = dnaList; 
  } 
  
  /* 
   * Displays the DNA data as a String 
   * @return the DNA data represented as a String 
   */ 
  public String toString() { 
    /** The String to be filled with the Base values of the DNA */ 
    String str = ""; 
    /** A nodeptr to iterate through "this" DNA list */ 
    DLNode<Base> nodeptr = this.getDNAList().getFront();   
    
    // iterates through the DNA list 
    while (nodeptr != null) { 
      // iterates through each Base value 
      for (Base b : Base.values()) { 
        // determines if the current element matches the current Base, appends Base
name to String if so 
        if (nodeptr.getElement() == b) { 
          str += b.getName(); 
        } 
      } 
      nodeptr = nodeptr.getNext(); 
    } 
    
    return str; 
  } 
  
  /** 
   * Appends the input DNA to "this" double linked list after removing numbases of 
Bases from the front 
   * @param dna The input DNA to be modified and appended 
   * @param numbases The number of Bases to remove from the begining of the input 
string 
   */ 
  public void splice(DNA intputDNA, int numbases) { 
    /** A nodeptr to iterate through the input DNA's list */ 
    DLNode<Base> nodeptr = intputDNA.getDNAList().getFront(); 
    /** A list to be filled with the remaining Base values of the input DNA's list 
*/ 
    DoubleLinkedList<Base> restOfInputList = new DoubleLinkedList<Base>(); 
    
    // iterates through the input DNA's list numbases number of spaces 
    while (numbases > 0 && nodeptr != null) { 
      nodeptr = nodeptr.getNext(); 
      numbases--; 
    } 
        
    // iterates through the remaining nodes of the input DNA's list and appends 
nodes to restOfInputList list 
    while (nodeptr != null) { 
      restOfInputList.addToBack(nodeptr.getElement()); 
      nodeptr = nodeptr.getNext(); 
    } 
    
    this.getDNAList().append(restOfInputList); 
  } 
  
  /** 
   * Compares two DNA objects to determine if they are equal 
   * @param inputDNA The DNA to compare to "this" DNA 
   * @return A numeric value indicating their alphabetical order (0 if they are 
they same) 
   */ 
  @Override 
  public int compareTo(DNA inputDNA) { 
    /** A nodeptr to iterate through "this" DNA list */ 
    DLNode<Base> thisNodeptr = this.getDNAList().getFront(); 
    /** A nodeptr to iterate through the inputDNA list */ 
    DLNode<Base> inputNodeptr = inputDNA.getDNAList().getFront(); 
    
    // iterates through the two DNA lists 
    while (thisNodeptr != null && inputNodeptr != null) { 
      // if the current elements are different, it returns their numeric difference
as an int 
      if (thisNodeptr.getElement().getName() != 
inputNodeptr.getElement().getName()) { 
        return (int)((inputNodeptr.getElement().getName()).charAt(0)) - (int)
((thisNodeptr.getElement().getName()).charAt(0)); 
      } 
      
      thisNodeptr = thisNodeptr.getNext(); 
      inputNodeptr = inputNodeptr.getNext(); 
    } 
    
    // if the lists have no differences, returns 0 
    if (thisNodeptr == null && inputNodeptr == null) { 
      return 0; 
    // if only "this" list is over, then "this" list is shorter (comes first 
alphabetically), so returns positive 
    } else if (thisNodeptr == null) { 
      return 1; 
    // if only input list is over, then "this" list is longer (comes last 
alphabetically), so returns negative 
    } else { 
      return -1; 
    } 
  } 
    
  /** 
   * Converts the input String into a DNA object 
   * @param inputStr The input String to be converted 
   * @return The new DNA object that was created from the input String 
   */ 
  public static DNA string2DNA(String inputStr) { 
    /** The DNA to be filled with the matching Base values to the input String */ 
    DNA newDNA = new DNA(); 
    
    if (inputStr.length() == 0) { 
      throw new IllegalArgumentException(); 
    } 
    
    // iterates through the chars in the input String 
    for (int i = 0; i < inputStr.length(); i++) { 
      // checking that char can match a Base value 
      if (inputStr.charAt(i) == 'A' || inputStr.charAt(i) == 'C' || 
inputStr.charAt(i) == 'G' || inputStr.charAt(i) == 'T') { 
        // iterates through Base values 
        for (Base b : Base.values()) { 
          // determines if the current char matches the current Base, appends to 
DNA list if so 
          if (String.valueOf(inputStr.charAt(i)).equals(b.getName())) { 
            newDNA.getDNAList().addToBack(b); 
          } 
        } 
      // throws IllegalArgumentException if char does not match a Base value 
      } else {  
        throw new IllegalArgumentException(); 
      } 
    } 
    return newDNA; 
  } 
    
  /** 
   * Determines if the two DNA match for n number of Bases 
   * @param dna1 The first DNA to be compared 
   * @param dna2 The second DNA to be compared 
   * @param n The number of Bases to compare from each DNA 
   * @return Whether or not the DNA's match 
   */ 
  public static boolean overlaps(DNA dna1, DNA dna2, int n) { 
    /** A nodeptr to iterate through the dna1 list (from the back) */ 
    DLNode<Base> nodeptr1 = dna1.getDNAList().getBack(); 
    /** A nodeptr to iterate through the dna2 list (from the front) */ 
    DLNode<Base> nodeptr2 = dna2.getDNAList().getFront(); 
    
    /** A String to be filled with the names of the Base values of dna1 (from the 
back) */ 
    String dna1Back = ""; 
    /** A String to be filled with the names of the Base values of dna2 (from the 
front) */ 
    String dna2Front = ""; 
    
    // iterates through dna1 and dna2 n number of Bases and appends the names of 
the Bases to the corresponding Strings 
    while (n > 0 && nodeptr1 != null && nodeptr2 != null) { 
      dna1Back = nodeptr1.getElement().getName() + dna1Back; 
      dna2Front = dna2Front + nodeptr2.getElement().getName(); 
      nodeptr1 = nodeptr1.getPrevious(); 
      nodeptr2 = nodeptr2.getNext(); 
      n--; 
    } 
    
    // compares String values to determine if the two inpus DNAs are equal for the 
n number of spaces  
    if (!dna1Back.equals(dna2Front)) { 
      return false; 
    } 
    return true; 
  } 
  
  /** 
   * The main method splices two Strings so that the final string is as short as 
possible 
   * @param args The String array containing the two input Strings to be spliced 
   */ 
  public static void main(String[] args) { 
    /** The first input String to be spliced */ 
    String DNA1 = args[0]; 
    /** The first input String as a DNA object to be spliced */ 
    DNA dna1 = string2DNA(DNA1); 
    
    /** The second input String to be spliced */ 
    String DNA2 = args[1]; 
    /** The second input String as a DNA object to be spliced */ 
    DNA dna2 = string2DNA(DNA2); 
    
    /** A counter to iterate through the DNA lists */ 
    int counter = 0; 
    /** If <code>counter</code> number of Base values of the DNAs are the same */ 
    boolean same = false; 
    /** The highest number of consecutive Base values of the DNAs that overlap 
(with dna1 in front) */ 
    int counter1 = 0; 
        
    // iterates through the DNA lists and determines the highest overlap (with dna1
in front) 
    while (counter < dna1.getDNAList().getLength()+1 && counter < 
dna2.getDNAList().getLength()+1) { 
      same = overlaps(dna1, dna2, counter); 
      // if the DNA lists overlap <code>counter</code> number of spaces, that 
counter number is saved to <code>counter1</code> 
      if (same) { 
        counter1 = counter; 
      } 
      counter++; 
    } 
    
    counter = 0; 
    /** The highest number of consecutive Base values of the DNAs that overlap 
(with dna2 in front) */ 
    int counter2 = 0; 
    
    // iterates through the DNA lists and determines the highest overlap (with dna2
in front) 
    while (counter < dna1.getDNAList().getLength()+1 && counter < 
dna2.getDNAList().getLength()+1) { 
      same = overlaps(dna2, dna1, counter); 
      // if the DNA lists overlap <code>counter</code> number of spaces, that 
counter number is saved to <code>counter2</code> 
      if (same) { 
        counter2 = counter; 
      } 
      counter++; 
    } 
        
    // if the DNA lists overlap more with dna1 in front, they are spliced with dna1
in front 
    if (counter1 > counter2) { 
      dna1.splice(dna2, counter1); 
      System.out.println("Spliced string 1 (" + args[0] + ") in front: " + 
dna1.toString()); 
    // if the DNA lists overlap more with dna2 in front, they are spliced with dna2
in front 
    } else { 
      dna2.splice(dna1, counter2); 
      System.out.println("Spliced string 2 (" + args[1] + ") in front: " + 
dna2.toString()); 
    } 
  } 
} 
