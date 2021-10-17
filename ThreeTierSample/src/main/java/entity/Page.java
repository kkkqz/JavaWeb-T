package entity;

import java.util.List;

//��ҳ�õ�����
public class Page {
//		��ǰҳ page
	private int page;
//		ҳ���С pageSize �̶�Ϊ10
	private int pageSize;
//		�������� totalCount
	private int totalCount;
//		��ҳ�� totalPage
	private int totalPage;
//		��ǰҳ�����ݼ��� students
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
		// ��ҳ�� = ��������%ҳ���С==0�� ��������/ҳ���С����������/ҳ���С+1 ȡ�࣬��������һҳ
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
