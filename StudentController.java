import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Tim sinh vien theo id, khong thay tra ve null
    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Nhap GPA (0 - 4.0)  nhap sai thi nhap lai
    private double readGpa() {
        while (true) {
            try {
                System.out.print("Nhap diem Gpa tu 0 - 4.0: ");
                String input = scanner.nextLine().trim().replace(",", "."); // nhap duoc . hoac ,
                double gpa = Double.parseDouble(input);
                if (gpa < 0 || gpa > 4.0) {
                    System.out.println("Gpa phai trong khoang 0 - 4.0");
                    continue;
                }
                return gpa;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le!");
            }
        }
    }

    // Doc lua chon menu cho MainThread, nhap sai tra ve -1
    public int readChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // In tieu de 
    private void printHeader() {
        System.out.printf("| %-10s | %-25s | %-25s | %-12s | %5s |%n",
                "Ma SV", "Ho ten", "Email", "SDT", "GPA");
    }

    public void addStudent() {
        System.out.println("Nhap ma SV: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Ma SV khong duoc de trong");
            return;
        }
        if (findById(id) != null) {
            System.out.println("Ma SV da ton tai");
            return;
        }
        System.out.println("Nhap Ho va Ten: ");
        String fullName = scanner.nextLine().trim();
        System.out.println("Nhap Email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Nhap so dien thoai: ");
        String phone = scanner.nextLine().trim();
        double gpa = readGpa();

        studentList.add(new Student(id, fullName, email, phone, gpa));
        System.out.println("Them sinh vien thanh cong");
    }

    public void printStudentList() {
        System.out.println("Danh sach tat ca sinh vien");
        if (studentList.isEmpty()) {
            System.out.println("Danh sach sinh vien trong");
            return;
        }
        printHeader();
        for (Student s : studentList) {
            s.displayData();
        }
    }

    public void searchStudentByName() {
        System.out.println("Nhap Ho va Ten sinh vien can tim: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                if (!found) {
                    printHeader(); // chi in tieu de mot lan
                }
                s.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien nao");
        }
    }

    public void updateStudentGpa() {
        System.out.println("Nhap ma sinh vien can update: ");
        String id = scanner.nextLine().trim();
        Student student = findById(id);
        if (student == null) {
            System.out.println("Ma sinh vien khong ton tai");
            return;
        }
        double gpa = readGpa();
        student.setGpa(gpa);
        System.out.println("Cap nhat GPA thanh cong");
    }

    public void deleteStudent() {
        System.out.println("Nhap ma sinh vien can xoa: ");
        String id = scanner.nextLine().trim();
        Student student = findById(id);
        if (student == null) {
            System.out.println("Ma sinh vien khong ton tai");
            return;
        }
        studentList.remove(student);
        System.out.println("Xoa thanh cong!");
    }

    public void sortStudentsByGpaDescending() {
        // Vòng ngoài: mỗi lượt đẩy 1 phần tử "nhỏ nhất" về cuối danh sách
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                Student a = studentList.get(j);
                Student b = studentList.get(j + 1);
                // Nếu GPA của a nhỏ hơn b thì sai thứ tự giảm dần -> hoán đổi
                if (a.getGpa() < b.getGpa()) {
                    studentList.set(j, b);
                    studentList.set(j + 1, a);
                }
            }
        }
        System.out.println("Da sap xep sinh vien giam dan theo GPA");
        printStudentList();
    }
}
