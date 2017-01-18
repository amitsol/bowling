package au.amit.test.service;

import java.util.ArrayList;
import java.util.List;

import au.amit.test.modal.Frame;

public class ScoreCalculator {
	
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int calculate(String input) {
		int score = 0;
		
		List<Frame> frames = createFrames(input);
		
		for (int i = 0; i < frames.size(); i++) {
			
			Frame frame = frames.get(i);
			
			frame.setCalculatedScore(frame.getScore());
			
			if(i <= 10 ) {
			
				if(frame.getPrevious() != null) {
					if(frame.isStrike() && frame.getPrevious().isStrike()) {
						if(frame.getPrevious().getPrevious() != null) {
							frame.getPrevious().getPrevious().setCalculatedScore(30);
						}
					} else {
						if(frame.getPrevious().isStrike()) {
							frame.getPrevious().setCalculatedScore(frame.getPrevious().getScore() + frame.getScore());
						}
						if(frame.getPrevious().isSpare()) {
							frame.getPrevious().setCalculatedScore(frame.getPrevious().getScore() + frame.getFirstBall());
						}
					}
				}
			}
		}
		
		for (Frame frame : frames) {
			score = score + frame.getCalculatedScore();	
			System.out.println(score);
		}
		
		return score;
	}
	
	private List<Frame> createFrames(String input) {
		
		String[] tokens = input.split(" ");
		
		List<Frame> retVal = new ArrayList<>();
		
		Frame previous = null;
		
		try {
			
			for (int i = 0; i < tokens.length; i++) {
				int firstBall = Integer.valueOf(tokens[i]);
				Frame frame = new Frame();
				retVal.add(frame);
				frame.setFirstBall(firstBall);
				if(previous != null) {
					previous.setNext(frame);
					frame.setPrevious(previous);
				}
				
				previous = frame;
				if(firstBall == 10) {
					continue;
				}
				int secondBall = Integer.valueOf(tokens[i + 1]);
				frame.setSecondBall(secondBall);
				i++;
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Input is in wrong format");
		}
		
		
		return retVal;
	}
	

}
