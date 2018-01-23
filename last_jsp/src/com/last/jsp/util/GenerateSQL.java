package com.last.jsp.util;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.last.jsp.common.MybatisSqlSessionFactory;

public class GenerateSQL {

	public static void main(String[] args) {
		try(SqlSession ss = MybatisSqlSessionFactory.getSS()){
			String tableName="user_info";
			List<Map<String,String>> colList = ss.selectList("common.selectTable", tableName);
			String selectSql = "";
			String updateSql = "";
			String deleteSql = "";
			String insertSql = "";
			for(Map<String,String> m : colList) {
				selectSql += m.get("colName") + ",";
				if(!m.get("colName").equals("uino")) {
					updateSql += m.get("colName") + ",";
				}
				deleteSql += m.get("colName") + ",";
				insertSql += m.get("colName") + ",";
			}
			selectSql = "select " + selectSql.substring(0, selectSql.length()-1) + " from " + tableName;
			System.out.println(selectSql);
			
//			deleteSql = "delete from " + tableName + " where " + ;
//			insertSql = "insert into " + tableName + ();
		}
	}
}
