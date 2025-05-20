package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.model.Colour;

public class EasyStrategy implements DifficultyStrategy {

  public static Colour getGuessColour() {

    return Colour.getRandomColourForAi();
  }

  public static Colour getChosenColour() {
    return Colour.getRandomColourForAi();
  }
}
