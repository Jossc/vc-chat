# Api Documentation


<a name="overview"></a>
## 概览
Api Documentation


### 版本信息
*版本* : 1.0


### 许可信息
*许可证* : Apache 2.0  
*许可网址* : http://www.apache.org/licenses/LICENSE-2.0  
*服务条款* : urn:tos


### URI scheme
*域名* : localhost:8082  
*基础路径* : /


### 标签

* UserDialogue : User Dialogue Controller




<a name="paths"></a>
## 资源

<a name="userdialogue_resource"></a>
### UserDialogue
User Dialogue Controller


<a name="createdialogue"></a>
#### 创建对话
```
POST //api/userDialogue/createDialogue
```


##### Body参数
userDialogue

*名称* : userDialogue  
*标志* : 必填  
*类型* : [UserDialogue](#userdialogue)


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[UserDialogue](#userdialogue)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/createDialogue
```


###### 请求 body
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
}
```


<a name="deletedialogue"></a>
#### 删除对话并删除消息
```
DELETE //api/userDialogue/deleteDialogue
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**dialogueId**  <br>*可选*|对话id|string|
|**Query**|**dialogueId**  <br>*可选*|对话id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/deleteDialogue
```


###### 请求 query
```
json :
{
  "dialogueId" : 0
}
```


<a name="getdialogue"></a>
#### 查询对话
```
GET //api/userDialogue/getDialogue/{dialogueId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*可选*|对话id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[UserDialogue](#userdialogue)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/getDialogue/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
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


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**userId**  <br>*可选*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|integer (int32)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/getUserUnreadTotal/string
```


##### HTTP响应示例

###### 响应 200
```
json :
0
```


<a name="listprimessagebydialogueid"></a>
#### 对话消息列表
```
GET //api/userDialogue/listPriMessageByDialogueId
```


##### 参数

|类型|名称|说明|类型|默认值|
|---|---|---|---|---|
|**Query**|**dialogueId**  <br>*可选*|对话id|integer (int64)||
|**Query**|**size**  <br>*可选*|取多少条|integer (int32)|`10`|
|**Query**|**startNum**  <br>*可选*|起始位|integer (int32)|`0`|
|**Query**|**userId**  <br>*可选*|用户id|string||


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< [PriMessage](#primessage) > array|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/listPriMessageByDialogueId
```


###### 请求 query
```
json :
{
  "dialogueId" : 0,
  "size" : 0,
  "startNum" : 0,
  "userId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
[ {
  "createdTime" : "string",
  "dialogueId" : 0,
  "id" : 0,
  "message" : "string",
  "messageType" : 0,
  "recId" : "string",
  "sendId" : "string",
  "type" : 0,
  "uniId" : "string"
} ]
```


<a name="listuserdialoguebyparentid"></a>
#### 获取对话列表
```
GET //api/userDialogue/listUserDialogueByParentId
```


##### 参数

|类型|名称|说明|类型|默认值|
|---|---|---|---|---|
|**Query**|**parentId**  <br>*可选*|父对话id|integer (int64)||
|**Query**|**size**  <br>*可选*|取多少条|integer (int32)|`10`|
|**Query**|**startNum**  <br>*可选*|起始位|integer (int32)|`0`|
|**Query**|**userId**  <br>*可选*|用户id|string||


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< [UserDialogue](#userdialogue) > array|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/listUserDialogueByParentId
```


###### 请求 query
```
json :
{
  "parentId" : 0,
  "size" : 0,
  "startNum" : 0,
  "userId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
[ {
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
  "push" : 0,
  "toUserId" : "string",
  "type" : 0,
  "uniId" : "string",
  "unreadTotal" : 0,
  "updatedTime" : "string",
  "userId" : "string"
} ]
```


<a name="maketop"></a>
#### 消息置顶
```
PUT //api/userDialogue/listUserDialogueByUserId
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**dialogueId**  <br>*可选*|对话id|integer (int64)|
|**Query**|**userId**  <br>*可选*|对话id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/listUserDialogueByUserId
```


###### 请求 query
```
json :
{
  "dialogueId" : 0,
  "userId" : "string"
}
```


<a name="listuserdialoguebyuserid"></a>
#### 获取对话列表
```
GET //api/userDialogue/listUserDialogueByUserId/{userId}
```


##### 参数

|类型|名称|说明|类型|默认值|
|---|---|---|---|---|
|**Path**|**userId**  <br>*可选*|用户id|string||
|**Query**|**size**  <br>*可选*|取多少条|integer (int32)|`10`|
|**Query**|**startNum**  <br>*可选*|起始位|integer (int32)|`0`|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< [UserDialogue](#userdialogue) > array|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/listUserDialogueByUserId/string
```


###### 请求 query
```
json :
{
  "size" : 0,
  "startNum" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
[ {
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
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


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**userId**  <br>*可选*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/readAll/string
```


<a name="readmessage"></a>
#### 设置对话已读
```
PUT //api/userDialogue/readMessage
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**dialogueId**  <br>*可选*|对话id|integer (int64)|
|**Path**|**userId**  <br>*可选*|对话id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/readMessage
```


<a name="sendmessage"></a>
#### 发送消息
```
POST //api/userDialogue/sendMessage
```


##### Body参数
priMessage

*名称* : priMessage  
*标志* : 必填  
*类型* : [PriMessage](#primessage)


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/sendMessage
```


###### 请求 body
```
json :
{
  "createdTime" : "string",
  "dialogueId" : 0,
  "id" : 0,
  "message" : "string",
  "messageType" : 0,
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


##### Body参数
userDialogue

*名称* : userDialogue  
*标志* : 必填  
*类型* : [UserDialogue](#userdialogue)


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 请求类型

* `application/json`


##### 响应类型

* `*/*`


##### HTTP请求示例

###### 请求 path
```
//api/userDialogue/updateDialogue
```


###### 请求 body
```
json :
{
  "createdTime" : "string",
  "id" : 0,
  "lastMessage" : "string",
  "ordered" : 0,
  "parentId" : 0,
  "parentMake" : 0,
  "priMessage" : {
    "createdTime" : "string",
    "dialogueId" : 0,
    "id" : 0,
    "message" : "string",
    "messageType" : 0,
    "recId" : "string",
    "sendId" : "string",
    "type" : 0,
    "uniId" : "string"
  },
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
## 定义

<a name="primessage"></a>
### PriMessage

|名称|说明|类型|
|---|---|---|
|**createdTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**dialogueId**  <br>*可选*|对话id  <br>**样例** : `0`|integer (int64)|
|**id**  <br>*可选*|id  <br>**样例** : `0`|integer (int64)|
|**message**  <br>*可选*|消息内容  <br>**样例** : `"string"`|string|
|**messageType**  <br>*可选*|0 普通消息 1 图片消息 2 语音消息  3 视频消息 4 实时语音消息 5 实时视频消息  <br>**样例** : `0`|integer (int32)|
|**recId**  <br>*可选*|收件人id  <br>**样例** : `"string"`|string|
|**sendId**  <br>*可选*|发件人id  <br>**样例** : `"string"`|string|
|**type**  <br>*可选*|0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动  <br>**样例** : `0`|integer (int32)|
|**uniId**  <br>*可选*|uniId  <br>**样例** : `"string"`|string|


<a name="userdialogue"></a>
### UserDialogue

|名称|说明|类型|
|---|---|---|
|**createdTime**  <br>*可选*|createdTime  <br>**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|id  <br>**样例** : `0`|integer (int64)|
|**lastMessage**  <br>*可选*|最后一条消息内容  <br>**样例** : `"string"`|string|
|**ordered**  <br>*可选*|排序字段  <br>**样例** : `0`|integer (int64)|
|**parentId**  <br>*可选*|父对话id  <br>**样例** : `0`|integer (int64)|
|**parentMake**  <br>*可选*|父字段标识位 0 不是 1 是  <br>**样例** : `0`|integer (int32)|
|**priMessage**  <br>*可选*|最后一条消息  <br>**样例** : `"[primessage](#primessage)"`|[PriMessage](#primessage)|
|**push**  <br>*可选*|0.正常全部接收 1.只接收不弹出 2.不接收不弹出  <br>**样例** : `0`|integer (int32)|
|**toUserId**  <br>*可选*|该字段为 冗余字段，用于记录对方id，方便用于查找头像  <br>**样例** : `"string"`|string|
|**type**  <br>*可选*|0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动  <br>**样例** : `0`|integer (int32)|
|**uniId**  <br>*可选*|使用双方id md5 加密 生成唯一id  <br>**样例** : `"string"`|string|
|**unreadTotal**  <br>*可选*|未读消息数  <br>**样例** : `0`|integer (int32)|
|**updatedTime**  <br>*可选*|对话更新时间,会随新来的消息进行时间更新  <br>**样例** : `"string"`|string (date-time)|
|**userId**  <br>*可选*|userId  <br>**样例** : `"string"`|string|
