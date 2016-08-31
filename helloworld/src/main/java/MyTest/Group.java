package MyTest;

import mybatis.Student;
import java.util.List;


/**
 * Created by majun on 15/9/14.
 */
public class Group {
    private int id;
    private String name;
    private String position;

    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public String toString() {
        return "Group{" +
                "position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
