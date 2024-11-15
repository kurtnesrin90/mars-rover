
import java.util.ArrayList;
import java.util.List;

public class InputParser {


    public PlateauSize checkPlateauSize(String input) {
        int first = 0;
        int second = 0;
        PlateauSize plateauSize = new PlateauSize(first, second);

        //we can not use empty or null input
        if(input == null ){
            throw new NullPointerException("can not allowed being null");
        }
        if(input.isEmpty()){
            throw new NullPointerException("Can not allowed being empty");
        }
        String[] inputNumbers = input.split(" ");
        first = Integer.parseInt(inputNumbers[0]); //parseInt() can throw an exception
        second = Integer.parseInt(inputNumbers[1]);

        //we can just have 2 numbers after splitting, otherwise throw an exception
        if (inputNumbers.length != 2) {
            throw new RuntimeException("Invalid size");
        }
        //we can not use 0 for our plateau
        if (first == 0 || second == 0){
            throw new IllegalArgumentException("Can not use \"0\"");
                }
        // we cannot use negative numbers for our plateau
        if(first < 0 || second < 0){
            throw new RuntimeException("Can not use negative numbers");
        }
        plateauSize = new PlateauSize(first, second);

            return plateauSize;
    }


    public Position checkPosition(String input) {


       // Position position = new Position(first , second , CompassDirection.valueOf(third));
        String[] positionInputValues = input.split(" ");
        // length 3 degilse exception
        //for sil
        for(int i=0; i<positionInputValues.length; i++){
           int first = Integer.parseInt(positionInputValues[0]); // numbersexception
           int second = Integer.parseInt(positionInputValues[1]); // numbersexception
           CompassDirection third = CompassDirection.valueOf(positionInputValues[2].toUpperCase()); // illegal argument exception

           Position position = new Position(first , second , third);
           return position;
        }
        throw new RuntimeException("INVALID STATE");
    }


    public List<String> checkInstruction(String input){

         List<String> result = new ArrayList<>();
         String resultOfL;
         String resultOfR;
         String resultOfM;
         String[] inputInstructions = input.split("");

         //if input size == 0 , throw an exception
        if(inputInstructions.length == 0){
            throw new ArrayIndexOutOfBoundsException("Can not move");
        }

        // if input has unwanted value throw an exception
         for (int i=0; i<inputInstructions.length; i++){
             if(!(inputInstructions[i].equals("L") || inputInstructions[i].equals("R") || inputInstructions[i].equals("M"))){
                 throw new IllegalArgumentException("Instruction is not valid");
             }
           if(Instruction.valueOf(inputInstructions[i].toUpperCase()) == Instruction.L) {
               resultOfL = "Spins the Rover 90 degrees Left without moving from the current coordinate point";
               result.add(resultOfL);
           }
           if(Instruction.valueOf(inputInstructions[i].toUpperCase()) == Instruction.R) {
               resultOfR = "Spins the Rover 90 degrees Right without moving from the current coordinate point";
               result.add(resultOfR);
           }
           if(Instruction.valueOf(inputInstructions[i].toUpperCase()) == Instruction.M) {
               resultOfM = "Moves the Rover forward by one grid point, maintaining the same heading/orientation";
               result.add(resultOfM);
           }

       }
         return result;
    }


}






