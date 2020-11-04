import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String args[]) throws IOException {

    try {
      List<String> mergedList = DataSource.getDatafromFiles("file1.txt", "file2.txt").collect(Collectors.toList());

      // store merged file input into Person Object
      List<Person> personList = new ArrayList<Person>();
      for (int i = 0; i < mergedList.size(); i++) {
        String lastName = mergedList.get(i).split("\t")[0];
        String firstName = mergedList.get(i).split("\t")[1];
        int age = Integer.parseInt(mergedList.get(i).split("\t")[2]);
        Person newPerson = new Person(lastName, firstName, age);
        newPerson.setLastName(lastName);
        newPerson.setFirstName(firstName);
        newPerson.setAge(age);
        personList.add(newPerson);
      }

      // sort By last name
      Comparator<Person> byLName = Comparator.comparing(Person::getLastName);
      Collections.sort(personList, byLName);

      // find first name duplicate count
      final long duplicates = personList.stream().filter(firstName -> Collections.frequency(personList, firstName.getFirstName()) > 1).distinct()
          .count();
      System.out.println("duplicates: "+duplicates);

      // find avg age
      final double average =  personList.stream().mapToDouble(age -> age.getAge()).average().getAsDouble();

      List<String> dataForCSV = Output.writeToFile(duplicates, average, personList);
      Files.write(Paths.get("output.csv"), dataForCSV, Charset.defaultCharset());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}