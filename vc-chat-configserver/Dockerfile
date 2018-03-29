FROM java:latest
RUN mkdir -p /data/vc-chat-configserver
COPY ./target/classes /data/vc-chat-configserver/classes
COPY ./target/dependency /data/vc-chat-configserver/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-configserver
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-configserver/classes:/data/vc-chat-configserver/dependencies/*","com.vcg.chat.configserver.VcChatConfigServerApplication"]