package com.zhou.demo.test.bleDemo;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName BluetoothServer
 * @Author JackZhou
 * @Date 2020/12/16  18:12
 **/
public class BluetoothServer implements Runnable{

    //本机蓝牙设备
    private LocalDevice local = null;
    // 流连接
    private StreamConnection streamConnection = null;

    // 输入流
    private InputStream inputStream;
    private OutputStream outputStream;
    //接入通知
    private StreamConnectionNotifier notifier;
    //线程池
    private final static ExecutorService service = Executors.newCachedThreadPool();

    public String serverName;
    public String serverUUID;

    private OnServerListener mServerListener;

    public interface OnServerListener {
        void onConnected(InputStream inputStream, OutputStream outputStream);
        void onDisconnected();
        void onClose();
    }

    public BluetoothServer(String serverUUID, String serverName) {
        this.serverUUID = serverUUID;
        this.serverName = serverName;
    }

    public void start() {
        try {
            local = LocalDevice.getLocalDevice();
            if (!local.setDiscoverable(DiscoveryAgent.GIAC)){
                System.out.println("请将蓝牙设置为可被发现");
            }

            /**
             * 作为服务端，被请求
             */
            System.out.println("本机：" + local.getFriendlyName());
            //String url = "btspp://localhost:" +  local.getBluetoothAddress();// + ";name="+serverName;
            String url = "btspp://localhost:" +  serverUUID;// + ";name="+serverName;
            notifier = (StreamConnectionNotifier) Connector.open(url);

            service.submit(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    public OnServerListener getServerListener() {
        return mServerListener;
    }

    public void setServerListener(OnServerListener mServerListener) {
        this.mServerListener = mServerListener;
    }

    @Override
    public void run() {
        try {
            streamConnection = notifier.acceptAndOpen();                //阻塞的，等待设备连接
            inputStream = streamConnection.openInputStream();
            outputStream = streamConnection.openOutputStream();

            if (mServerListener != null) {
                mServerListener.onConnected(inputStream, outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
