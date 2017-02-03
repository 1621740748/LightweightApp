package org.taoran.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��JDBC��������SAE���ݿ�
 * 
 * @author ����
 *
 */

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 119132134141414675L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		PrintWriter out = response.getWriter();
		// ��ѯuser
		List<HashMap<String, Object>> userList = queryUser(request);
		// ����List����
		for (HashMap<String, Object> map : userList) {
			out.println(map.get("name") + " " + map.get("age"));
		}
		out.flush();
		out.close();
	}

	/**
	 * ��ѯSAE MySQL���ݿ���user��
	 */
	private List<HashMap<String, Object>> queryUser(HttpServletRequest request) {

		List<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		
		String dbName = "app_saber92";
		String host = "w.rdc.sae.sina.com.cn";
		String port = "3307";
		String username = "2l0jj5xw1k";
		String password = "hiwil13w0lw5iil1x41zy02235hx24mylyx555jy";
																
		String driverName = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://";
		String serverName = host + ":" + port + "/";
		String connName = dbUrl + serverName + dbName;
		try {
			// ����MySQL����
			Class.forName(driverName);
			// ��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(connName, username, password);
			// �����ѯSQL���
			String sql = "select * from user";
			// ����PreparedStatement����(�����ѱ����sql���)
			PreparedStatement ps = conn.prepareStatement(sql);
			// ִ�в�ѯ����ȡ�����
			ResultSet rs = ps.executeQuery();

			// ���������
			while (rs.next()) {
				HashMap<String, Object> userMap = new HashMap<String, Object>();
				userMap.put("name", rs.getString("name"));
				userMap.put("age", rs.getInt("age"));
				userList.add(userMap);
			}
			// �ر����ӣ��ͷ���Դ
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}
}
