package com.Site;

import java.util.ArrayList;

public abstract class AbstractDev {
	private String id;
	private String name = "NewDev";
	private ArrayList<AbstractVar> vars;
	private AbstractChannParam channParam;
	
	//@Transient
	private AbstractChann chann;
	
	private ArrayList<AbstractDev> children;
	private AbstractDev parent;
	
	public void refresh() {
		for (AbstractVar var : vars) {
			 var.walkJudger();
		}
		if(parent!=null) {
			parent.refresh();
		}
	};
	
	public void addChild(AbstractDev dev) {
		if(dev==null) return;
		if(children.contains(this)) return;
		
		children.add(dev);
		dev.parent = this;
	}
	public void removeChild(AbstractDev dev) {
		if(dev==null) return;
		if(!children.contains(this)) return;
		
		children.remove(dev);
		dev.parent = null;
	}
	public void setParent(AbstractDev dev) {
		if(dev==null) {
			if(parent!=null) {
				parent.removeChild(this);
			}
		}else {
			dev.addChild(this);
		}
	}
	public AbstractDev getParent() {
		return parent;
	}	
	public void addVar(AbstractVar var) {
		if(var==null) {
			vars.add(var);
		}
	}
	public void walkVarJudger() {
		for (AbstractVar var : vars) {
			var.walkJudger();
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
	public ArrayList<AbstractVar> getVars() {
		return vars;
	}
	public void setVars(ArrayList<AbstractVar> vars) {
		this.vars = vars;
	}	
	public AbstractChannParam getChannParam() {
		return channParam;
	}
	public void setChannParam(AbstractChannParam channParam) {
		this.channParam = channParam;
	}
	public AbstractChann getChann() {
		return chann;
	}
	public void setChann(AbstractChann chann) {
		this.chann = chann;
	}
	@Override
	public String toString() {
		return "Dev [id=" + id + ", name=" + name + ", vars=" + vars  + "]";
	}
	
}
