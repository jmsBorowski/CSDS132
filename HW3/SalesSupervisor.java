/** 
 * Jaiden Borowski 
 * CSDS 132 
 * SalesSupervisor class - The SalesSupervisor class contains methods which manipulate SalesSupervisor objects 
 */ 
public class SalesSupervisor extends Employee implements Supervisor {
  /** 
   * The amount of money the supervisor is paid 
  */ 
  public double salary; 
  /** 
   * The additional amount of money the supervisor is paid per sale 
   */ 
  public double commission; 
  /** 
   * The number of sales the supervisor has made 
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
  public SalesSupervisor(String firstName, String lastName, String number, double salary, double commission) {
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.salary = salary; 
    this.commission = commission; 
  } 
  
 /**
  * This method retrieves the supervisor's commission 
  * @return the supervisor's current commision 
  */
  public double getCommission() { 
    return commission; 
  } 
  
 /**
  * This method changes the supervisor's commission to the input value 
  * @param commission the new commission value 
  */
  public void setCommission(double commission) {
    this.commission = commission; 
  } 
  
 /**
  * This method retrieves the supervisor's number of sales made 
  * @return the supervisor's current number of sales 
  */
  public int getNumSales() {
    return numSales; 
  } 
  
 /**
  * This method changes the supervisor's number of sales to the input value 
  * @param numSales the new numSales value 
  */
  public void setNumSales(int numSales) { 
    this.numSales = numSales; 
  } 
  
 /**
  * This method retrieves the supervisor's salary 
  * @return the supervisor's current salary 
  */
  public double getSalary() {
    return salary; 
  } 
  
 /**
  * This method changes the supervisor's salary to the input value 
  * @param salary the new salary value 
  */
  public void setSalary(double salary) {
    this.salary = salary; 
  } 
  
 /**
  * This method retrieves the total amount of money the supervisor has earned 
  * @return the supervisor's total paycheck 
  */
  public double getAmountEarned() { 
    return salary + (commission * numSales) + bonus; 
  } 
  
 /**
  * This method modifies the supervisor's salary by the input value 
  * @param percentage the amount to modify the salary 
  */
  public void adjustPay(double percentage) {
    salary = percentage * salary; 
  } 
  
 /**
  * This method retrieves the supervisor's information as an easily understandable 
string 
  * @return the supervisor's information in a clear string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", Sales Supervisor"; 
  } 
}
