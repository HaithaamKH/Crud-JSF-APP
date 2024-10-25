
package com.crud.busniss;

import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class EmployeeBusiness {
    private EmployeeDAO empDAO;

    public EmployeeBusiness() {
        this.empDAO = new EmployeeDAO();
    }
    
    public List<Employee> employees(){
        try{
            return this.empDAO.getAllEmployees();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String login(String username , String password){
        Employee emp = null;
        try{
            emp = this.empDAO.getUserByCredentials(username, password);
            if(emp!=null){
                HttpSession session = (HttpSession)
                        FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("employee", emp);
                return "login";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Employee getloggedEmp(String username , String password){
        Employee emp = null;
        try{
            emp = this.empDAO.getUserByCredentials(username, password);
            if(emp!=null){
                return emp;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean deleteEmployee(int id){
        try{
            this.empDAO.deleteEmployee(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public String logout(){
        HttpSession session =(HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(false);
        if(session!=null){
            session.invalidate();
            return "logout";
        }
        return "logout";
    }
    public void addEmp(Employee emp){
        try{
            this.empDAO.insertEmployee(emp);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateEmp(Employee emp){
       try{
            this.empDAO.updateEmployee(emp);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Employee getEmpById(int id){
        try{
            return this.empDAO.getById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Employee> searchBy(String name , String country){
        try{
            return this.empDAO.searchByNameAndCountry(name, country);
        }catch(Exception e){
           e.printStackTrace();
        }
        return null;
    }
    
    
}
