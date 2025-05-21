package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class RandomStrategy implements Strategy {
  // set dummy default variables
  private Colour[] colour = {Colour.RED, Colour.RED};

  @Override
  public Colour[] getColours(Player currentPlayer) {
    // 0 is chosen, 1 is guess
    colour[0] = Colour.getRandomColourForAi();
    colour[1] = Colour.getRandomColourForAi();
    return colour;
  }
}
