package iot.jackson.light.judgeData;

import java.util.HashMap;
import java.util.Map;

public class GetResult {
	GetString getString = GetString.getInstance();
	String s1,s2,s3,s4;
	Map <String,String> map = new HashMap<>();
	
	public void addElement() {
		map.put("1","心跳间隔");
		map.put("2","IP地址与port地址");
		map.put("3","模块ID");
		map.put("4","设定基站管理点数");
		map.put("5","调光数据设置");
		map.put("6","单独路灯调光控制");
		map.put("7","分组路灯设置");
		map.put("8","分段路灯设置");
		map.put("9","分组路灯控制");
		map.put("A","分段路灯控制");
		map.put("B","设置路灯地址");
		map.put("C", "设置网络参数");
		map.put("D", "设置开关机");
	}
	
	
	/**
	 * 此函数用来输出结果
	 * @param c 类型编号
	 */
	public String printResult(String key,String orderString) {
		getString.setOrderString(orderString);
		//System.out.println(getString.orderString+"yy");
		getString.subString();
		s1 = getString.s1;
		s2 = getString.s2;
		s3 = getString.s3;
		s4 = getString.s4;
		if(s2.equals(s4)) {
			System.out.println(map.get(key) + "参数长度是：" + Integer.parseInt(s1));
			System.out.println("参数值："+s2);
			System.out.println("消息编号"+s3);
			return s3;
		}
		else {
			System.out.println("命令格式错误");
			return "-1";
		}
	}
	
	void print() {
		System.out.println(map.get("1"));
	}
}
