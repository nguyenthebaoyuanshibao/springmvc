package springmvc_example.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Users {
	
	//ユーザ ID
	private Integer userId;
	
	//user name
	private String userName;
	
	//パスワード
	private String password;
	
	// ユーザ性別
	private String userGender;
	
	// ユーザメール
	private String userEmail;
	
	// 電話番号
	private String telNumber;
	
	// 作成日
	private Timestamp createAt;
	
	// 更新日
    private Timestamp updateAt;
	
	public Users() {
		super();
	}

	public Users(String userName, String password) {

		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.telNumber = telNumber;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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
