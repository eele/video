package a;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path2 = Thread.currentThread().getContextClassLoader().getResource("\\").getPath();  
		System.out.println("path2 = " + path2);  
	}

}
