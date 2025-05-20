package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class MediumAi implements Ai {
    Colour chosenColour = null;
    Colour guessColour = null;
    boolean firstRound = true;
    Colour previousPlayerGuess = null;

    public MediumAi(){
        this.chosenColour = null;
        this.guessColour = null;
    }
  @Override
  public void makeGuess() {
    //checks if its the first round and uses random strategy if so
    if (firstRound){

        this.chosenColour = RandomStrategy.getChosenColour();
        this.guessColour = RandomStrategy.getGuessColour();
    }else{

    }
    
  }



  @Override
  public void checkOutcome(Player currentPlayer, Colour powerColour, Boolean powerRound) {
    //saves the previous player guess
    previousPlayerGuess = currentPlayer.getPlayerGuess();
  }
  @Override
  public Colour getAiGuess() {
    return this.guessColour;
  }

  @Override
  public Colour getAIColour() {
   return this.chosenColour;
  }

  @Override
  public void printGuess() {
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", this.chosenColour, this.guessColour);
  }
}
