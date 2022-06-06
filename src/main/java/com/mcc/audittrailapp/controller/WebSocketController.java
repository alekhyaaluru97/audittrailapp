package com.mcc.audittrailapp.controller;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.mcc.audittrailapp.sockets.AddConfigurationSocket;
import com.mcc.audittrailapp.sockets.EditConfigurationSocket;
import com.mcc.audittrailapp.sockets.ViewAuditTrailByNameSocket;

public class WebSocketController implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(addConfigurationSocket(), "/add_configuration_socket");
		registry.addHandler(editConfigurationSocket(), "/edit_configuration_socket");
		registry.addHandler(viewAuditTrailByNameSocket(), "/view_audit_trail_by_name");
	}

	private WebSocketHandler viewAuditTrailByNameSocket() {
		return new ViewAuditTrailByNameSocket();
	}

	private WebSocketHandler editConfigurationSocket() {
		return new EditConfigurationSocket();
	}

	private WebSocketHandler addConfigurationSocket() {
		return new AddConfigurationSocket();
	}

}
