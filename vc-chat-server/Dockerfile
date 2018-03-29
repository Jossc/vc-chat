FROM java:latest
RUN mkdir -p /data/vc-chat-server
COPY ./target/classes /data/vc-chat-server/classes
COPY ./target/dependency /data/vc-chat-server/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-server
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-server/classes:/data/vc-chat-server/dependencies/*","com.vcg.chat.server.VcChatServerApplication"]