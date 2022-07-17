import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesByCollectionsFrequency {

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

        Set<String> duplicates = data.stream()
                .filter(item -> Collections.frequency(data, item) > 1)
                .collect(Collectors.toSet());

        System.out.println("Found duplicates: " + duplicates);
    }

}
