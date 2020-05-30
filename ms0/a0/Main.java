package ms0.a0;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Stack s = new Stack ();
s.push("1");
s.push("2");	
s.push("3");	
s.push("4");	
s.push("5");	
s.print();
System.out.println("");
System.out.println("Das oberste Element vom Stapel: " + s.pop());
s.print();
System.out.println("");
System.out.println("Das oberste Element vom Stapel: " + s.peek());
s.print();
System.out.println("");
System.out.println("Anzahl der Elemente im Stapel " + s.size());

}


}
