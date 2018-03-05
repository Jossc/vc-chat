# Api Documentation


<a name="overview"></a>
## Overview
Api Documentation


### Version information
*Version* : 1.0


### License information
*License* : Apache 2.0  
*License URL* : http://www.apache.org/licenses/LICENSE-2.0  
*Terms of service* : urn:tos


### URI scheme
*Host* : localhost:8081  
*BasePath* : /


### Tags

* Push : Push Controller




<a name="paths"></a>
## Resources

<a name="push_resource"></a>
### Push
Push Controller


<a name="multipush"></a>
#### 多链路推送
```
POST //api/push/multiPush
```


##### Description
需要用户id进行推送


##### Body parameter
request

*Name* : request  
*Flags* : required  
*Type* : [Request](#request)


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
//api/push/multiPush
```


###### Request body
```
json :
{
  "clientType" : "string",
  "createdTime" : "string",
  "data" : "object",
  "eventName" : "string",
  "id" : "string",
  "retryCount" : 0,
  "sessionId" : "string",
  "userId" : "string"
}
```


<a name="singlepush"></a>
#### 单机推送
```
POST //api/push/singlePush
```


##### Description
需要sessionid 进行推送


##### Body parameter
request

*Name* : request  
*Flags* : required  
*Type* : [Request](#request)


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
//api/push/singlePush
```


###### Request body
```
json :
{
  "clientType" : "string",
  "createdTime" : "string",
  "data" : "object",
  "eventName" : "string",
  "id" : "string",
  "retryCount" : 0,
  "sessionId" : "string",
  "userId" : "string"
}
```




<a name="definitions"></a>
## Definitions

<a name="request"></a>
### Request

|Name|Description|Schema|
|---|---|---|
|**clientType**  <br>*optional*|客户端类型  <br>**Example** : `"string"`|string|
|**createdTime**  <br>*optional*|时间戳  <br>**Example** : `"string"`|string (date-time)|
|**data**  <br>*optional*|推送的数据  <br>**Example** : `"object"`|object|
|**eventName**  <br>*optional*|事件名  <br>**Example** : `"string"`|string|
|**id**  <br>*optional*|唯一id  <br>**Example** : `"string"`|string|
|**retryCount**  <br>*optional*|重试次数  <br>**Example** : `0`|integer (int32)|
|**sessionId**  <br>*optional*|socketio建立的连接id  <br>**Example** : `"string"`|string|
|**userId**  <br>*optional*|用户id  <br>**Example** : `"string"`|string|




