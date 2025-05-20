package nz.ac.auckland.se281.ai;

public class AiFactory {
  public static Ai createAi(String difficulty) {
    switch (difficulty) {
      case "easy":
        return new EasyAi();
    }
    return null;
  }
}
