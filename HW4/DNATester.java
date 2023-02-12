import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator; 
/** 
 * A DNATester class to test the methods of the DNA class.
 * 
 * @author <em>Jaiden Borowski</em> 
 * @version 1.0
 */ 
public class DNATester {
  
  /**
   * Test the getDNAList method 
   */
  @Test
  public void testGetDnaList() {
    DNA dna = new DNA(); 
    assertEquals("Testing get DNA list EMPTY", "null", 
String.valueOf(dna.getDNAList().getFront())); 
    dna = dna.string2DNA("A"); 
    assertEquals("Testing get DNA list ONE","A", 
String.valueOf(dna.getDNAList().getFront().getElement())); 
    dna = dna.string2DNA("ACGT"); 
    String dna3Str = String.valueOf(dna.getDNAList().getFront().getElement()) 
                   + 
String.valueOf(dna.getDNAList().getFront().getNext().getElement())
                   + 
String.valueOf(dna.getDNAList().getFront().getNext().getNext().getElement())
                   + 
String.valueOf(dna.getDNAList().getFront().getNext().getNext().getNext().getElement
()); 
    assertEquals("Testing get DNA list MANY","ACGT", dna3Str); 
  } 
  
  /**
   * Test the setDNAList method 
   */ 
  @Test
  public void testSetDNAList() {
    DNA dna = new DNA(); 
    dna.setDNAList(new DoubleLinkedList<>()); 
    assertEquals("Testing set DNA list EMPTY", "null", 
String.valueOf(dna.getDNAList().getFront())); 
    DoubleLinkedList<DNA.Base> list = new DoubleLinkedList<DNA.Base>(); 
    list.addToBack(DNA.Base.values()[0]); 
    dna.setDNAList(list); 
    assertEquals("Testing set DNA list ONE","A", dna.toString()); 
    list.addToBack(DNA.Base.values()[1]); 
    list.addToBack(DNA.Base.values()[2]); 
    list.addToBack(DNA.Base.values()[3]); 
    dna.setDNAList(list); 
    assertEquals("Testing set DNA list MANY","ACGT", dna.toString()); 
  }
  
  /**
   * Test the toString method 
   */ 
  @Test
  public void testToString() {
    DNA dna = new DNA(); 
    assertEquals("Testing to String EMPTY", "", dna.toString()); 
    dna = dna.string2DNA("A"); 
    assertEquals("Testing toString ONE","A", dna.toString()); 
    dna = dna.string2DNA("ACGT"); 
    assertEquals("Testing toString MANY","ACGT", dna.toString()); 
  }
  
  /**
   * Test the string2DNA method 
   */ 
  @Test
  public void testString2DNA() { 
    DNA dna = new DNA(); 
    //dna = dna.string2DNA(""); 
    assertEquals("Testing string 2 DNA EMPTY", "", dna.toString()); 
    dna = dna.string2DNA("A"); 
    assertEquals("Testing string 2 DNA ONE", "A", dna.toString()); 
    dna = dna.string2DNA("ACGT"); 
    assertEquals("Testing string 2 DNA MANY", "ACGT", dna.toString()); 
  } 
  
  /**
   * Test the splice method 
   */ 
  @Test
  public void testSplice() {
    DNA dna = new DNA(); 
    DNA dna2 = new DNA(); 
    dna.splice(dna2,0); 
    assertEquals("Testing splice EMPTY", "", dna.toString()); 
    dna2 = dna2.string2DNA("A"); 
    dna.splice(dna2,0); 
    assertEquals("Testing splice ONE", "A", dna.toString()); 
    dna2 = dna2.string2DNA("CGT"); 
    dna.splice(dna2,1); 
    assertEquals("Testing splice MANY", "AGT", dna.toString()); 
    dna.splice(dna2,5); 
    assertEquals("Testing splice MANY", "AGT", dna.toString()); 
  }
  
  /**
   * Test the overlaps method 
   */ 
  @Test
  public void testOverlaps() {
    DNA dna = new DNA(); 
    DNA dna2 = new DNA(); 
    assertEquals("Testing overlaps EMPTY", "true", 
Boolean.toString(dna.overlaps(dna,dna2,0))); 
    dna = dna.string2DNA("A"); 
    dna2 = dna2.string2DNA("A"); 
    assertEquals("Testing overlaps true ONE", "true", 
Boolean.toString(dna.overlaps(dna,dna2,1))); 
    dna2 = dna2.string2DNA("C"); 
    assertEquals("Testing overlaps false ONE", "false", 
Boolean.toString(dna.overlaps(dna,dna2,1))); 
    dna = dna.string2DNA("ACGT"); 
    dna2 = dna2.string2DNA("GTTT"); 
    assertEquals("Testing overlaps true MANY", "true", 
Boolean.toString(dna.overlaps(dna,dna2,2))); 
    dna2 = dna2.string2DNA("TTTT"); 
    assertEquals("Testing overlaps true MANY", "false", 
Boolean.toString(dna.overlaps(dna,dna2,2))); 
  } 
  
  /**
   * Test the compareTo method 
   */ 
  @Test
  public void testCompareTo() { 
    DNA dna = new DNA(); 
    DNA dna2 = new DNA(); 
    assertEquals("Testing compareTo EMPTY", "0", 
Integer.toString(dna.compareTo(dna2))); 
    dna = dna.string2DNA("A"); 
    dna2 = dna2.string2DNA("A"); 
    assertEquals("Testing overlaps equal ONE", "0", 
Integer.toString(dna.compareTo(dna2))); 
    dna2 = dna2.string2DNA("C"); 
    assertEquals("Testing overlaps unequal ONE", "2", 
Integer.toString(dna.compareTo(dna2))); 
    assertEquals("Testing overlaps unequal ONE", "-2", 
Integer.toString(dna2.compareTo(dna))); 
    dna = dna.string2DNA("ACGT"); 
    dna2 = dna2.string2DNA("ACGT"); 
    assertEquals("Testing overlaps equal MANY", "0", 
Integer.toString(dna.compareTo(dna2))); 
    dna2 = dna2.string2DNA("TGCG"); 
    assertEquals("Testing overlaps unequal MANY", "19", 
Integer.toString(dna.compareTo(dna2))); 
    assertEquals("Testing overlaps unequal MANY", "-19", 
Integer.toString(dna2.compareTo(dna))); 
  } 
  
  /**
   * Test the main method 
   */ 
  @Test
  public void testMain() {
    DNA dna = new DNA(); 
    String[] args = {"A","C"}; 
    dna.main(args); 
    // printed in interactions pane: Spliced string 2 (C) in front: CA 
    assertEquals("Testing main method ONE", "Spliced string 2 (C) in front: CA", 
"Spliced string 2 (C) in front: CA"); 
    args[0] = "CA"; 
    args[1] = "AT"; 
    dna.main(args); 
    // printed in interactions pane: Spliced string 1 (CA) in front: CAT 
    assertEquals("Testing main method MANY", "Spliced string 1 (CA) in front: CAT",
"Spliced string 1 (CA) in front: CAT"); 
  } 
} 
