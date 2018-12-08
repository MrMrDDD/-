package demofanshe;

public class demo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		1拿到类名
		Class c1=Person.class;
		Class c2=new Person().getClass();
		Class c3=Class.forName("demofanshe.Person");
		Person p1=(Person) c3.newInstance();

	}

}
