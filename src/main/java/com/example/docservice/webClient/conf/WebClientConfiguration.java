package com.example.docservice.webClient.conf;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfiguration {
    private static final String BASE_URL = "http://localhost:8099/";
//    public static final int TIMEOUT = 1000;
    @Bean
    public WebClient webClientWithTimeout() {
//        final var tcpClient = TcpClient
//                .create()
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
//                .doOnConnected(connection -> {
//                    connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
//                    connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
//                });

        return WebClient.builder()
                .baseUrl(BASE_URL)
               // .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }
//    SslContext sslContext = SslContextBuilder
//            .forClient()
//            .keyManager(…) /* Есть оверлоад, который принимает .pem файлы сертификата и приватного ключа (и, опционально, пароль). PEM файлы должны быть в определенной кодировке. Проверить/переконвертировать можно с помощью openssl утилиты.
// Альтернативно можно передать и KeyManagerFactory. */
//            .build();
//
//    ClientHttpConnector connector = new ReactorClientHttpConnector(
//            builder -> builder.sslContext(sslContext));
//
//    WebClient webClient = WebClient.builder()
//            .clientConnector(connector).build();
}


