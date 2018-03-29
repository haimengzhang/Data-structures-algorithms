import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserExercises extends DBTable<User> {
    UserExercises() {
    }

    UserExercises(Collection<User> lst) {
        super(lst);
    }

    /**
     * Get an ordered List of Users, sorted first on age,
     * then on their id if the age is the same.
     */
    public List<User> getOrderedByAgeThenId() {
        List<User> myinput = entries;
        return myinput.stream()
                .sorted((o1, o2) -> o1.getAge() == o2.getAge()?
                Integer.compare(o1.getId(), o2.getId()):
                Integer.compare(o1.getAge(), o2.getAge()))
                .collect(Collectors.toList());

// FIX ME
    }

    /**
     * Get the average age of all the users.
     * If there are no users, the average is 0.
     */
    public double getAverageAge() {
        List <User> myinput = entries;
        return (double) myinput.stream()
                .mapToInt(o1 -> o1.getAge())
                .average()
                .orElse(0);
        // FIX ME
        // HINT: You may find an IntStream helpful 
    }

    /**
     * Group usernames by user age, for all users that have an age greater than min_age.
     * Usernames with ages less than or equal to min_age are excluded.
     * Returns a Map from each age present to a list of the usernames that have that age.
     */
    public Map<Integer, List<String>> groupUsernamesByAgeOlderThan(int min_age) {
        List <User> myinput = entries;
        return myinput.stream()
                .filter(o1 -> o1.getAge() > min_age)
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getUsername, Collectors.toList())));
                // FIX ME
        // HINT: See the Additional Examples for a helpful Collector
        // HINT2: You will need to use Collectors.mapping. See the Javadocs for examples
    }
}
