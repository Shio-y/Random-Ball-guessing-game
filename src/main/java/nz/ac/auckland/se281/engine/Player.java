package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.model.Colour;


public class Player {

  private String name;
  private Colour chosenColour = null;
  private Colour guessColour;
  private Colour previousGuessColour = null;
  List<Colour> playerColourHistory = new ArrayList<>();

  public Player(String name) {
    this.name = name;
    
  }

  public String getPlayerName() {
    return this.name;
  }
  //sets the colours the player picked
  public void setColour(Colour chosenColour, Colour guessColour) {
    
    this.chosenColour = chosenColour;
    this.guessColour = guessColour;
    this.previousGuessColour = this.chosenColour;
    this.playerColourHistory.add(chosenColour);
    
  }

  public List<Colour> getPlayerColourHistory(){
    return this.playerColourHistory;

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
