package com.example.messagingstompwebsocket;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // JS쪽 코드에서 "/chat"으로 소켓 연결 시도
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // JS쪽 코드에서 "/topic"으로 subscribe 중인 모든 클라이언트에게 브로드캐스팅 방식으로 메세지 전달
        registry.enableSimpleBroker("/topic");
        // JS쪽 코드에서 "/app"으로 시작되는 경로는 클라이언트의 메세지 전송을 의미한다는 설정
        registry.setApplicationDestinationPrefixes("/app");
    }
}
