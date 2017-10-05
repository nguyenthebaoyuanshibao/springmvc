package springmvc_example.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Category {

	// カテゴリーID
	private Integer categoryId;
	
	// categoryName
	private String categoryName;

	// 作成日
	private Timestamp createAt;

	// 更新日
	private Timestamp updateAt;

	/* Construction */
	public Category() {

	}

	public Category(Integer categoryId, String categoryName, Timestamp createAt, Timestamp updateAt) {
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getcategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
