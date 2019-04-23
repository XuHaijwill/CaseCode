package com.xhjc.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author xhj
 * http://localhost:8080/cookie1
 *
 */
@WebServlet("/cookie1")
public class CookieDemoOne extends HttpServlet {

	private static final long serialVersionUID = -6211530960341374593L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 设置服务器端以UTF-8编码进行输出
		response.setCharacterEncoding("UTF-8");
		// 设置浏览器以UTF-8编码进行接收,解决中文乱码问题
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		// 获取浏览器访问访问服务器时传递过来的cookie数组
		Cookie[] cookies = request.getCookies();
		// 如果用户是第一次访问，那么得到的cookies将是null
		if (cookies != null) {
			out.write("你上次访问的时间是：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie ck = cookies[i];
				if ("lastAccessTime".equals(ck.getName())) {
					long parseLong = Long.parseLong(ck.getValue());
					Date date = new Date(parseLong);
					out.write(date.toLocaleString());
				}
			}

		}else{
			out.write("欢迎首次访问本网站!");
		}

		// 用户访问过之后重新设置用户的访问时间，存储到cookie中，然后发送到客户端浏览器
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		//设置cookie的生效时间
		//cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		doGet(request, response);

	}

}
