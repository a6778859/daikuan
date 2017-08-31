package com.daikuan.until;

public class PageLimit {
	protected String pageNo = "1";
	protected String pageSize = "10";

	public int getPageNo() {
		return Integer.parseInt(pageNo);
	}

	public void setPageNo(String pageNo) {
		if (!CommonUtil.isNumeric(pageNo) || StringUtil.isBlank(pageNo)) {
			pageNo = "1";
		}
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return Integer.parseInt(pageSize);
	}

	public void setPageSize(String pageSize) {
		if (!CommonUtil.isNumeric(pageSize) || StringUtil.isBlank(pageSize)) {
			pageSize = "10";
		}
		this.pageSize = pageSize;
	}

}
