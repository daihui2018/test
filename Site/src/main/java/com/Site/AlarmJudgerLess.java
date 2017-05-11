package com.Site;

public class AlarmJudgerLess extends AlarmJudgerGreater implements InterfaceDoubleMarker { 
	@Override
	public boolean judge(double val) {
		if(val<thresholdDou) {
			return true;
		}
		return false;
	}
}
