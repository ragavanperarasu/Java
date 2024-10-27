import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectExample {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/ragavan"; // Replace with your database name
        String user = "root"; // Replace with your MySQL username
        String password = "root"; // Replace with your MySQL password

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query to create a table (example)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Students ("
                    + "ID INT PRIMARY KEY AUTO_INCREMENT, "
                    + "Name VARCHAR(50), "
                    + "Age INT)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Students' created or already exists.");

            // Step 4: Insert sample data
            String insertDataSQL = "INSERT INTO Students (Name, Age) VALUES ('Alice', 21), ('Bob', 22)";
            stmt.executeUpdate(insertDataSQL);
            System.out.println("Inserted sample data.");

            // Step 5: Execute a SELECT query and display the result
            String selectSQL = "SELECT * FROM Students";
            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println("Students Table:");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            rs.close(); // Close ResultSet

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Step 6: Clean up resources
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
