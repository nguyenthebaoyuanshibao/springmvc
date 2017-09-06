package springmvc_example.model;

import java.math.BigDecimal;

/**
 * @author life
 *
 */
public class Product
{
	private String productId 		;
	private String productName 			;
	private BigDecimal unitPrice 	= null;
	private String description		= null;
	private String manufacturer	 	= null;
	private String categoryId			;
	private Integer unitsInStock		= null;
	private Integer unitsInOrder		= null;
	private String condition		= null;
	
	public Product()
	{
		super();
	}

	public Product(String argProductId, String arName, BigDecimal arUnitPrice)
	{
		this.productId = argProductId;
		this.productName = arName;
		this.unitPrice = arUnitPrice;
	}
	
	public String getProductId()
	{
		return this.productId;
	}
	public void setProductId(String argProductId)
	{
		this.productId = argProductId;
	}
	public String getProductName()
	{
		return this.productName;
	}
	public void setProductName(String argName)
	{
		this.productName = argName;
	}
	public BigDecimal getUnitPrice()
	{
		return this.unitPrice;
	}
	public void setUnitPrice(BigDecimal argUnitPrice)
	{
		this.unitPrice = argUnitPrice;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String argDescription)
	{
		this.description = argDescription;
	}
	public String getManufacturer()
	{
		return this.manufacturer;
	}
	public void setManufacturer(String argManufacturer)
	{
		this.manufacturer = argManufacturer;
	}
	public String getCategoryId()
	{
		return this.categoryId;
	}
	public void setCategoryId(String argCategory)
	{
		this.categoryId = argCategory;
	}
	public Integer getUnitsInStock()
	{
		return this.unitsInStock;
	}
	public void setUnitsInStock(Integer argUnitsInStock)
	{
		this.unitsInStock = argUnitsInStock;
	}
	public Integer getUnitsInOrder()
	{
		return this.unitsInOrder;
	}
	public void setUnitsInOrder(Integer argUnitsInOrder)
	{
		this.unitsInOrder = argUnitsInOrder;
	}
	
	public String getCondition()
	{
		return this.condition;
	}
	public void setCondition(String argCondition)
	{
		this.condition = argCondition;
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
