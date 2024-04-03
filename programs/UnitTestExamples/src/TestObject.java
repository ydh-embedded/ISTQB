// Diese Klasse ist das Testobjekt.
public class TestObject {
  public static int sum(int... numbers) {
    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }
    return sum;
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }

  // Abstrakte Testfälle:
  // age               <18   =18  >18
  // expected result   nein  ja   ja

  // Konkrete Testfälle:
  // age               10    12     17     18    21
  // expected result   false false  false  true  true
  public static boolean isAdult(int age) {
    return age >= 18;
  }

  // Testfälle werden in der Phase "Testentwurf / Test Design" erstellt.
  // Abstrakte Testfälle: (abstrakte Eingaben mit Wertebereichen, meist nur Operatoren)
  // isMember          ja       ja       nein    nein
  // totalOrderValue   < 100    >= 100   < 100   >= 100
  // expected result:  2%       5%       0%      0%

  // Konkrete Testfälle (konkrete Eingabewerte bzw. Testdaten)
  // isMember          true     true     false   false
  // totalOrderValue   90       100      50      110
  // expected result:  2%       5%       0%      0%
  public static double discount(boolean isMember, double totalOrderValue) {
    if (totalOrderValue < 0) throw new IllegalArgumentException("Negativer Bestellwert unzulässig");
    if (!isMember) return 0;
    return totalOrderValue >= 100.0 ? 5 : 2;
  }
}
