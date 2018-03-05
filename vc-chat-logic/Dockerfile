FROM java:latest
RUN mkdir -p /data/vc-chat
COPY ./target/classes /data/vc-chat/classes
COPY ./target/dependency /data/vc-chat/dependencies
#RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
WORKDIR /data/vc-chat
EXPOSE 8080:8080 5005:5005
VOLUME /tmp /data
#ENV JAVA_OPTS="-server -Xms1024M -Xmx1024M -Xss512k -XX:PermSize=256M"
#ENTRYPOINT ["java","-Duser.timezone=GMT+08","-cp","/data/vc-chat/classes:/data/vc-chat/dependencies/*","com.vcg.chat.VcChatApplication"]
CMD ["java","-server -Xms1g -Xmx1g","-cp","/data/vc-chat/classes:/data/vc-chat/dependencies/*","com.vcg.chat.VcChatApplication"]