package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.cli.Utils;

public class Interact {

    public static String readStringInput(){
        //this reads the next line inputted by the user.
        String placeholder = Utils.scanner.nextLine().toString();
        return placeholder;
    }
    
}
