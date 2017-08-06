package com.ssm.dto;

public class Nav {
	 private Integer id;    
	 
	 private Integer cid; 
	 
	 //是否显示
	 private Integer ifshow;  
	 
	//显示顺序
	 private Integer vieworder;  
	 
	//是否显示新标签
	 private Integer opennew;  
	    
	 //菜单名称
	 private String name;   
	 //url
	 private String url;
	//类型
	 private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getIfshow() {
		return ifshow;
	}
	public void setIfshow(Integer ifshow) {
		this.ifshow = ifshow;
	}
	public Integer getVieworder() {
		return vieworder;
	}
	public void setVieworder(Integer vieworder) {
		this.vieworder = vieworder;
	}
	public Integer getOpennew() {
		return opennew;
	}
	public void setOpennew(Integer opennew) {
		this.opennew = opennew;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Nav [id=" + id + ", cid=" + cid + ", ifshow=" + ifshow + ", vieworder=" + vieworder + ", opennew="
				+ opennew + ", name=" + name + ", url=" + url + ", type=" + type + "]";
	}
	 
    
}
