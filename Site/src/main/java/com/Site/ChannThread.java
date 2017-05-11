package com.Site;

import java.util.ArrayList;

public class ChannThread implements Runnable {
	private ArrayList<AbstractDev> devs;
	private boolean stop;
	
	public void run(){
		while(!stop) {
			for (AbstractDev dev : devs) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dev.refresh();
			}
			//loop done
		}
	}
	public void addDev(AbstractDev dev) {
		devs.add(dev);
	}
	public AbstractChannParam getChannParam() {
		for (AbstractDev dev : devs) {
			return dev.getChannParam();
		}		
		return null;
	}	
	public void setStop(boolean stop) {
		this.stop = stop;
	}	
}
