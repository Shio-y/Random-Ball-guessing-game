package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class EasyAi implements Ai {
  int points = 0;
  Colour chosenColour = null;
  Colour guessColour = null;

  public EasyAi() {
    this.chosenColour = null;
    this.guessColour = null;
  }

  @Override
  public void makeGuess() {
    //picks random colours for guessing.
    this.chosenColour = RandomStrategy.getChosenColour();
    this.guessColour = RandomStrategy.getGuessColour();
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
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", this.chosenColour, this.guessColour);
  }

  @Override
  public void checkOutcome(Player currentPlayer, Colour powerColour, Boolean powerRound) {
    //checks if player guessed correctly
    if (currentPlayer.getPlayerGuess() == this.chosenColour) {
        //checks if player can get 3 points
      if (powerRound && this.chosenColour == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "3");

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "1");
      }

    } else {

      MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "0");
    }
    //checks if ai guessed correctly
    if (currentPlayer.getPlayerColour() == this.guessColour) {
        //checks for 3 points
      if (powerRound && this.guessColour == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "3");

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "1");
      }

    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "0");
    }
  }
}
