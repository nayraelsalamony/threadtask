import java.sql.Timestamp;

public class Student {
    private  String name;
    private Timestamp date;

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
