package com.Site;

import java.util.ArrayList;

public abstract class DevReal extends AbstractDev {	
	private ArrayList<Protocal> pros;
	private String dataFormat = "HEX";
	private int pollInterval;
	public abstract void decode(Protocal pro);
	public abstract void init();
	
	@Override
	public void refresh() {
		for (Protocal pro : pros) {
			poll(pro);
			try {
				Thread.sleep(pollInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fill(pro);
			decode(pro);
		}
		
		super.refresh();
	}
	
	public void poll(Protocal pro) {
		AbstractChann chann = getChann();
		if(chann==null) return;
		if(pro==null) return;
		pro.getSendData();
		chann.setParam(getChannParam());
		chann.write(null);
	}
	public void fill(Protocal pro) {
		AbstractChann chann = getChann();
		if(chann==null) return;
		if(pro==null) return;
		chann.read(null);
		pro.setRecvData("recvData");
	}	
	public ArrayList<Protocal> getPros() {
		return pros;
	}
	public void setPros(ArrayList<Protocal> pros) {
		this.pros = pros;
	}
	public int getPollInterval() {
		return pollInterval;
	}
	public void setPollInterval(int pollInterval) {
		this.pollInterval = pollInterval;
	}
	public String getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(String dataFormat) {
		if(dataFormat.equalsIgnoreCase("ascii")) {
			this.dataFormat = "ASCII";
		}else {
			this.dataFormat = "HEX";
		}
	}
	

}
