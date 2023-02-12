/** 
 * Jaiden Borowski 
 * CSDS 132 
 * HourlySupervisor class - The HourlySupervisor class contains methods which 
manipulate HourlySupervisor objects 
 */ 
public class HourlySupervisor extends Employee implements Supervisor {
  /** 
   * The amount of money the supervisor is paid per hour 
   */ 
  public double hourlyRate; 
  /** 
   * The number of hours the supervisor has worked 
   */ 
  public double hoursWorked; 
  
 /**
  * The constructor to create a new instance of the class 
  * @param firstName the new firstName value 
   * @param lastName the new lastName value 
   * @param number the new number value 
   * @param hourlyRate the new hourlyRate value 
  */
  public HourlySupervisor(String firstName, String lastName, String number, double 
hourlyRate) {
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.hourlyRate = hourlyRate; 
  } 
  
 /**
  * This method retrieves the supervisor's pay per hour 
  * @return the supervisor's pay rate per hour 
  */
  public double getHourlyRate() {
    return hourlyRate; 
  } 
  
 /**
  * This method changes the supervisor's hourly pay rate to the input value 
  * @param rate the new hourly pay rate 
  */
  public void setHourlyRate(double rate) {
    this.hourlyRate = rate; 
  } 
  
 /**
  * This method retrieves the number of hours worked by the supervisor 
  * @return the number of hours the supervisor has worked 
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
  * This method retrieves the total amount of money the supervisor has earned 
  * @return the supervisor's total paycheck 
  */
  @Override 
  public double getAmountEarned() { 
    return (hourlyRate * hoursWorked) + bonus; 
  } 
  
 /**
  * This method modifies the supervisor's hourly rate by the input value 
  * @param percentage the amount to modify the hourly rate 
  */
  @Override 
  public void adjustPay(double percentage) {
    hourlyRate = percentage * hourlyRate; 
  } 
  
 /**
  * This method retrieves the supervisor's information as an easily understandable string 
  * @return the supervisor's information in a clear string 
  */
  @Override 
  public String toString() {
    return number + ": " + lastName + ", " + firstName + ", Hourly Supervisor"; 
  } 
}
