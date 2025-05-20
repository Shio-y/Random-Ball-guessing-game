package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.ai.*;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;

public class Game {
  public static String AI_NAME = "HAL-9000";
  public int maxRounds = 0;
  public int currentRound = 0;
  public Ai currentAi = null;
  public Player currentPlayer = null;
  public HardAi dummyHardAi = null;
  boolean gameBegin = false;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    gameBegin = true;
    maxRounds = numRounds; // set the max number of rounds

    // makes a new player instance
    Player newPlayer = new Player(options[0]);
    currentPlayer = newPlayer;

    MessageCli.WELCOME_PLAYER.printMessage(currentPlayer.getPlayerName());

    currentAi = AiFactory.createAi(difficulty);

    // clear history after starting new game
    currentPlayer.clearPlayerColourHistory();
    currentRound = 0;
    if (difficulty == difficulty.HARD) {
      dummyHardAi = (HardAi) (currentAi);
      dummyHardAi.clearHardAi();
    }
  }

  public void play() {
    Colour chosenColour = null;
    Colour guessColour = null;
    Colour powerColour = null;
    String[] input;
    Boolean validInputs = false;
    Boolean powerRound = false;

    // check if game began
    if (!gameBegin) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    currentRound += 1;
    // checks if power colour is active
    if (currentRound % 3 == 0) {
      powerRound = true;
    } else {
      powerRound = false;
    }

    MessageCli.START_ROUND.printMessage(currentRound, maxRounds);

    // ai makes guess and picks colour
    currentAi.makeGuess(currentPlayer);

    // human inputs
    while (validInputs == false) {
      MessageCli.ASK_HUMAN_INPUT.printMessage();

      input = (Interact.readStringInput().split(" "));

      // checks if there are enough inputs
      if (input.length != 2) {
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
        continue;
      }

      // attempts to turn inputs into colour enum
      chosenColour = Colour.fromInput(input[0]);
      guessColour = Colour.fromInput(input[1]);

      // checks if both inputs are valid and outputs error message if not
      if (Valid.checkColour(chosenColour) && Valid.checkColour(guessColour)) {
        currentPlayer.setColour(chosenColour, guessColour);
        break;

      } else {
        MessageCli.INVALID_HUMAN_INPUT.printMessage();
      }
    }

    // picks a power colour
    if (powerRound) {
      powerColour = Colour.getRandomColourForPowerColour();
      MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour.toString());
    }
    // outputs move info
    MessageCli.PRINT_INFO_MOVE.printMessage(
        currentPlayer.getPlayerName(), chosenColour.toString(), guessColour.toString());

    // ai outputs colour and allocates points

    currentAi.printGuess();
    currentAi.checkOutcome(currentPlayer, powerColour, powerRound);

    // checks if its the last round and outputs accordingly
    if (currentRound == maxRounds) {

      showStats();
      gameBegin = false;
      MessageCli.PRINT_END_GAME.printMessage();
      // checks for a winner if any.
      if (currentPlayer.getAiPoints() == currentPlayer.getPlayerPoints()) {
        MessageCli.PRINT_TIE_GAME.printMessage();
      } else if (currentPlayer.getAiPoints() > currentPlayer.getPlayerPoints()) {
        MessageCli.PRINT_WINNER_GAME.printMessage("HAL-9000");
      } else if (currentPlayer.getAiPoints() < currentPlayer.getPlayerPoints()) {
        MessageCli.PRINT_WINNER_GAME.printMessage(currentPlayer.getPlayerName());
      }
    }
  }

  public void showStats() {

    // check if game has started yet
    if (!gameBegin) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // outputs message containing total points
    MessageCli.PRINT_PLAYER_POINTS.printMessage(
        currentPlayer.getPlayerName(), String.valueOf(currentPlayer.getPlayerPoints()));
    MessageCli.PRINT_PLAYER_POINTS.printMessage(
        "HAL-9000", String.valueOf(currentPlayer.getAiPoints()));
  }
}
