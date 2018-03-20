FROM java:latest
RUN mkdir -p /data/vc-chat-sample
COPY ./target/classes /data/vc-chat-sample/classes
COPY ./target/dependency /data/vc-chat-sample/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-sample
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-sample/classes:/data/vc-chat-sample/dependencies/*","com.vcg.chat.sample.VcChatSampleApplication"]