
# Ecommerce Application

## Overview
the main goal of this application is to facilitate  the management of 
the products for merchants, track orders, offering seamless shopping experience

![ecommerce-req](https://github.com/user-attachments/assets/23aa8e0a-b9c5-4b68-a23f-555a2ba431c4)


## 
## Actors of the system
* Admin
* Merchant
* Customer

![ecommerce - usecase](https://github.com/user-attachments/assets/0cdb9148-e2c9-46ae-a5e2-aea404ff1908)


## All Use Cases ( Features )

  [&check;]  User Registration & Authentications

  [&check;] manage Customer

  [&check;] manage Merchant

  [&check;] manage Category

  [&check;] manage product

  [&check;] manage order

  [&cross;] payment Integartion

  [&cross;] others etc....

![ecommerce - usecase2](https://github.com/user-attachments/assets/e82d6a98-4a35-4ce5-9681-e5b9d34c81c0)




## 
## Entities and tables
![entity](https://github.com/user-attachments/assets/c0c030b8-8e90-4bb0-bb7d-7c876a5c6d91)

## 
## APIS Endpoints
![apis2](https://github.com/user-attachments/assets/931e6e03-d7b7-4d26-a6f0-4059312f3f21)


## User registration & Authentication Functions

#### User Registration and Authentication

-   [&cross;]Sign in
-   [&cross;]Login
-   [&cross;]logout
-   [&cross;]Forget password

#### Token Managment

-    [&cross;]request token
-    [&cross;]refresh token

#### Third party Authentication (OAuth)

-   [&cross;]Socail Media Authentication

#### Customer Managment

-  [&cross;] Create Customer
-   [&cross;]get Customer
-   [&cross;]update Customer
-   [&cross;]delete Customer
-   [&cross;]Enable Customer
-   [&cross;]Disable Customer


## Merchant Management

-   [&check;] Add Merchant
  
![add-merchant](https://github.com/user-attachments/assets/75780979-0eda-43ce-b5ba-f08dcaf53724)

-   [&check;] list Merchant

![get-all-merchant](https://github.com/user-attachments/assets/b85bd0fa-30e0-4cfa-8fe1-d3e3df337097)

-   [&check;] update Merchant

![update-merchant](https://github.com/user-attachments/assets/221d58ed-1d18-4dd1-a2cc-041cc03d1f00)


-   [&check;] delete Merchant

![delete-merchant](https://github.com/user-attachments/assets/d3dab8c1-85fb-4918-a71a-14f5166681fd)

-   [&check;] list all merchant products

![list all merchant products](https://github.com/user-attachments/assets/267d3e5b-9026-4dd0-aecb-c112dc7c6d82)


-   [&check;] list all merchant categories

![list all merchant categories](https://github.com/user-attachments/assets/18661016-cbd1-4399-b8de-ec8a1996d132)
![list all merchant products and their categories](https://github.com/user-attachments/assets/13f9dfb2-e495-4357-bac3-2d1f70b1ceaf)


-   [&check;] Search 

![search merchant](https://github.com/user-attachments/assets/db22ab07-d220-47d3-afb4-a8fc2c13d9ad)


## Category Management

-   [&check;] Add Category

![1-add-category](https://github.com/user-attachments/assets/22193da5-a015-4fbe-9062-d031ce34ab1e)


-   [&check;] list Category

![4-list-all-categories](https://github.com/user-attachments/assets/fbeb5b03-27e4-4648-bcb6-b2747f313328)


-   [&check;] update Category

![2-update-category](https://github.com/user-attachments/assets/a9470a94-59cb-4126-a09a-b582ef667344)


-   [&check;] delete Category

![3-delete category](https://github.com/user-attachments/assets/8cbd3184-855e-4dbc-801e-3cf880c2a234)


-   [&check;] list all category products

![list all category products](https://github.com/user-attachments/assets/48e9af74-de4c-4792-b343-3572d01ccd6b)

 

-   [&check;] Search
  
## Product Management

-   [&check;] Add Product
-   
![1-add-product](https://github.com/user-attachments/assets/359655c3-3491-4f43-9845-d51a576727e4)

-   [&check;] list Product

![2-list-products](https://github.com/user-attachments/assets/0267d15d-8f7a-4a29-8561-bd728c7b6902)

-   [&check;] update Product

![3-update-product](https://github.com/user-attachments/assets/df0f659f-ce6b-4249-bb63-e5b95d484224)


-   [&check;] delete Product

![4-delete-product](https://github.com/user-attachments/assets/edc1d433-02fb-4e22-9000-4777104fa6b8)


-   [&check;] Search 


## Order Management

-   [&check;] create Order

![1-order-create](https://github.com/user-attachments/assets/d64f78d8-9c91-40a6-84d2-751a9cf04a7e)


-   [&check;] list Order

![2-order-list](https://github.com/user-attachments/assets/d3b00df0-bdb6-450d-abec-134fe4c8037b)


-   [&check;] update Order / Cancel Order / process Order

![3-order-update](https://github.com/user-attachments/assets/09b22ff3-d51a-4aa6-afa1-605bc94eacc9)

![3-order-cancel](https://github.com/user-attachments/assets/6bda7ef8-c580-46c2-ad18-e14ff5c33edd)

![3-order-process](https://github.com/user-attachments/assets/c459e345-8703-4c57-9d4f-e6d9835eecbb)


-   [&check;] delete Order

![4-order-deleet](https://github.com/user-attachments/assets/62cf1968-0595-42ae-8f0d-82581ad3172b)


-   [&check;] Search
  



## Order details (items) Management

-   [&check;] create Order item

![order-item-create](https://github.com/user-attachments/assets/81c56f34-8e17-46c2-9102-47b6f31105d3)


-   [&check;] list Order items

![order-item-list](https://github.com/user-attachments/assets/02ab389a-e197-456c-bbb0-ec404200a303)


-   [&check;] update Order items

![order-item-update](https://github.com/user-attachments/assets/f8402835-781a-40ca-8b53-1239e0680c2c)


-   [&check;] delete Order items

![order-item-delete](https://github.com/user-attachments/assets/105507eb-5894-46a8-a6e2-d54281940a7a)


-   [&check;] Search



