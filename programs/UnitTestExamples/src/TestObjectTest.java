import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
  void ifAgeIsEqualTo18ThenReturnTrue() {
    assertTrue(TestObject.isAdult(18));
  }

  @Test
  @DisplayName("If age > 18 then result is true")
  void ifAgeIsGreaterThan18ThenReturnTrue() {
    assertTrue(TestObject.isAdult(21));
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 12, 17})
  @DisplayName("If age < 18 then result is False")
  void ifAgeIsLowerThan18ThenReturnFalse(int age) {
    assertFalse(TestObject.isAdult(age));
  }

  @BeforeEach
  void prepareTest(TestInfo testInfo) {
    String testMethodName = testInfo.getTestMethod().orElseThrow().getName();
    System.out.println("Preparing next test: %s".formatted(testMethodName));
  }

  @BeforeAll
  static void setUpTestEnvironment() {
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