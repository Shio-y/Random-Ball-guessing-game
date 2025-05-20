package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class AvoidLastStrategy implements Strategy {

  Colour[] colour = {Colour.RED, Colour.RED};

  public static Colour getGuessColour(Colour previousPlayerGuess) {

    return Colour.getRandomColourExcluding(previousPlayerGuess);
  }

  @Override
  public Colour[] getColours(Player currentPlayer) {
    colour[0] = Colour.getRandomColourForAi();
    colour[1] = Colour.getRandomColourExcluding(currentPlayer.getPreviousGuessColour());
    return colour;
  }
}
