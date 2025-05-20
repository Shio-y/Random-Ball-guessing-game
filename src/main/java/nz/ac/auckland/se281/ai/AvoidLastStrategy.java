package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.model.Colour;


public class AvoidLastStrategy implements Strategy {
    
    public static Colour getGuessColour(Colour previousPlayerGuess){

        return Colour.getRandomColourExcluding(previousPlayerGuess);
    }

    @Override
    public Colour[] getColours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColours'");
    }
}
