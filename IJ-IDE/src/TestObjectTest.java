import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestObjectTest {

    @ParameterizedTest
    @DisplayName("Kein Mitglied = 0% Rabatt")
    @CsvFileSource(files = ".\\test-data-file\\discount.csv", numLinesToSkip = 1)
    void discount_ShouldReturn(boolean isMember, double totalOrderValue, double expected) {
        Assertions.assertEquals(expected, TestObject.discount(isMember, totalOrderValue));

    }

    @ParameterizedTest
    @DisplayName("Kein Mitglied = 0% Rabatt")
    @CsvFileSource(files = ".\\test-data-file\\discount_2.csv", numLinesToSkip = 1, delimiter = ';')
    void discount_ShouldReturn_2(boolean isMember, double totalOrderValue, double expected) {
        Assertions.assertEquals(expected, TestObject.discount(isMember, totalOrderValue));

    }

    @ParameterizedTest
    @DisplayName("negativer values")
    @ValueSource(doubles = {-0.05, -100, -30})
    void discount_ShouldReturn_Exception(double totalOrderValue) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> TestObject.discount(true, totalOrderValue));
    }

    ;
}
