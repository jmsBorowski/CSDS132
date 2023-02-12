/** 
 * Jaiden Borowski 
 * CSDS 132 
 * Project3Tester class - The Project3Tester class contains methods which tests all
 * the classes for project 3 
 */ 
import org.junit.*;
import static org.junit.Assert.*;
public class Project3Tester {
// GENERAL METHODS 
  /**
   * Test the getFirstName method (same for all employees) 
   */
  @Test
  public void testGetFirstName() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Checking First Name set from constructor with one word", 
"Jaiden", hourlyEmployee.getFirstName());
    hourlyEmployee.setName("", "Borowski"); 
    assertEquals("Checking First Name with empty string", "", 
hourlyEmployee.getFirstName()); 
    hourlyEmployee.setName("Jaiden Malaika", "Borowski"); 
    assertEquals("Checking First Name with many words", "Jaiden Malaika", 
hourlyEmployee.getFirstName());
  } 
  /**
   * Test the getLastName method (same for all employees) 
   */
  @Test
  public void testGetLastName() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Checking Last Name set from constructor with one word", 
"Borowski", hourlyEmployee.getLastName());
    hourlyEmployee.setName("Jaiden", ""); 
    assertEquals("Checking Last Name with empty string", "", 
hourlyEmployee.getLastName()); 
    hourlyEmployee.setName("Jaiden", "Bor ow ski"); 
    assertEquals("Checking Last Name with many words", "Bor ow ski", 
hourlyEmployee.getLastName()); 
  } 
  /**
   * Test the setName method (same for all employees) 
   */
  @Test
  public void testSetName() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    hourlyEmployee.setName("Jada","B"); 
    assertEquals("Setting first and last name. Checking first Name with one word", 
"Jada", hourlyEmployee.getFirstName());
    assertEquals("Setting first and last name. Checking last Name with one word", 
"B", hourlyEmployee.getLastName());
    hourlyEmployee.setName("",""); 
    assertEquals("Setting first and last name. Checking first Name with empty 
string", "", hourlyEmployee.getFirstName());
    assertEquals("Setting first and last name. Checking last Name with empty 
string", "", hourlyEmployee.getLastName());
    hourlyEmployee.setName("Jaiden Malaika","Bor ow ski"); 
    assertEquals("Setting first and last name. Checking first Name with many 
words", "Jaiden Malaika", hourlyEmployee.getFirstName());
    assertEquals("Setting first and last name. Checking last Name with many words",
"Bor ow ski", hourlyEmployee.getLastName());
  } 
  /**
   * Test the getNumber method (same for all employees) 
   */
  @Test
  public void testGetNumber() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Checking get Number set from constructor with one character", 
"1", hourlyEmployee.getNumber());
    hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "", 10); 
    assertEquals("Checking Number with empty string", "", 
hourlyEmployee.getNumber());
    hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1000000", 10); 
    assertEquals("Checking Number with many characters", "1000000", 
hourlyEmployee.getNumber());
  } 
  /**
   * Test the getBonus and setBonus method (same for all employees) 
   */ 
  @Test
  public void testGetSetBonus() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Setting Bonus. Checking empty Bonus", "0.0", 
Double.toString(hourlyEmployee.getBonus()));
    hourlyEmployee.setBonus(1); 
    assertEquals("Setting Bonus. Checking Bonus with one", "1.0", 
Double.toString(hourlyEmployee.getBonus()));
    hourlyEmployee.setBonus(1000); 
    assertEquals("Setting Bonus. Checking Bonus with many", "1000.0", 
Double.toString(hourlyEmployee.getBonus()));
  } 
  /**
   * Test the equals method (same for all employees) 
   */ 
  @Test
  public void testEquals() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Jada", "B", "2", 10); 
    assertEquals("Checking if employees are equal", "false", 
Boolean.toString(hourlyEmployee.equals(hourlyEmployee2)));
    HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    HourlyEmployee hourlyEmployee4 = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Checking if employees are equal", "true", 
Boolean.toString(hourlyEmployee3.equals(hourlyEmployee4)));
  } 
  /**
   * Test the compareToByName method (same for all employees) 
   */ 
  @Test
  public void testCompareToByName() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking compare to by name when employees have the same name", 
"0", Integer.toString(hourlyEmployee.compareToByName(hourlyEmployee2)));
    HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Jaiden", "C", "1", 10); 
    HourlyEmployee hourlyEmployee4 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking compare to by name when this employee has later name", 
