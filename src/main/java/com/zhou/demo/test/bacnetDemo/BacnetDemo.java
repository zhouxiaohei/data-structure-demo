package com.zhou.demo.test.bacnetDemo;

import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.npdu.ip.IpNetwork;
import com.serotonin.bacnet4j.npdu.ip.IpNetworkBuilder;
import com.serotonin.bacnet4j.transport.DefaultTransport;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.UnsignedInteger;
import com.serotonin.bacnet4j.util.PropertyValues;
import com.serotonin.bacnet4j.util.ReadListener;
import com.serotonin.bacnet4j.util.RequestUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BacnetDemo
 * @Author JackZhou
 * @Date 2020/12/30  13:52
 **/
public class BacnetDemo {

    public static void main(String[] args) throws Exception {
        LocalDevice d = null;
        try {
            //创建网络对象
            IpNetwork ipNetwork = new IpNetworkBuilder()
                    .withLocalBindAddress("10.136.78.39")//本机的ip
                    .withSubnet("255.255.252.0", 24)
                    .withPort(32896) //Yabe默认的UDP端口
                    .withReuseAddress(true)
                    .build();
            //创建虚拟的本地设备，deviceNumber随意
            d = new LocalDevice(123, new DefaultTransport(ipNetwork));
            d.initialize();
            d.startRemoteDeviceDiscovery();

            RemoteDevice rd = d.getRemoteDeviceBlocking(3);//获取远程设备，instanceNumber 是设备的device id

            System.out.println("modelName=" + rd.getDeviceProperty( PropertyIdentifier.modelName));
            System.out.println("analogInput2= " +RequestUtils.readProperty(d, rd, new ObjectIdentifier(ObjectType.analogInput, 2), PropertyIdentifier.presentValue, null));


            List<ObjectIdentifier> objectList =  RequestUtils.getObjectList(d, rd).getValues();

            //打印所有的Object 名称
            for(ObjectIdentifier o : objectList){
                System.out.println(o);
            }


            ObjectIdentifier oid = new ObjectIdentifier(ObjectType.analogInput, 0);
            ObjectIdentifier oid1 = new ObjectIdentifier(ObjectType.analogInput, 1);
            ObjectIdentifier oid2 = new ObjectIdentifier(ObjectType.analogInput, 2);

            //获取指定的presentValue
            PropertyValues pvs = RequestUtils.readOidPresentValues(d, rd, Arrays.asList(oid,oid1,oid2), new ReadListener(){
                @Override
                public boolean progress(double progress, int deviceId,
                                        ObjectIdentifier oid, PropertyIdentifier pid,
                                        UnsignedInteger pin, Encodable value) {
                    System.out.println("========");
                    System.out.println("progress=" + progress);
                    System.out.println("deviceId=" + deviceId);
                    System.out.println("oid="+oid.toString());
                    System.out.println("pid="+pid.toString());
                    System.out.println("UnsignedInteger="+pin);
                    System.out.println("value="+value.toString() + "  getClass =" +value.getClass());
                    return false;
                }

            });
            Thread.sleep(3000);
            System.out.println("analogInput:0 == " + pvs.get(oid, PropertyIdentifier.presentValue));
            //获取指定的presentValue
            PropertyValues pvs2 = RequestUtils.readOidPresentValues(d, rd,Arrays.asList(oid,oid1,oid2),null);
            System.out.println("analogInput:1 == " + pvs2.get(oid1, PropertyIdentifier.presentValue));

            d.terminate();
        } catch (Exception e) {
            e.printStackTrace();
            if(d != null){
                d.terminate();
            }
        }

    }
}
