package com.ebs.service.listener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer extends Thread {

    private DatagramSocket datagramSocket;

    @Override
    public void run() {

        try {
            datagramSocket = new DatagramSocket(5506);
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
                datagramSocket.receive(datagramPacket);
                String msg = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(datagramPacket.getAddress() + "/" + datagramPacket.getPort() + " msg:" + msg);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
