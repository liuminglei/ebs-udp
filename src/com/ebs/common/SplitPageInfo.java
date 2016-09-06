package com.ebs.common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 分页对象
 * 
 * @author 李小江
 * 
 */
public class SplitPageInfo implements Serializable {
	private static final long serialVersionUID = -1610997402731940907L;

	private int totalRowsAmount; // 总行数

	private boolean rowsAmountSet; // 是否设置过总行数

	private int pageSize = 5; // 每页行数

	private int currentPage = 1; // 当前页

	private int nextPage; // 下一页

	private int previousPage; // 前一页

	private int totalPages; // 总页数

	private int pageRowBegin; // 页面起始记录号

	private int pageRowEnd; // 页面终止记录号

	private boolean hasToFirstPage; // 是否有第一页

	private boolean hasNext; // 是否有下一页

	private boolean hasPrevious; // 是否有上一页

	private boolean hasLastPage; // 是否有最后一页

	private String description; // 当前页描述信息()(共7条,此页1-6条,共2页,此页1/2)

	private boolean listIsEmpty = true; // 是否有分页数据

	private String sbSqlWhere = null;

	public SplitPageInfo() {
	}

	/**
	 * 构造函数
	 * 
	 * @param pageSize
	 *            每页记录数
	 */
	public SplitPageInfo(int pageSize) {
		this.pageSize = pageSize;
		this.rowsAmountSet = false;
	}

	/**
	 * 获取符合条件的总记录数
	 * 
	 * @return 符合条件的总记录数
	 */
	public int getTotalRowsAmount() {
		return this.totalRowsAmount;
	}

	/**
	 * 设置符合条件的总记录数
	 * 
	 * @param totalRowsAmount
	 */
	public void setTotalRowsAmount(int totalRowsAmount) {
		this.totalRowsAmount = totalRowsAmount;
		this.rowsAmountSet = true;
		if (totalRowsAmount > 0) {
			this.listIsEmpty = false;
		}
		if ((this.totalRowsAmount % this.pageSize) == 0) {
			this.totalPages = this.totalRowsAmount / this.pageSize;
		} else {
			this.totalPages = this.totalRowsAmount / this.pageSize + 1;
		}

		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPages) {
			this.currentPage = this.totalPages;
		}
		if (this.currentPage > 1) {
			this.hasToFirstPage = true;
		} else {
			this.hasToFirstPage = false;
		}

		if (this.currentPage < this.totalPages) {
			this.nextPage = this.currentPage + 1;
			this.hasNext = true;
		} else {
			this.nextPage = this.currentPage;
			this.hasNext = false;
		}

		if (this.currentPage > 1) {
			this.previousPage = this.currentPage - 1;
			this.hasPrevious = true;
		} else {
			this.previousPage = this.currentPage;
			this.hasPrevious = false;
		}

		if (this.currentPage > 0) {
			this.pageRowBegin = (this.currentPage - 1) * this.pageSize + 1;
		} else {
			this.pageRowBegin = 0;
		}

		if (this.currentPage < this.totalPages) {
			this.pageRowEnd = this.pageRowBegin + this.pageSize - 1;
		} else {
			this.pageRowEnd = this.pageRowBegin + (this.totalRowsAmount - 1)
					% this.pageSize;
			if (this.pageRowEnd < 0) {
				this.pageRowEnd = 0;
			}
		}

		if (this.currentPage == this.totalPages) {
			this.hasLastPage = false;
		} else {
			this.hasLastPage = true;
		}

