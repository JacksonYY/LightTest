package iot.jackson.light.judgeData;

public class DealData {
	public String orderString;
	public String newsNumber; //定义消息编号
	public void setorderString(String orderString) {
		this.orderString = orderString;
	}
	
	public String getorderString() {
		return orderString;
	}
	
	public boolean judgeOrderForm () {
		if(orderString.startsWith("#21") 
				&& orderString.endsWith("*")) {
			return true;
		}
		else 
			return false;
	}
	
	
	public void analyseOrder () {
		
		String key  = orderString.substring(3,4);
		
		//获得类型编号
		GetResult getResult = new GetResult();
		getResult.addElement();
		//getResult.print();
		newsNumber = getResult.printResult(key,orderString);
	}
	
	public String getnewsNumber() {
		return  newsNumber;
	}
}
