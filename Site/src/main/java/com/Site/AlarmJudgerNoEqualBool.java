package com.Site;

public class AlarmJudgerNoEqualBool extends AlarmJudgerEqualBool implements InterfaceBoolMarker {
	@Override
	public boolean judge(boolean val) {
		if(val!=thresholdBool)
			return true;
		return false;
	}
}
