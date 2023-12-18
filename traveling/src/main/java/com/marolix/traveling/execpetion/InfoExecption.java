package com.marolix.traveling.execpetion;

import java.time.LocalDateTime;

import lombok.Data;


public class InfoExecption {
	
	private String msg;
	
	private LocalDateTime time;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "InfoExecption [msg=" + msg + ", time=" + time + "]";
	}

	
}
