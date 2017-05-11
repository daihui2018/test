package com.Site;

import java.util.ArrayList;

public class VarBoolean extends AbstractVar {
    private boolean val;
    protected transient ArrayList<VarBoolean> children;
	
	@Override
	public String getValue() {
		return String.valueOf(val);
	}
	@Override
	public boolean getValueBool() {
		return val;
	}
	@Override
	public double getValueDou() {
		if(val==true)
			return 1;
		
		return 0;
	};
	@Override
	public void setValue(String value) {
		boolean val = Boolean.valueOf(value);
		this.val = val;		
	}
	@Override
	public void setValue(boolean value) {
		this.val = value;
	}
	@Override
	public boolean isJudgerMatch(AbstractAlarmJudger aj) {
		return (aj instanceof InterfaceBoolMarker);
	}
	@Override
	public void walkJudger() {
		for (AbstractAlarmJudger aj : judgers) {
			aj.judge(val);
		}
	}
	@Override
	public void addChild(AbstractVar var) {
		if(var instanceof VarBoolean) {
			children.add((VarBoolean) var);
		}
	}
	@Override
	public void calValueFromChildren() {
		if(this.getChildrenCalMethod()==null) return;
		if(children.size()==0) return;
		
		boolean vals[] = new boolean[children.size()];
		for(int index = 0; index < children.size(); index++) {
			vals[index] = children.get(index).getValueBool();
		}
		boolean ret = false;
		this.getChildrenCalMethod().commit(vals, ret);
		this.val = ret;
	}
	@Override
	public boolean isCalMethodMatch(AbstractCalMethod cm) {
		return (cm instanceof InterfaceBoolMarker);
	}
}
