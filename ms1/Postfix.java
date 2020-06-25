package ms1;

import java.math.BigDecimal;
import ms0.a1.Tokenizer;
import java.util.Stack;
import static ms1.Mathcore.*;
import java.lang.Exception;

public class Postfix {

    static Stack<BigDecimal> stack = new Stack();

    public static String eval(String eingabe) {
        Tokenizer tok = new Tokenizer(eingabe);
        while (!tok.done()) {
            String s = tok.next();
            if (isNumber(s)) {
                stack.push((new BigDecimal(s, mc)));
            } else if (s.equals("e")) {
                stack.push((new BigDecimal(E, mc)));
            } else if (s.equals("pi")) {
                stack.push((new BigDecimal(PI, mc)));
            } else if (s.equals("-e")) {
                stack.push((new BigDecimal(E, mc)).negate());
            } else if (s.equals("-pi")) {
                stack.push((new BigDecimal(PI, mc)).negate());
            } else if (s.equals("+")) {
                stack.push(add(stack.pop(), stack.pop()));
            } else if (s.equals("-")) {
                stack.push(sub((stack.pop()), stack.pop()));
            } else if (s.equals("*")) {
                stack.push(mul((stack.pop()), stack.pop()));
            } else if (s.equals("/")) {
                try {
                    stack.push(div(stack.pop(), stack.pop()));
                } catch (ArithmeticException ex) {
                    return ex.getMessage();
                }
            } else if (s.equals("!")) {
                try {
                    stack.push(fak(stack.pop()));
                } catch (Exception e) {
                    return e.getMessage();
                }
            } else if (s.equals("exp")){
                stack.push(exp(stack.pop()));
            } else if (s.equals("ln")) {
                try {
                    stack.push(ln(stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                }
            } else if (s.equals("^")) {
                try {
                    stack.push(pot(stack.pop(), stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                }
            } else if (s.equals("root")){
                try {
                    stack.push(root(stack.pop(),stack.pop()));
                } catch (IllegalArgumentException e){
                    return e.getMessage();
                }
            } else if (s.equals("sin")){
                stack.push(sin(stack.pop()));
            } else if (s.equals("cos")){
                stack.push(cos(stack.pop()));
            } else if (s.equals("tan")) {
                try {
                    stack.push(tan(stack.pop()));
                } catch (ArithmeticException e){
                    return e.getMessage();
                }
            }
        }
        return (stack.pop().round(mc_out)).toString();
    }
    public static boolean isNumber(String string) {
        try {
            BigDecimal test = new BigDecimal(string,mc);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}








