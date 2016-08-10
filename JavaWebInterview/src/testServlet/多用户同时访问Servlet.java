package testServlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多用户同时访问是访问一个Servlet对象,还是多个Servlet对象?
 * 好像是一个{@link Servlet#service}
 * @author lv
 *
 */
public class 多用户同时访问Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("多用户同时访问Servlet");
	}
}
