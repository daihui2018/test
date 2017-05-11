package com.Site;

public class CalMethodSum extends AbstractCalMethod implements InterfaceDoubleMarker, InterfaceBoolMarker{
	@Override
	public boolean commit(double[] vals, double result) {
		if(vals.length==0) return false;
		result = 0.0;
		for (double d : vals) {
			result += d;
		}
		return true;
	}
}
