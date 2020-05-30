package ms0.a0;

public class Stack {
	String[] strArray = new String [0];
public Stack() {
	
}
public void push(String item) {         //liegt ein Element auf den Stapel
    strArray=add(item);

}
private String[] add(String it) {                                                 
	String[] strArray1 = new  String [strArray.length+1];  //Hilfsmethode: erzeugt ein neues Array und fuegt neues Element,  
	for (int i = 0; i < strArray.length; i++) {            //das der Methode push uebergegeben war, am Ende hinzu 
		strArray1[i]=strArray[i];
	}
	strArray1[strArray1.length-1]=it;
	return strArray1;
}

public String peek () {                   //gibt das letzte Element vom Stapel aus
	return strArray[strArray.length-1];
}
public int size () {                    //Berechnet Stapelgroesse
	return strArray.length;
}
public String pop() {                  //Gibt null aus, falls keine Elemente mehr im Stapel sind
	if (strArray.length==0) {          //Gibt das letzte Element zurueck und laest der Methode delete() das Array verkuerzen, sonst
		return null;
	}
	String buf = strArray[strArray.length-1];
	strArray=delete();
	return buf;
	
}
public void print() {            //Hilfsmethode: gibt Stack in die Konsole aus 
	System.out.print("Stack: ");
	for (int i=0; i<strArray.length; i++) {
		System.out.print(strArray[i]+" ");
	}
}
private String[] delete() {                  //Hilfsmethode: erzeugt neues Array der Laenge um 1 kuerzer und kopiert 
	String[] strArray1 = new  String [strArray.length-1];   //alle Element ausser letztes
	for (int i=0; i<strArray1.length; i++) {
		strArray1[i]=strArray[i];
	}
	
	return strArray1;
}
}



