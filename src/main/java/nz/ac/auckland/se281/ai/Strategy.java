package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.engine.Player;
import nz.ac.auckland.se281.model.Colour;

public interface Strategy {
    Colour[] getColours(Player currentPlayer);

    
        
    
}