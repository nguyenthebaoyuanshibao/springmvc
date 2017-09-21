package springmvc_example.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Category {

	// カテゴリーID
	private String categoryId;

	// 作成日
	private Timestamp createAt;

	// 更新日
	private Timestamp updateAt;

	/* Construction */
	public Category() {

	}

	public Category(String categoryId, Timestamp createAt, Timestamp updateAt) {
		
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

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}
