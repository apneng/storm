package storm;

public class Test09Main {
	public static void main(String[] args) {
		Test09Factory t09f = new Test09Factory();
		
		Test09 t91 = t09f.get09("test091");
		t91.draw();
		
		Test09 t92 = t09f.get09("test092");
		t92.draw();
		
		Test09 t93 = t09f.get09("test093");
		t93.draw();
	}

}
