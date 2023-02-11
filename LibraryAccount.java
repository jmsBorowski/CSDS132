/* Jaiden Borowski 
 * CSDS 132 
 * 10/01/2021 
 * LibraryAccount - The Library Account class tracks a student's borrowed books and
overdue fees 
 */ 
// The Library Account 
public class LibraryAccount extends Account { 
  // The fine for an overdue book 
  private double bookFine = 0.0; 
  // The fine for an overdue reserve book 
  private double reserveFine = 0.0; 
  // The number of overdue books 
  private int overdueBooks = 0; 
  // The number of overdue reserve books 
  private int overdueReserves = 0; 
  
  /* A constructor to create a LibraryAccount with an account number, balance 
limit, and fines for overdue books/reserved books */ 
  public LibraryAccount(String accountNumber, int balanceLimit, double bookFine, 
double reserveFine) { 
    super(accountNumber, balanceLimit); 
    this.bookFine = bookFine; 
    this.reserveFine = reserveFine; 
  } 
  
  // sets the fine for an overdue book to be equal to the input value 
  public void setBookFine(double bookFine) {
    this.bookFine = bookFine; 
  } 
  
  // returns the account's current fine for an overdue book 
  public double getBookFine() {
    return bookFine; 
  } 
  
  // sets the fine for an overdue reserve book to be equal to the input value 
  public void setReserveFine(double reserveFine) {
    this.reserveFine = reserveFine; 
  } 
  
  // returns the account's current fine for an overdue reserve book 
  public double getReserveFine() { 
    return reserveFine; 
  } 
  
  // increases the student's number of overdue books by one 
  public void incrementOverdueBooks() {
    overdueBooks = overdueBooks + 1; 
  } 
  
  // decreases the student's number of overdue books by one 
  public void decrementOverdueBooks() {
    if(overdueBooks > 0) {
      overdueBooks = overdueBooks - 1; 
    } 
  } 
  
  // returns the student's current number of overdue books 
  public int getNumberOverdueBooks() {
    return overdueBooks; 
  }
  
  // increases the student's number of overdue reserve books by one 
  public void incrementOverdueReserve() {
    overdueReserves = overdueReserves + 1; 
  } 
  
  // decreases the student's number of overdue books by one 
  public void decrementOverdueReserve() {
    if(overdueReserves > 0) {
      overdueReserves = overdueReserves - 1; 
    } 
  } 
  
  // returns the student's current number of overdue reserve books 
  public int getNumberOverdueReserve() {
    return overdueReserves; 
  } 
  
  // determines if the student can borrow a book if their current balance does not exceed the limit 
  public boolean canBorrow() { 
    if (getBalance() <= getBalanceLimit()) {
      return true; 
    } else {
      return false; 
    } 
  } 
  
  // adds the fines for overdue books and reserve books to the student's current balance 
  public void endOfDay() {
    charge((overdueBooks*bookFine) + (overdueReserves*reserveFine));  
  } 
} 