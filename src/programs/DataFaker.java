package programs;
import net.datafaker.Faker;
public class DataFaker {

	public static void main(String[] args) {
		
		Faker  faker = new Faker ();
		String  firstname	= faker.name().malefirstName();
		String lastname  = faker.name().lastName();
		String emailString =faker.address().fullAddress();
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(emailString);
			
			
	}
	
}

