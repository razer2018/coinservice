package com.coindemo.common.id;

/**
 * @author kaihu
 */
public interface IdCreator {
	public Long nextId(String sKey) throws Exception;
}
