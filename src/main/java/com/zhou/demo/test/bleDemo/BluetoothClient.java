package com.zhou.demo.test.bleDemo;

import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName BluetoothClient
 * @Author JackZhou
 * @Date 2020/12/16  17:07
 **/
public class BluetoothClient {
    private StreamConnection streamConnection;
    private OnDiscoverListener onDiscoverListener = null;
    private OnClientListener onClientListener = null;

    public interface OnClientListener {
        void onConnected(InputStream inputStream, OutputStream outputStream);
        void onConnectionFailed();
        void onDisconnected();
        void onClose();
    }

    public interface OnDiscoverListener {
        void onDiscover(RemoteDevice remoteDevice);
    }


    public BluetoothClient() {
    }


    public OnDiscoverListener getOnDiscoverListener() {
        return onDiscoverListener;
    }


    public void setOnDiscoverListener(OnDiscoverListener onDiscoverListener) {
        this.onDiscoverListener = onDiscoverListener;
    }


    public OnClientListener getClientListener() {
        return onClientListener;
    }


    public void setClientListener(OnClientListener onClientListener) {
        this.onClientListener = onClientListener;
    }

    public void find() throws IOException, InterruptedException {
        Set<RemoteDevice> devicesDiscovered = RemoteDeviceDiscovery.getDevices();       //附近所有的蓝牙设备，必须先执行 runDiscovery

        Iterator<RemoteDevice> itr = devicesDiscovered.iterator();
        while (itr.hasNext()) {                                   //连接
            RemoteDevice remoteDevice = itr.next();

            onDiscoverListener.onDiscover(remoteDevice);
        }
    }

    public void startClient(RemoteDevice remoteDevice, String serviceUUID) throws IOException, InterruptedException {
        String url = RemoteDeviceDiscovery.searchService(remoteDevice, serviceUUID);
        //System.out.println("得到url:" + url);
        //streamConnection = (StreamConnection) Connector.open(url);
        streamConnection = (StreamConnection) Connector.open("btspp://" + remoteDevice.getBluetoothAddress() + ":1");
        if (this.onClientListener != null) {
            this.onClientListener.onConnected(streamConnection.openInputStream(), streamConnection.openOutputStream());
        }
    }
}
