package com.qianfeng.jdbc;
import java.sql.DriverManager;
	/**
	 *  JDBC :һ�����ר��ΪJava�������ݿ��ṩ�� �����ӿ�
	 *  JDBC ֻ������Java
	 *  ԭ��ִ�еĹ���ʹ��Java���뷢��sql��䵽���ݿ�˵ķ�����ȥִ�У����Ҹ������ǵ��߼�ʵ�����ݵ���
	 *  �����JDBC
	 *  ע�⣺sql �������ԣ� ���ݿ��ύ�ͻع�
	 *  5.7 8.0
	 *  
	 *  jdbc�ĺ��Ĳ����ӿ�
	 *  1.Driver ���ݿ�������ӿ� ��������
	 *  2.connection�ش����� ���ݿ�����Ӷ���ӿ� ��������
	 *  3.statement ִ��sql�Ķ���ӿ� ��preparestatement ��ֹsqlע�룩ִ��Ԥ����sql����ӿ�
	 *  4.resultSet ��������������� ������Ķ���ӿ�
	 *  
	 *  
	 *  
	 *  �������ݿ���Ҫ��Щ��Ϣ��
	 *  MySQL�ķ�������ַ 127.0.0.1 localhost
	 *  ��װ���ݿ�����ʱ���Լ����õ���Ϣ-------�û���������
	 *  
	 *  URL:ͳһ��Դ��λ�� ----------URL
	 *  
	 *  jdbc:���ݿ�����://�����ַ�����������˿ں�/���ݿ�����
	 *  
	 *  ���빤�߰�jar��
	 * */
public class JDBCTest {
	public static void main(String[] args){
		selectAll();
	}
	
	public static void selectAll(){
		// jdbc 7���������
		// 1:�������ݿ⳧���ṩ����
		// ����Ҳ����ѡ����д������ǧ��Ҫд���ˣ�ע����JDBC
		// ���ݿ����ǲ���Ҫ��װ ��Ϊ�������ݿⲻ��Ҫ���Ӱ�װ
		try{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connection = DriverManager
					.getConnection("jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/chensiwei","root","3cwangzi");
			// 3:ͨ��connection��ʵ����һ�����ݿ�ʵ��preparestatement
			// ʲô�����ݿ�ʵ�������ݿ�ʵ��������ִ�ж�ӦSQL����
			java.sql.PreparedStatement preparedStatament = 
					connection.prepareStatement("select * from ahgc_user");
			// 4:ͨ��preparestatement���ݿ�ʵ����ִ��SQL��䲢ʵ����һ��resultset(���ݿ��ѯ�����)
			java.sql.ResultSet resultSet = preparedStatament.executeQuery();
			// 5:
			while(resultSet.next()){
				// 6:��������
				String username = (String) resultSet.getObject("username");
				System.out.println(username);
			}
			// 7:�ر����ݿ�����
			resultSet.close();
			preparedStatament.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
