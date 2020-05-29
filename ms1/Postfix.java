package ms1;

import java.math.BigDecimal;
import ms0.a1.Tokenizer;
import java.util.Stack;
import static ms1.Mathcore.*;

public class Postfix {
    String[] tokens = new String[0];
    static Stack<BigDecimal> stack = new Stack<BigDecimal>();

    public static String eval(String eingabe) {
        Tokenizer tok = new Tokenizer(eingabe);
        while (!tok.done()) {
            String s = tok.next();
            if ('0' <= s.charAt(0) && s.charAt(0) <= '9') {
                stack.push(new BigDecimal (s, mc));
            } else if (s.equals("+")) {
                stack.push(add(stack.pop(), stack.pop()));
            } else if (s.equals("-")) {
                stack.push(sub(stack.pop(), stack.pop()));
            } else if (s.equals("*")) {
                stack.push(mul(stack.pop(), stack.pop()));
            } else if (s.equals("/")) {
                try {
                    stack.push(div(stack.pop(), stack.pop()));
                } catch (ArithmeticException ex) {
                    return ex.getMessage();
                }
            } else if (s.equals("!")) {
                try {
                    stack.push(fak(stack.pop()));
                } catch (ArithmeticException ex) {
                    return ex.getMessage();
                }
            }
        }
        return (stack.pop().round(mc_out)).toString();
    }
}








