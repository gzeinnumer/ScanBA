package com.gzeinnumer.scanba.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponsePlat{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}