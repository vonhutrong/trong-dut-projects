package java_programing_english_version.exercise;

public class Fraction {
	private long numerator;
	private long denominator;
	
	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	public Fraction(long number) {
		numerator = number;
		denominator = 1;
	}

	public Fraction(long numerator, long denominator) throws IllegalArgumentException{
		this.numerator = numerator;
		this.denominator = denominator;
		checkDenominator();
		compact();
	}
	
	private void checkDenominator() throws IllegalArgumentException{
		if (denominator == 0)
			throw new IllegalArgumentException("Denominator shoud not equal zero");
	}
	
	public Fraction add(Fraction fractionB) {
		numerator = numerator * fractionB.getDenominator() + fractionB.getNumerator() * denominator;
		denominator = denominator * fractionB.getDenominator();
		compact();
		return this;
	}
	
	public Fraction sub(Fraction fractionB) {
		return this.add(new Fraction(-fractionB.getNumerator(), fractionB.getDenominator()));
	}
	
	public Fraction mul(Fraction fractionB) {
		numerator *= fractionB.getNumerator();
		denominator *= fractionB.getDenominator();
		compact();
		return this;
	}
	
	public Fraction divide(Fraction fractionB) throws IllegalArgumentException {
		if (fractionB.getNumerator() == 0)
			throw new IllegalArgumentException("Can not divide by zero");
		return this.mul(new Fraction(fractionB.getDenominator(), fractionB.getNumerator()));
	}
	
	public void compact() {
		long absoluteNumerator = Math.abs(numerator);
		long absoluteDenominator = Math.abs(denominator);
		long greatestCommonDivisor;
		
		if (absoluteNumerator == 0 || absoluteDenominator == 0) {
			greatestCommonDivisor = absoluteNumerator + absoluteDenominator;
		} else {
			while (absoluteNumerator != absoluteDenominator) {
				if (absoluteNumerator > absoluteDenominator)
					absoluteNumerator -= absoluteDenominator;
				else
					absoluteDenominator -= absoluteNumerator;
			}
			greatestCommonDivisor = absoluteDenominator;
		}
		
		numerator /= greatestCommonDivisor;
		denominator /= greatestCommonDivisor;
	}
	
	public double toRealNumber() {
		return (float) numerator / denominator;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
}
