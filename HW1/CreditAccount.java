/* Jaiden Borowski 
 * CSDS 132 
 * 10/01/2021 
 * CreditAccount - The Credit Account class tracks the amount of money borrowed by 
a student 
 */ 
public class CreditAccount extends Account{ 
  // The interest rate on the student's debt 
  private double interestRate = 0.0; 
  // The monthly payment required of the student to avoid receiving an interest 
  // charge on the account balance 
  private double monthlyPayment = 0.0; 
  // The actual monthly payment by the student  
  private double amountPaidThisMonth = 0.0; 
  
  // A constructor to create a CreditAccount with an account number and interest 
  // rate 
  public CreditAccount(String accountNumber, double interestRate) {
    super(accountNumber, 0); 
    this.interestRate = interestRate; 
  } 
  
  // sets the student's interest rate to be equal to the input value 
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate; 
  } 
  
  // returns the student's current interest rate 
  public double getInterestRate() {
    return interestRate; 
  } 
  
  // return's the student's current monthly payment (the amount of money needed to 
  // avoid an interest charge) 
  public double getMonthlyPayment() {
    return monthlyPayment; 
  } 
  
  // returns the student's current amount of money paid this month 
  public double getAmountPaidThisMonth() {
    return amountPaidThisMonth; 
  } 
  
  // determines if interest charge is necessary if the monthly payment is not fully
  // paid 
  // sets required monthly payment equal to the current balance 
  //   (so that in an ideal situation, the student would pay off the balance 
  // completely by the end of the month) 
  // resets the amount paid this month to 0 because it is the start of a new month 
  public void endOfMonth() { 
    if(amountPaidThisMonth < monthlyPayment) {
      charge((interestRate * getBalance())/12);  
    } 
    monthlyPayment = this.getBalance(); 
    amountPaidThisMonth = 0; 
  } 
  
  // subtracts the input value from the account balance 
  // updates amount paid this month to include most recent payment 
  @Override 
  public void credit(double credit) {
    super.credit(credit); 
    this.amountPaidThisMonth = amountPaidThisMonth + credit; 
  } 
} 
