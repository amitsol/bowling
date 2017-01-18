package au.amit.test.app;

import au.amit.test.service.ScoreCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        String input = "9 1 9 1";
        ScoreCalculator calc = new ScoreCalculator();
        int score = calc.calculate(input);
        System.out.println(String.format("Score for \"%1$s\" is %2$s ", input, score) );
    }
}
