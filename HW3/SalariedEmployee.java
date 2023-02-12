/** 
 * Jaiden Borowski 
 * CSDS 132 
 * SalariedEmployee class - The SalariedEmployee class contains methods which 
 * manipulate SalariedEmployee objects 
 */ 
public class SalariedEmployee extends Employee {
  /** 
   * The amount of money the employee is paid 
   */ 
  public double salary; 
  
 /**
  * The constructor to create a new instance of the class 
  * @param firstName the new firstName value 
   * @param lastName the new lastName value 
   * @param number the new number value 
   * @param salary the new salary value 
  */
  public SalariedEmployee(String firstName, String lastName, String number, double 
salary) {
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.salary = salary; 
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
    return salary + bonus; 
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
  * This method retrieves the employee's information as an easily understandable string 
  * @return the employee's information in a clear string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", Salaried Employee"; 
  } 
}
