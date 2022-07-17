import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesBySet {

    public static void main(String[] args) {
        List<String> data = List.of(
                "Lexus",
                "Lexus",
                "BMW",
                "Toyota",
                "Toyota",
                "Porsche",
                "Audi",
                "Ferrari"
        );

        // From docs of Set.add(): true if this set did not already contain the specified element
        Set<String> container = new HashSet<>();
        Set<String> duplicates = data.stream()
                .filter(item -> !container.add(item))
                .collect(Collectors.toSet());

        System.out.println("Found duplicates: " + duplicates);
    }

}
