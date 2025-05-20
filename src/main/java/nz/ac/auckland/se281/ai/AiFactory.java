package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
    
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case HARD:
        return new HardAi();
      case MEDIUM:
        return new MediumAi();
    }
    return null;
  }
}
