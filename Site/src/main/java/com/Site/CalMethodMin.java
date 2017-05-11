package com.Site;

public class CalMethodMin extends AbstractCalMethod implements InterfaceDoubleMarker {
	@Override
	public boolean commit(double[] vals, double result) {
		if(vals.length==0) return false;
		result = vals[0];
		for (double d : vals) {
			if(result < d) {
				result = d;
			}
		}
		return true;
	}
}
