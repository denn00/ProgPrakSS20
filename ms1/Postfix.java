package ms1;

import java.math.BigDecimal;
import ms0.a1.Tokenizer;
import java.util.EmptyStackException;
import java.util.Stack;
import static ms1.Mathcore.*;
import java.lang.Exception;

public class Postfix {

    static Stack<BigDecimal> stack = new Stack();

    public static String eval(String eingabe) throws Exception {
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
                try {
                    stack.push(add(stack.pop(), stack.pop()));
                } catch (EmptyStackException e){
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("-")) {
                try {
                    stack.push(sub((stack.pop()), stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("*")) {
                try {
                    stack.push(mul((stack.pop()), stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("/")) {
                try {
                    stack.push(div(stack.pop(), stack.pop()));
                } catch (ArithmeticException ex) {
                    return ex.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("!")) {
                try {
                    stack.push(fak(stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("exp")){
                try {
                    stack.push(exp(stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("ln")) {
                try {
                    stack.push(ln(stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
                } else if (s.equals("lg")) {
                try {
                    stack.push(lg(stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("log")){
                    try {
                        stack.push(log(stack.pop(),stack.pop()));
                    } catch (ArithmeticException e) {
                        return e.getMessage();
                    } catch (EmptyStackException e) {
                        return "Kein sinnvoller Ausdruck";
                    }
            } else if (s.equals("^")) {
                try {
                    stack.push(pot(stack.pop(), stack.pop()));
                } catch (ArithmeticException e) {
                    return e.getMessage();
                }
            } else if (s.equals("root")) {
                try {
                    stack.push(root(stack.pop(), stack.pop()));
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if(s.equals("sqrt")){
                try {
                    stack.push(sqrt(stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("sin")){
                try{
                    stack.push(sin(stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("cos")){
                try{
                    stack.push(cos(stack.pop()));
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            } else if (s.equals("tan")) {
                try {
                    stack.push(tan(stack.pop()));
                } catch (ArithmeticException e){
                    return e.getMessage();
                } catch (EmptyStackException e) {
                    return "Kein sinnvoller Ausdruck";
                }
            }
        }
        if (tok.done() && stack.size()!=1) {
            stack.clear();
            String s = "Ausdruck ist fehlerhaft";
            return s;
        }
        return (stack.pop().round(mc_out)).toString();
    }
    /*Hilfsmethode*/
    public static boolean isNumber(String string) {
        try {
            BigDecimal test = new BigDecimal(string,mc);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}








