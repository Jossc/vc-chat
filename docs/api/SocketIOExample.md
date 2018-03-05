连接地址: http://localhost:1337

所需参数 | 说明 | 是否必填
---|---
accessToken | 用于鉴证用户是否合法 | 是
clientType | 客户端类型 |选填 

### 网页
---
依赖包:

```
https://github.com/socketio/socket.io-client.git
```

调用示例:
```
<script src="/socket.io/socket.io.js"></script>
<script>
  //需要先获取连接token
  var token;
  $.ajax({ 
        url: "/community/sitemessage/v2/getToken", 
        dataType:json,
        method: get,
        async: false,
        success: function(data){
         token = data.token
      }});

  var socket = io('http://localhost:1337/?access_token='+token);
  socket.on('connect', function(){});
  socket.on('message', function(data){});
  socket.on('disconnect', function(){});
  socket.on('error', function(data){});
</script>
```

### 安卓
---

依赖包:

```

https://github.com/socketio/socket.io-client-java

<dependency>
	<groupId>io.socket</groupId>
	<artifactId>socket.io-client</artifactId>
	<version>0.8.3</version>
</dependency>

如果有okhttp 可以忽略
<dependency>
	<groupId>com.squareup.okhttp3</groupId>
	<artifactId>okhttp</artifactId>
	<version>3.5.0</version>
</dependency>
```

调用示例

```

IO.Options options = new IO.Options();

//传输协议
options.transports = new String[]{"websocket"};
//是否自动重连
options.reconnection = true;
options.timeout = this.timeout;
Socket socket = IO.socket("http://localhost:1337/accessToken/", options);
socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

  @Override
  public void call(Object... args) {

  }

}).on(Socket.EVENT_MESSAGE, new Emitter.Listener() {

  @Override
  public void call(Object... args) {
    System.out.println(args[0].toString)
  }


}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

  @Override
  public void call(Object... args) {}

});

socket.connect();
```


### IOS
---

依赖:
```
https://github.com/socketio/socket.io-client-swift

```

调用示例:

swift

```
import SocketIO

let socket = SocketIOClient(socketURL: URL(string: "http://localhost:1337/?accessToken=xxx")!, config: [.log(true), .forcePolling(true)])

socket.on("connect") {data, ack in
    print("socket connected")
}

socket.on("message") {data, ack in
    if let cur = data[0] as? Double {
        socket.emitWithAck("canUpdate", cur).timingOut(after: 0) {data in
            socket.emit("update", ["amount": cur + 2.50])
        }

        ack.with("Got your currentAmount", "dude")
    }
}

socket.connect()
```

Objective-C

```

@import SocketIO;
NSURL* url = [[NSURL alloc] initWithString:@"http://localhost:1337/?accessToken=xxx"];
SocketIOClient* socket = [[SocketIOClient alloc] initWithSocketURL:url config:@{@"log": @YES, @"forcePolling": @YES}];

[socket on:@"connect" callback:^(NSArray* data, SocketAckEmitter* ack) {
    NSLog(@"socket connected");
}];

[socket on:@"message" callback:^(NSArray* data, SocketAckEmitter* ack) {
    double cur = [[data objectAtIndex:0] floatValue];

    [[socket emitWithAck:@"canUpdate" with:@[@(cur)]] timingOutAfter:0 callback:^(NSArray* data) {
        [socket emit:@"update" withItems:@[@{@"amount": @(cur + 2.50)}]];
    }];

    [ack with:@[@"Got your currentAmount, ", @"dude"]];
}];

[socket connect];
```

