import java.util.*;
public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] num = {3, 30, 34};
        List<Student> list = new ArrayList<Student>();

        for(int i = 0; i < num.length; i++) {
            list.add(new Student(num[i], num[i]%10, num[i]%100, num[i]%100));
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getScore() < s2.getScore()) {
                    return -1;
                } else if (s1.getScore() > s2.getScore()) {
                    return 1;
                }
                return 0;
            }
        });

        for (Student s : list) {
            System.out.println(s.getScore());
        }
    }
}
class Student {
    int origin;
    int unit;
    int tens;
    int hund;

    public Student(int origin, int unit, int tens, int hund) {
        this.origin = origin;
        this.unit = unit;
        this.tens = tens;
        this.hund = hund;
    }
    public int getOrigin() {
        return this.origin;
    }
    public int getUnit() {
        return this.tens;
    }
    public int getTens() {
        return this.tens;
    }
    public int getHund() {
        return this.hund;
    }
}
