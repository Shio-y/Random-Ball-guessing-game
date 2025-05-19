package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  public Game() {


  }

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
   
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {}

  public void showStats() {}
}
