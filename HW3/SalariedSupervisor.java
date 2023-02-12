/** 
 * Jaiden Borowski 
 * CSDS 132 
 * SalariedSupervisor class - The SalairedSupervisor class contains methods which 
manipulate SalariedSupervisor objects 
 */ 
public class SalariedSupervisor extends Employee implements Supervisor {
  /** 
   * The amount of money the supervisor is paid 
  */ 
  public double salary; 
  
 /**
  * The constructor to create a new instance of the class 
  * @param firstName the new firstName value 
   * @param lastName the new lastName value 
   * @param number the new number value 
   * @param salary the new salary value 
  */
  public SalariedSupervisor(String firstName, String lastName, String number, 
double salary) {
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.number = number; 
    this.salary = salary; 
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
  @Override 
  public double getAmountEarned() { 
    return salary + bonus; 
  } 
  
 /**
  * This method modifies the supervisor's salary by the input value 
  * @param percentage the amount to modify the salary 
  */
  @Override 
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
    return number + ": " + lastName + ", " + firstName + ", Salaried Supervisor"; 
  } 
}
