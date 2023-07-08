package EmployeeSystem;
public class Employee 
{
	private int empno;
	private String ename;
	private int salary;
	
	Employee (int empno,String ename,int salary)
	{
		this.empno=empno;
		this.ename=ename;
		this.salary=salary;
	}
	public int getEmpno()
	{
		return empno;
	}
	public int getSalary()
	{
		return salary;
	}
	public String getEname()
	{
		return ename;
	}
	
	  public void setEname(String ename) {
	        this.ename = ename;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }
	
	public String toString()
	{
		return empno+" "+ename+" "+salary;
	}
}
