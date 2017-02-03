package com.acme.rooster;

/**
 * Simple CLI based Java application that calculate what would be the ten pin bowling score given an array of integers which represents the bowling pins.
 * Example:
    "1 2 3 4" -> 10
    "9 1 9 1" -> 29
    "1 1 1 1 10 1 1" -> 18
    "10 10 10 10 10 10 10 10 10 10 10 10" -> 300
 *See README.txt for the approach for the implemented solution
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println("Score inputs: " + args[0]);
        Game game = new Game();
        game.init(args[0]); //init will setup frames and bowls
        game.calculateScore(); //calculate is assumed to be called after the game has been initialised
        System.out.println("Total score: " + game.getTotalScore());


    }
}
