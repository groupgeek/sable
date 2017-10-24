package com.xiaohe.bean;

import java.util.List;

public class ProductcolourCustom extends Productcolour {
	
	private List<ProductcoloursizeCustom> colourSizeList;

	public List<ProductcoloursizeCustom> getColourSizeList() {
		return colourSizeList;
	}

	public void setColourSizeList(List<ProductcoloursizeCustom> colourSizeList) {
		this.colourSizeList = colourSizeList;
	}

}
