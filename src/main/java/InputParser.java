
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public PlateauSize parsePlateauSize(String input) {
        int xAxis;
        int yAxis;
        PlateauSize plateauSize;

        //we can not use empty or null input
        if(input == null ){
            throw new NullPointerException("can not allowed being null");
        }
        if(input.isEmpty()){
            throw new NullPointerException("Can not allowed being empty");
        }
        String[] inputNumbers = input.split(" ");
        xAxis = Integer.parseInt(inputNumbers[0]); //parseInt() can throw an exception
        yAxis = Integer.parseInt(inputNumbers[1]);

        //we can just have 2 numbers after splitting, otherwise throw an exception
        if (inputNumbers.length != 2) {
            throw new RuntimeException("Invalid size");
        }
        //we can not use 0 for our plateau
        if (xAxis == 0 || yAxis == 0){
            throw new IllegalArgumentException("Can not use \"0\"");
                }
        // we cannot use negative numbers for our plateau
        if(xAxis < 0 || yAxis < 0){
            throw new RuntimeException("Can not use negative numbers");
        }
        plateauSize = new PlateauSize(xAxis, yAxis);

            return plateauSize;
    }


    public Position parsePosition(String input) {

         // input can not be null
        if(input == null){
            throw new NullPointerException("Input can not be null");
        }
        // input can not be empty
        if(input.isEmpty()){
            throw new IllegalArgumentException("Input can not be empty");
        }

        //Split input to the array
        String[] positionInputValues = input.split(" ");

        // we need 3 elements after splitting
        if(positionInputValues.length != 3){
            throw new RuntimeException("Input length is invalid");
        }

        int xAxis = Integer.parseInt(positionInputValues[0]); // parseInt() can throw numbers exception
        int yAxis = Integer.parseInt(positionInputValues[1]); // parseInt() can throw numbers exception
        CompassDirection facing = CompassDirection.valueOf(positionInputValues[2].toUpperCase());// valueOf() can throw illegal argument exception

        if(xAxis < 0 || yAxis < 0){
            throw new RuntimeException("Can not use negative numbers");
        }

        Position position = new Position(xAxis , yAxis , facing);
           return position;
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






