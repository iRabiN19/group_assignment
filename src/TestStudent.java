import java.util.ArrayList;
import java.util.Scanner;

class TestStudent{
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                ArrayList<Student> base = new ArrayList<Student>();
                to:
                while (true) {

                        System.out.println("-----------------The Student Report Program--------");
                        System.out.println("1: Data Entry");
                        System.out.println("2: Data Removal");
                        System.out.println("3: Data Updating");
                        System.out.println("4: Viewing Data");
                        System.out.println("5: Exit");

                        System.out.println("Enter Your Choice:");
                        int choice = sc.nextInt();

                        switch (choice) {
                                case 1:

                                        entry(base);
                                        break;
                                case 2:

                                        delete(base);
                                        break;
                                case 3:

                                        update(base);
                                        break;
                                case 4:

                                        Query(base);
                                        break;
                                case 5:
                                        System.out.println("Thank you.");
                                        break to;

                                default:
                                        System.out.println("Invalid input");
                                        break;
                        }
                }

        }

        public static void update(ArrayList<Student> base) {
                System.out.println("Enter the student roll number to update:");
                Scanner sc = new Scanner(System.in);
                int updateroll = sc.nextInt();

                int index = getIndex(base,updateroll);

                if(index == -1){

                        System.out.println("No data found.");
                }else{

                        System.out.println("Enter new Student Name:");
                        String name = sc.next();
                        System.out.println("Enter  new Student Roll:");
                        int roll = sc.nextInt();
                        System.out.println("Enter new School Name:");
                        String school = sc.next();
                        System.out.println("Enter  new Student Standard:");
                        int grade = sc.nextInt();
                        System.out.println("Enter  new DOB(YYYY/MM/DD) :");
                        String dob = sc.next();
                        System.out.println("Gender :");
                        char gen = sc.next().charAt(0);
                        System.out.println("Enter Science Marks :");
                        int science = sc.nextInt();
                        System.out.println("Enter English  Marks :");
                        int english = sc.nextInt();
                        System.out.println("Enter Maths Marks :");
                        int maths = sc.nextInt();
                        System.out.println("Enter Nepali Marks :");
                        int nepali = sc.nextInt();
                        System.out.println("Enter Social Marks :");
                        int social = sc.nextInt();

                        int total = english+maths+nepali+social;



                        Student stud1 = new Student(name, roll, grade, science, maths, english, nepali, social, total, school, dob, gen);

                        base.set(index, stud1);
                        System.out.println("Updated successfully!");
                        System.out.println(" ");
                }
        }

        public static void delete(ArrayList<Student> base) {

                System.out.println("Student Roll Number  to delete data:");

                Scanner sc = new Scanner(System.in);
                int deleteroll = sc.nextInt();

                int index = getIndex(base,deleteroll);

                if(index == -1){
                        System.out.println("No data found.");
                }else{

                        base.remove(index);
                        System.out.println("Successfully deleted!");
                        System.out.println(" ");
                }
        }

        public static void Query(ArrayList<Student> base) {

                if(base.size() == 0){
                        System.out.println("The registry is empty.");
                        return;
                }
                for (int i = 0; i < base.size(); i++) {
                        Student stud1 = base.get(i);
                        Student stud =new Student() {
                        };
                        System.out.println(" ");
                        System.out.println("*****************************");
                        System.out.println("*****************************");
                        System.out.println("Mark sheet of Grade :"+stud1.getGrade()+" , "+stud1.getSchool());
                        System.out.println("*****************************");
                        System.out.println("Roll :"+stud1.getRoll()+"   "+"Name :"+ stud1.getName() );
                        System.out.println("Gender :"+stud1.getGen()+"   "+"DOB :"+ stud1.getDob() );
                        System.out.println("******************************");
                        System.out.println("Subject      Marks");

                        System.out.println("******************************");

                        System.out.println("Science    :"+stud1.getSci() );
                        System.out.println("English    :"+stud1.getEng() );
                        System.out.println("Maths      :"+stud1.getMaths() );
                        System.out.println("Nepali     :"+stud1.getNep() );
                        System.out.println("Social     :"+stud1.getSos() );
                        System.out.println("-----------------------------");
                        System.out.println("Total :"+stud1.getTotal() );
                        System.out.println("=============================");
                        System.out.println(" ");


                }
        }
        public static void entry(ArrayList<Student> base) {
                for (int i=0; i<5; i++){
                        Scanner sc = new Scanner(System.in);
                        int roll;

                        while(true){
                                System.out.println("Enter Roll Number:");
                                roll = sc.nextInt();

                                int index = getIndex(base, roll);

                                if(index == -1){

                                        break;
                                }
                        }

                        System.out.println("Name:");
                        String name = sc.next();
                        System.out.println("School Name:");
                        String school = sc.next();

                        System.out.println("Student Standard:");
                        int grade = sc.nextInt();
                        System.out.println("Student DOB(yyyy/mm/dd):");
                        String dob = sc.next();
                        System.out.println("Student Gender(M/F):");
                        char gen = sc.next().charAt(0);
                        System.out.println("Enter Science marks :");
                        int science = sc.nextInt();
                        System.out.println("Enter English Marks :");
                        int english = sc.nextInt();
                        System.out.println("Enter Maths Marks :");
                        int maths = sc.nextInt();
                        System.out.println("Enter Nepali Marks :");
                        int nepali = sc.nextInt();
                        System.out.println("Enter Social Marks :");
                        int social = sc.nextInt();
                        int total= nepali+english+science+maths+social;

                        Student stud1 = new Student(name, roll, grade, science, maths, english, nepali, social, total, school, dob, gen);

                        base.add(stud1);

                        System.out.println("Added successfully!");
                        System.out.println(" ");
                        System.out.println(" ");;
                }
        }






        public static int getIndex(ArrayList<Student> base, int roll) {

                int index = -1;

                for (int i = 0; i < base.size(); i++) {
                        Student stud1 = base.get(i);

                        int id = stud1.getRoll();
                        if (id==roll) {
                                //
                                index = i;
                        }
                }
                return index;
        }

}