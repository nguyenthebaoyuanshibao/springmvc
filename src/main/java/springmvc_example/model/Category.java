package springmvc_example.model;

import java.util.Date;
import java.util.List;

public class Category {

	// カテゴリーID
	private String categoryId;

	// 作成日
	private Date createAt;

	// 更新日
	private Date updateAt;

	/* Construction */
	public Category() {

	}

	public Category(String categoryId, Date createAt, Date updateAt) {
		
		this.categoryId = categoryId;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
