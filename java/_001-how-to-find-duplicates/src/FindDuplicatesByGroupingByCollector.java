import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicatesByGroupingByCollector {

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

        // Grouped elements
        Map<String, List<String>> grouped = data.stream()
                .collect(Collectors.groupingBy(Function.identity()));
        System.out.println("Grouped: " + grouped);

        // Grouped and counted
        Map<String, Long> counted = data.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Elements count: " + counted);

        // Counted duplicates
        Map<String, Long> duplicates = data.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Duplicates: " + duplicates);
    }

}