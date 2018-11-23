import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JPMorganChase1 {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    
    while ((line = in.readLine()) != null) {
      System.out.println(isHappy(line) ? 1 : 0);
    }
  }
  
  // Determine if the entered positive integer (possibly huge number) is Happy
  static private boolean isHappy(String line) {  
    HashSet<Integer> hset = new HashSet<>();
    int num = getSumOfSquaresOfDigits(line);
    if (num > 1) {
      do {
        hset.add(num);
        num = getSumOfSquaresOfDigits(num);
        // Alternatively, only one method for getSumOfSquaresOfDigits
        // could be defined if we want to pass the number as a string,
        // shown on next line
        //num = getSumOfSquaresOfDigits(num + "");
      } while (num != 1 && !hset.contains(num));
    }
    return num == 1;  //Happy Number results in num = 1
  }
  
  // Sum the Squares of each Digit in the given positive integer (possibly huge number)
  static private int getSumOfSquaresOfDigits(String line) {
    // line is a string of digits and could be a really huge integer, 
    // but successive numbers will be within size of int
    int sumSquares = 0, digit;
    for (int i = 0; i < line.length(); i++) {
      digit = line.charAt(i) - '0';
      sumSquares += (digit * digit);
    }
    return sumSquares;
  }
  
  // Sum the Squares of each Digit in the given positive integer
  static private int getSumOfSquaresOfDigits(int num) {
    int sumSquares = 0, digit;
    while (num > 0) {
      digit = num % 10;
      sumSquares += (digit * digit);
      num /= 10;
    }
    return sumSquares;
  }
}
