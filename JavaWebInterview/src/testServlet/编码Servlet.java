package testServlet;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ����Servlet extends HttpServlet {
	/**
	 * GET��ʽ����ı��봦��
	 * ʹ��req.setCharacterEncoding("UTF-8");��������.��Ҫʹ�����·�ʽ.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		resp.getWriter().write("����Servlet:"+name);
	}
	/**
	 * POST��ʽ����ı��봦��: 
	 * ��οͻ���û����Content-Type�����ñ�����Ϣ������Ĭ��ʹ��ISO-8859-1���롣
	 * ��Ҫ��req.setCharacterEncoding("UTF-8");����.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		resp.getWriter().write("����Servlet:"+name);
	}
}
