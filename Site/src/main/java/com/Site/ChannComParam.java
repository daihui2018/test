package com.Site;

public class ChannComParam extends AbstractChannParam {
	private int port;
	private int baudRate;
	private int parity;
	private int dataBits;
	private int stopBits;
	
	public ChannComParam() {
		super();		
	}

	public ChannComParam(int port, int baudRate, int parity, int dataBits, int stopBits) {
		super();
		
		this.port = port;
		this.baudRate = baudRate;
		this.parity = parity;
		this.dataBits = dataBits;
		this.stopBits = stopBits;
	}

	
	
	@Override
	public String toString() {
		return "ChannComParam [port=" + port + ", baudRate=" + baudRate + ", parity=" + parity + ", dataBits="
				+ dataBits + ", stopBits=" + stopBits + "]";
	}

	@Override
	public String getType() {
		return "com";
	}
	@Override
	public String getName() {
		return super.getName() + port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}


	public int getDataBits() {
		return dataBits;
	}

	public void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	public int getStopBits() {
		return stopBits;
	}

	public void setStopBits(int stopBits) {
		this.stopBits = stopBits;
	}

	public int getParity() {
		return parity;
	}

	public void setParity(int parity) {
		this.parity = parity;
	}
}
