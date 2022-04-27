package com.test.entelgy.dto.request;

import java.util.List;

public class ExternalUserResponseDto {
	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	
	public ExternalUserResponseDto() {
		super();
	}
	private List<ExternalUserResponseDataDto> data;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<ExternalUserResponseDataDto> getData() {
		return data;
	}
	public void setData(List<ExternalUserResponseDataDto> data) {
		this.data = data;
	}
	
}
