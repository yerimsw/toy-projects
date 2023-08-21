package yerimswtoy.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/notice") // "prefix/경로" => "/pub/notice" 경로로 클라이언트가 메시지를 발행해야 한다.
    public void sendNotice(@Payload String message) {
        template.convertAndSend("/topic/room", message); // "/topic/room" 토픽을 구독한 클라이언트에 메세지가 전송됨.
    }

    @MessageMapping("/chat") // "/pub/chat"
    public void sendPersonalMessage(@Payload String message) {
        String roomId = message;
        template.convertAndSend("/topic/room/personal-room" + roomId, message); // "/topic/room/personal-room/1" 토픽을 구독한 클라이언트에 메시지가 전송됨.
    }
}
