package yerimswtoy.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // SimpMessagingTemplate bean
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // 'topic' 토픽을 관리하는 메시지 브로커 활성화
        registry.setApplicationDestinationPrefixes("/pub"); // 클라이언트가 메시지를 publish하는 경로를 설정
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket-endpoint")
                .setAllowedOriginPatterns("*")
                .withSockJS(); // 웹소켓 커넥션을 체결하는 엔드포인트 등록
    }
}
