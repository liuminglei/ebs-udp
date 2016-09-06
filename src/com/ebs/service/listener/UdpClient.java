package com.ebs.service.listener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 工程： e招标</br> 类名：UdpClient</br>
 * 
 * <p>
 * 功能描述：TODO
 * </p>
 * 
 * 作者： </br> 创建日期： 2016年9月5日</br> 修改记录：（修改时间、作者、原因）：</br>
 */
public class UdpClient {
    private static final int PORT = 5506;
    private DatagramSocket dataSocket;
    private DatagramPacket dataPacket;
    private byte sendDataByte[];
    private String sendStr;

    public UdpClient() {
        Init();
    }

    public void Init() {
        try {
            // 指定端口号，避免与其他应用程序发生冲突
            dataSocket = new DatagramSocket(PORT + 1);
            sendDataByte = new byte[1024];
            sendStr = "UDP方式发送数据";
            sendDataByte = sendStr.getBytes();
            dataPacket = new DatagramPacket(sendDataByte, sendDataByte.length, InetAddress.getByName("192.168.7.11"), PORT);
            dataSocket.send(dataPacket);
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new UdpClient();
    }
}
