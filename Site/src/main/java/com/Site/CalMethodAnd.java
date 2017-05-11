package com.Site;

public class CalMethodAnd extends AbstractCalMethod implements InterfaceBoolMarker {

	@Override
	public boolean commit(boolean[] vals, boolean result) {
		if(vals.length==0) return false;
		result = vals[0];
		for (boolean val : vals) {
			if(val==false) {
				result = false;
				return true;
			}
		}
		return false;
	}

}
