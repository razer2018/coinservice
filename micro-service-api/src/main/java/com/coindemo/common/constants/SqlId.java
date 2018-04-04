package com.coindemo.common.constants;

/**
 * Mybatis Sql脚本的ID名称
 */
public interface SqlId {
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_BY_ID = "selectByPrimaryKey";
	public String SQL_UPDATE_BY_ID = "updateByPrimaryKey";
	public String SQL_UPDATE_BY_ID_SELECTIVE = "updateByPrimaryKeySelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
	public String SQL_INSERT = "insert";
	public String SQL_INSERT_BY_Batch = "insertByBatch";
	public String SQL_DELETE_BY_IDLIST = "deleteByIdList";
	
	
}
