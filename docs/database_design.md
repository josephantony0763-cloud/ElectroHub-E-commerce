# Database Design

## Entities

### User
Stores customer account details.

Attributes:
- user_id (PK)
- name
- email
- password
- phone


### Product
Stores electronic component details.

Attributes:
- product_id (PK)
- name
- description
- price
- stock
- category_id (FK)


### Category
Stores product categories.

Attributes:
- category_id (PK)
- category_name


### Cart
Stores user cart details.

Attributes:
- cart_id (PK)
- user_id (FK)


### Cart Item
Stores products added to cart.

Attributes:
- cart_item_id (PK)
- cart_id (FK)
- product_id (FK)
- quantity


### Order
Stores customer orders.

Attributes:
- order_id (PK)
- user_id (FK)
- order_date
- status
- total_amount


### Order Item
Stores products inside an order.

Attributes:
- order_item_id (PK)
- order_id (FK)
- product_id (FK)
- quantity
- price


### Payment
Stores payment information.

Attributes:
- payment_id (PK)
- order_id (FK)
- payment_method
- payment_status


## Relationships

User
→ has many Orders

User
→ has one Cart

Category
→ contains many Products

Cart
→ contains many Cart Items

Order
→ contains many Order Items

Product
→ belongs to Category