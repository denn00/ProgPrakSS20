package ms0.a2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args) {
		
		BigDecimal a = new BigDecimal("1"), b = new BigDecimal("5"), c = new BigDecimal("2");
		MathContext mc = new MathContext(30, RoundingMode.HALF_UP);
		BigDecimal result = a.add(b.sqrt(mc), mc).divide(c, mc);
	    System.out.println(result.toString());
	    System.out.println("Unskaliertes Wert: "+result.unscaledValue());
	    System.out.println("Skalierung: "+result.scale());
	}

}
