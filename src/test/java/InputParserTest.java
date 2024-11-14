import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    @Test
    @DisplayName("Test the given values if they are valid")
    void testCheckPlateuSizeWithInvalidInput() {
        //Arrange
        String input1 = "A B";
        String input2 = "ABCD";
        String input3 = " ";
        String input4 = "0 0";
        String input5 = "3 4 5";


        //Act
        InputParser inputParser = new InputParser();
        //Assert
        assertThrows(NumberFormatException.class , () -> inputParser.checkPlateauSize(input1));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(input2));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(input3));
        assertThrows(IllegalArgumentException.class, () -> inputParser.checkPlateauSize(input4));
        assertThrows(RuntimeException.class , () -> inputParser.checkPlateauSize(input5));




    }
}