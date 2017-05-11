package com.Site;

import java.util.ArrayList;

public class VarDouble extends AbstractVar {
	private double val;
	protected transient ArrayList<VarDouble> children;

	@Override
	public String getValue() {		
		return String.valueOf(val);
	}
	@Override
	public double getValueDou() {
		return val;
	}
	@Override
	public boolean getValueBool() {
		return (val!=0);
	}
	@Override
	public void setValue(String value) {
		Double val = Double.valueOf(value);
		this.val = val;		
	}
	@Override
	public void setValue(double value) {
		this.val = value;
	}

	@Override
	public boolean isJudgerMatch(AbstractAlarmJudger aj) {
		return (aj instanceof InterfaceDoubleMarker);
	}
	@Override
	public void walkJudger() {
		for (AbstractAlarmJudger aj : judgers) {
			aj.judge(val);
		}
	}
	@Override
	public void addChild(AbstractVar var) {
		if(var instanceof VarDouble) {
			children.add((VarDouble) var);
		}
	}
	@Override
	public void calValueFromChildren() {
		if(this.getChildrenCalMethod()==null) return;
		
		if(children.size()==0) return;
		double vals[] = new double[children.size()];
		for(int index = 0; index < children.size(); index++) {
			vals[index] = children.get(index).getValueDou();
		}
		double ret = 0;
		this.getChildrenCalMethod().commit(vals, ret);
		this.val = ret;		
	}
	@Override
	public boolean isCalMethodMatch(AbstractCalMethod cm) {
		return(cm instanceof InterfaceDoubleMarker);
	}

}
