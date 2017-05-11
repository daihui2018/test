package com.Site;

public class AlarmJudgerEqualBool extends AbstractAlarmJudger implements InterfaceBoolMarker {
	boolean thresholdBool;
	
	@Override
	public boolean judge(String val) {
		boolean v = Boolean.parseBoolean(val);
		return judge(v);
	}		
	@Override
	public String getThreshold() {
		return String.valueOf(thresholdBool);
	}	
	@Override
	public void setThreshold(boolean val) {
		thresholdBool = val;
	}
	@Override
	public void setThreshold(String threshold) {
		boolean th = Boolean.parseBoolean(threshold);
		thresholdBool = th;
	}
	@Override
	public boolean judge(boolean val) {
		if(val==thresholdBool) {
			return true;
		}
		return false;
	}
}
