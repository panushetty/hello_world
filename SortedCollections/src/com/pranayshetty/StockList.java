package com.pranayshetty;
import java.util.*;



public class StockList {
	private final Map<String,StockItem> list;

	public StockList(Map<String, StockItem> list) {
		this.list = new HashMap<>();
	}
	
	public int addStock(StockItem item) {
		if(item!=null) {
			StockItem inStock=list.getOrDefault(item.getName(), item);
			if(inStock!=item) {
				item.adjustStock(inStock.getQuantityStock());
				
			} 
			list.put(item.getName(),item);
			return item.getQuantityStock();
		}
		return 0;
	}
	
	public int sellStock(String item,int quantity) {
		StockItem inStock=list.getOrDefault(item, null);
		
		if((inStock!=null)&& (inStock.getQuantityStock()>=quantity) && (quantity>0)) {
			inStock.adjustStock(-quantity);
			return quantity;
		}
		else {
			return 0;
		}
		
	}
	
	public StockItem get(String key) {
		return list.get(key);
	}
	
	public Map<String ,StockItem> Items(){
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s="\nStockList\n";
		double totalCost=0.0;
	    for(Map.Entry<String, StockItem> item:list.entrySet()) {
	    	StockItem stockItem=item.getValue();
	    	
	    	double itemValue=stockItem.getPrice()*stockItem.getQuantityStock();
	    	s=s+ stockItem +". There are "+ stockItem.getQuantityStock()+"in stock . Value of Items :";
	    	s=s+itemValue+"\n";
	    	totalCost+=itemValue;
	    	
	    }
	    return s+" Total stock value "+totalCost; 
	}
	
	
	

}
