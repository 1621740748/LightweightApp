package org.taoran.course.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taoran.course.service.ChatService;
import org.taoran.course.service.CoreService;
import org.taoran.course.util.SignUtil;


/**
 * ������������
 * 
 * @author ����
 * @date 2015-2-6
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 13483644821986L;

	/**
	 * ����У��(ȷ����������΢�ŷ�����)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();

		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * ����У���봦��΢�ŷ�������������Ϣ
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������Ӧ�ı��������ΪUTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// ���ղ��� ΢�ż���ǩ����ʱ����������
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		PrintWriter out = response.getWriter();
		// ����У��
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			// ���ú���ҵ������մ�������
			String respXml = CoreService.processRequest(request);
			out.print(respXml);
		}
		out.close();
		out = null;
	}
	
	@Override
	public void init() {
		File indexDir = new java.io.File(ChatService.getIndexDir());
		//������Ŀ¼�������򴴽�����
		if (!indexDir.exists())
			ChatService.createIndex();
	}
}
