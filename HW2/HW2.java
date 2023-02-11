/** 
 * Jaiden Borowski 
 * CSDS 132 
 * HW2 class - The HW2 class contains methods which manipulate strings and arrays 
 */ 
public class HW2 { 
  /** 
   * Determines if the input string is in alphabetical order 
   * @param inputString - the string to be tested 
   * @return - if the string is alphabetical or not 
   */ 
  public static boolean alphabeticalOrder(String inputString) {       
    // StringBuilder to hold modified version of inputString 
    StringBuilder alphaBuilder = new StringBuilder(""); 
    
    // iterates through each char in inputString and appends it to alphaBuilder if 
// it is a letter 
    for(int i = 0; i < inputString.length(); i++) { 
      if(Character.isLetter(inputString.charAt(i))) {
        alphaBuilder.append(Character.toLowerCase(inputString.charAt(i))); 
      } 
    } 
    
    // iterates through each char in alphaBuilder and determines if it has a lower 
// value than the value after it, 
    // returning false if that condition is not met and the chars are not in 
// alphabetical order 
    for(int i = 0; i < alphaBuilder.length()-1; i++) {
      if (alphaBuilder.charAt(i) > alphaBuilder.charAt(i+1)) {
        return false; 
      } 
    } 
    return true; 
  } 
  
  /** 
   * Shifts every letter/digit in the cipherString by the cipherInt 
   * @param inputString - the string to be modified 
   * @param inputInt - the number which determines how much the chars are moved 
   * @return - a modified version of the input String 
   */ 
  public static String casearCipher(String inputString, int inputInt) {
    // StringBuilder to hold modified version of inputString 
    StringBuilder cipherBuilder = new StringBuilder(""); 
    // current char to modify 
    char appendChar; 
    
    // 
    for(int i = 0; i < inputString.length(); i++) { 
      appendChar = inputString.charAt(i); 
      // if the input int is positive 
      if (Character.isLetterOrDigit(appendChar) && inputInt >= 0) {
        // adds 1 to the char inputInt number of times and catches the char at 'z',
// 'Z', and '9' 
        for(int ii = 0; ii < inputInt ; ii++) { 
          if (appendChar == 'z') { 
            appendChar = 'a'; 
          } else if (appendChar == 'Z') { 
            appendChar = 'A'; 
          } else if (appendChar == '9') {
            appendChar = '0'; 
          } else { 
            appendChar = (char)((int)appendChar + 1); 
          } 
        } 
        cipherBuilder.append(appendChar); 
      // if the input int is negative 
      } else if (Character.isLetterOrDigit(appendChar)) { 
        // adds 1 to the char inputInt number of times and catches the char at 'a',
// 'A', and '0' 
        for(int ii = inputInt; ii < 0 ; ii++) { 
          if (appendChar == 'a') { 
            appendChar = 'z'; 
          } else if (appendChar == 'A') { 
            appendChar = 'Z'; 
          } else if (appendChar == '0') {
            appendChar = '9'; 
          } else { 
            appendChar = (char)((int)appendChar - 1); 
          } 
        } 
        cipherBuilder.append(appendChar); 
      // if the current char is not a letter or digit 
      } else {
        cipherBuilder.append(appendChar); 
      } 
    } 
    return cipherBuilder.toString(); 
  } 
  
  /** 
   * Repeats each char from inputString inputInt number of times. 
   * @param inputString - the string to be modified 
   * @param inputInt - the number of times to repeat each char, if negative the 
input string is changed to be backwards 
   * @return - the modified version of inputString 
   */ 
  public static String repeatChars(String repeatString, int repeatInt) {
    // StringBuilder to hold modified version of inputString 
    StringBuilder repeatBuilder = new StringBuilder(""); 
    
    // if the input int is positive 
    if (repeatInt >= 0) { 
      // iterates through each char in inputString 
      for (int index = 0; index < repeatString.length(); index++) { 
        // repeats each char inputInt number of times 
        for (int i = 0; i < repeatInt; i++) { 
          repeatBuilder.append(repeatString.charAt(index)); 
        } 
      } 
    // if the input int is negative 
    } else { 
      // iterates through each char in inputString backwards 
      for (int j = repeatString.length()-1; j > -1; j--) { 
        // repeats each char inputInt number of times 
        for (int counter = repeatInt; counter < 0; counter++) { 
          repeatBuilder.append(repeatString.charAt(j)); 
        } 
      } 
    } 
    return repeatBuilder.toString(); 
  } 
  
