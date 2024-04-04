import static java.lang.System.out;

public class DivisionByZero {

  public static void main(String[] args) {
    // Dieses Programm enthält eine Reihe von Defects (Mängel, Bugs).
    // 1) Es wird nicht geprüft, ob der Nutzer genügend Argumente angegeben hat.
    // 2) Es wird nicht geprüft, ob der Nutzer Zahlen angegeben hat.
    // 3) Es wird eine Integer-Division durchgeführt, wodurch ein falsches Ergebnis entstehen kann.
    // 4) Falls der Nutzer eine Null für das zweite Argument angibt, stürzt das Programm aufgrund einer Division
    //    durch Null ab.
    int firstNumber = Integer.parseInt(args[0]);
    int secondNumber = Integer.parseInt(args[1]);
    double result = firstNumber / secondNumber;

    out.printf("Division von %d und %d ergibt %.2f\n", firstNumber, secondNumber, result);
  }

  // Um die Defects (Bugs) zu triggern (auszulösen) rufe das Programm wie folgt auf:
  // 1) java DivisionByZero löst ArrayIndexOutOfBoundsException aus (Failure)
  // 2) java DivisionByZero 10 xx löst eine NumberFormatException aus (Failure)
  // 3) java DivisionByZero 3 4 löst keine Exception aus, aber ein falsches Ergebnis (Failure).
  // 4) java DivisionByZero 3 0 löst eine ArithmeticException aus und stürzt ab (Failure).
}