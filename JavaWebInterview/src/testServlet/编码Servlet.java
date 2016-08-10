package testServlet;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class 编码Servlet extends HttpServlet {
	/**
	 * GET方式请求的编码处理
	 * 使用req.setCharacterEncoding("UTF-8");不起作用.需要使用如下方式.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		resp.getWriter().write("编码Servlet:"+name);
	}
	/**
	 * POST方式请求的编码处理: 
	 * 如何客户端没有在Content-Type中设置编码信息。窗口默认使用ISO-8859-1编码。
	 * 需要用req.setCharacterEncoding("UTF-8");覆盖.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		resp.getWriter().write("编码Servlet:"+name);
	}
}
