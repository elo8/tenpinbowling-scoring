package com.acme.rooster;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GameTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GameTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GameTest.class );
    }

    /* TESTS:
    TC = Test Case
    TC1: "1 2 3 4" -> 10
    TC2: "9 1 9 1" -> 29
    TC3: "1 1 1 1 10 1 1" -> 18
    TC4: "10 10 10 10 10 10 10 10 10 10 10 10" -> 300
     */

    public void testScoreTC1()
    {
        Game bowling = new Game();
        String inputs = "1 2 3 4";
        bowling.init(inputs);
        bowling.calculateScore();

        int expectedScore = 10;

        assertEquals(expectedScore, bowling.getTotalScore().intValue());
    }

    public void testScoreTC2()
    {
        Game bowling = new Game();
        String inputs = "9 1 9 1";
        bowling.init(inputs);
        bowling.calculateScore();

        int expectedScore = 29;

        assertEquals(expectedScore, bowling.getTotalScore().intValue());
    }

    public void testScoreTC3()
    {
        Game bowling = new Game();
        String inputs = "1 1 1 1 10 1 1";
        bowling.init(inputs);
        bowling.calculateScore();

        int expectedScore = 18;

        assertEquals(expectedScore, bowling.getTotalScore().intValue());
    }

    public void testScoreTC4()
    {
        Game bowling = new Game();
        String inputs = "10 10 10 10 10 10 10 10 10 10 10 10";
        bowling.init(inputs);
        bowling.calculateScore();

        int expectedScore = 300;

        assertEquals(expectedScore, bowling.getTotalScore().intValue());
    }


}