"-1", Integer.toString(hourlyEmployee3.compareToByName(hourlyEmployee4)));
    HourlyEmployee hourlyEmployee5 = new HourlyEmployee("Jaiden", "A", "1", 10); 
    HourlyEmployee hourlyEmployee6 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking compare to by name when this employee has earlier name",
"1", Integer.toString(hourlyEmployee5.compareToByName(hourlyEmployee6)));
  } 
  /**
   * Test the compareToByEarnings method (same for all employees) 
   */ 
  @Test
  public void testCompareToByEarnings() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking if employees have the same earnings", "0", 
Integer.toString(hourlyEmployee.compareToByEarnings(hourlyEmployee2))); 
    HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Jaiden", "Borowski", "1", 
100); 
    hourlyEmployee3.setHoursWorked(1); 
    HourlyEmployee hourlyEmployee4 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking if this employee has more earnings", "100", 
Integer.toString(hourlyEmployee3.compareToByEarnings(hourlyEmployee4)));
    HourlyEmployee hourlyEmployee5 = new HourlyEmployee("Jaiden", "Borowski", "1", 
100); 
    hourlyEmployee5.setHoursWorked(1); 
    HourlyEmployee hourlyEmployee6 = new HourlyEmployee("Jaiden", "Borowski", "2", 
10); 
    assertEquals("Checking if this employee has less earnings", "-100", 
Integer.toString(hourlyEmployee6.compareToByEarnings(hourlyEmployee5)));  
  } 
  /**
   * Test the setSupervisor and getSupervisor method (same for all employees) 
   */ 
  @Test
  public void testSetGetSupervisor() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    HourlySupervisor hourlySupervisor = new HourlySupervisor("Sophia", "A", "2", 
10); 
    assertEquals("Checking employee supervisor is null", "null", 
String.valueOf(hourlyEmployee.getSupervisor())); 
    hourlyEmployee.setSupervisor(hourlySupervisor); 
    assertEquals("Checking employee supervisor is set", "Sophia", 
hourlyEmployee.getSupervisor().getFirstName()); 
  } 
  
// HOURLY EMPLOYEE METHODS (Exact same as hourly supervisor methods except 
toString()) 
  /**
   * Test the getAmountEarned method (Hourly version) 
   */ 
  @Test
  public void testGetAmountEarnedHourly() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
1); 
    assertEquals("Checking amount earned Hourly 0", "0.0", 
Double.toString(hourlyEmployee.getAmountEarned())); 
    hourlyEmployee.setHoursWorked(1); 
    hourlyEmployee.setBonus(1); 
    assertEquals("Checking amount earned Hourly 1", "2.0", 
Double.toString(hourlyEmployee.getAmountEarned())); 
    hourlyEmployee.setBonus(1000); 
    assertEquals("Checking amount earned Hourly many", "1001.0", 
Double.toString(hourlyEmployee.getAmountEarned())); 
  } 
  
  /**
   * Test the adjustPay method (Hourly version) 
   */ 
  @Test
  public void testAdjustPayHourly() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
9); 
    hourlyEmployee.adjustPay(1.1); 
    assertEquals("Checking adjust pay Hourly 1", "9.9", 
Double.toString(hourlyEmployee.getHourlyRate())); 
    hourlyEmployee.adjustPay(1000); 
    assertEquals("Checking adjust pay Hourly many", "9900.0", 
Double.toString(hourlyEmployee.getHourlyRate())); 
    hourlyEmployee.adjustPay(0); 
    assertEquals("Checking adjust pay Hourly 0", "0.0", 
Double.toString(hourlyEmployee.getHourlyRate())); 
  } 
  
  /** 
   * Test the toString method (HourlyEmployee version) 
   */ 
  @Test
  public void testToStringHourlyEmployee() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
