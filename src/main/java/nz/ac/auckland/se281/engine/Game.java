package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

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
    currentRound +=1; //increments the round counter
    MessageCli.START_ROUND.printMessage(currentRound,maxRounds);
  }

  public void showStats() {}
}
