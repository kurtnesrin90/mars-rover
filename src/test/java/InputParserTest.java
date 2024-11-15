import Base.CompassDirection;
import Base.InputParser;
import Base.PlateauSize;
import Base.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("Test the given values for the plateau size if they are invalid")
    void testParsePlateauSizeWithInvalidInput() {
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
            assertThrows(NumberFormatException.class, () -> inputParser.parsePlateauSize(inputWithNotNumber));
            assertThrows(RuntimeException.class, () -> inputParser.parsePlateauSize(inputIsNotValidLength));
            assertThrows(RuntimeException.class, () -> inputParser.parsePlateauSize(inputIsEmpty));
            assertThrows(IllegalArgumentException.class, () -> inputParser.parsePlateauSize(inputWithZero));
            assertThrows(RuntimeException.class, () -> inputParser.parsePlateauSize(inputWithNumberInvalidLength));
            assertThrows(RuntimeException.class, () -> inputParser.parsePlateauSize(inputWithNegativeNumber));
            assertThrows(NullPointerException.class, () -> inputParser.parsePlateauSize(inputIsNull));

    }

    @Test
    @DisplayName("Test the given values for the plateau size if they are valid")
    void testParsePlateauSizeWithValidInput() {
        //Arrange
            String input = "4 5";
        //Act
            InputParser inputParser = new InputParser();
            PlateauSize plateauSize = inputParser.parsePlateauSize(input);
        //Assert
            assertEquals(4, plateauSize.getX());
            assertEquals(5, plateauSize.getY());
    }

    @Test
    @DisplayName("Test the given inputs for the position if they are invalid")
    void testParsePositionWithInvalidInput() {
        //Arrange
            String inputIsEmpty = "";
            String inputIsNull = null;
            String inputWithInvalidLength = "1 2 3 4 N";
            String inputWithSmallerLength = "1 N";
            String inputWithoutNumbers = "1 N N";
            String inputWithAnIllegalDirection = "1 2 A";
            String inputWithNegativeNumbers = "-4 5 N";
        //Act
            InputParser inputParser = new InputParser();
        //Assert
            assertThrows(IllegalArgumentException.class, () -> inputParser.parsePosition(inputIsEmpty));
            assertThrows(NullPointerException.class, () -> inputParser.parsePosition(inputIsNull));
            assertThrows(RuntimeException.class, () -> inputParser.parsePosition(inputWithInvalidLength));
            assertThrows(RuntimeException.class, () -> inputParser.parsePosition(inputWithSmallerLength));
            assertThrows(NumberFormatException.class, () -> inputParser.parsePosition(inputWithoutNumbers));
            assertThrows(IllegalArgumentException.class, () -> inputParser.parsePosition(inputWithAnIllegalDirection));
            assertThrows(RuntimeException.class, () -> inputParser.parsePosition(inputWithNegativeNumbers));
    }


    @Test
    @DisplayName("Test the given inputs for the position if they are valid")
    void testParsePositionWithValidInput() {
            //Arrange
            String inputIsValid = "6 6 N";
            //Act
            InputParser inputParser = new InputParser();
            Position position = inputParser.parsePosition(inputIsValid);
            //Assert
            assertEquals(6, position.getX());
            assertEquals(6, position.getY());
            assertEquals(CompassDirection.N, position.getFacing());
        }


    @Test
    @DisplayName("Test the given inputs for the instructions if they are invalid")
    void testParseInstructionWithInvalidInput(){
            //Arrange
            String inputIsNull = null;
            String inputIsEmpty = "";
            String inputWithUnwantedValue = "LMRN";
            String inputWithNumber = "3LM4R";
            //Act
            InputParser inputParser = new InputParser();
            //Assert
            assertThrows(NullPointerException.class , () -> inputParser.parseInstruction(inputIsNull));
            assertThrows(IllegalArgumentException.class , () -> inputParser.parseInstruction(inputIsEmpty));
            assertThrows(IllegalArgumentException.class , () -> inputParser.parseInstruction(inputWithUnwantedValue));
            assertThrows(IllegalArgumentException.class , () -> inputParser.parseInstruction(inputWithNumber));


    }

    @Test
    @DisplayName("Test the given inputs for the instructions if they are valid")
    void testParseInstructionWithValidInput(){
            //Arrange
            String inputWithValidInstructions = "LRM";
            List<String> listOfInputWithValidInstructions = List.of("Spins the Rover 90 degrees Left without moving from the current coordinate point",
                   "Spins the Rover 90 degrees Right without moving from the current coordinate point" ,
                    "Moves the Rover forward by one grid point, maintaining the same heading/orientation");
            //Act
            InputParser inputParser = new InputParser();
            List<String> result = inputParser.parseInstruction(inputWithValidInstructions);
            //Assert
            assertEquals(listOfInputWithValidInstructions, result);

    }

}