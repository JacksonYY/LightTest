package iot.jackson.light.judgeData;

public class GetString {
	public String s1,s2,s3,s4;
	public String orderString;
	public  void setOrderString(String orderString) {
		this.orderString = orderString;
	}
	
	private static class GetStringHolder {
		public static GetString getString = new GetString();
	}
	
	public static GetString getInstance() {
		return GetStringHolder.getString;
	}
	public void subString () {
		int paramNum,length ;
		length = orderString.length();
		s1 = orderString.substring(4,6);  
		paramNum = Integer.parseInt(s1);    //获取参数的长度
		s2 = orderString.substring(6,6+paramNum);  //获取参数的值
		s3 = orderString.substring(6+paramNum,8+paramNum);  //获取消息编号
		s4 = orderString.substring(length - 5 - paramNum ,length - 5);
		//反过来获得参数的值，用来验证命令串是否符合格式;
	}
}
