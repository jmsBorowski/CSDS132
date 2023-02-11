/* Jaiden Borowski 
 * CSDS 132 
 * 10/01/2021 
 * StudentAccount - The Student Account class tracks the other accounts of a 
student 
 */ 
public class StudentAccount extends Account{
  // The student's name 
  private String name = ""; 
  // The student's address 
  private String address = ""; 
  // The library account for the student 
  private LibraryAccount libraryAccount = null; 
  // The tuition account for the student 
  private CreditAccount tuitionAccount = null; 
  // The dining account for the student 
  private CreditAccount diningAccount = null; 
  // The amount of money to be refunded to the student 
  private double refundAmount = 0.0; 
  
  /* A constructor to create a StudentAccount with an account number and student 
name */ 
  public StudentAccount(String accountNumber, String name) {
    super(accountNumber, 0); 
    this.name = name;     
  } 
  
  // sets the student's name to be equal to the input value 
  public void setName(String name) {
    this.name = name; 
  } 
  
  // returns the student's current name 
  public String getName() {
    return name; 
  } 
  
  // sets the student's address to be equal to the input value 
  public void setAddress(String address) { 
    this.address = address; 
  } 
  
  // returns the student's current address  
  public String getAddress() {
    return address; 
  } 
  
  // sets the student's Library Account to be equal to the input value 
  public void setLibraryAccount(LibraryAccount libraryAccount) {
    this.libraryAccount = libraryAccount; 
  } 
  
  // returns the student's current Library Account  
  public LibraryAccount getLibraryAccount() {
    return libraryAccount; 
  } 
  
  // sets the student's Tuition Account to be equal to the input value 
  public void setTuitionAccount(CreditAccount tuitionAccount) {
    this.tuitionAccount = tuitionAccount; 
  } 
  
  // returns the student's current Tuition Account  
  public CreditAccount getTuitionAccount() {
    return tuitionAccount; 
  } 
  
  // sets the student's Dining Account to be equal to the input value 
  public void setDiningAccount(CreditAccount diningAccount) {
    this.diningAccount = diningAccount; 
  } 
  
  // returns the student's current Tuition Account  
  public CreditAccount getDiningAccount() {
    return diningAccount; 
  } 
  
  // returns the total balance of the student's library, tuition, and dining 
  // accounts (minus amount to be refunded to student) 
  @Override 
  public double getBalance() { 
    if(libraryAccount != null && tuitionAccount != null && diningAccount != null) {
      return ((libraryAccount.getBalance() + tuitionAccount.getBalance() + 
diningAccount.getBalance()) - refundAmount); 
    } else { 
      return 0.0;  
    } 
  } 
  
  // adds input amount to the tuition balance if the amount cannot be paid off by 
  // the refund amount 
  @Override 
  public void charge(double charge) {
    if (charge - refundAmount >= 0 && tuitionAccount != null) { 
      tuitionAccount.charge(charge - refundAmount); 
      refundAmount = 0; 
    } else { 
      refundAmount = (-1*(charge - refundAmount)); 
    } 
  } 
  
  // subtracts the input amount from the tuition, dining, and library accounts in 
  // order so that the monthly amount for a 
  // preceeding account is paid off before a following account is considered 
  // if any money is left over, it is placed in the refund amount 
  @Override 
  public void credit(double credit) {
    if(tuitionAccount != null) {
      // The amount of money needed to make the amount paid this month equal to the
      // monthly payment that is required 
      double needed = tuitionAccount.getMonthlyPayment() - tuitionAccount.getAmountPaidThisMonth(); 
      if(needed >= credit) {
        tuitionAccount.credit(credit); 
        credit = 0; 
      } else if (needed < credit) {
        tuitionAccount.credit(needed); 
        credit = credit - needed; 
      } 
    } 
    if(diningAccount != null && credit > 0) {
      // The amount of money needed to make the amount paid this month equal to the
      // monthly payment that is required 
      double needed = diningAccount.getMonthlyPayment() - diningAccount.getAmountPaidThisMonth(); 
      if(needed >= credit) {
        diningAccount.credit(credit); 
        credit = 0; 
      } else if (needed < credit) {
        diningAccount.credit(needed); 
        credit = credit - needed; 
      } 
    } 
    if(libraryAccount != null && credit > 0) {
      if(libraryAccount.getBalance() >= credit){ 
        libraryAccount.credit(credit); 
        credit = 0; 
      } else if (libraryAccount.getBalance() < credit) { 
        libraryAccount.credit(libraryAccount.getBalance()); 
        credit = credit - libraryAccount.getBalance(); 
      } 
    } 
    refundAmount = refundAmount + credit; 
  } 
} 