public class MainThread {
    public static void main(String[] args) {
        StudentController SC1 = new StudentController();
        boolean running = true;
        while (running) {
            System.out.println("HE THONG QUAN LY SINH VIEN");
            System.out.println("---------------------------");
            System.out.println("1.Them sinh vien.");
            System.out.println("2.In danh sach sinh vien.");
            System.out.println("3.Tim kiem sinh vien.");
            System.out.println("4.Cap nhat lai diem sinh vien.");
            System.out.println("5.Xoa sinh vien ra khoi danh sach.");
            System.out.println("6.Sap xep sinh vien theo diem giam dan.");
            System.out.println("7.Exit program");
            System.out.println("---------------------------");
            System.out.println("");

            int choice = SC1.readChoice();

            switch (choice) {
                case 1:
                    SC1.addStudent();
                    break;
                case 2:
                    SC1.printStudentList();
                    break;
                case 3:
                    SC1.searchStudentByName();
                    break;
                case 4:
                    SC1.updateStudentGpa();
                    break;
                case 5:
                    SC1.deleteStudent();
                    break;
                case 6:
                    SC1.sortStudentsByGpaDescending();
                    break;
                case 7:
                    System.out.println("Hen gap lai");
                    running = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon tu 1 - 7");
                    break;
            }
        }
    }
}
