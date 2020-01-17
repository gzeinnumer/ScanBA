package com.gzeinnumer.scanba.model;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("id")
	private String id;

	@SerializedName("plat")
	private String plat;

	@SerializedName("status")
	private String status;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPlat(String plat){
		this.plat = plat;
	}

	public String getPlat(){
		return plat;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}