package ms0.a1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Tokenizer tok = new Tokenizer ("     A     42  Epsilon   Q 16  tее    ragag ");
Tokenizer tok1 = new Tokenizer ("Informatik +        Uni     2020");
Tokenizer tok2 = new Tokenizer (" Y     2093482 AA vmxv                                 afe --1");
String[] s = new String[3];
Tokenizer[] tokArray = new Tokenizer[3];
tokArray[0]=tok;
tokArray[1]=tok1;
tokArray[2]=tok2;
System.out.println("Funktionalitaet der Methoden next() und done() anschaulich 3 Beispielen:");
while (!tok.done() || !tok1.done() || !tok2.done()){
	for(int i = 0; i < 3; i++){
			if(!tokArray[i].done()) {                  
				s[i] = tokArray[i].next();} else {              
					s[i] = String.valueOf(tokArray[i].done());
				}
}
	
System.out.printf("%-30s %-30s %-30s\n", s[0], s[1], s[2]);

}
}


}

