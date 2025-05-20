package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public class HardAi implements Ai {
  int roundCounter;
  Colour[] holdColours; // 0 is chosen, 1 is guess;
  SelectAi selectAi = new SelectAi();
  Strategy randomStrategy = new RandomStrategy();
  Strategy avoidLastStrategy = new AvoidLastStrategy();
  Strategy leastUsedStrategy = new LeastUsedStrategy();
  Boolean lostPrevious = false;
  Strategy previouStrategy;

  @Override
  public void makeGuess(Player currentPlayer) {
    //checks which round it is and picks strategy accordingly
    roundCounter+=1;
    switch (roundCounter) {
      case (1):
        selectAi.setStrategy(randomStrategy);
        break;
      case (2):
        selectAi.setStrategy(randomStrategy);
        break;
      case (3):
        selectAi.setStrategy(leastUsedStrategy);
        previouStrategy = leastUsedStrategy;
        break;
      default:
        if (lostPrevious){
          //dynamically switches which strategy to use round 4 onwards
          if(previouStrategy == leastUsedStrategy){
            previouStrategy = avoidLastStrategy;
          }else{
            previouStrategy = leastUsedStrategy;
          }
          
        }
        selectAi.setStrategy(previouStrategy);
    


      
        
    }
  
    
    holdColours = selectAi.execute(currentPlayer);
  }

  @Override
  public Colour getAiGuess() {
    return holdColours[1];
  }

  @Override
  public Colour getAIColour() {
    return holdColours[0];
  }

  @Override
  public void printGuess() {
    MessageCli.PRINT_INFO_MOVE.printMessage("HAL-9000", holdColours[0], holdColours[1]);
  }

  @Override
  public void checkOutcome(Player currentPlayer, Colour powerColour, Boolean powerRound) {
    // checks if player guessed correctly
    if (currentPlayer.getPlayerGuess() == holdColours[0]) {
      // checks if player can get 3 points
      if (powerRound && holdColours[0] == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "3");

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "1");
      }
      

    } else {

      MessageCli.PRINT_OUTCOME_ROUND.printMessage(currentPlayer.getPlayerName(), "0");
      
    }
    // checks if ai guessed correctly
    if (currentPlayer.getPlayerColour() == holdColours[1]) {
      // checks for 3 points
      if (powerRound && holdColours[1] == powerColour) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "3");

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "1");
      }
      lostPrevious = false; //remembers for next round

    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HAL-9000", "0");
      lostPrevious = true; //remembers for next round
    }
  }
}
