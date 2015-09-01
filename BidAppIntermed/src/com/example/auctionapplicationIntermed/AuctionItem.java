package com.example.auctionapplicationIntermed;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AuctionItem implements Serializable {

	private BigDecimal BidPrice;
	private String name;
	private String description;
	private String image;
	private int ItemID;
	private Date StartDate;
	private Date EndDate;
	
	//MAKE THIS SOME SORT OF LIBRARY TO BE SHARED BY SERVER PROJECT AND BIDAPP PROJECT

	
	public AuctionItem(BigDecimal bidPrice, String name, String image, String description, int itemID, Date StartDate, Date EndDate) {
		super();
		this.setImage(image);
		BidPrice = bidPrice;
		this.name = name;
		this.ItemID = itemID;
		this.setDescription(description);
		this.setStartDate(StartDate);
		this.setEndDate(EndDate);
	}
	


	public AuctionItem(BigDecimal bidPrice, String name, String description, int itemID, Date StartDate, Date EndDate) {
		super();
		this.image = "questionmark";
		BidPrice = bidPrice;
		this.name = name;
		this.ItemID = itemID;
		this.setDescription(description);
		this.setStartDate(StartDate);
		this.setEndDate(EndDate);
	}
	



	public BigDecimal getBidPrice() {
		return BidPrice;
	}

	public void setBidPrice(BigDecimal d) {
		BidPrice = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getEndDate() {
		return EndDate;
	}



	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}



	public Date getStartDate() {
		return StartDate;
	}



	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	
}
