package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Validity {
  // checks if the input is a valid colour.
  public static boolean checkColour(Colour colour) {
    if (colour != null) {
      return true;
    }
    return false;
  }
}
