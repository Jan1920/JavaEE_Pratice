package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpServlettRequst request ����ļ�ʵ���Ͼ���servelt��http������ ��һ����װ�ͳ���˵���˾���http����������һ��java�ļ���
		// HttpServletResponse response ����ļ�ʵ���Ͼ���servlet��http��Ӧ�� ��һ����װ�ͳ���˵���˾���http��Ӧ������һ��java�ļ���
		
		// httpЭ�����
		// http����ɷ�Ϊ��������
		// http �����壨�û�Ҫ�Է�������ʲô�£�����������˵���㣩��http ��Ӧ�壨������Ҫ���û���ʲô�£�
		
		// http ������ �� ��Ӧ��
		// http ��������3���������
		// (1) http�������� (url ��ַ����ʽ(get post))
		// (2) http����ͷ 
		// (�����û�ʹ�õ��Ǻ����������ʹ��ʲô�ںˡ��û���IP��ʲô���û�ʱ����ʲô�ȵ�)
		// (3) http�����ģ�������������û���Ҫ��������ύ���������ݣ�
		
		// http ��Ӧ���������������
		// (1)http��Ӧ״̬��404�ļ��Ҳ�����500�������ڲ�����200�ɹ���
		// (2)http��Ӧͷ����������Ӧ���ĵ���ʾ��ʽ����������html��ʽ��plain���ı���ʽ��json��ʽ...��
		// (3)http��Ӧ���ģ��û������ܹ��۲쵽���ݶ�����Ӧ���ĵ����ݣ����磩
		
		// ʹ���������ȡ�û��ύ������
		java.lang.String username = request.getParameter("username");
		// ����Ӧ������д������
		response.getWriter().print("hello"+username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
