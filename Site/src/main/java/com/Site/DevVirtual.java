package com.Site;

public class DevVirtual extends AbstractDev {
	@Override
	public void refresh() {
		for (AbstractVar var : getVars()) {
			 var.calValueFromChildren();
		}
		super.refresh();
	}
}
