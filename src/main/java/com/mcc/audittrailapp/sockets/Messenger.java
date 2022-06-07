package com.mcc.audittrailapp.sockets;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class Messenger {
	private static WebSocketSession session = null;

	public static void setWebSocketSession(WebSocketSession sessionObj) {
		session = sessionObj;
	}

	public static boolean sendMessage(String message) {
		try {
			if (session != null) {
				session.sendMessage(new TextMessage(message));
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	public static boolean sendMessage(String message, WebSocketSession session) {
		try {
			if (session == null) {
				System.out.println("sendMessage:(session == null) : " + message);
				return false;
			}

			synchronized (session.getId()) {
				if (session != null) {
					session.sendMessage(new TextMessage(message));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

}
