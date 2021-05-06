package newfeatures;

import java.util.Optional;

/**
 * Optional allows to check whether a variable has null value or not and by
 * doing this we can avoid the NullPointerException.
 * 
 * An Optional may either contain a non-null T reference (in which case we say
 * the reference is “present”), or it may contain nothing (in which case we say
 * the reference is “absent”)
 * 
 * You can also view Optional as a single-value container that either contains a
 * value or doesn’t.
 * 
 * It's purpose is to help design more-comprehensible APIs
 * 
 * @author Gustavo
 *
 */
public class F6_Optional {

	public static void main(String[] args) {
		F6_Optional f6 = new F6_Optional();
		f6.simpleSample();
		f6.createOptional();
		f6.defaultAbsentValues();
		f6.rejectingValues();
	}

	private void simpleSample() {
		Optional<Integer> canBeEmtpty1 = Optional.of(5);
		System.out.println(canBeEmtpty1.isPresent());
		System.out.println(canBeEmtpty1.get());

		Optional<Integer> canBeEmpty2 = Optional.empty();
		System.out.println(canBeEmpty2.isPresent());
	}

	private void createOptional() {
		// 1. Optional.empty() to create an empty optional
		Optional<Integer> possible = Optional.empty();

		// 2. Optional.of() create optional with default non-null value. If you pass
		// null in of(), then a NullPointerException
		possible = Optional.of(5);

		// 3. Optional.ofNullable() - may hold a null value. If null, resulting Optional
		// object would be empty (don’t read it null)
		possible = Optional.ofNullable(null);
		possible = Optional.ofNullable(10);

	}

	private void whenValuePresent() {
		// once you got your optional object
		Optional<Integer> possible = Optional.of(5);

		// check whether it holds any value inside it.
		possible.ifPresent(System.out::println);
		// empty, nothing would be printed

		// You can do the following but it's not recommended because it’s not much of an
		// improvement over nested null checks
		// if(possible.isPresent()) {
		// System.out.println( possible.get() );
		// }
	}

	private void defaultAbsentValues() {
		class Company {}
		// Assuming this value has returned from a method
		Optional<Company> companyOptional = Optional.empty();

		// Check Optional; if value is present, returned, else create a new Company
		// object and return it.
		Company company = companyOptional.orElse(new Company());
		
		// Or you can throw an exception as well
		Company company2 = companyOptional.orElseThrow(IllegalStateException::new);
	}
	
	private void rejectingValues() {
		class Company{
			public String getName() {
				return "Accounting";
			}
		}
		Optional<Company> companyOptional = Optional.empty();
		
		companyOptional
		.filter(d-> "Finance".equals( d.getName()) );
		//.ifPresent( ()-> System.out.println("") );

		
	}
}