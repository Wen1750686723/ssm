package com.ssm.dto;

/**
 * @author liuwenbo
 *
 */
public class Loginlog {
	private Integer id;
	private Integer userid;
	private Long time;
	private String ip;
	private String safari;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSafari() {
		return safari;
	}
	public void setSafari(String safari) {
		this.safari = safari;
	}
	@Override
	public String toString() {
		return "Loginlog [id=" + id + ", userid=" + userid + ", time=" + time + ", ip=" + ip + ", safari=" + safari
				+ "]";
	}
	
}