  /** 
   * Repeats each word from inputString inputInt number of times 
   * @param inputString - the string to be modified 
   * @param inputInt - the number of times to repeat each word 
   * @return - the modified version of inputString 
   */ 
  public static String repeatWords(String inputString, int inputInt) { 
    // StringBuilder to hold modified version of inputString 
    StringBuilder newSentence = new StringBuilder(""); 
    // a counter to go through each char in inputString 
    int index = 0; 
    
    // iterates through each char in inputString 
    while (index < inputString.length()) {
      // while the chars are not letters, they are appended to newSentence 
      while(index < inputString.length() && !
Character.isLetter(inputString.charAt(index))) {
        newSentence.append(inputString.charAt(index)); 
        index++;  
      } 
      // StringBuilder to store a word built from consecutive letters in input 
// String 
      StringBuilder word = new StringBuilder(""); 
      
      // while there are consecutive letters, they are appended to word 
      while(index < inputString.length() && Character.isLetter(inputString.charAt(index))) {
        word.append(inputString.charAt(index)); 
        index++; 
      } 
      
      // counts up from 0 to the inputInt value 
      for (int i = 0; i < inputInt; i++) { 
        // if the word is the last word in a sentence, no space is added after it 
        if (i == inputInt-1 && word.length() > 0) { 
          newSentence.append(word); 
        } else if (word.length() > 0) { 
          newSentence.append(word + " "); 
        } 
      } 
    } 
    return newSentence.toString(); 
  } 
  
  /** 
   * Repeats each value from inputArr inputInt number of times 
   * @param inputArr - the array of values to be repeated 
   * @param inputInt - the number of times to repeat each value  
   * @return - the modified version of inputArr  
   */ 
  public static double[] repeatValues(double[] inputArr, int inputInt) {
    // array to hold modified version of inputArr 
    double[] newArr = new double[inputArr.length*inputInt]; 
    
    // current index of newArr 
    int index = 0; 
    
    // iterates through each value in inputArr 
    for (int i = 0; i < inputArr.length; i++) { 
      // appends each value to newArr inputInt number of times 
      for (int j = 0; j < inputInt; j++) {
        newArr[index] = inputArr[i]; 
        index++; 
      } 
    } 
    return newArr; 
  } 
  
  /** 
   * Determine if there is a path of increasing values through all the values 
   * @param inputArr - the array of values to be tested 
   * @return - if there is a "winding path" 
   */ 
  public static boolean isWindingPath(double[][] inputArr) { 
    // smallest number x index 
    int x = 0; 
    // smallest number y index 
    int y = 0; 
    // if a value for the smallest number has been found yet 
    boolean valFound = false; 
    // value of smallest number 
    double val = 0.0; 
    // number of total cells in input array 
    int totalCells = 0; 
    
    // iterates through all cells of the inputArr and locates the smallest number 
// in inputArr 
    // rows of inputArr 
    for (int i = 0; i < inputArr.length; i++) { 
      // columns of inputArr 
      for (int j = 0; j < inputArr[i].length; j++) { 
        totalCells++; 
        if((!valFound) || (inputArr[i][j] < val)) { 
          x = i; 
          y = j; 
          val = inputArr[i][j]; 
          valFound = true; 
        } 
      } 
    } 
    
    // runs for the number of jumps/increases needed to have a winding path 
    for(int jumps = 0; jumps < totalCells-1; jumps++) { 
      // next num x index 
      int nextX = 0; 
      // next num y index 
      int nextY = 0; 
      // if a value has been set yet 
      boolean nextValFound = false; 
      // the current next num value 
      double nextVal = 0.0; 
      
      // iterates through each cell of inputArr and finds the next larger value to 
// the current value 
      // rows of inputArr 
      for (int i = 0; i < inputArr.length; i++) { 
        // columns of inputArr 
        for (int j = 0; j < inputArr[i].length; j++) {
          if (inputArr[i][j] > val && (!nextValFound || inputArr[i][j] < nextVal)) 
{
            nextVal = inputArr[i][j]; 
            nextX = i; 
            nextY = j; 
            nextValFound = true; 
          } 
        } 
      } 
      
      // the difference between the x coordinate of the next value and the current 
// value 
      int differenceX = nextX - x; 
      // the difference between the y coordinate of the next value and the current 
// value 
      int differenceY = nextY - y; 
      
      // determines if the next value is one non-diagonal jump away from the 
// current value 
      if (!(differenceX == 1 && differenceY == 0) && !(differenceX == 0 && 
differenceY == 1) && !(differenceX == -1 && differenceY == 0) && !(differenceX == 0
&& differenceY == -1)) {
        return false; 
      } 
      
      val = nextVal; 
      y = nextY; 
      x = nextX; 
    } 
    return true; 
  } 
}