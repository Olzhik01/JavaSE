import java.util.*;


public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList,new StudComparator());




        Collections.reverse(studentList);
        for(Student st: studentList){
            System.out.println(st.getFname());
        }

    }
}

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudComparator implements Comparator<Student>{

    @Override
    public int compare(Student h1, Student h2) {
        if (h1.getCgpa() == h2.getCgpa()) {
            if(h1.getFname().compareTo(h2.getFname())<0){
                return 1;
            }
            if(h1.getFname().compareTo(h2.getFname())>0){
                return -1;
            }
            if(h1.getFname().equals(h2.getFname())){

                if(h1.getId()>h2.getId()){
                    return 1;
                }
                if(h1.getId()<h2.getId()){
                    return -1;
                }

            }

        }
        if (h1.getCgpa() > h2.getCgpa()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}












