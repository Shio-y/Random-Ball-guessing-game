package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;


public class EasyAi implements Ai {
    int points = 0;
    Colour chosenColour = null;
    Colour guessColour = null;

    public EasyAi(){
        this.chosenColour = null;
        this.guessColour = null;
    }

    
  @Override
  public void makeGuess() {
    
    this.chosenColour = EasyStrategy.getChosenColour();
    this.guessColour = EasyStrategy.getGuessColour();
  }
  


  @Override
  public Colour getAiGuess() {
    return guessColour;
  }


  @Override
  public Colour getAIColour() {
    return chosenColour;
  }


  @Override
  public void printGuess() {
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", this.chosenColour,this.guessColour);
    
  }
}
