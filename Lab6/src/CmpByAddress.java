import java.util.Comparator;

public class CmpByAddress implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.homeAddress.compareTo(o2.homeAddress);
	}

}
