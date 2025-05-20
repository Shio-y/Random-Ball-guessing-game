package nz.ac.auckland.se281.ai;

import java.util.Arrays;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class LeastUsedStrategy implements Strategy {
  Colour[] colour = {Colour.RED, Colour.RED};
  // hierarchy is RED, GREEN, BLUE, YELLOW
  int[] colourCount = {0, 0, 0, 0};
  Colour[] dummyColour = {Colour.RED, Colour.GREEN, Colour.BLUE, Colour.YELLOW};
  int lowestCount;
  int lowestIndex = 0;

  @Override
  public Colour[] getColours(Player currentPlayer) {
    // resets the counter arrays
    Arrays.fill(colourCount, 0);
    lowestIndex = 0;
    // counts how many of each colour there are
    for (Colour currentColour : currentPlayer.getPlayerColourHistory()) {
      switch (currentColour) {
        case Colour.RED:
          colourCount[0] += 1;
          break;
        case Colour.GREEN:
          colourCount[1] += 1;
          break;
        case Colour.BLUE:
          colourCount[2] += 1;
          break;
        case Colour.YELLOW:
          colourCount[3] += 1;
          break;
      }
    }
    lowestCount = colourCount[0];

    // finds which colour has the least appearances
    for (int i = 0; i < 4; i++) {

      if (colourCount[i] < lowestCount) {
        lowestCount = colourCount[i];
        lowestIndex = i;
      }
    }
    colour[0] = Colour.getRandomColourForAi();
    colour[1] = dummyColour[lowestIndex];
    return colour;
  }
}
