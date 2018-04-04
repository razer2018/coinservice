package com.coindemo.common.message;

public interface MessageListener
{
	public void onMessage(Message message, String topic);
}
