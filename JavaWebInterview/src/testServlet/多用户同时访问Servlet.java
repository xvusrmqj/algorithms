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
 * ���û�ͬʱ�����Ƿ���һ��Servlet����,���Ƕ��Servlet����?
 * ������һ��{@link Servlet#service}
 * @author lv
 *
 */
public class ���û�ͬʱ����Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("���û�ͬʱ����Servlet");
	}
}
