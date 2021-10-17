package entity;

import java.util.List;

//分页用到的类
public class Page {
//		当前页 page
	private int page;
//		页面大小 pageSize 固定为10
	private int pageSize;
//		总数据量 totalCount
	private int totalCount;
//		总页数 totalPage
	private int totalPage;
//		当前页的数据集合 students
	private List<Student> students;

	public Page() {
	}

	public Page(int page, int pageSize, int totalCount, int totalPage, List<Student> students) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		// 总页数 = 数据总数%页面大小==0？ 数据总数/页面大小：数据总数/页面大小+1 取余，看够不够一页
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", students=" + students + "]";
	}

}
