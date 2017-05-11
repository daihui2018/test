package com.Site;

import java.util.ArrayList;

public abstract class AbstractVar {
	private String id;
	private String name;
	protected ArrayList<AbstractAlarmJudger> judgers;
	
	private AbstractCalMethod childrenCalMethod;
	
	public abstract void addChild(AbstractVar var);
	public abstract void calValueFromChildren();
	public abstract boolean isCalMethodMatch(AbstractCalMethod cm);
	public AbstractCalMethod getChildrenCalMethod() {
		return childrenCalMethod;
	}
	public void setChildrenCalMethod(AbstractCalMethod childrenCalMethod) {
		if(isCalMethodMatch(childrenCalMethod))
			this.childrenCalMethod = childrenCalMethod;
	}
	
	public void addJudger(AbstractAlarmJudger aj) {
		if(isJudgerMatch(aj)) 
			judgers.add(aj);
	}
	
	public void walkJudger() {
		for (AbstractAlarmJudger aj : judgers) {
			aj.judge(getValue());
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<AbstractAlarmJudger> getJuders() {
		return judgers;
	}
	public void setJuders(ArrayList<AbstractAlarmJudger> judgers) {
		this.judgers = judgers;
	}
	
	@Override
	public String toString() {
		return "AbstractVar [id=" + id + ", name=" + name + ", getValue()=" + getValue() + "]";
	}

	public abstract String getValue();
	public abstract void setValue(String value);
	public double getValueDou() {return 0;};
	public boolean getValueBool() {return false;};
	public void setValue(double value) {}
	public void setValue(boolean value) {}
	public abstract boolean isJudgerMatch(AbstractAlarmJudger aj);
}