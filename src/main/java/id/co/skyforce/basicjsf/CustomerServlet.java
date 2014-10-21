package id.co.skyforce.basicjsf;

import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		SimpleDateFormat formaterr = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		try {
			birthDate = formaterr.parse(req.getParameter("birthDate"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String mobilePhone = req.getParameter("mobilePhone");
		String homePhone = req.getParameter("homePhone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");

		if (action.equals("create")) {

			Address addres = new Address();
			Customer customer = new Customer();

			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setBirthDate(birthDate);
			customer.setMobileNo(mobilePhone);
			customer.setHomePhone(homePhone);
			customer.setPassword(password);
			customer.setEmail(email);

			addres.setStreet(street);
			addres.setCity(city);
			addres.setPostalCode(postalCode);

			customer.setAddress(addres);

			Session session = HibernateUtil.openSession();
			org.hibernate.Transaction trx = session.beginTransaction();

			session.save(customer);

			trx.commit();
			session.close();
			resp.sendRedirect("listCustomer");
		} else if (action.equals("update")) {
			String id = req.getParameter("id");
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			Customer customer = (Customer) session.get(Customer.class,Long.parseLong(id));

			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setBirthDate(birthDate);
			customer.setHomePhone(homePhone);
			customer.setMobileNo(mobilePhone);
			customer.setEmail(email);
			customer.setPassword(password);

			customer.getAddress().setStreet(street);
			customer.getAddress().setCity(city);
			customer.getAddress().setPostalCode(postalCode);
			session.save(customer);

			trx.commit();
			session.close();
			resp.sendRedirect("listCustomer");
		}

//		} else if (pilihan.equals("delete")) {
//
//			String id = req.getParameter("idc");
//
//			Session session = HibernateUtil.openSession();
//			Transaction trx = session.beginTransaction();
//
//			Customer customer = (Customer) session.get(Customer.class,
//					Long.parseLong(id));
//
//			session.delete(customer);
//			trx.commit();
//			session.close();
//
//			resp.sendRedirect("listCustomer");
//		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String updel = req.getParameter("parameter");

		if (updel != null) {
			
			if (updel.equals("update")) {
				String id = req.getParameter("idCustomer");
				
				Session session = HibernateUtil.openSession();
				
				Customer customer = (Customer) session.get(Customer.class, Long.parseLong(id));
				req.setAttribute("customer", customer);
				
				session.close();
				
				RequestDispatcher rd = req.getRequestDispatcher("formUpdate.jsp");
				rd.forward(req, resp);
			
			}else if(updel.equals("delete")){
				
				String id = req.getParameter("idCustomer");
				
				Session session = HibernateUtil.openSession();
				Transaction trx = session.beginTransaction();
				
				Customer customer = (Customer) session.get(Customer.class, Long.parseLong(id));
				session.delete(customer);
				trx.commit();
				
				List<Customer> listCustomer = session.createQuery("from Customer").list();
				req.setAttribute("listCustomer", listCustomer);
				
				session.close();
				
				RequestDispatcher rd = req.getRequestDispatcher("listCustomer.jsp");
				rd.forward(req, resp);
			}
		}else{
		
		Session session = HibernateUtil.openSession();

		Query query = session.createQuery("from Customer");
		List<Customer> listCustomer = query.list();

		req.setAttribute("listCustomer", listCustomer);

		RequestDispatcher rd = req.getRequestDispatcher("listCustomer.jsp");
		rd.forward(req, resp);
		session.close();
		}
	}

}
