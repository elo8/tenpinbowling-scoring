package com.acme.rooster;

import java.util.ArrayList;


/**
 * Created by LoE on 31/01/2017.
 */
public class Frame {
    public static final int TEN_PINS_BOWLING = 10;
    //status can be strike, spare or normal

    public enum Status {
        UNKNOWN,
        STRIKE,
        SPARE,
        NORMAL_PLAY
    }
    ArrayList<Integer> bowls = new ArrayList<Integer>(2);
    Status playStatus = Status.UNKNOWN;
    boolean isCompleted = false;
    int score = 0;

    public Frame(Status playStatus) {
        //no-args
        this.playStatus = playStatus;
    }

    public Frame(Integer firstBowl, Integer secondBowl, Status playStatus) {
        bowls.add(firstBowl);
        bowls.add(secondBowl);
        this.playStatus = playStatus;
    }

    public void addBowl(Integer pins) {
        bowls.add(pins);
        //check if 2 have been completed

        if (bowls.size() == 1) {
            if (bowls.get(0).intValue() == TEN_PINS_BOWLING) {
                //STRIKE
                this.playStatus = Status.STRIKE;
                bowls.add(0);
                this.isCompleted = true;
            } else {
                this.playStatus = Status.NORMAL_PLAY;
                this.isCompleted = false;
            }
        } else {
            if ( bowls.get(0) != null && bowls.get(1) != null) {
                //frame is complete
                this.isCompleted = true;
                if ((bowls.get(0).intValue() + bowls.get(1).intValue()) == TEN_PINS_BOWLING) {
                    //
                    this.playStatus = Status.SPARE;
                } else {
                    this.playStatus = Status.NORMAL_PLAY;
                }
            }
        }


    }

    public Integer getFirstBowl() {
        return bowls.get(0);
    }

    public Integer getSecondBowl() {
        return bowls.get(1);
    }

    public void addFirstBowl(Integer firstBowl) {
        bowls.add(0, firstBowl);
    }

    public void addSecondBowl(Integer secondBowl) {
        bowls.add(1, secondBowl);
    }

    public Status getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(Status playStatus) {
        this.playStatus = playStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "bowls=" + bowls +
                ", playStatus=" + playStatus + "}";
    }
}

