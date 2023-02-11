/** 
 * Jaiden Borowski 
 * CSDS 132 
 * EmployeeDatabase class - The EmployeeDatabase class contains methods which manipulate a LinkedList of employees 
 */ 
public class EmployeeDatabase {
  // list of all Employees (which includes supervisors because they all extend Employee) 
  public LinkedList<Employee> employees = new LinkedList<Employee>(); 
  
 /**
  * The constructor to create a new instance of the class 
  */
  public EmployeeDatabase() {
  } 
  
 /**
  * This method adds an Employee to the employees list 
  * @param o the object to be added   */
  public void add(Object o) {
    if (o instanceof Employee) { 
      Employee e = (Employee)o; 
      employees.addToEnd(e); 
    } 
  } 
  
 /**
  * This method removes an Employee from the employees list 
  * @param firstName the first name of the Employee to be removed 
   * @param lastName the last name of the Employee to be removed 
   * @param number the number of the Employee to be removed 
   * @return the Employee that has been removed 
  */
  public Employee remove(String firstName, String lastName, String number) throws NoSuchEmployeeException { 
    try { 
      // whether or not the employee to remove has been found 
      boolean unfound = true; 
      // the employee that has been removed 
      Employee found = null; 
      
   // if the list of employees has one or more employees in it 
      if (!employees.isEmpty()) { 
        // a linked list to store the employees that are not removed 
        LinkedList<Employee> employeesNew = new LinkedList<Employee>(); 
        // the beginging node of the employees linked list 
        LLNode<Employee> nodeptr = employees.getFirstNode();
    // while there is a next employee 
        while (nodeptr != null) {
     // if the employee matches the input information and is the first employee to match all of the information 
     // then that employee is the employee to be returned & removed 
          if(unfound && nodeptr.getElement().getFirstName() == firstName && 
              nodeptr.getElement().getLastName() == lastName && nodeptr.getElement().getNumber() 
              == number){
            found = nodeptr.getElement(); 
            unfound = false; 
          } else {
            employeesNew.addToEnd(nodeptr.getElement()); 
          } 
          nodeptr = nodeptr.getNext();
        }
        employees = employeesNew; 
      } 
      
      return found; 
    } catch (NoSuchEmployeeException e) { 
      return null; 
    } 
  } 
  
 /**
  * This method finds and employee from the employees list that matches the input information 
  * @param firstName the first name of the Employee to be found 
   * @param lastName the last name of the Employee to be found 
   * @param number the number of the Employee to be found 
   * @return the Employee that has been found 
  */
  public Employee find(String firstName, String lastName, String number) throws 
NoSuchEmployeeException { 
    try { 
      // the employee (if it's found) 
      Employee found = null; 
      if (!employees.isEmpty()) { 
        // the beginging of the employees linked list 
        LLNode<Employee> nodeptr = employees.getFirstNode();
        while (nodeptr != null) {
          if(nodeptr.getElement().getFirstName() == firstName && 
nodeptr.getElement().getLastName() == lastName && nodeptr.getElement().getNumber() 
== number){
            found = nodeptr.getElement(); 
          } 
          nodeptr = nodeptr.getNext(); 
        }
      } 
      return found; 
    } catch (NoSuchEmployeeException e) { 
      return null; 
    } 
  } 
  
