package ms0.a1;

public class Tokenizer {
	public Tokenizer(String st) {    //Initialisiert die Instanz mit einem zu verarbeitenden String
		this.st=st;
		stringparse();
	}
String[] strArray = new String [0];	
private String st;
	private void stringparse() {      //Hilfsmethode: untersucht den eingegebenen String und findet Tokens
	  String substring = new String();
      boolean writinWord = false;    //"Flagge": entscheidet ob man am Anfang (bzw. am Ende) des Tokens angekommen ist   
      for(int i=0; i<st.length(); i++) {

          if(st.charAt(i) !=' ') {           //Solange man kein Leerzeichen trifft, speichert man das Token elementenweise 
              substring += st.charAt(i);    //in neuen String und fuegt es schon als ganzes Wort, nachdem man  
              writinWord = true;            //den ganzen String durchgegangen ist, zu einem Array, das ausgegeben wird, hin.
              if(i == st.length() - 1)
              {
                  strArray=add(substring);
                  substring = "";       //Substring wird geloesht
              }
          }
          
          if (st.charAt(i) ==' ' && writinWord){  //Wenn man ein Leerzeichen trifft und am Ende des Tokens steht, dann wird
              strArray=add(substring);            //das Token ausgegeben.
              substring = "";
              writinWord = false;
          }
      }
	}
	private String[] add(String it) {
		String[] strArray1 = new  String [strArray.length+1];
		for (int i = 0; i < strArray.length; i++) {
			strArray1[i]=strArray[i];
		}
		strArray1[strArray1.length-1]=it;
		return strArray1;
	}
	public void print() {                       //Eigene Hilfsmethode zum Ueberprufen: gibt Tokens in die Konsole aus
		for (int i = 0; i < strArray.length; i++){
			System.out.println(strArray[i]);
		}
	}
	public boolean done() {
		if (strArray.length==0)
			return true;
		return false;
	}
	public String next () {
		if ( strArray.length>0) {
				String buf = strArray[0];
		strArray=delete();
		return buf;
		}
		return null;
		
	}
	private String[] delete() {
		String[] strArray1 = new  String [strArray.length-1];
		for (int i=0; i<strArray1.length; i++) {
			strArray1[i]=strArray[i+1];
		}
		return strArray1;
	}
}
