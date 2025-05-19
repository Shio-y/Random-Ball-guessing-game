package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;
import nz.ac.auckland.se281.engine.Valid;

public class Game {
  public static String AI_NAME = "HAL-9000";
  public int maxRounds = 0;
  public int currentRound = 0;

  public Game() {


  }

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    maxRounds = numRounds; //set the max number of rounds
   
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    
  }

  public void play() {
    Colour chosenColour;
    Colour guessColour;
    String[] input;
    Boolean validInputs = false;
    
    
    currentRound +=1; //increments the round counter
    MessageCli.START_ROUND.printMessage(currentRound,maxRounds);

    
    while (validInputs == false){
      MessageCli.ASK_HUMAN_INPUT.printMessage();
      //splits the input and then attempts to turn them into colour enum
      input = (Interact.readStringInput().split(" ")); 

      //checks if there are enough inputs
      if (input.length!=2){
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
        continue;
      }

      //attempts to turn inputs into colour enum
      chosenColour = Colour.fromInput(input[0]);
      guessColour = Colour.fromInput(input[1]);

      //checks if both inputs are valid and outputs error message if not
      if (Valid.checkColour(chosenColour)&& Valid.checkColour(guessColour)){
        break;
      }else{
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
      }

    }
    
      
    


    
  }

  public void showStats() {}
}
