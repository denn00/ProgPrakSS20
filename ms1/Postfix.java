package ms1;

import java.math.BigDecimal;
import ms0.a1.Tokenizer;
import ms0.a0.Stack;
import static ms1.Mathcore.*;
import java.lang.Exception;

public class Postfix {

    static Stack stack = new Stack();

    public static String eval(String eingabe) throws Exception {
        Tokenizer tok = new Tokenizer(eingabe);
        while (!tok.done()) {
            String s = tok.next();
            if ('0' <= s.charAt(0) && s.charAt(0) <= '9') {
                stack.push((new BigDecimal(s, mc)).toString());
            } else if (s.equals("e")) {
                stack.push((new BigDecimal(E, mc)).toString());
            } else if (s.equals("pi")) {
                stack.push((new BigDecimal(PI, mc)).toString());
            } else if (s.equals("+")) {
                stack.push(add(new BigDecimal(stack.pop()), new BigDecimal(stack.pop())).toString());
            } else if (s.equals("-")) {
                stack.push(sub(new BigDecimal(stack.pop()), new BigDecimal(stack.pop())).toString());
            } else if (s.equals("*")) {
                stack.push(mul(new BigDecimal(stack.pop()), new BigDecimal(stack.pop())).toString());
            } else if (s.equals("/")) {
                try {
                    stack.push(div(new BigDecimal(stack.pop()), new BigDecimal(stack.pop())).toString());
                } catch (ArithmeticException ex) {
                    return ex.getMessage();
                }
            } else if (s.equals("!")) {
                try {
                    stack.push(fak(new BigDecimal(stack.pop())).toString());
                } catch (Exception e) {
                    return e.getMessage();
                }
            }else if (s.equals("exp")){
                stack.push(exp(new BigDecimal(stack.pop())).toString());
            }
        }
        return (new BigDecimal(stack.pop()).round(mc_out)).toString();
    }
}








