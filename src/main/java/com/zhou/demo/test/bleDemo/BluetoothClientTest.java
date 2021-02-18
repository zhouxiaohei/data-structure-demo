package com.zhou.demo.test.bleDemo;

import javax.bluetooth.RemoteDevice;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * @ClassName BluetoothClientTest
 * @Author JackZhou
 * @Date 2020/12/16  17:09
 **/

public class BluetoothClientTest {
    public static void main(String[] argv) {
        final String serverUUID = "1000110100001000800000805F9B34FB"; //需要与服务端相同

        BluetoothClient client = new BluetoothClient();

        Vector<RemoteDevice> remoteDevices = new Vector<>();

        client.setOnDiscoverListener(new BluetoothClient.OnDiscoverListener() {

            @Override
            public void onDiscover(RemoteDevice remoteDevice) {
                remoteDevices.add(remoteDevice);
            }

        });

        client.setClientListener(new BluetoothClient.OnClientListener() {

            @Override
            public void onConnected(InputStream inputStream, OutputStream outputStream) {
                System.out.println("Connected");
                //添加通信代码
            }

            @Override
            public void onConnectionFailed() {
                System.out.println("Connection failed");
            }

            @Override
            public void onDisconnected() {

            }

            @Override
            public void onClose() {

            }

        });

        try {
            client.find();

            if (remoteDevices.size() > 0) {
                for(RemoteDevice device : remoteDevices){
                    if(device.getFriendlyName(false).equalsIgnoreCase("DESKTOP-SIJ19AE")){
                        System.out.println("开始连接");
                        client.startClient(device, serverUUID);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
