package springmvc_example.model;

import java.util.Date;
import java.util.List;

public class UserInfo {
	
	
	private String userName;
	
	private String password;
	
    private UserRole role;
	
	// ユーザ性別
	private String userGender;
	
	// ユーザメール
	private String userEmail;
	
	// 電話番号
	private String telNumber;
	
	// 作成日
	private Date createAt;
		
	// 更新日
	private Date updateAt;
	
	//ストアのリスト
	private List<Store> stores;
	
	//お気に入りのリスト
	private List<Favorite> favorites;
	
	//レビューのリスト
	private List<Review> reviews;
	
	//販売履歴のリスト
	private List<Salehistory> saleHistories;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
		this.role = role;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.telNumber = telNumber;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.stores = stores;
		this.favorites = favorites;
		this.reviews = reviews;
		this.saleHistories = saleHistories;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
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

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Salehistory> getSaleHistories() {
		return saleHistories;
	}

	public void setSaleHistories(List<Salehistory> saleHistories) {
		this.saleHistories = saleHistories;
	}
    
	
	
}
