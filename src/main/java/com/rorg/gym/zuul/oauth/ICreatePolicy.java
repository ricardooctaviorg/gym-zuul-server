package com.rorg.gym.zuul.oauth;

public interface ICreatePolicy<E, B> {
	
	public B createPolicyUserSystem(E http) throws Exception;

}