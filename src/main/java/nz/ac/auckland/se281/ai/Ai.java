package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public interface Ai {
  public void makeGuess();

  public Colour getAiGuess();

  public Colour getAIColour();

  public void printGuess();

  public void checkOutcome(Player currentPlayer, Colour powerColour, Boolean powerRound);
}
