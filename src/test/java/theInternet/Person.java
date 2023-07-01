package theInternet;

public class Person {

    String firstname;
    String lastname;
    String email;
    String due;
    String website;
    public Person(String lastname, String firstname, String email, String due, String website) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public float getDue() {
        float due = Float.parseFloat(this.due.replace("$",""));
        return due;
    }

    public String getWebsite() {
        return website;
    }



}
