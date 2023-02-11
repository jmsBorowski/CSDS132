/** 
 * Jaiden Borowski 
 * CSDS 132 
 * Employee class - The Employee class contains methods which manipulate Employee 
objects 
 */ 
public class Employee { 
  /** 
   * The first name of the employee 
   */ 
  public String firstName = ""; 
 /** 
   * The last name of the employee 
   */ 
  public String lastName = ""; 
 /** 
   * The employee account number
   */ 
  public String number = ""; 
 /** 
   * The amount of money the employee recieves as a bonus to their paycheck
   */ 
  public double bonus = 0.0; 
 /** 
   * The supervisor over the employee 
   */ 
  public Employee supervisor = null; 
  
 /**
  * This method retrieves employee's first name 
  * @return the employee's first name 
  */
  public String getFirstName() {
    return this.firstName; 
  } 
  
 /**
  * This method retrieves employee's last name 
  * @return the employee's last name 
  */
  public String getLastName() {
    return this.lastName; 
  } 
  
 /**
  * This method changes employee's first and last names to the respective input values 
  * @param firstName the new first name value 
   * @param lastName the new last name value 
  */
  public void setName(String firstName, String lastName) { 
    this.firstName = firstName; 
    this.lastName = lastName; 
  } 
  
 /**
  * This method retrieves the employee's number 
  * @return the employee's number 
  */
  public String getNumber() {
    return this.number; 
  } 
  
 /**
  * This method retrieves the employee's bonus 
  * @return the employee's bonus 
  */
  public double getBonus() {
    return this.bonus; 
  } 
  
 /**
  * This method changes the employee's bonus to the input value 
  * @param bonus the new bonus value 
  */
  public void setBonus(double bonus) {
    this.bonus = bonus; 
  } 
  
 /**
  * This method retrieves the employee's total amount earned (varries by employee type) 
  * @return the employee's total earnings 
  */
  public double getAmountEarned() { 
    return this.bonus; 
  } 
  
 /**
  * This method modifies the employee's pay by the input value (varries by employeetype) 
  * @param percentage the multiplied amount to modify the pay by 
  */
  public void adjustPay(double percentage) {
  } 
  
 /**
  * This method converts the employee's information to a string (varries by employee type) 
  * @return the employee's combined information as a string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", "; 
  } 
  
 /**
  * This method compares two employees to determine if they are equal 
  * @param o the Object to compare to 
  * @return the determination if they are equal (true or false) 
  */
  @Override 
  public boolean equals(Object o) {
    if (o instanceof Employee) { 
      Employee e = (Employee)o; 
      return this.getFirstName() == e.getFirstName() 
        && this.getLastName() == e.getLastName() 
        && this.getNumber() == e.getNumber(); 
    } 
    return false; 
  } 
  
 /**
  * This method compares two employees by name to determine if they are equal 
  * @param o the Object to compare to 
  * @return the determination if they are equal (negative, 0, positive) 
  */
  public int compareToByName(Object o) {
    if (o instanceof Employee) {
      Employee e = (Employee)o; 
      int i = 0;
      // compare last names 
      while (i < this.getLastName().length() && i < e.getLastName().length()) { 
        if (this.getLastName().charAt(i) > e.getLastName().charAt(i)) {
          return -1; 
        // if "this" char is smaller 
        } else if (this.getLastName().charAt(i) < e.getLastName().charAt(i)) {
          return 1; 
        } 
        i++; 
      } 
      
      // if unsolved, compared first names 
      int ii = 0;
      while (ii < this.getFirstName().length() && ii < e.getFirstName().length()) {
        if(this.getFirstName().charAt(ii) > e.getFirstName().charAt(ii)) { 
          return -1;  
        } else if (this.getFirstName().charAt(ii) < e.getFirstName().charAt(ii)) {
          return 1; 
        } 
        ii++; 
      } 
      return 0; 
    } else {
      return 0; 
    } 
  } 
  
 /**
  * This method compares two employees by earnings to determine if they are equal 
  * @param o the Object to compare to 
  * @return the determination if they are equal (negative, 0, positive) 
  */
  public int compareToByEarnings(Object o) {
    if (o instanceof Employee) {
      Employee e = (Employee)o; 
      return (int)(this.getAmountEarned() - e.getAmountEarned()); 
    } else {
      return 0; 
    } 
  } 
  
 /**
  * This method changes the employee's supervisor to the input value 
  * @param supervisor the new supervisor value 
  */
  public void setSupervisor(Employee supervisor) {
    this.supervisor = supervisor; 
  } 
  
 /**
  * This method retrieves the employee's supervisor 
  * @return the employee's supervisor 
  */
  public Employee getSupervisor() {
    return this.supervisor; 
  } 
}
