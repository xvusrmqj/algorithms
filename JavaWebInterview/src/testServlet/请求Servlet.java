package testServlet;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ����Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. ���·����Ϣ. requestURI = contextPath + servletPath + pathInfo
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String pathInfo = req.getPathInfo();
		System.out.println("requestURI:"+requestURI);
		System.out.println("contextPath:"+contextPath);
		System.out.println("servletPath:"+servletPath);
		System.out.println("pathInfo:"+pathInfo);
		//2. ������������Ϣ
		String name = req.getParameter("name");
		String[] values = req.getParameterValues("name");
		Enumeration<String> names = req.getParameterNames();
		Map<String, String[]> map = req.getParameterMap();
		//3. ���HTTPͷ��Ϣ, �������������ķ�����ࡣ
		req.getHeader("accept");
		req.getHeaders("accept");
		req.getHeaderNames();
		
		resp.getWriter().write("hello1111:"+name);
	}
}
