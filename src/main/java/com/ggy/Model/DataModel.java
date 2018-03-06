package com.ggy.Model;

public class DataModel extends BaseResultModel {
	private Object data;

	public DataModel() {
	}

	public DataModel(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
