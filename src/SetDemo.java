import java.util.*;

public class SetDemo {

  public static final int NUMBERS = 6;
  public static final int MAX_NUMBER = 40;

  public static void main(String[] args) {
    while (true) runLottery();
  }

  public static void runLottery() {
    Set<Integer> winningNumbers = createWinningNumbers();
    Set<Integer> ticket = getTicket();

    // keep only the winning numbers from the user's ticket
    Set<Integer> intersection = new TreeSet<Integer>(ticket);
    intersection.retainAll(winningNumbers);
    if (intersection.size() > 0) {
      double prize = 100 * intersection.size();
      System.out.println("Matched numbers are " + intersection);
      System.out.println("Your prize is $" + prize);
     } else
       System.out.println("Sorry! You loose");
  }

  // Create a winning number by having NUMBERS integers, each 
  // between 0 and 40. Each number must be unique.
  public static Set<Integer> createWinningNumbers() {
    Set<Integer> winningNumbers = new TreeSet<Integer>();
    Random r = new Random();
    while (winningNumbers.size() < NUMBERS) {
      int number = r.nextInt(MAX_NUMBER) + 1;
      winningNumbers.add(number);
    }
    return winningNumbers;
  }

  // reads the player's lottery ticket from the console. Collect 6
  // unique numbers. Little bug here. 
  public static Set<Integer> getTicket() {
    Set<Integer> ticket = new TreeSet<Integer>();
    try (Scanner console = new Scanner(System.in)) {
      System.out.print("\nType your " + NUMBERS + " unique lotto numbers: ");
      while (ticket.size() < NUMBERS) {
        int number = console.nextInt();
        ticket.add(number);
      }
    }
    return ticket;
  }

}
