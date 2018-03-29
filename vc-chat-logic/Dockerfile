FROM java:latest
RUN mkdir -p /data/vc-chat-logic
COPY ./target/classes /data/vc-chat-logic/classes
COPY ./target/dependency /data/vc-chat-logic/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-logic
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-logic/classes:/data/vc-chat-logic/dependencies/*","com.vcg.chat.logic.VcChatLogicApplication"]