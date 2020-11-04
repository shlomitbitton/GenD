

public class Person {

  private String firstName;
  private String lastName;
  private int age;

  public Person(String lastName, String firstName, int age) {
    lastName = this.firstName;
    firstName = this.firstName;
    age = this.age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
