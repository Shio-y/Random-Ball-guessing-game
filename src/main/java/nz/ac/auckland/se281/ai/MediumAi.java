package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class MediumAi implements Ai {

  private boolean firstRound = true;
  private Colour[] holdColours; // 0 is chosen, 1 is guess;
  private SelectAi selectAi = new SelectAi();
  private Strategy randomStrategy = new RandomStrategy();
  private Strategy avoidLastStrategy = new AvoidLastStrategy();

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
    // checks if player guessed correctly
    if (currentPlayer.getPlayerGuess() == holdColours[0]) {
      // checks if player can get 3 points
      if (powerRound && holdColours[0] == powerColour) {
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
    if (currentPlayer.getPlayerColour() == holdColours[1]) {
      // checks for 3 points
      if (powerRound && holdColours[1] == powerColour) {
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
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", holdColours[0], holdColours[1]);
  }
}
