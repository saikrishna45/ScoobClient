package edu.cmpe273.univclient.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmpe273.univserver.beans.Person;
import edu.cmpe273.univserver.service.UniversityServerServiceProxy;

/**
 * Servlet implementation class UpdateUserDetails
 */
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In register Servlet");
		Person person = new Person(); 
		HttpSession session = request.getSession();
		
		if(request.getParameter("sjsuidinput")!=null || !"".equals(request.getParameter("sjsuidinput"))){
			person.setFirstName(request.getParameter("sjsuidinput"));
		}
		if(request.getParameter("firstName")!=null || !"".equals(request.getParameter("firstName"))){
			person.setFirstName(request.getParameter("firstName"));
		}
		if(request.getParameter("lastName")!=null || !"".equals(request.getParameter("lastName"))){
			person.setLastName(request.getParameter("lastName"));
		}	
		if(request.getParameter("gender")!=null || !"".equals(request.getParameter("gender"))){
			person.setGender(request.getParameter("gender"));
		}	
		if(request.getParameter("dateOfBirth")!=null || !"".equals(request.getParameter("dateOfBirth"))){
			person.setDateOfBirth(request.getParameter("dateofbirth"));
		}	
		if(request.getParameter("addrLine1")!=null || !"".equals(request.getParameter("addrLine1"))){
			person.setAddrLine1(request.getParameter("address1"));
		}	
		if(request.getParameter("addrLine2")!=null || !"".equals(request.getParameter("addrLine2"))){
			person.setAddrLine2(request.getParameter("address2"));
		}	
		if(request.getParameter("emailid")!=null || !"".equals(request.getParameter("emailid"))){
			person.setEmailid(request.getParameter("emailid"));
		}	
		if(request.getParameter("password")!=null || !"".equals(request.getParameter("password"))){
			person.setPassword(request.getParameter("password"));
		}	
		if(request.getParameter("cityName")!=null || !"".equals(request.getParameter("cityName"))){
			person.setCityName(request.getParameter("city"));
		}
		if(request.getParameter("state")!=null || !"".equals(request.getParameter("state"))){
			person.setStateName(request.getParameter("state"));
		}
		if(request.getParameter("zipCode")!=null || !"".equals(request.getParameter("zipCode"))){
			person.setZipCode(request.getParameter("zipcode"));
		}
		if(request.getParameter("role")!=null || !"".equals(request.getParameter("role"))){
			person.setRole(request.getParameter("role"));
		}
		if(request.getParameter("department")!=null || !"".equals(request.getParameter("department"))){
			person.setDepartment(request.getParameter("department"));
		}

		UniversityServerServiceProxy proxy = new UniversityServerServiceProxy();
		proxy.setEndpoint("http://localhost:8080/UniversityServer/services/UniversityServerService");
		String registerReply = proxy.editProfessorInformation(person);
		System.out.println("Reply from service is :: "+registerReply);
		session.setAttribute("registerReply", registerReply);
		
		if("Update Success".equals(registerReply))
			response.sendRedirect("view/UpdateProferssorDetails.jsp");
		else
			response.sendRedirect("view/updateUserDetailsData.jsp");
		
	}

}