		this.description = "共" + this.totalRowsAmount + "条，" + "此页"
				+ this.pageRowBegin + "-" + this.pageRowEnd + "条  共"
				+ this.totalPages + "页，此页" + this.currentPage + "/"
				+ this.totalPages;

	}

	/**
	 * 是否设置过符合条件的总记录数
	 * 
	 * @return true-已设置 false-未设置
	 */
	public boolean getRowsAmountSet() {
		return this.rowsAmountSet;
	}

	/**
	 * 设置是否设置过符合条件的总记录数
	 */
	public void setRowsAmountSet(boolean rowsAmountSet) {
		this.rowsAmountSet = rowsAmountSet;
	}

	/**
	 * 返回每页记录数
	 * 
	 * @return 每页记录数
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * 设置每页记录数
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取当前页码
	 * 
	 * @return 当前页码
	 */
	public int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * 设置当前页码
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取下页页码
	 * 
	 * @return 下页页码
	 */
	public int getNextPage() {
		return this.nextPage;
	}

	/**
	 * 设置下页页码
	 * 
	 * @param nextPage
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * 获取上页页码
	 * 
	 * @return 上页页码
	 */
	public int getPreviousPage() {
		return this.previousPage;
	}

	/**
	 * 设置上页页码
	 * 
	 * @param previousPage
	 */
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * 获取总页数
	 * 
	 * @return 总页数
	 */
	public int getTotalPages() {
		return this.totalPages;
	}

	/**
	 * 设置总页数
	 * 
	 * @param totalPages
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 获取当前页的起始记录号
	 * 
	 * @return 当前页的起始记录号
	 */
	public int getPageRowBegin() {
		return this.pageRowBegin;
	}

	/**
	 * 设置当前页的起始记录号
	 * 
	 * @param pageRowBegin
	 */
	public void setPageRowBegin(int pageRowBegin) {
		this.pageRowBegin = pageRowBegin;
	}

	/**
	 * 获取当前页的终止记录号
	 * 
	 * @return 当前页的终止记录号
	 */
	public int getPageRowEnd() {
		return this.pageRowEnd;
	}

	/**
	 * 设置当前页的终止记录号
	 * 
	 * @param pageRowEnd
	 */
	public void setPageRowEnd(int pageRowEnd) {
		this.pageRowEnd = pageRowEnd;
	}

	/**
	 * 获取是否有下一页
	 * 
	 * @return 是否有下一页
	 */
	public boolean getHasNext() {
		return this.hasNext;
	}

	/**
	 * 设置是否有下一页
	 * 
	 * @param hasNext
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * 获取是否有上一页
	 * 
	 * @return true-有 false-无
	 */
	public boolean getHasPrevious() {
		return this.hasPrevious;
	}

	/**
	 * 设置是否有上一页
	 * 
	 * @param hasPrevious
	 */
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	/**
	 * 获取是否有最后一页
	 * 
	 * @return 是否有最后一页
	 */
	public boolean getHasLastPage() {
		return this.hasLastPage;
	}

	/**
	 * 设置是否有最后一页
	 * 
	 * @param hasLastPage
	 */
	public void setHasLastPage(boolean hasLastPage) {
		this.hasLastPage = hasLastPage;
	}

	/**
	 * 获取当前页描述信息()(共7条,此页1-6条,共2页,此页1/2)
	 * 
	 * @return 当前页描述信息
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置当前页描述信息()(共7条,此页1-6条,共2页,此页1/2)
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取是否有分页数据
	 * 
	 * @return 是否有分页数据
	 */
	public boolean getListIsEmpty() {
		return this.listIsEmpty;
	}

	/**
	 * 设置是否有分页数据
	 * 
	 * @param listIsEmpty
	 */
	public void setListIsEmpty(boolean listIsEmpty) {
		this.listIsEmpty = listIsEmpty;
	}

	/**
	 * 获取是否有第一页
	 * 
	 * @return true-有 false-无
	 */
	public boolean getHasToFirstPage() {
		return this.hasToFirstPage;
	}

	/**
	 * 设置是否有第一页
	 * 
	 * @param hasToFirstPage
	 */
	public void setHasToFirstPage(boolean hasToFirstPage) {
		this.hasToFirstPage = hasToFirstPage;
	}

	/**
	 * 获取当前分页对象所携带的业务查询条件
	 * 
	 * @return 当前分页对象所携带的业务查询条件
	 */
	public String getSbSqlWhere() {
		return this.sbSqlWhere;
	}

	/**
	 * 设置当前分页对象所携带的业务查询条件
	 * 
	 * @param sbSqlWhere
	 */
	public void setSbSqlWhere(String sbSqlWhere) {
		this.sbSqlWhere = sbSqlWhere;
	}

	public static SplitPageInfo getInstance(HttpServletRequest request) {
		SplitPageInfo splitPageInfo = new SplitPageInfo();
		if (request.getParameter("currentPage_Split") != null
				&& !request.getParameter("currentPage_Split").equals("")) {
			int currentPage_Split = Integer.parseInt(request
					.getParameter("currentPage_Split"));
			splitPageInfo.setCurrentPage(currentPage_Split);
		}
		if (request.getParameter("pageSize_Split") != null
				&& !request.getParameter("pageSize_Split").equals("")) {
			int pageSize_Split = Integer.parseInt(request
					.getParameter("pageSize_Split"));
			splitPageInfo.setPageSize(pageSize_Split);
		}
		if (request.getParameter("sbSqlWhere_Split") != null
				&& !request.getParameter("sbSqlWhere_Split").equals("")) {
			String sbSqlWhere_Split = request.getParameter("sbSqlWhere_Split");
			splitPageInfo.setSbSqlWhere(sbSqlWhere_Split);
		}
		return splitPageInfo;
	}

	public void setSplitPageData(HttpServletRequest request) {
		request.setAttribute("SplitPageInfo_Split", this);
	}
}