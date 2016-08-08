package com.school.util;
/** 
 * @author Sherlock-lee
 * @version 创建时间：2015年3月25日 上午8:22:01 
 * @Tel 15622358381
 * @state 分页
 */
public class Page {
	
	private int offset = 0;
	private int limit = 10;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * 
	 * @author Sherlock-lee
	 * 功能:mybatis ognl表达式的要求
	 * @return page
	 */
	public Page getPage(){
		
		return new Page();
	}

}