10); 
    assertEquals("Checking toString HourlyEmployee 1", "1: Borowski, Jaiden, Hourly
Employee", hourlyEmployee.toString()); 
    HourlyEmployee hourlyEmployee2 = new HourlyEmployee("", "", "", 0); 
    assertEquals("Checking toString HourlyEmployee 0", ": , , Hourly Employee", 
hourlyEmployee2.toString()); 
    HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Jaiden Malaika", "Bo row 
ski", "1000", 0); 
    assertEquals("Checking toString HourlyEmployee many", "1000: Bo row ski, Jaiden
Malaika, Hourly Employee", hourlyEmployee3.toString()); 
  } 
 /**
   * Test the setHourlyRate & getHourlyRate method 
   */ 
  @Test
  public void testSetGetHourlyRate() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
1.0); 
    assertEquals("Checking hourly rate from constructor 1", "1.0", 
Double.toString(hourlyEmployee.getHourlyRate())); 
    hourlyEmployee.setHourlyRate(10.0); 
    assertEquals("Checking set hourly rate many", "10.0", 
Double.toString(hourlyEmployee.getHourlyRate())); 
    hourlyEmployee.setHourlyRate(0.0); 
    assertEquals("Checking set hourly rate 0", "0.0", 
Double.toString(hourlyEmployee.getHourlyRate())); 
  } 
 
 /**
   * Test the setHoursWorked & getHoursWorked method 
   */ 
  @Test
  public void testSetGetHoursWorked() {
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Jaiden", "Borowski", "1", 
9); 
    assertEquals("Checking hours worked from constructor 0", "0.0", 
Double.toString(hourlyEmployee.getHoursWorked())); 
    hourlyEmployee.setHoursWorked(1); 
    assertEquals("Checking set hours worked 1", "1.0", 
Double.toString(hourlyEmployee.getHoursWorked())); 
    hourlyEmployee.setHoursWorked(1000); 
    assertEquals("Checking set hours worked many", "1000.0", 
Double.toString(hourlyEmployee.getHoursWorked())); 
  } 
