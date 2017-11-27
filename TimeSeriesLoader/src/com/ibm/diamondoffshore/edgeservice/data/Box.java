package com.ibm.diamondoffshore.edgeservice.data;

import com.google.gson.annotations.SerializedName;

public class Box {

  /**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

@SerializedName("w")
  private int width;

  @SerializedName("h")
  private int height;

  @SerializedName("d")
  private int depth;

  // Methods removed for brevity
}