import java.util.HashSet;
import java.util.List;

public class DoesCollectionContainDuplicates {

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

        boolean containsDuplicates = new HashSet<>(data).size() != data.size();

        System.out.println(data);
        System.out.println("Does the collection contain duplicates? Answer: " + containsDuplicates);
    }

}
