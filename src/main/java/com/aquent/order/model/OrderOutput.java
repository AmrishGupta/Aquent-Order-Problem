package com.aquent.order.model;

import java.io.Serializable;
import java.util.Date;

public class OrderOutput implements Serializable,Comparable<OrderOutput> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemOrdered;
	private Date timeOfOrder;
	
	
	public OrderOutput(String itemOrdered, Date timeOfOrder) {
		super();
		this.itemOrdered = itemOrdered;
		this.timeOfOrder = timeOfOrder;
	}
	
	public String getItemOrdered() {
		return itemOrdered;
	}
	public void setItemOrdered(String itemOrdered) {
		this.itemOrdered = itemOrdered;
	}
	public Date getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(Date timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	//This method will also govern the output format to the file.
	@Override
	public String toString() {
		return String.format("%-15s", itemOrdered) + timeOfOrder;
	}

	@Override
	public int compareTo(OrderOutput o) {
		// TODO Auto-generated method stub
		if(this.getItemOrdered().compareTo(o.getItemOrdered()) == 0)
		{
			return this.getTimeOfOrder().compareTo(o.getTimeOfOrder());
		}
		return this.getItemOrdered().compareTo(o.getItemOrdered());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemOrdered == null) ? 0 : itemOrdered.hashCode());
		result = prime * result + ((timeOfOrder == null) ? 0 : timeOfOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderOutput other = (OrderOutput) obj;
		if (itemOrdered == null) {
			if (other.itemOrdered != null)
				return false;
		} else if (!itemOrdered.equals(other.itemOrdered))
			return false;
		if (timeOfOrder == null) {
			if (other.timeOfOrder != null)
				return false;
		} else if (!timeOfOrder.equals(other.timeOfOrder))
			return false;
		return true;
	}
	
	

	

}
