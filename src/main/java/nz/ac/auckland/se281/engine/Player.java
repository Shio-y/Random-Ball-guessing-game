package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Player {

  private String name;
  private Colour chosenColour = null;
  private Colour guessColour;
  private Colour previousGuessColour = null;

  public Player(String name) {
    this.name = name;
  }

  public String getPlayerName() {
    return this.name;
  }
  //sets the colours the player picked
  public void setColour(Colour chosenColour, Colour guessColour) {
    this.previousGuessColour = this.chosenColour;
    this.chosenColour = chosenColour;
    this.guessColour = guessColour;
    
  }



  public Colour getPlayerGuess() {
    return this.guessColour;
  }
  public Colour getPreviousGuessColour(){
    return this.previousGuessColour;
  }

  public Colour getPlayerColour() {
    return this.chosenColour;
  }
}
