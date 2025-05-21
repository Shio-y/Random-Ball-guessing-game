package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class EasyAi implements Ai {

  private Colour chosenColour;
  private Colour guessColour;
  private Colour[] holdColours; // index 0 is chosen colour, 1 is guessed colour

  private RandomStrategy randomStrategy = new RandomStrategy();
  private SelectAi selectAi = new SelectAi();

  public EasyAi() {
    this.chosenColour = null;
    this.guessColour = null;
  }

  @Override
  public void makeGuess(Player currentPlayer) {
    selectAi.setStrategy(randomStrategy);

    // picks random colours for guessing.
    holdColours = selectAi.execute(currentPlayer);
    this.chosenColour = holdColours[0];
    this.guessColour = holdColours[1];
  }

  @Override
  public Colour getAiGuess() {
    return holdColours[1];
  }

  @Override
  public Colour getAiColour() {
    return holdColours[0];
  }

  @Override
  public void printGuess() {
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", this.chosenColour, this.guessColour);
  }

  @Override
  public void checkOutcome(Player currentPlayer, Colour powerColour, Boolean powerRound) {
    // checks if player guessed correctly
    if (currentPlayer.getPlayerGuess() == this.chosenColour) {
      // checks if player can get 3 points
      if (powerRound && this.chosenColour == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "3");
        currentPlayer.incrementPlayerPoints(3);

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "1");
        currentPlayer.incrementPlayerPoints(1);
      }

    } else {

      MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "0");
    }
    // checks if ai guessed correctly
    if (currentPlayer.getPlayerColour() == this.guessColour) {
      // checks for 3 points
      if (powerRound && this.guessColour == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "3");
        currentPlayer.incrementAiPoints(3);

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "1");
        currentPlayer.incrementAiPoints(1);
      }

    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "0");
    }
  }
}
