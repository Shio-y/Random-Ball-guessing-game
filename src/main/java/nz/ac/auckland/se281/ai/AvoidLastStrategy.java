package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class AvoidLastStrategy implements Strategy {
  // need default values or else doesnt work
  private Colour[] colour = {Colour.RED, Colour.RED};

  // returns randomly a colour that was not picked in the previous turn by human.
  @Override
  public Colour[] getColours(Player currentPlayer) {
    colour[0] = Colour.getRandomColourForAi();
    colour[1] = Colour.getRandomColourExcluding(currentPlayer.getPreviousGuessColour());
    return colour;
  }
}
