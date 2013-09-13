package iot.jackson.light.main;


import iot.jackson.light.judgeData.DealData;
import iot.jackson.light.judgeData.GetResult;
import iot.jackson.light.settingData.settingData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class lightTest {
	private static BufferedReader reader;
	private static BufferedWriter writer;
	private static Timer sendOrderTimer;
	
	public static void main(String[]args) { 
		Socket  socket = null;
		String recvData = "";
		String data = ""; //消息编号
		try {
			socket = new Socket(settingData.LightIP,settingData.LightMainPort);
			reader = new BufferedReader(new InputStreamReader
								(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter
								(socket.getOutputStream()));
			
			if (sendOrderTimer != null) {
				sendOrderTimer.cancel();
				sendOrderTimer = null;
			}
				
			sendOrderTimer = new Timer();
			
			sendOrderTimer.schedule(new TimerTask() {
				String string = "#2017csfj001  *";
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (writer != null) {
						synchronized (writer) {
							try {
								writer.write(string+"\n");
								writer.flush();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}, 0 , 5000);
			while(true) {
				recvData = reader.readLine();
				System.out.println(recvData);
				//把从服务器读取到的值打印出来
				DealData dealData = new DealData();
				dealData.setorderString(recvData);
				
				if (dealData.judgeOrderForm()) { 
					dealData.analyseOrder(); 
					data = dealData.newsNumber;  //消息编号
					writer.write("#2897csfj001"+data+"  *"+"\n");
					//命令回复;
					writer.flush();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

