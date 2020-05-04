package com.foucstech.pojo;

/**
 * @author wuandong
 * @classname UserInfo
 * @date 2020/5/4 11:13
 */
public class UserInfo {
    private Long userId;

    private String userName;

    private String mobile;

    private String email;

    public UserInfo(Long userId, String userName, String mobile, String email) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
