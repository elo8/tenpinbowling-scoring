package com.acme.rooster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by elo80 on 2/02/2017.
 */
public class Game {
    public static final int MAX_INPUT_SIZE = 22;
    private Frame[] frames = new Frame[10]; //a game consists of 10 frames
    ArrayList<Integer> bonusBowls = new ArrayList<Integer>(2);
    private Integer totalScore = 0; //total score of all the frames

    public Integer getTotalScore() {
        return totalScore;
    }

    //todo: add validation for the inputs to ensure they're valid scores for a ten pin bowling game
    //fail early if the inputs are invalid
    public void init(String inputs) {

        //todo validate the inputs
        //e.g. max 20 items plus 2 potential bonus, anymore than that disregard the rest.

        StringTokenizer st = new StringTokenizer(inputs);

        Integer[] inputArray = new Integer[MAX_INPUT_SIZE];
        int index = 0;
        while (st.hasMoreTokens()) {
            if (index > MAX_INPUT_SIZE) {
                break;
            }
            inputArray[index] = Integer.valueOf(st.nextToken());
            index++;
        }

        //at this point we have inputs in integer array
        System.out.println("Our Inputs have been transformed to array of integers as follow:");
        System.out.println(Arrays.toString(inputArray));


        int currentFrame = 0;

        int i = 0;
        while(i < inputArray.length) {

            if (currentFrame < 10) {
                if (frames[currentFrame] == null) {
                    frames[currentFrame] = new Frame(Frame.Status.UNKNOWN);
                }

                if (inputArray[i] != null) {
                    frames[currentFrame].addBowl(inputArray[i]);

                } else {
                    frames[currentFrame].addBowl(0);
                }

                if (frames[currentFrame].isCompleted) {
                    currentFrame++;
                }
            } else {
                //todo: add validation to ensure the extra bowls are allowed
                //based on the last frame's status, if strike then add 2, if  spare then add 1
                if (inputArray[i] != null) {
                    bonusBowls.add(inputArray[i]);
                }
            }
            i++;

        }

        for (Frame f : frames) {
            System.out.println(f);
        }

        System.out.println("Bonus Bowls: " + bonusBowls.toString());

    }

    public void calculateScore() {
        //can only be invoked after init() when all the game structure has been setup
        //when it detects strike or spare it will get the bowl results from the next frame.
        int runningScore=0;

        for (int i=0; i < frames.length; i++) {
            if (frames[i].getPlayStatus() == Frame.Status.STRIKE) {
                runningScore += frames[i].getFirstBowl();

                if (i+2 < frames.length) { //avoid index out of bounds

                    if (frames[i+1].getPlayStatus() != Frame.Status.STRIKE) {
                        runningScore += frames[i+1].getFirstBowl() + frames[i+1].getSecondBowl();
                    } else {
                        runningScore += frames[i+1].getFirstBowl() + frames[i+2].getFirstBowl();
                    }

                } else if (i == 8) {
                    runningScore += frames[9].getFirstBowl() + bonusBowls.get(0);
                } else if (i==9) {
                    runningScore += bonusBowls.get(0) + bonusBowls.get(1);
                }

            } else if (frames[i].getPlayStatus() == Frame.Status.SPARE) {
                //figure out next bowl score
                runningScore += frames[i].getFirstBowl() + frames[i].getSecondBowl(); //+ frames[i+1].getFirstBowl();
                if (i+1 < frames.length) {
                    runningScore += frames[i+1].getFirstBowl();
                }
            } else if (frames[i].getPlayStatus() == Frame.Status.NORMAL_PLAY) {
                //just sum it up
                runningScore += frames[i].getFirstBowl() + frames[i].getSecondBowl();
            } else {
                //unknown=> nothing to do
            }
        }

        totalScore += runningScore;


        /*
        "1 2 3 4" -> 10
"9 1 9 1" -> 29
"1 1 1 1 10 1 1" -> 18
"10 10 10 10 10 10 10 10 10 10 10 10" -> 300

6 2 7 1 10 9 0
         */

    }

}
