public class Person{
//	private char z;
	private int id;
	private int age = 20;
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int Age){
		age = Age;
	}
	
	public int getId(){
		return id;
	}
	
	Person(int i, int j, int k){
		
	}
	
	Person(int _id, int _age){
		id = _id;
		age = _age;
		
	}
//	public void testCharZero(){
//		System.out.println("1"+z+"2");
//	}
}