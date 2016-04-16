package com.csdhsm.concurrent;

/** 
 * @Title: IntGenerator.java
 * @Package: com.csdhsm.concurrent
 * @Description 
 * @author Han
 * @date 2016-4-9 下午8:21:41 
 * @version V1.0
 */ 
  	
public abstract class IntGenerator {
	
	//判断该对象是否被取消
	private volatile boolean canceled = false;
	public abstract int next();
	
	
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
}
