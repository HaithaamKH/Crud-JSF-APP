package com.crud.beans;

import com.crud.busniss.EmployeeBusiness;
import com.crud.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmployeeBean {
    private EmployeeBusiness empBus = new EmployeeBusiness(); // employeeBusiness
    private Employee loggedEmp , operationEmp ;
    List<Employee> employees = new ArrayList<>();
    private String username , password ,action , name , country;
    
    
    public String search(){
       this.setEmployees(this.empBus.searchBy(name, country));
       return "success";
    }
    public void clear(){
        this.name=null;
        this.country=null;
        
    }
    public String operationOnEmp(){
        if(this.action.equals("add")){
            this.empBus.addEmp(operationEmp);
            return this.response();
        }else if(this.action.equals("edit")){
            this.empBus.updateEmp(operationEmp);
            return this.response();
        }
        return response();
    }
    public String login(){
        String login = this.empBus.login(username, password);
        if(login.equalsIgnoreCase("login")){
            this.setEmployees(this.empBus.employees());
            this.setLoggedEmp(this.empBus.getloggedEmp(username, password));
            return login;
        }
        return null;
        
    }
    public String logout(){
        return this.empBus.logout();
    }
    public String deleteEmp(int id){
        if(this.empBus.deleteEmployee(id)){
            return this.adminList();
        }
        return null;
    }
    public String showForm(){
        this.setOperationEmp(new Employee());
        return "opreation";
        
    }
    public String showForm(int id){
        this.setOperationEmp(this.empBus.getEmpById(id));
        return "opreation";
        
    }
    public boolean isView(){
        return this.action.equals("view");
    }
    public String response() {
        this.setEmployees(this.empBus.employees());
        return "response";
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getLoggedEmp() {
        return loggedEmp;
    }
    
    public void setLoggedEmp(Employee loggedEmp) {
        if(this.loggedEmp==null){
            this.loggedEmp = new Employee();
        }
        this.loggedEmp = loggedEmp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String adminList() {
        this.setEmployees(this.empBus.employees());
        return "success";
    }

    public Employee getOperationEmp() {
        return operationEmp;
    }

    public void setOperationEmp(Employee operationEmp) {
        if (this.operationEmp==null){
            this.operationEmp = new Employee();
        }
        this.operationEmp = operationEmp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
   
}
