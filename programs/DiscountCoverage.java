import static java.lang.System.out;
import java.util.Scanner;

public class DiscountCoverage {

  public static void main(String[] args) {

    var scanner = new Scanner(System.in);
    out.printf("Sind Sie Kunde bei uns? (j/n): ");
    String input = scanner.nextLine().trim();
    boolean isMember = input.equalsIgnoreCase("j");

    double totalSum = 0;
    double discount = 0;
    boolean isPremiumMember = false;
    if (isMember) {
      out.printf("Sind Sie Premiumkunde? (j/n): ");
      input = scanner.nextLine().trim();
      isPremiumMember = input.equalsIgnoreCase("j");
    }

    out.printf("Wie hoch ist der Bestellwert? ");
    input = scanner.nextLine().trim();
    totalSum = Double.parseDouble(input);

    if (!isMember) {
      discount = totalSum > 100 ? 2 : 0;
    } else {
      discount = isPremiumMember ? 10 : 5;
    }

    String memberType = "Nichtkunde";
    if (isMember) {
      memberType = isPremiumMember ? "Premiumkunde" : "Standardkunde";
    }
    out.printf("Als %s erhalten sie einen Rabatt in Höhe von %.2f%% für den Bestellwert %.2f.\n",
      memberType, discount, totalSum);


    scanner.close();



  }


}