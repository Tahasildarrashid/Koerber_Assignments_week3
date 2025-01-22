package Demo;

import java.util.Objects;

public class UserDefinedMap {
    private int id;
    private String name;
    private int marks;

    public UserDefinedMap(int marks, String name, int id) {
        this.marks = marks;
        this.name = name;
        this.id = id;
    }

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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDefinedMap that = (UserDefinedMap) o;
        return id == that.id;

    }

    public int hashcode(){
        return Objects.hash(id);}

    @Override
    public String toString() {
        return "UserDefinedMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
