package springmvc_example.model;

import java.sql.Timestamp;
import java.util.Date;

public class Sale {
	
	// 販売履歴のID
	private Integer saleId;

	// ユーザ ID
	private Integer userId;

	// 商品ID
	private String productId;

	// 購入の数
	private Integer quantity;

	// 合計金額
	private Integer price;

	// 作成日
	private Timestamp createAt;

	// 更新日
	private Timestamp updateAt;

	/* Construction */
	public Sale() {

	}

	public Sale(Integer saleId, Integer userId, String productId, Integer quantity, Integer price) {
		super();
		this.saleId = saleId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
