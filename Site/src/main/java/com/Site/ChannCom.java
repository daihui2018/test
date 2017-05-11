package com.Site;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ChannCom extends AbstractChann {
	SerialPort sp = null;
	ChannComParam comParam = null;
	
	public ChannCom(ChannComParam param) {
		setParam(param);
	}
    
	@Override
	public void setParam(AbstractChannParam param) {
		if(!(param instanceof ChannComParam)) return;
		
		boolean needRefreshParam = false;
		if(comParam==null) {
			comParam = (ChannComParam)param;
			needRefreshParam = true;
		}else {
			if(comParam.isInTheSameChann(param)) {				
				comParam = (ChannComParam)param;
				needRefreshParam = true;
			}
		}
		
		if(needRefreshParam) {
			try {
				if(sp!=null)
					sp.setParams(comParam.getBaudRate(), comParam.getDataBits(), comParam.getStopBits(), comParam.getParity());
			} catch (SerialPortException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean open() {
		if(comParam==null) {
			return false;
		}
		if(sp!=null) {
			if(sp.isOpened()) {
				try {
					sp.closePort();
				} catch (SerialPortException e) {
					e.printStackTrace();
				}
			}
			sp = null;
		}
		
		sp = new SerialPort("/dev/pts/3");
		
		try {
			sp.openPort();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
		if(isOpened())
			System.out.println("channel opened: " + comParam );
		
		return isOpened();
	}

	@Override
	public void close() {
		if(isOpened()) {
			try {
				sp.closePort();
			} catch (SerialPortException e) {
				e.printStackTrace();
			}
			System.out.println("channel closed: " + this.getParam() );
		}
	}

	@Override
	public void write(String data){
		if(sp==null) return;
		if(sp.isOpened()) {
			try {
				sp.writeString(data);
			} catch (SerialPortException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(getParam().getName() + " write: " + data);
	}

	@Override
	public void read(BufferedInputStream is) {
		System.out.println(getParam().getName() + "is reading");
	}

	public boolean isOpened() {
		if(sp!=null) {
			return sp.isOpened();
		}
		return false;
	}

}
