package com.zhou.demo.test.bleDemo;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName BluetoothServerTest
 * @Author JackZhou
 * @Date 2020/12/16  18:14
 **/
public class BluetoothServerTest {
    public static void main(String[] argv) {
        final String serverName = "Bluetooth Server Test";
        final String serverUUID = "1000110100001000800000805F9B34FB";  //根据需要自定义

        BluetoothServer server = new BluetoothServer(serverUUID, serverName);
        server.setServerListener(new BluetoothServer.OnServerListener() {

            @Override
            public void onConnected(InputStream inputStream, OutputStream outputStream) {
                System.out.println("Connected");
                //添加通信代码
            }

            @Override
            public void onDisconnected() {
                System.out.println("onDisconnected");
            }

            @Override
            public void onClose() {
                System.out.println("onClose");
            }

        });

        server.start();
    }
}
