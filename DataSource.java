import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSource {

  public static Stream<String> getDatafromFiles(String file1, String file2) {

    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    try (Stream<String> stream = Files.lines(Paths.get(file1))) {
      list1 = stream.collect(Collectors.toList());
    } catch (IOException e) {
      e.getMessage();
    }

    try (Stream<String> stream = Files.lines(Paths.get(file2))) {
      list2 = stream.collect(Collectors.toList());
    } catch (IOException e) {
      e.getMessage();
    }
    Stream<String> mergedList = Stream.concat(list1.stream(), list2.stream());
    return mergedList;
  }
}