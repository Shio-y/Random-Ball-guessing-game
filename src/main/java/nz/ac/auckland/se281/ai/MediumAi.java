package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class MediumAi implements Ai {
  Colour chosenColour = null;
  Colour guessColour = null;
  boolean firstRound = true;
  
  Colour[] holdColours; // 0 is chosen, 1 is guess;
  SelectAi selectAi = new SelectAi();
  Strategy randomStrategy = new RandomStrategy();
  Strategy avoidLastStrategy = new AvoidLastStrategy();

  public MediumAi() {
    this.chosenColour = null;
    this.guessColour = null;
  }

  @Override
  public void makeGuess(Player currentPlayer) {
    // checks if its the first round and uses random strategy if so
    if (firstRound) {

      selectAi.setStrategy(randomStrategy);
      firstRound = false;

    } else {
      // changes strategy after first round
      selectAi.setStrategy(avoidLastStrategy);
    }

    holdColours = selectAi.execute(currentPlayer);
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

  @Override
  public Colour getAiGuess() {
    return holdColours[1];
  }

  @Override
  public Colour getAIColour() {
    return holdColours[0];
  }

  @Override
  public void printGuess() {
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", holdColours[0], holdColours[1]);
  }
}
