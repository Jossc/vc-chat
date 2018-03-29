FROM java:latest
RUN mkdir -p /data/vc-chat-oauth2
COPY ./target/classes /data/vc-chat-oauth2/classes
COPY ./target/dependency /data/vc-chat-oauth2/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-oauth2
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-oauth2/classes:/data/vc-chat-oauth2/dependencies/*","com.vcg.chat.oauth2.VcChatOAuth2ServerApplication"]