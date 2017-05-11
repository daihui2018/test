package com.Site;

import java.io.IOException;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* Dev dev = new Dev();
        dev.setId("kt01");
        dev.setName("AC");
        
        AbstractChann chann = new ChannCom(new ChannComParam(2,4800,"n",8,1));
        dev.setChann(chann);
        
        System.out.println(dev);
        */
        double t1 = 0;
        try {
        	t1 = Double.parseDouble(".6");
        	//t1 = Integer.parseInt("21");
        }catch(Exception e) {
        	System.out.println(e);
        }
        
        
        System.out.println("done!" + t1);
        
        AbstractVar var = new VarDouble();
        var.setId("WSD01");
        var.setName("Temp");
        var.setValue("12.3");
        System.out.println(var);
        
        AbstractAlarmJudger aj = new AlarmJudgerGreater();
        aj.setThreshold(12.4);
        System.out.println("Alarmjudge result: " + aj.judge(var.getValue()));
        
        var = new VarBoolean();
        var.setId("KG01");
        var.setName("AC_ON");
        var.setValue("true");
        System.out.println(var);
        
        /*String[] portNames = SerialPortList.getPortNames();
        
        if (portNames.length == 0) {
            System.out.println("There are no serial-ports :( You can use an emulator, such ad VSPE, to create a virtual serial port.");
            System.out.println("Press Enter to exit...");
            try {
                System.in.read();
            } catch (IOException e) {
                 // TODO Auto-generated catch block
                  e.printStackTrace();
            }
        }

        for (int i = 0; i < portNames.length; i++){
            System.out.println(portNames[i]);
        }
        
        SerialPort sp = new SerialPort("/dev/pts/3");
        try {
			if(sp.openPort()) {
				System.out.println("port " + sp.getPortName() + " opened!");
				sp.writeString("test from eclipse!");
				sp.closePort();
			}else {
				System.out.println("failed to open port " + sp.getPortName());
			}
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        AbstractChann com = new ChannCom(new ChannComParam(1, SerialPort.BAUDRATE_9600, 
        		SerialPort.PARITY_NONE, 
        		SerialPort.DATABITS_8,
        		SerialPort.STOPBITS_1));
        com.open();
        com.write("data from eclipse...");
        com.close();
        AbstractVar var1 = new VarBoolean();
        var1.setValue(1);
        System.out.println("var1's value = " + var1.getValueDou());
        
        var = new VarDouble();
        var.setValue(var1.getValueDou());
        System.out.println("var's value = " + var.getValueBool());
        
    }
}
