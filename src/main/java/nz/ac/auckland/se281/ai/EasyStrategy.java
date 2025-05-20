package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.model.Colour;

public class EasyStrategy implements DifficultyStrategy {
    Colour[] chosenColours;


    
    @Override
    public Colour[] pickColour() {

        chosenColours[0] = Colour.getRandomColourForAi();
        chosenColours[1] = Colour.getRandomColourForAi();
        return chosenColours;
        
    }
}
