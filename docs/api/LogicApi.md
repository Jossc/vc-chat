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
*Host* : localhost:8080  
*BasePath* : /


### Tags

* UserDialogue : User Dialogue Controller




<a name="paths"></a>
## Resources

<a name="userdialogue_resource"></a>
### UserDialogue
User Dialogue Controller


<a name="deletedialogue"></a>
#### 删除对话并删除消息
```
DELETE //api/userDialogue/deleteDialogue/{dialogueId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*optional*|对话id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
//api/userDialogue/deleteDialogue/0
```


<a name="getdialogue"></a>
#### 查询对话
```
GET //api/userDialogue/getDialogue/{dialogueId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*optional*|对话id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[UserDialogue](#userdialogue)|
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
//api/userDialogue/getDialogue/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
}
```


<a name="getuserunreadtotal"></a>
#### 统计未读数量
```
GET //api/userDialogue/getUserUnreadTotal/{userId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**userId**  <br>*optional*|用户id|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|integer (int32)|
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
//api/userDialogue/getUserUnreadTotal/string
```


##### Example HTTP response

###### Response 200
```
json :
0
```


<a name="listprimessagebydialogueid"></a>
#### 对话消息列表
```
GET //api/userDialogue/listPriMessageByDialogueId/{dialogueId}
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**dialogueId**  <br>*optional*|对话id|integer (int64)||
|**Query**|**size**  <br>*optional*|取多少条|integer (int32)|`10`|
|**Query**|**startNum**  <br>*optional*|起始位|integer (int32)|`0`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [PriMessage](#primessage) > array|
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
//api/userDialogue/listPriMessageByDialogueId/0
```


###### Request query
```
json :
{
  "size" : 0,
  "startNum" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
[ {
  "createdTime" : "string",
  "dialogueId" : 0,
  "id" : 0,
  "message" : "string",
  "recId" : "string",
  "sendId" : "string",
  "type" : 0,
  "uniId" : "string"
} ]
```


<a name="maketop"></a>
#### 消息置顶
```
PUT //api/userDialogue/listUserDialogueByUserId/{dialogueId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*optional*|对话id|integer (int64)|


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
//api/userDialogue/listUserDialogueByUserId/0
```


<a name="listuserdialoguebyuserid"></a>
#### 获取对话列表
```
GET //api/userDialogue/listUserDialogueByUserId/{userId}
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**userId**  <br>*optional*|用户id|string||
|**Query**|**size**  <br>*optional*|取多少条|integer (int32)|`10`|
|**Query**|**startNum**  <br>*optional*|起始位|integer (int32)|`0`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [UserDialogue](#userdialogue) > array|
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
//api/userDialogue/listUserDialogueByUserId/string
```


###### Request query
```
json :
{
  "size" : 0,
  "startNum" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
[ {
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
} ]
```


<a name="readall"></a>
#### 设置所有对话已读
```
PUT //api/userDialogue/readAll/{userId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**userId**  <br>*optional*|用户id|string|


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
//api/userDialogue/readAll/string
```


<a name="readmessage"></a>
#### 设置对话已读
```
PUT //api/userDialogue/readMessage/{dialogueId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*optional*|对话id|integer (int64)|


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
//api/userDialogue/readMessage/0
```


<a name="sendmessage"></a>
#### 发送消息
```
POST //api/userDialogue/sendMessage
```


##### Body parameter
priMessage

*Name* : priMessage  
*Flags* : required  
*Type* : [PriMessage](#primessage)


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
//api/userDialogue/sendMessage
```


###### Request body
```
json :
{
  "createdTime" : "string",
  "dialogueId" : 0,
  "id" : 0,
  "message" : "string",
  "recId" : "string",
  "sendId" : "string",
  "type" : 0,
  "uniId" : "string"
}
```


<a name="updatedialogue"></a>
#### 更新对话
```
PUT //api/userDialogue/updateDialogue
```


##### Body parameter
userDialogue

*Name* : userDialogue  
*Flags* : required  
*Type* : [UserDialogue](#userdialogue)


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
//api/userDialogue/updateDialogue
```


###### Request body
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
}
```




<a name="definitions"></a>
## Definitions

<a name="primessage"></a>
### PriMessage

|Name|Description|Schema|
|---|---|---|
|**createdTime**  <br>*optional*|创建时间  <br>**Example** : `"string"`|string (date-time)|
|**dialogueId**  <br>*optional*|对话id  <br>**Example** : `0`|integer (int64)|
|**id**  <br>*optional*|id  <br>**Example** : `0`|integer (int64)|
|**message**  <br>*optional*|消息内容  <br>**Example** : `"string"`|string|
|**recId**  <br>*optional*|收件人id  <br>**Example** : `"string"`|string|
|**sendId**  <br>*optional*|发件人id  <br>**Example** : `"string"`|string|
|**type**  <br>*optional*|0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动  <br>**Example** : `0`|integer (int32)|
|**uniId**  <br>*optional*|uniId  <br>**Example** : `"string"`|string|


<a name="userdialogue"></a>
### UserDialogue

|Name|Description|Schema|
|---|---|---|
|**createdTime**  <br>*optional*|createdTime  <br>**Example** : `"string"`|string (date-time)|
|**id**  <br>*optional*|id  <br>**Example** : `0`|integer (int64)|
|**lastMessage**  <br>*optional*|最后一条消息  <br>**Example** : `"string"`|string|
|**ordered**  <br>*optional*|排序字段  <br>**Example** : `0`|integer (int64)|
|**parentId**  <br>*optional*|父对话id  <br>**Example** : `0`|integer (int64)|
|**parentMake**  <br>*optional*|父字段标识位 0 不是 1 是  <br>**Example** : `0`|integer (int32)|
|**push**  <br>*optional*|0.正常全部接收 1.只接收不弹出 2.不接收不弹出  <br>**Example** : `0`|integer (int32)|
|**toUserId**  <br>*optional*|该字段为 冗余字段，用于记录对方id，方便用于查找头像  <br>**Example** : `"string"`|string|
|**type**  <br>*optional*|0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动  <br>**Example** : `0`|integer (int32)|
|**uniId**  <br>*optional*|使用双方id md5 加密 生成唯一id  <br>**Example** : `"string"`|string|
|**unreadTotal**  <br>*optional*|未读消息数  <br>**Example** : `0`|integer (int32)|
|**updatedTime**  <br>*optional*|对话更新时间,会随新来的消息进行时间更新  <br>**Example** : `"string"`|string (date-time)|
|**userId**  <br>*optional*|userId  <br>**Example** : `"string"`|string|