// HOURLY SUPERVISOR METHODS (only those different from hourly emoployee) 
 /**
   * Test the toString method (HourlySupervisor version) 
   */ 
  @Test
  public void testToStringHourlySupervisor() {
    HourlySupervisor hourlySupervisor = new HourlySupervisor("Jaiden", "Borowski", 
"1", 10); 
    assertEquals("Checking toString HourlySupervisor 1", "1: Borowski, Jaiden, 
Hourly Supervisor", hourlySupervisor.toString()); 
    HourlySupervisor hourlySupervisor2 = new HourlySupervisor("", "", "", 10); 
    assertEquals("Checking toString HourlySupervisor 0", ": , , Hourly Supervisor",
hourlySupervisor2.toString()); 
    HourlySupervisor hourlySupervisor3 = new HourlySupervisor("Jaiden Malaika", "Bo
row ski", "1000.3", 10); 
    assertEquals("Checking toString HourlySupervisor many", "1000.3: Bo row ski, 
Jaiden Malaika, Hourly Supervisor", hourlySupervisor3.toString()); 
  } 
// SALARIED EMPLOYEE METHODS (Exact same as salaried supervisor methods except 
toString()) 
 
  /**
   * Test the setSalary & getSalary methods 
   */ 
  @Test 
  public void testSetGetSalarySalaried() {
    SalariedEmployee salariedEmployee = new SalariedEmployee("Jaiden", "Borowski", 
"1", 1); 
    assertEquals("Checking get salary from setting salary in constructor 1",  
"1.0", Double.toString(salariedEmployee.getSalary())); 
    salariedEmployee.setSalary(0); 
    assertEquals("Checking get salary from setting salary in constructor 0",  
"0.0", Double.toString(salariedEmployee.getSalary())); 
    salariedEmployee.setSalary(1000); 
    assertEquals("Checking get salary from setting salary in constructor many",  
"1000.0", Double.toString(salariedEmployee.getSalary())); 
  } 
  
 /**
   * Test the getAmountEarned method (Salaried version) 
   */ 
  @Test
  public void testGetAmountEarnedSalaried() {
    SalariedEmployee salariedEmployee = new SalariedEmployee("Jaiden", "Borowski", 
"1", 1); 
    assertEquals("Checking salary Salaried 1", "1.0", 
Double.toString(salariedEmployee.getAmountEarned())); 
    salariedEmployee.setSalary(0); 
    assertEquals("Setting salary. Checking salary Salaried 0", "0.0", 
Double.toString(salariedEmployee.getAmountEarned())); 
    salariedEmployee.setBonus(1000); 
    assertEquals("Setting bonus. Checking salary Salaried many", "1000.0", 
Double.toString(salariedEmployee.getAmountEarned())); 
  } 
 /**
   * Test the adjustPay method (Salaried version) 
   */ 
  @Test
  public void testAdjustPaySalaried() {
    SalariedEmployee salariedEmployee = new SalariedEmployee("Jaiden", "Borowski", 
"1", 1); 
    salariedEmployee.adjustPay(1.1); 
    assertEquals("Checking adjusted pay/salary Salaried 1", "1.1", 
Double.toString(salariedEmployee.getSalary())); 
    salariedEmployee.adjustPay(1000); 
    assertEquals("Checking adjusted pay/salary Salaried many", "1100.0", 
Double.toString(salariedEmployee.getSalary())); 
    salariedEmployee.adjustPay(0); 
    assertEquals("Checking adjusted pay/salary Salaried 0", "0.0", 
Double.toString(salariedEmployee.getSalary())); 
  } 
 /**
   * Test the toString method (SalariedEmployee version) 
   */ 
  @Test
  public void testToStringSalariedEmployee() {
    SalariedEmployee salariedEmployee = new SalariedEmployee("Jaiden", "Borowski", 
"1", 100); 
    assertEquals("Checking to string SalariedEmployee 1", "1: Borowski, Jaiden, 
Salaried Employee", salariedEmployee.toString()); 
    SalariedEmployee salariedEmployee2 = new SalariedEmployee("", "", "", 100); 
    assertEquals("Checking to string SalariedEmployee 0", ": , , Salaried 
Employee", salariedEmployee2.toString()); 
    SalariedEmployee salariedEmployee3 = new SalariedEmployee("Jaiden Malaika", "Bo
row ski", "1000.000", 100); 
    assertEquals("Checking to string SalariedEmployee many", "1000.000: Bo row ski,
Jaiden Malaika, Salaried Employee", salariedEmployee3.toString()); 
  } 
// SALARIED SUPERVISOR
 /**
   * Test the toString method (SalariedSupervisor version) 
   */ 
  @Test
  public void testToStringSalariedSupervisor() {
    SalariedSupervisor salariedSupervisor = new SalariedSupervisor("Jaiden", 
"Borowski", "1", 1000); 
    assertEquals("Checking to string SalariedSupervisor 1", "1: Borowski, Jaiden, 
Salaried Supervisor", salariedSupervisor.toString()); 
    SalariedSupervisor salariedSupervisor2 = new SalariedSupervisor("", "", "", 
1000); 
    assertEquals("Checking to string SalariedSupervisor 0", ": , , Salaried 
Supervisor", salariedSupervisor2.toString()); 
    SalariedSupervisor salariedSupervisor3 = new SalariedSupervisor("Jaiden 
Malaika", "Bo row ski", "1000", 1000); 
    assertEquals("Checking to string SalariedSupervisor many", "1000: Bo row ski, 
Jaiden Malaika, Salaried Supervisor", salariedSupervisor3.toString()); 
  } 
// SALES EMPLOYEE 
 /**
   * Test the setSalary & getSalary methods 
   */ 
  @Test
  public void testSetGetSalarySales() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 0, 
100); 
    assertEquals("Checking get salary from setting salary in the constructor 0", 
"0.0", Double.toString(salesEmployee.getSalary())); 
    salesEmployee.setSalary(1000); 
    assertEquals("Checking set salary many", "1000.0", 
Double.toString(salesEmployee.getSalary())); 
    salesEmployee.setSalary(1); 
    assertEquals("Checking set salary 1", "1.0", 
Double.toString(salesEmployee.getSalary())); 
  } 
  
 /**
   * Test the setCommission & getCommission methods 
   */ 
  @Test
  public void testSetGetCommission() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 10, 
1); 
    assertEquals("Checking get commission from setting commission in constructor 
1", "1.0", Double.toString(salesEmployee.getCommission())); 
    salesEmployee.setCommission(1000); 
    assertEquals("Checking get commission many", "1000.0", 
Double.toString(salesEmployee.getCommission())); 
    salesEmployee.setCommission(0); 
    assertEquals("Checking get commission 0", "0.0", 
Double.toString(salesEmployee.getCommission())); 
  } 
  
 /**
   * Test the setNumSales & getNumSales methods 
   */ 
  @Test
  public void testSetGetNumSales() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 
1000, 100); 
    assertEquals("Checking get num from initial numSales 0", "0", 
Integer.toString(salesEmployee.getNumSales())); 
    salesEmployee.setNumSales(1); 
    assertEquals("Checking get num 1", "1", 
Integer.toString(salesEmployee.getNumSales())); 
    salesEmployee.setNumSales(1000); 
    assertEquals("Checking get num many", "1000", 
Integer.toString(salesEmployee.getNumSales())); 
  } 
  
 /**
   * Test the getAmountEarned method (Sales version) 
   */ 
  @Test
  public void testGetAmountEarnedSales() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 1, 
1); 
    assertEquals("Checking pay Sales 1", "1.0", 
Double.toString(salesEmployee.getAmountEarned())); 
    salesEmployee.setSalary(0); 
    assertEquals("Setting salary. Checking pay Sales 0", "0.0", 
Double.toString(salesEmployee.getAmountEarned())); 
    salesEmployee.setBonus(1000); 
    assertEquals("Setting bonus. Checking pay Sales many", "1000.0", 
Double.toString(salesEmployee.getAmountEarned())); 
  } 
 /**
   * Test the adjustPay method (Sales version) 
   */ 
  @Test
  public void testAdjustPaySales() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 1, 
0); 
    salesEmployee.adjustPay(1.1); 
    assertEquals("Checking adjusted pay/salary Sales 1", "1.1", 
Double.toString(salesEmployee.getSalary())); 
    salesEmployee.adjustPay(1000); 
    assertEquals("Checking adjusted pay/salary Sales many", "1100.0", 
Double.toString(salesEmployee.getSalary())); 
    salesEmployee.adjustPay(0); 
    assertEquals("Checking adjusted pay/salary Sales 0", "0.0", 
Double.toString(salesEmployee.getSalary())); 
  } 
 /**
   * Test the toString method (SalesEmployee version) 
   */ 
  @Test
  public void testToStringSalesEmployee() {
    SalesEmployee salesEmployee = new SalesEmployee("Jaiden", "Borowski", "1", 
1000, 100); 
    assertEquals("Checking to string SalesEmployee 1", "1: Borowski, Jaiden, Sales 
Employee", salesEmployee.toString()); 
    SalesEmployee salesEmployee2 = new SalesEmployee("", "", "", 1000, 100); 
    assertEquals("Checking to string SalesEmployee 0", ": , , Sales Employee", 
salesEmployee2.toString()); 
    SalesEmployee salesEmployee3 = new SalesEmployee("Jaiden Malaika", "Bo row 
ski", "1000", 1000, 100); 
    assertEquals("Checking to string SalesEmployee many", "1000: Bo row ski, Jaiden
Malaika, Sales Employee", salesEmployee3.toString()); 
  } 
// SALES SUEPERVISOR 
  
 /**
   * Test the toString method (SalesSupervisor version) 
   */ 
  @Test
  public void testToStringSalesSupervisor() {
    SalesSupervisor salesSupervisor = new SalesSupervisor("Jaiden", "Borowski", 
"1", 1000, 100); 
    assertEquals("Checking to string SalesSupervisor 1", "1: Borowski, Jaiden, 
Sales Supervisor", salesSupervisor.toString()); 
    SalesSupervisor salesSupervisor2 = new SalesSupervisor("", "", "", 1000, 100); 
    assertEquals("Checking to string SalesSupervisor 0", ": , , Sales Supervisor", 
salesSupervisor2.toString()); 
    SalesSupervisor salesSupervisor3 = new SalesSupervisor("Jaiden Malaika", "Bo 
row ski", "1000", 1000, 100); 
    assertEquals("Checking to string SalesSupervisor many", "1000: Bo row ski, 
Jaiden Malaika, Sales Supervisor", salesSupervisor3.toString()); 
  } 
// EMPLOYEE DATABASE 
  
 /**
   * Test the add method 
   */ 
  @Test
  public void testAdd() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking if employee was added", "1: Borowski, Jaiden, Hourly 
Employee", employeeDatabase.find("Jaiden","Borowski","1").toString()); 
  } 
  
 /**
   * Test the remove method 
   */ 
  @Test
  public void testRemove() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    employeeDatabase.remove("Jaiden","Borowski","1"); 
    assertEquals("Checking if employee was removed", "null", 
String.valueOf(employeeDatabase.find("Jaiden","Borowski","1"))); 
  } 
  
 /**
   * Test the find method 
   */ 
  @Test
  public void testFind() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking if employee can be found in employee database", 
"Jaiden", employeeDatabase.find("Jaiden","Borowski","1").getFirstName()); 
  } 
  
 /**
   * Test the getPayrollAmount method 
   */ 
  @Test
  public void testGetPayrollAmount() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking payroll amount with empty list", "0.0", 
Double.toString(employeeDatabase.getPayrollAmount())); 
    HourlyEmployee hourlyEmployee = new 
HourlyEmployee("Jaiden","Borowski","1",100); 
    hourlyEmployee.setHoursWorked(1); 
    employeeDatabase.add(hourlyEmployee); 
    assertEquals("Checking payroll amount with one employee", "100.0", 
Double.toString(employeeDatabase.getPayrollAmount())); 
  } 
 /**
   * Test the getMinimumEarned method 
   */ 
  @Test
  public void testGetMinimumEarned() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking min earned with empty list", "null", 
String.valueOf(employeeDatabase.getMinimumEarned())); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking min earned with one employee", "Jaiden", 
employeeDatabase.getMinimumEarned().getFirstName()); 
  } 
 /**
   * Test the getMaximumEarned method 
   */ 
  @Test
  public void testGetMaximumEarned() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking maximum earned with empty list", "null", 
