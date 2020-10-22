import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TheardClass extends Thread{
    PreparedStatement pre;
    DbConnection dbConnection=new DbConnection();
    Connection connection=dbConnection.getConnection();
    Scanner scanner=new Scanner(System.in);
    Timestamp timestamp = new Timestamp(new Date().getTime());
    public void insert(){
        System.out.println(" plese enter name  ");
        String name =scanner.next();
        Calendar cal = Calendar.getInstance();
       cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.MINUTE, 1);
        timestamp = new Timestamp(cal.getTime().getTime());
        try {
            pre=connection.prepareStatement("insert into youtubeschool.thread (cname,cbrithdate) values (?,?);");
            pre.setString(1, name);
            pre.setTimestamp(2,timestamp);
            pre.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public  ResultSet selectName(){
        Timestamp timestamp1 = new Timestamp(new Date().getTime());
        try {
            pre = connection.prepareStatement("SELECT cname , cbrithdate FROM youtubeschool.thread WHERE cbrithdate = ? ");
            pre.setTimestamp(1,timestamp1);
            ResultSet resultSet= pre.executeQuery();
            return  resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public ResultSet selectAll() {
        ResultSet resultSet1=selectName();

        try{
            while (resultSet1.next()) {
                Student student=new Student();
                student.setName(resultSet1.getString("cname"));
                student.setDate(resultSet1.getTimestamp("cbrithdate"));
                System.out.println(student);
            }}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void run() {
        while (true){
            selectAll();
        }
    }

    public static void main(String[] args) {
        TheardClass theardClass =new TheardClass();
        for(int i=0;i<2;i++){
            theardClass.insert(); }
        TheardClass thread =new TheardClass();
        thread.start();}
}
