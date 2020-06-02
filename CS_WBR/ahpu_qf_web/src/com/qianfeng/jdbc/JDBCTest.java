package com.qianfeng.jdbc;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		//selectAll();
		//addUser();
		//findByUserName();
		updateUser();
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
				String idString = (String) resultSet.getObject("ID");
				String username = (String) resultSet.getObject("username");
				System.out.println(idString+":"+username);
			}
			// 7:�ر����ݿ�����
			resultSet.close();
			preparedStatament.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void addUser(){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		// Ϊʲô�������� ���ݿ����� �����ݿ�ʵ��֮�� ������Ҫдһ��try catch
		// ������Ϊ�־��Բ��� ������в��ȶ��ԣ����� ����д��SQL����д��
		// �ܽ�һ�仰 ���ǳԾͳԵĲ������в��ȶ��� ��Ҫtry catch����
		try {
			//f3���Կ��ٶ�λ�� �ı����Ĵ�����
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/chensiwei","root","3cwangzi");
			preparedStatement = connection
					.prepareStatement("insert into ahgc_user (username) values (?)");
			preparedStatement.setObject(1,"������");
			int executeNum = preparedStatement.executeUpdate();
			if(executeNum == 0){
				System.out.println("���ʧ��");
			}
			else{
				System.out.println("��ӳɹ�");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void updateUser(){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		// Ϊʲô�������� ���ݿ����� �����ݿ�ʵ��֮�� ������Ҫдһ��try catch
		// ������Ϊ�־��Բ��� ������в��ȶ��ԣ����� ����д��SQL����д��
		// �ܽ�һ�仰 ���ǳԾͳԵĲ������в��ȶ��� ��Ҫtry catch����
		try {
			//f3���Կ��ٶ�λ�� �ı����Ĵ�����
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/chensiwei","root","3cwangzi");
			preparedStatement = connection
					.prepareStatement("update ahgc_user set age = 21 where id = ?");
			preparedStatement.setObject(1,"129");
			int executeNum = preparedStatement.executeUpdate();
			if(executeNum == 0){
				System.out.println("�޸�ʧ��");
			}
			else{
				System.out.println("�޸ĳɹ�");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		// Ϊʲô�������� ���ݿ����� �����ݿ�ʵ��֮�� ������Ҫдһ��try catch
		// ������Ϊ�־��Բ��� ������в��ȶ��ԣ����� ����д��SQL����д��
		// �ܽ�һ�仰 ���ǳԾͳԵĲ������в��ȶ��� ��Ҫtry catch����
		try {
			//f3���Կ��ٶ�λ�� �ı����Ĵ�����
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/chensiwei","root","3cwangzi");
			preparedStatement = connection
					.prepareStatement("delete from ahgc_user where id = ?");
			preparedStatement.setObject(1,"170");
			int executeNum = preparedStatement.executeUpdate();
			if(executeNum == 0){
				System.out.println("ɾ��ʧ��");
			}
			else{
				System.out.println("ɾ���ɹ�");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// �����û���������id
	public  static void findByUserName(){
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//f3���Կ��ٶ�λ�� �ı����Ĵ�����
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/chensiwei","root","3cwangzi");
			preparedStatement = connection
					.prepareStatement("select id from ahgc_user where username = ?");
			preparedStatement.setObject(1, "���");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getObject("ID"));
				System.out.println(resultSet.getObject(1));
				//170
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
