package com.Site;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public abstract class AbstractChann {
	private AbstractChannParam param;
	
	public abstract boolean open();
	public abstract void close();	
	
	//public abstract void write(BufferedOutputStream os);
	public abstract void write(String data);
	public abstract void read(BufferedInputStream is);
	
	public void setParam(AbstractChannParam param) {
		this.param = param;
	}
	public AbstractChannParam getParam() {
		return param;
	}
	public abstract boolean isOpened();
}
