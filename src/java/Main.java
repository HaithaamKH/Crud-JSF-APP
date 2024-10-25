
import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        EmployeeDAO e = new EmployeeDAO();
        //System.out.println(e.getById(1));
        //System.out.println(e.getUserByCredentials("haitham", "12345"));
        //Employee emp = new Employee(4 , "Basem" , "basem" , "12345" ,"user" , "Plesatine");
        //e.insertEmployee(emp);
        //e.deleteEmployee(4);
        //e.updateEmployee(emp);
        //System.out.println(e.searchByNameAndCountry("Haitham Khateeb","Jordan"));
        System.out.println(e.searchByNameAndCountry("Basem", "Jordan"));
    }
}
