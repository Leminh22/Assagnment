public class Student {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private double gpa;

    // Constructor không tham số
    public Student() {
        this.id = "A001";
        this.fullName = "Nguyen Van A";
        this.email = "NguyenA@gmail.com";
        this.phone = "093218293";
        this.gpa = 3.5;
    }

    // Constructor có tham số
    public Student(String id, String fullName, String email, String phone, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void displayData() {
      System.out.printf("| %-10s | %-25s | %-25s | %-12s | %5.2f |%n",
            id, fullName, email, phone, gpa);
    }

}
