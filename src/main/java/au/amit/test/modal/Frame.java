package au.amit.test.modal;

public class Frame {

	private int firstBall;
	
	private int secondBall;
	
	private Frame previous;
	
	private Frame next;
	
	private int calculatedScore = 0;
	
	public Frame getPrevious() {
		return previous;
	}


	public void setPrevious(Frame previous) {
		this.previous = previous;
	}


	public Frame getNext() {
		return next;
	}


	public void setNext(Frame next) {
		this.next = next;
	}

	public int getCalculatedScore() {
		return calculatedScore;
	}


	public void setCalculatedScore(int calculatedScore) {
		this.calculatedScore = calculatedScore;
	}

	public int getFirstBall() {
		return firstBall;
	}

	public void setFirstBall(int firstBall) {
		this.firstBall = firstBall;
	}

	public int getSecondBall() {
		return secondBall;
	}

	public void setSecondBall(int secondBall) {
		this.secondBall = secondBall;
	}

	public int getScore() {
		return firstBall + secondBall;
	}

	public boolean isStrike() {
		return (firstBall == 10);
	}
	
	public boolean isSpare() {
		return ((firstBall + secondBall) == 10 && !isStrike());
	}
	
}
