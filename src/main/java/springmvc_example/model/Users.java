package springmvc_example.model;

import java.util.Date;
import java.util.List;

public class Users {
	
	
	private String userId;
	
	private String password;
	
	
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
	
	
	public Users() {
		super();
	}

	public Users(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.telNumber = telNumber;
		this.createAt = createAt;
		this.updateAt = updateAt;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
