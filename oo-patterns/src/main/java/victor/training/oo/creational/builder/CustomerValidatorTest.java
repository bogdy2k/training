package victor.training.oo.creational.builder;

import org.junit.Test;

public class CustomerValidatorTest {

	private CustomerValidator validator = new CustomerValidator();
	
	@Test
	public void validCustomer_ok() {
		// INITIAL(
//		validator.validate(new CustomerBuilder()
//			.withName("John Doe")
//			.withAddress(new AddressBuilder()
//					.withStreetName("Viorele")
//					.withCity("Bucharest")
//					.build())
//			.build());
		// INITIAL)
		validator.validate(aValidCustomer().build()); // SOLUTION
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void customerWithoutName_fails() {
		validator.validate(aValidCustomer().withName(null).build()); // SOLUTION
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void customerWithoutAddress_fails() {
		validator.validate(aValidCustomer().withAddress((Address)null).build()); // SOLUTION
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void customerWithoutAddressCity_fails() {
		validator.validate(aValidCustomer().withAddress(aValidAddress().withCity("")).build()); // SOLUTION
	}

	// SOLUTION(
	private CustomerBuilder aValidCustomer() {
		return new CustomerBuilder()
				.withName("John Doe")
				.withAddress(aValidAddress());
	}

	private AddressBuilder aValidAddress() {
		return new AddressBuilder()
				.withStreetName("Viorele")
				.withCity("Bucharest");
	} 	// SOLUTION)
}