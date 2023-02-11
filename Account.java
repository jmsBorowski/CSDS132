/* Jaiden Borowski 
 * CSDS 132 
 * 10/01/2021 
 * Account - The Account class records the monetary transactions/debt of a student 
 */ 
public class Account { 
  // The identifying number of the account (as a String) 
  private static String accountNumber = ""; 
  // The student's total amount due/balance 
  private double balance = 0.0; 
  // The student's maximum amount due/balance 
  private int balanceLimit = 0; 
  
  // A constructor to create an Account with an account number and balance limit 
  public Account(String accountNumber, int balanceLimit) {    
    this.accountNumber = accountNumber;    
    this.balanceLimit = balanceLimit;    
  } 
  
  // returns the student's account number 
  public static String getAccountNumber() { 
    return accountNumber; 
  } 
  
  // returns the student's current balance/debt 
  public double getBalance() { 
    return balance; 
  }
  
  // adds money to the student's balance 
  public void charge(double charge) {
    balance = balance + charge; 
  } 
  
  // subtracts money from the student's balance 
  public void credit(double credit) { 
    balance = balance - credit; 
  } 
  
  // sets the student's balance limit to be equal to the input value 
  public void setBalanceLimit(int balanceLimit) {
    this.balanceLimit = balanceLimit; 
  }
  
  // returns the student's current balance limit 
  public int getBalanceLimit() {
    return balanceLimit; 
  }  
} 