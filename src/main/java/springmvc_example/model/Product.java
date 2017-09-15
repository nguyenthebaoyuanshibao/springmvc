package springmvc_example.model;

import java.math.BigDecimal;

/**
 * @author life
 *
 */
public class Product

{
	private Integer productId;
	private String url;
	private String categoryId;
	private String productName;
	private Integer unitPrice;
	private Integer unitsInStock;
	private String description;
	private String manufacturer;
	
	
	
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
