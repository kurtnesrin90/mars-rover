
import java.util.Arrays;
import java.util.Scanner;

public class InputParser {


    public PlateauSize checkPlateauSize(String input) {
        int first = 0;
        int second = 0;
        PlateauSize plateauSize = new PlateauSize(first, second);
        String[] inputNumbers = input.split(" ");
        for(int i=0; i<inputNumbers.length; i++) {
            try {
                first = Integer.parseInt(inputNumbers[0]);
            } catch (NumberFormatException e){
                return null;
            }
            try {
                second = Integer.parseInt(inputNumbers[1]);
            } catch (NumberFormatException e){
                return null;
            }
            plateauSize = new PlateauSize(first, second);
        }
        return plateauSize;
    }


    public void controlDirection(String input) {

    }
}






