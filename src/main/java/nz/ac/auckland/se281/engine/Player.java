package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Player {

  private String name;
  private Colour chosenColour;
  private Colour guessColour;

  public Player(String name) {
    this.name = name;
  }

  public String getPlayerName() {
    return this.name;
  }

  public void setColour(Colour chosenColour, Colour guessColour) {
    this.chosenColour = chosenColour;
    this.guessColour = guessColour;
  }

  public Colour getPlayerGuess() {
    return this.guessColour;
  }

  public Colour getPlayerColour() {
    return this.chosenColour;
  }
}
