package com.example.auctionapplicationIntermed;

import java.io.Serializable;

public class CrudModel implements Serializable{
	public static enum Command{
		ADD, DELETE, BID, UPDATE, READ, START, UPDATEID
	}
	private Command command;
	private String args;
	
	public CrudModel(Command cmd, String str){
		this.command = cmd;
		this.args = str;
	}
	
	public Command getCommand(){
		return this.command;
	}
	public String getArgs(){
		return args;
	}
	
	public String toString(){
		return ("[cmd: " + this.command.toString() + ", args: '" + this.args + "']");
	}
	
}
