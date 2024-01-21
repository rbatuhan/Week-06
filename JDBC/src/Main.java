import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args){

        Connection connect = null;

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = connect.createStatement();

            PreparedStatement pr = connect.prepareStatement("INSERT INTO employees (name, position, salary) VALUES (?,?,?)");

            pr.setString(1,"Estel Etuck");
            pr.setString(2,"Doctor");
            pr.setInt(3, 10000);
            pr.executeUpdate();

            pr.setString(1,"Row Byfford");
            pr.setString(2,"Actor");
            pr.setInt(3, 8000);
            pr.executeUpdate();

            pr.setString(1,"Raleigh Rubinowitch");
            pr.setString(2,"Driver");
            pr.setInt(3, 25000);
            pr.executeUpdate();

            pr.setString(1,"Wallis Cullingworth");
            pr.setString(2,"Chief");
            pr.setInt(3, 6000);
            pr.executeUpdate();

            pr.setString(1,"Gunar Aldrick");
            pr.setString(2,"Worker");
            pr.setInt(3, 2000);
            pr.executeUpdate();

            ResultSet rSet = st.executeQuery("SELECT * FROM employees");
            System.out.println("Employees Listesi");

            while (rSet.next()){
                System.out.println("\n##############");
                System.out.println("EMPLOYEE ID: " + rSet.getInt("id"));
                System.out.println("EMPLOYEE NAME: " + rSet.getString("name"));
                System.out.println("EMPLOYEE POSITION: " + rSet.getString("position"));
                System.out.println("EMPLOYEE SALARY: " + rSet.getDouble("salary"));
            }

            pr.close();
            st.close();
            connect.close();
        }catch (SQLException e){
            throw new RuntimeException();
        }

    }
}