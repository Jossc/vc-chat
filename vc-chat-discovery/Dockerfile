FROM java:latest
RUN mkdir -p /data/vc-chat-discovery
COPY ./target/classes /data/vc-chat-discovery/classes
COPY ./target/dependency /data/vc-chat-discovery/dependencies
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat-discovery
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat-discovery/classes:/data/vc-chat-discovery/dependencies/*","com.vcg.chat.discovery.DiscoveryApplication"]