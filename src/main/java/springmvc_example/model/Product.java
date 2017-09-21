package springmvc_example.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * @author life
 *
 */
public class Product

{   
	//商品ID
	private Integer productId;
	
	//商品の写真のアドレス
	private String url;
	
	//商品のカテゴリ
	private String categoryId;
	
	//商品名
	private String productName;
	
	//商品の値段
	private Integer unitPrice;
	
	//残っている数
	private Integer unitsInStock;
	
	//商品の描写
	private String description;
	
	//サプライヤー
	private String manufacturer;
	
	private Timestamp createAt;
	
	private Timestamp updateAt;
	
	
	public Product()
	{
		super();
	}

	public Product(Integer productId,String url, String categoryId, String productName,
			Integer unitPrice, Integer unitsInStock,String description, String manufacturer )
	{
		this.productId = productId;
		this.url = url;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.description = description;
		this.manufacturer = manufacturer;
		
	}
	
	public Integer getProductId()
	{
		return this.productId;
	}
	
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public String getCategoryId()
	{
		return this.categoryId;
	}
	
	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public String getProductName()
	{
		return this.productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public Integer getUnitPrice()
	{
		return this.unitPrice;
	}
	
	public void setUnitPrice(Integer unitPrice)
	{
		this.unitPrice = unitPrice;
	}
	
	public Integer getUnitsInStock()
	{
		return this.unitsInStock;
	}
	
	public void setUnitsInStock(Integer unitsInStock)
	{
		this.unitsInStock = unitsInStock;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getManufacturer()
	{
		return this.manufacturer;
	}
	
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Product other = (Product) obj;
		if (productId == null)
		{
			if (other.productId != null) return false;
		}
		else if (!productId.equals(other.productId)) return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Product [productId=" + productId + ", name=" + productName + "]";
	}
}
