/** 
 * Jaiden Borowski 
 * CSDS 132 
 * HourlyEmployee class - The HourlyEmployee class contains methods which 
manipulate HourlyEmployee objects 
 */ 
public class HourlyEmployee extends Employee {
  /** 
   * The amount of money the employee is paid per hour 
   */ 
  public double hourlyRate; 
  /** 
   * The number of hours the employee has worked 
   */ 
  public double hoursWorked; 
  
 /**
  * The constructor to create a new instance of the class 
  * @param firstName the new firstName value 
   * @param lastName the new lastName value 
   * @param number the new number value 
   * @param hourlyRate the new hourlyRate value 
  */
  public HourlyEmployee(String firstName, String lastName, String number, double hourlyRate) { 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.hourlyRate = hourlyRate; 
  } 
    
 /**
  * This method retrieves the employee's pay per hour 
  * @return the employee's pay rate per hour 
  */
  public double getHourlyRate() {
    return hourlyRate; 
  } 
  
 /**
  * This method changes the employee's hourly pay rate to the input value 
  * @param rate the new hourly pay rate 
  */
  public void setHourlyRate(double rate) {
    this.hourlyRate = rate; 
  } 
  
 /**
  * This method retrieves the number of hours worked by the employee 
  * @return the number of hours the employee has worked 
  */
  public double getHoursWorked() {
    return hoursWorked; 
  } 
  
 /**
  * This method changes the number of hours worked to the input value 
  * @param hoursWorked the new number of hours worked 
  */
  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked; 
  } 
  
 /**
  * This method retrieves the total amount of money the employee has earned 
  * @return the employee's total paycheck 
  */
  @Override 
  public double getAmountEarned() { 
    return (hourlyRate * hoursWorked) + bonus; 
  } 
  
 /**
  * This method modifies the employee's hourly rate by the input value 
  * @param percentage the amount to modify the hourly rate 
  */
  @Override 
  public void adjustPay(double percentage) {
    hourlyRate = percentage * hourlyRate; 
  } 
  
 /**
  * This method retrieves the employee's information as an easily understandable string 
  * @return the employee's information in a clear string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", Hourly Employee"; 
  } 
}
