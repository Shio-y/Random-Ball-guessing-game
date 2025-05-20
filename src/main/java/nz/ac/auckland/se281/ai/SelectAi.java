package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.model.Colour;


public class SelectAi {
    protected Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public Colour[] execute(){
        return strategy.getColours();

    }
}
