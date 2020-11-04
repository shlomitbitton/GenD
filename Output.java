import java.util.LinkedList;
import java.util.List;

public class Output {

  public static List<String> writeToFile(long duplicateFirstNames, double average, List<Person> personList) {

    final String dupFName = "There were " + duplicateFirstNames + " incidences of duplicate first names";
    final String avgAge = "The average age for both files was " + average;
    final String header = "Lastname, firstname, age";

    // data to be written to csv
    List<String> dataForCSV = new LinkedList<>();
    dataForCSV.add(header);
    System.out.println(header);
    personList.forEach(l -> {
      System.out.println(l.getLastName() + "," + l.getFirstName() + "," + l.getAge());
      dataForCSV.add(l.getLastName() + "," + l.getFirstName() + "," + l.getAge());
    });
    dataForCSV.add(dupFName);
    dataForCSV.add(avgAge);
    System.out.println(dupFName);
    System.out.println(avgAge);

    return dataForCSV;
  }
}
