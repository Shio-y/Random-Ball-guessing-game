package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.model.Colour;

public class RandomStrategy implements Strategy {
  //set dummy default variables
  Colour[] colour = {Colour.RED, Colour.RED};

  public Colour[] getColours() {
    //0 is chosen, 1 is guess
    colour[0] = Colour.getRandomColourForAi();
    colour[1] = Colour.getRandomColourForAi();
    return colour;
  }

  // public static Colour getChosenColour() {
  //   return Colour.getRandomColourForAi();
  // }
}
