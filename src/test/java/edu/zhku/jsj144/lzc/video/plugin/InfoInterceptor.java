package edu.zhku.jsj144.lzc.video.plugin;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

public class InfoInterceptor extends AbstractPhaseInterceptor<Message> {

	public InfoInterceptor(String phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(Message msg) throws Fault {
		// TODO Auto-generated method stub
//		System.out.println("aa");
//		Info info = new Info("OK");
//		msg.setContent(Info.class, info);
	}

}
