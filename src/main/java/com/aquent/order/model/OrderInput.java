package com.aquent.order.model;

public class OrderInput {

	private String itemOrdered;
	private long timeOfOrder;
	
	public OrderInput(String itemOrdered, long timeOfOrder) {
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

	public long getTimeOfOrder() {
		return timeOfOrder;
	}

	public void setTimeOfOrder(long timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	@Override
	public String toString() {
		return "OrderInput [itemOrdered=" + itemOrdered + ", timeOfOrder=" + timeOfOrder + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemOrdered == null) ? 0 : itemOrdered.hashCode());
		result = prime * result + (int) (timeOfOrder ^ (timeOfOrder >>> 32));
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
		OrderInput other = (OrderInput) obj;
		if (itemOrdered == null) {
			if (other.itemOrdered != null)
				return false;
		} else if (!itemOrdered.equals(other.itemOrdered))
			return false;
		if (timeOfOrder != other.timeOfOrder)
			return false;
		return true;
	}
	
	
	
}