 /**
  * This method determines the sum of the employees' (and supervisors') incomes 
   * @return the total sum of incomes 
  */
  public double getPayrollAmount() { 
    // the total amount of money the employees are paid 
    double total = 0; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) {
      total += nodeptr.getElement().getAmountEarned(); 
      nodeptr = nodeptr.getNext();
    }
    return total; 
  } 
  
 /**
  * This method determines the employee/supervisor who makes the most amount of money 
   * @return the Employee that is paid the most 
  */
  public Employee getMaximumEarned() {
    // the max amount employees are paid 
    double max = -1; 
    // the employee getting paid the most 
    Employee maxEmployee = null; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) {
      if (nodeptr.getElement().getAmountEarned() > max) { 
        max = nodeptr.getElement().getAmountEarned(); 
        maxEmployee = nodeptr.getElement(); 
      } 
      nodeptr = nodeptr.getNext();
    }
    return maxEmployee; 
  } 
  
 /**
  * This method determines the employee/supervisor who makes the least amount of money 
   * @return the Employee that is paid the least 
  */
  public Employee getMinimumEarned() {
   if (employees.isEmpty()) {
    return null; 
   } else { 
      // whether or not an employee earning the minimum amount has been found 
      boolean found = false; 
      // how much the employee getting paid the least is paid 
      double min = -1; 
      // the employee getting paid the least 
      Employee minEmployee = null; 
      // the beginging of the employees linked list 
      LLNode<Employee> nodeptr = employees.getFirstNode();
      while (nodeptr != null) {
        if (!found || nodeptr.getElement().getAmountEarned() <= min) { 
          min = nodeptr.getElement().getAmountEarned(); 
          minEmployee = nodeptr.getElement(); 
          found = true; 
        } 
        nodeptr = nodeptr.getNext();
      }
      return minEmployee; 
   } 
  } 
  
 /**
  * This method determines which employee/suppervisor made the most amount of sales
   * @return the Employee that made the most amount of sales 
  */ 
  public Employee getMaxSales() {
    Employee maxEmployee = null; 
    double max = -1; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) { 
      if (nodeptr.getElement() instanceof SalesEmployee || nodeptr.getElement() 
instanceof SalesSupervisor) { 
        SalesEmployee salesEmp = (SalesEmployee)nodeptr.getElement(); 
        if (salesEmp.getNumSales() > max) { 
          max = salesEmp.getNumSales(); 
          maxEmployee = nodeptr.getElement(); 
        } 
      } 
      nodeptr = nodeptr.getNext();
    } 
    return maxEmployee; 
  } 
  
 /**
  * This method determines which employee/suppervisor made the least amount of sales 
   * @return the Employee that made the least amount of sales 
  */ 
  public Employee getMinSales() {
    Employee minEmployee = null; 
    boolean found = false; 
    double min = -1; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) {
      if (nodeptr.getElement() instanceof SalesEmployee || nodeptr.getElement() 
instanceof SalesSupervisor) {
        SalesEmployee salesEmp = (SalesEmployee)nodeptr.getElement(); 
        if (!found || salesEmp.getNumSales() <= min) { 
          min = salesEmp.getNumSales(); 
          minEmployee = nodeptr.getElement(); 
          found = true; 
        } 
      } 
      nodeptr = nodeptr.getNext();
    } 
    return minEmployee; 
  } 
  
 /**
  * This method determines which employee/suppervisor worked the most amount of hours  
   * @return the Employee that worked the most amount of hours 
  */ 
  public Employee getMaxHoursWorked() {
    Employee maxEmployee = null; 
    double max = -1; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) { 
      if (nodeptr.getElement() instanceof HourlyEmployee || nodeptr.getElement() 
instanceof HourlySupervisor) {
        HourlyEmployee hourlyEmp = (HourlyEmployee)nodeptr.getElement(); 
        if (hourlyEmp.getHoursWorked() > max) { 
          max = hourlyEmp.getHoursWorked(); 
          maxEmployee = nodeptr.getElement(); 
        } 
      } 
      nodeptr = nodeptr.getNext();
    } 
    return maxEmployee; 
  } 
  
 /**
  * This method determines which employee/suppervisor worked the least amount of hours  
   * @return the Employee that worked the least amount of hours 
  */ 
  public Employee getMinHoursWorked() {
    Employee minEmployee = null; 
    boolean found = false; 
    double min = -1; 
    // the beginging of the employees linked list 
    LLNode<Employee> nodeptr = employees.getFirstNode();
    while (nodeptr != null) {
      if (nodeptr.getElement() instanceof HourlyEmployee || nodeptr.getElement() 
instanceof HourlySupervisor) {
        HourlyEmployee hourlyEmp = (HourlyEmployee)nodeptr.getElement(); 
        if (!found || hourlyEmp.getHoursWorked() <= min) { 
          min = hourlyEmp.getHoursWorked(); 
          minEmployee = nodeptr.getElement(); 
          found = true; 
        } 
      } 
      nodeptr = nodeptr.getNext();
    }
    return minEmployee; 
  } 
  
 /**
  * This method determines which employees work for the inputted supervisor 
   * @param supervisor the supervisor which the employees work under 
   * @return an array of Employees which work under that supervisor 
  */ 
  public Employee[] getSupervisees(Employee supervisor) {
    if (!employees.isEmpty()) { 
      int counter = 0; 
      LLNode<Employee> nodeptr = employees.getFirstNode();
      
      while (nodeptr != null) {
        if(nodeptr.getElement().getSupervisor().equals(supervisor)) { 
          counter++; 
        } 
      } 
      
      if (counter > 0) { 
        Employee[] array = new Employee[counter]; 
        
        LLNode<Employee> nodeptr2 = employees.getFirstNode();
        int index = 0; 
        while (nodeptr2 != null) {
          if(nodeptr2.getElement().getSupervisor().equals(supervisor)) { 
            array[index] = nodeptr2.getElement(); 
          } 
          index++; 
        } 
        
        return array; 
      } else { 
        return null; 
      } 
    } else { 
      return null; 
    } 
  } 
}
