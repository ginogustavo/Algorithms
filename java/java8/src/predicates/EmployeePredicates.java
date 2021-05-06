package predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

	public static Predicate<Employee> isAdult() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Employee> isAdultFemale() {
		return e -> e.getAge() > 18 && e.getGender().equalsIgnoreCase("F");

	}

	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return e -> e.getAge() > age;
	}

	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {

		return employees.stream()
				.filter(predicate)
				.collect(Collectors.<Employee>toList());

	}

}
