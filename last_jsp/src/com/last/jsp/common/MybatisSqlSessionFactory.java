package com.last.jsp.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory ssf;
	
	//MybatisSqlSessionFactory -> mybatis-config.xml -> menu.xml 순서
	static {
		try(InputStream is = Resources.getResourceAsStream("conf/mybatis-config.xml")) { //inputstream 바이트단위로 데이터를 읽는다
			ssf = new SqlSessionFactoryBuilder().build(is); //sqlsession: 마이바티스를 사용하기 위한 기본적인 자바 인터페이스
			//모든 마이바티스 애플리케이션은 SqlSessionFactory 인스턴스를 사용한다. SqlSessionFactory인스턴스는 SqlSessionFactoryBuilder를 사용하여 만들수 있다
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSSF() {
		return ssf;
	}
	
	public static SqlSession getSS() {
		return getSSF().openSession();
	}
	
	public static SqlSession getSS(boolean commit) {
		return getSSF().openSession(commit);
	}
	
	public static void main(String[] args) {
		try(SqlSession ss = MybatisSqlSessionFactory.getSS()) { //
			List<Map<String,String>> list = ss.selectList("menu.selectMenu"); //menu.xml에서 namespace,id를 저렇게 줬음
			for(Map<String,String> m : list) {
				System.out.println(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
