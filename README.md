# Book-Borrowing-Sys
以Spring-Boot實作一個線上圖書借閱系統，目前只完成後端功能，功能如下

 * 註冊功能(密碼進資料庫前有加鹽(salt)並經雜湊(Hash)後儲存)
 * 登入驗證功能(以註冊的電話和密碼進行登入)
 * 書本的CRUD(RestFul 風格)
 * 借還書功能(需先經過登入才可以使用)(實作Transaction，避免資料錯亂)

下面將介紹可用的API功能

## 註冊功能

 method: Post
 
 example URL: http://localhost:8080/register

 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
        "phoneNumber": "0988111222",
        "password": "123",
        "userName": "test3"
 Response:
  * 200: 回傳字串"註冊成功!"
  * 400: 回傳字串"註冊失敗!"
     
## 登入功能
 method: Post
 
 example URL: http://localhost:8080/register

 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
        "phoneNumber": "0933111222",
        "password": "123"
 Response:
  * 200: 回傳字串"登入成功!"
  * 400: 回傳字串"登入失敗!"
  
## 書本的CRUD(RestFul 風格)

 example URL: http://localhost:8080/book

### 查詢書本
 method: Get
 
 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
 
        "isbn": "9789577436368"        

 Response:
  * 200: 回Json格式的傳書本Entity
  
  
        "isbn": "9789577436368",
        "name": "我想成為影之強者！ (1)",
        "author": " 逢沢大介",
        "introduction": "「吾名闇影。乃潛伏於闇影之中，狩獵闇影之人……」",
        "inventoryEntity": [
        {
            "inventoryId": 5,
            "storeTime": "2023-04-21",
            "status": "在庫"
        } 
        ]
   

### 新增書本
 method: Post
 
 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
 
        "isbn": "9789577436368",
        "name": "我想成為影之強者！ (1)",
        "author": " 逢沢大介",
        "introduction": "「吾名闇影。乃潛伏於闇影之中，狩獵闇影之人……」"

 Response:
  * 200: 回Json格式的傳書本Entity
  
  
        "isbn": "9789577436368",
        "name": "我想成為影之強者！ (1)",
        "author": " 逢沢大介",
        "introduction": "「吾名闇影。乃潛伏於闇影之中，狩獵闇影之人……」"
        "inventoryEntity": null
    
### 修改書本
 method: Put
 
 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
 
        "isbn": "9789577436368",
        "name": "我想成為影之強者！ (1)",
        "author": " 逢沢大介QQQ",
        "introduction": "「吾名闇影。乃潛伏於闇影之中，狩獵闇影之人……」"

 Response:
  * 200: 回Json格式的傳書本Entity
  
  
        "isbn": "9789577436368",
        "name": "我想成為影之強者！ (1)",
        "author": " 逢沢大介QQQ",
        "introduction": "「吾名闇影。乃潛伏於闇影之中，狩獵闇影之人……」"
        "inventoryEntity": [
        {
            "inventoryId": 5,
            "storeTime": "2023-04-21",
            "status": "在庫"
        }
        ]
    
    
### 刪除書本
 method: Delete
 
 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
 
        "isbn": "9789577436368"        

 Response:
  * 200: 回傳字串"刪除成功!!!"
  
## 借書功能
 
 登入之後，在Request Body 中提供想借閱書本的InventoryId即可進行借書
 
 method: Post
 
 example URL: http://localhost:8080/borrow

 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
        "inventoryId": 2

 Response:
  * 200: 回傳字串"借閱成功"
  * 400: 回傳字串"註冊失敗!"
 
## 還書功能
 
 登入之後，在Request Body 中提供想還書本的InventoryId即可進還書
 
 method: Post
 
 example URL: http://localhost:8080/loan

 Request:
 	
 * header: 
 			Content-Type : application/json
 * Body: 
 
        "inventoryId": 2

 Response:
  * 200: 回傳字串"還書成功"
  * 400: 回傳字串"還書操作異常!! 請確認借閱紀錄!"
     