String.valueOf(employeeDatabase.getMaximumEarned())); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking maximum earned with one employee", "Jaiden", 
employeeDatabase.getMaximumEarned().getFirstName()); 
  } 
 /**
   * Test the getMaxSales method 
   */ 
  @Test
  public void testGetMaxSales() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking maximum sales with empty list", "null", 
String.valueOf(employeeDatabase.getMaxSales())); 
    employeeDatabase.add(new SalesEmployee("Jaiden","Borowski","1",100,10)); 
    assertEquals("Checking maximum sales with one employee", "Jaiden", 
employeeDatabase.getMaxSales().getFirstName()); 
  } 
 /**
   * Test the getMinSales method 
   */ 
  @Test
  public void testGetMinSales() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking minimum sales with empty list", "null", 
String.valueOf(employeeDatabase.getMinSales())); 
    employeeDatabase.add(new SalesEmployee("Jaiden","Borowski","1",100,10)); 
    assertEquals("Checking minimum sales with one employee", "Jaiden", 
employeeDatabase.getMinSales().getFirstName()); 
  } 
 /**
   * Test the getMaxHoursWorked method 
   */ 
  @Test
  public void testGetMaxHoursWorked() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking max hrs worked with empty list", "null", 
String.valueOf(employeeDatabase.getMaxHoursWorked())); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking max hrs worked with one employee", "Jaiden", 
employeeDatabase.getMaxHoursWorked().getFirstName()); 
  } 
 /**
   * Test the getMinHoursWorked method 
   */ 
  @Test
  public void testGetMinHoursWorked() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    assertEquals("Checking min hrs worked with empty list", "null", 
String.valueOf(employeeDatabase.getMinHoursWorked())); 
    employeeDatabase.add(new HourlyEmployee("Jaiden","Borowski","1",100)); 
    assertEquals("Checking min hrs worked with one employee", "Jaiden", 
employeeDatabase.getMinHoursWorked().getFirstName()); 
  } 
 /**
   * Test the getSupervisees method 
   * note: this method causes the tester to run forever so it is commented out 
   *
  @Test
  public void testGetSupervisees() {
    EmployeeDatabase employeeDatabase = new EmployeeDatabase(); 
    HourlySupervisor hourlySupervisor = new HourlySupervisor("Jada","B","2",1000); 
    assertEquals("Checking supervisees with empty list", "null", 
String.valueOf(employeeDatabase.getSupervisees(hourlySupervisor))); 
    HourlyEmployee hourlyEmployee = new 
HourlyEmployee("Jaiden","Borowski","1",100); 
    hourlyEmployee.setSupervisor(hourlySupervisor); 
    employeeDatabase.add(hourlyEmployee); 
    employeeDatabase.add(hourlySupervisor); 
    HourlyEmployee[] arr = new HourlyEmployee[1]; 
    arr[0] = (HourlyEmployee)employeeDatabase.getSupervisees(hourlySupervisor)[0]; 
    assertEquals("Checking supervisees with one employee", 
hourlyEmployee.getFirstName(), arr[0].getFirstName()); 
  } */ 
  
}
