package com.mcc.audittrailapp.sockets;

import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.mcc.audittrailapp.controller.AuditTrailController;
import com.mcc.audittrailapp.model.AuditTrail;
import com.mcc.audittrailapp.model.Configuration;

public class ViewAuditTrailByNameSocket implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String sessionId = session.getId();
		String remoteUser = session.getRemoteAddress().getHostName();
		System.out.println("View AuditTrail By Name Socket: session ID: "+sessionId);
		String payload = message.getPayload().toString();
		
		Gson gson = new Gson();
		Configuration configuration = gson.fromJson(payload, Configuration.class);
		
		AuditTrailController controller = new AuditTrailController();
		List<AuditTrail> auditTrailList = controller.getAuditTrailByName(configuration);
 	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
