package com.Site;

public class CalMethodOr extends AbstractCalMethod implements InterfaceBoolMarker {
	@Override
	public boolean commit(boolean[] vals, boolean result) {
		if(vals.length==0) return false;
		result = vals[0];
		for (boolean val : vals) {
			if(val==true) {
				result = true;
				return true;
			}
		}
		return false;
	}
}
