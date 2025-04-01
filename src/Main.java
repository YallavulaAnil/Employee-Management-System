
import com.anilSoft.beans.Employee;
import com.anilSoft.factory.ConnectionFactory;
import com.anilSoft.factory.EmployeeServiceFactory;
import com.anilSoft.service.EmployeeService;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static {
		ConnectionFactory.getConnection();
		EmployeeServiceFactory.getEmployeeService();
	}
	public static void main(String[] args) throws Exception{
		System.out.println("Employee Management System");
		System.out.println("============================");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		int eno=0;
		String ename = "";
		float esal = 0.0f;
		String eaddr = "";
		Employee employee = null;
		String status = "";
		
		while(true) {
			System.out.println();
			System.out.println("1.ADD Employee");
			System.out.println("2.SEARCH Employee");
			System.out.println("3.UPDATE Employee");
			System.out.println("4.DELETE Employee");
			System.out.println("5.EXIT");
			System.out.println("Enter your choice [1,2,3,4,5]  :");
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				System.out.println("Employee Add Module");
				System.out.println("--------------------------");
				System.out.println("Employee Number     :");
				eno = Integer.parseInt(br.readLine());
				Employee emp = employeeService.searchEmployee(eno);
				if(emp == null) {
					System.out.println("Employee Name    :");
					ename = br.readLine();
					System.out.println("Employee Salary   :");
					esal = Float.parseFloat(br.readLine());
					System.out.println("Employee Adderss  :");
					eaddr = br.readLine();
					
					employee  = new Employee();
					employee.setEno(eno);
					employee.setEname(ename);
					employee.setEsal(esal);
					employee.setEaddr(eaddr);
					
					status = employeeService.addEmployee(employee);
					
					if(status.equalsIgnoreCase("SUCCESS")) {
						System.out.println("Employee Added Successfully");
					}
					if(status.equalsIgnoreCase("FAILURE")) {
						System.out.println("Employee Not Added Sucessfully");
					}
				}else {
					System.out.println("Employee Existed Already");
				}
				break;
			case 2:
				System.out.println("Employee Serach Module");
				System.out.println("--------------------------");
				System.out.println("Employee Number     :");
				eno = Integer.parseInt(br.readLine());
				employee = employeeService.searchEmployee(eno);
				if(employee != null) {
					System.out.println("Employee Details");
					System.out.println("--------------------");
					System.out.println("Employee Number   :"+employee.getEno());
					System.out.println("Employee Name      :"+employee.getEname());
					System.out.println("Employee Salary     :"+employee.getEsal());
					System.out.println("Employee Adders     :"+employee.getEaddr());
				}else {
					System.out.println("Employee Not found");
				}
				break;
			case 3:
				System.out.println("Employee Update Module");
				System.out.println("-----------------------");
				System.out.println("Employee Number     :");
				eno = Integer.parseInt(br.readLine());
				employee = employeeService.searchEmployee(eno);
				if(employee != null) {
					System.out.println("Employee Name Old:"+employee.getEname()+" New: ");
					ename = br.readLine();
					if(ename == null || ename.equals("")) {
						ename = employee.getEname();
					}
					System.out.println("Employee Salary old:"+employee.getEsal()+" New:");
					String salary = br.readLine();
					if(salary == null || salary.equals("")) {
						esal = Float.parseFloat(salary);
					}else {
						esal = Float.parseFloat(salary);
					}
					System.out.println("Employee Adderss Old:"+employee.getEaddr()+" New:");
					eaddr = br.readLine();
					if(eaddr == null || eaddr.equals("")) {
						eaddr = employee.getEaddr();
					}
					Employee employee1 = new Employee();
					employee1.setEno(eno);
					employee1.setEname(ename);
					employee1.setEsal(esal);
					employee1.setEaddr(eaddr);
					
					status = employeeService.updateEmployee(employee1);
					if(status.equalsIgnoreCase("SUCCESS")) {
						System.out.println("Employee updated Successfully");
					}
					if(status.equalsIgnoreCase("FAILURE")) {
						System.out.println("Employee Not Update Successfully");
					}
				}else {
					System.out.println("Employee not Found");
				}
				break;
			case 4:
				System.out.println("Employee Delete Module");
				System.out.println("---------------------------");
				System.out.println("Employee Number  :");
				eno = Integer.parseInt(br.readLine());
				employee = employeeService.searchEmployee(eno);
				if(employee != null) {
					status = employeeService.deleteEmployee(eno);
					if(status.equalsIgnoreCase("SUCCESS")) {
						System.out.println("Employee Deleted Successfully");
					}
					if(status.equalsIgnoreCase("FAILURE") ) {
						System.out.println("Employee Not Deleted Successfully");
						
					}
				}else {
					System.out.println("Employee Not Found");
				}
				break;
			case 5:
				System.out.println("Thank you for using Employee Management System Application");
				ConnectionFactory.close();
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Choice, Please Provid the choice from 1,2,3,4,5.");
					break;
				
			}
		}
		
	}

}
