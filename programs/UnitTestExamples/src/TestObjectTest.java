import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

// Unit Tests sind eine Form von automatisierten Tests. Man implementiert sie
// während der Testimplementierungsphase (Test implementation).
class TestObjectTest {

  @Test
  void sum() {
    // Da sich die Klasse TestObject im selben Package befindet,
    // wie Klasse TestObjectTest, ist ein expliziter Import von TestObject
    // nicht notwendig.
    assertEquals(0, TestObject.sum());
    assertEquals(2, TestObject.sum(2));
    assertEquals(5, TestObject.sum(2, 3));
  }

  @Test
  void min() {
    assertEquals(1, TestObject.min(3, 1));
    assertEquals(1, TestObject.min(1, 1));
    assertEquals(1, TestObject.min(1, 2));
  }

  @Test
  @DisplayName("If age is 18 then result is true")
  void isAdult_ShouldReturnTrueIfAgeIsEqualTo18() {
    assertTrue(TestObject.isAdult(18));
  }

  @Test
  @DisplayName("If age > 18 then result is true")
  void isAdult_ShouldReturnTrueIfAgeIsGreaterThan18() {
    assertTrue(TestObject.isAdult(21));
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 12, 17})
  @DisplayName("If age < 18 then result is False")
  void isAdult_ShouldReturnFalseIfAgeIsLowerThan18(int age) {
    assertFalse(TestObject.isAdult(age));
  }

  @Test
  @DisplayName("A member with a total order of < 100 should get discount of 2%")
  void discount_ShouldReturn2ForMembersWithOrderValueLessThan100() {
    assertEquals(2.0, TestObject.discount(true, 90));
  }

  @Test
  @DisplayName("A member with a total order of =100 should get discount of 5%")
  void discount_ShouldReturn5ForMembersWithOrderValueEqualTo100() {
    assertEquals(5.0, TestObject.discount(true, 100));
  }

  // Diese Methode stellt Argumente bzw. Testdaten für die unten folgende Testmethode bereit.
  private static Stream<Arguments> discount_ShouldReturn0IfNoMember() {
    return Stream.of(
            Arguments.of(false, 50.0),
            Arguments.of(false, 110.0),
            Arguments.of(false, 20.0),
            Arguments.of(false, 200.5)
    );
  }

  @ParameterizedTest
  @DisplayName("Non-members don't get a discount, i.e. 0%.")
//  @MethodSource("discount_provideArgumentsForShouldReturn0IfNoMember")
//  @MethodSource
  @CsvFileSource(files = ".\\test-data\\discount-test-data.csv", numLinesToSkip = 1, delimiter = ';')
  void discount_ShouldReturn0IfNoMember(boolean isMember, double totalOrderValue, double expectedResult) {
    assertEquals(expectedResult, TestObject.discount(isMember, totalOrderValue));
  }

  @ParameterizedTest
  @ValueSource(doubles = {-0.05, -100, -30})
  @DisplayName("Negative order values should cause an Illegal Argument Exception")
  void discount_ShouldThrowExceptionWhenTotalOrderValueIsNegative(double totalOrderValue) {
    // Prüfe, ob die discount Methode eine IllegalArgumentException wirft.
    assertThrowsExactly(IllegalArgumentException.class, () -> TestObject.discount(true, totalOrderValue));
    assertThrowsExactly(IllegalArgumentException.class, () -> TestObject.discount(false, totalOrderValue));
  }

  @BeforeEach
  void prepareTest(TestInfo testInfo) {
    String testMethodName = testInfo.getTestMethod().orElseThrow().getName();
    System.out.println("Preparing next test: %s".formatted(testMethodName));
  }

  @BeforeAll
  static void setUpTestEnvironment() {
    System.out.println("Current directory: %s".formatted(System.getProperty("user.dir")));
    System.out.println("Setting up test environment...");
    // z.B. Eine Verbindung zur Datenbank aufbauen, die für die Tests notwendig ist.
  }

  @AfterEach
  void cleanUpTest(TestInfo testInfo) {
    String testMethodName = testInfo.getTestMethod().orElseThrow().getName();
    System.out.println("Cleaning up test: %s".formatted(testMethodName));
  }

  @AfterAll
  static void tearDownTestEnvironment() {
    System.out.println("Tearing down test environment...");
    // z.B. Eine bestehende Verbindung zur Datenbank beenden.
  }


}