import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    @Test
    @DisplayName("Test the given values if they are invalid")
    void testCheckPlateauSizeWithInvalidInput() {
        //Arrange
        String inputWithNotNumber = "A B";
        String inputIsNotValidLength = "ABCD";
        String inputIsEmpty = " ";
        String inputWithZero = "0 0";
        String inputWithNumberInvalidLength = "3 4 5";
        String inputWithNegativeNumber = "-3 5";
        String inputIsNull = null;
        //Act
        InputParser inputParser = new InputParser();
        //Assert
        assertThrows(NumberFormatException.class , () -> inputParser.checkPlateauSize(inputWithNotNumber));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(inputIsNotValidLength));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(inputIsEmpty));
        assertThrows(IllegalArgumentException.class, () -> inputParser.checkPlateauSize(inputWithZero));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(inputWithNumberInvalidLength));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(inputWithNegativeNumber));
        assertThrows(NullPointerException.class , () -> inputParser.checkPlateauSize(inputIsNull));

    }

    @Test
    @DisplayName("Test the given values if they are valid")
    void testCheckPlateauSizeWithValidInput() {
        //Arrange
        String input = "4 5";
        //Act
        InputParser inputParser = new InputParser();
        PlateauSize plateauSize = inputParser.checkPlateauSize(input);
        //Assert
        assertEquals(4, plateauSize.getX());
        assertEquals(5, plateauSize.getY());
    }
}