/** 
 * Jaiden Borowski 
 * CSDS 132 
 * SalesEmployee class - The SalesEmployee class contains methods which manipulate 
SalesEmployee objects 
 */ 
public class SalesEmployee extends Employee {
  /** 
   * The amount of money the employee is paid 
  */ 
  public double salary; 
  /** 
   * The additional amount of money the employee is paid per sale 
   */ 
  public double commission; 
  /** 
   * The number of sales the employee has made 
   */ 
  public int numSales; 
  
 /**
  * The constructor to create a new instance of the class 
  * @param firstName the new firstName value 
   * @param lastName the new lastName value 
   * @param number the new number value 
   * @param salary the new salary value 
   * @param commission the new commission value 
  */
  public SalesEmployee(String firstName, String lastName, String number, double salary, double commission) {
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.salary = salary; 
    this.commission = commission; 
  } 
  
 /**
  * This method retrieves the employee's commission 
  * @return the employee's current commision 
  */
  public double getCommission() { 
    return commission; 
  } 
  
 /**
  * This method changes the employee's commission to the input value 
  * @param commission the new commission value 
  */
  public void setCommission(double commission) {
    this.commission = commission; 
  } 
  
 /**
  * This method retrieves the employee's number of sales made 
  * @return the employee's current number of sales 
  */
  public int getNumSales() {
    return numSales; 
  } 
  
 /**
  * This method changes the employee's number of sales to the input value 
  * @param numSales the new numSales value 
  */
  public void setNumSales(int numSales) { 
    this.numSales = numSales; 
  } 
  
 /**
  * This method retrieves the employee's salary 
  * @return the employee's current salary 
  */
  public double getSalary() {
    return salary; 
  } 
  
 /**
  * This method changes the employee's salary to the input value 
  * @param salary the new salary value 
  */
  public void setSalary(double salary) {
    this.salary = salary; 
  } 
  
 /**
  * This method retrieves the total amount of money the employee has earned 
  * @return the employee's total paycheck 
  */
  @Override 
  public double getAmountEarned() { 
    return salary + (commission * numSales) + bonus; 
  } 
  
 /**
  * This method modifies the employee's salary by the input value 
  * @param percentage the amount to modify the salary 
  */
  @Override 
  public void adjustPay(double percentage) {
    salary = percentage * salary; 
  } 
  
 /**
  * This method retrieves the employee's information as an easily understandable 
  8 string 
  * @return the employee's information in a clear string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", Sales Employee"; 
  } 
} 
  
