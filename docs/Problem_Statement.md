# Multi-Vendor E-Commerce Marketplace (Amazon-Style)

## Project Overview

The Multi-Vendor E-Commerce Marketplace is a web application that connects customers with multiple electronic component vendors on a single platform. Instead of visiting different shops to compare prices and availability, customers can search, compare, and purchase products from multiple vendors in one place.

The platform also helps small and local vendors expand their business by allowing them to sell their products online.

---

# Problem Statement

Customers often need to visit multiple electronic stores to compare prices and check product availability. This process is time-consuming and inconvenient.

Small vendors also struggle to reach a wider customer base because they mainly depend on local sales.

This project aims to solve both problems by creating a centralized marketplace where multiple vendors can sell electronic components and customers can easily compare products, prices, and purchase them online.

---

# Objectives

* Connect multiple vendors and customers on one platform.
* Allow customers to compare prices from different vendors.
* Enable online purchasing of electronic components.
* Help small vendors expand their business digitally.
* Provide secure authentication and order management.

---

# User Roles

## Customer

* Register
* Login
* Search products
* View product details
* Add products to cart
* Place orders
* Track orders
* Write reviews and ratings

## Vendor

* Register
* Login
* Add products
* Update products
* Delete products
* Manage inventory
* View received orders

## Admin

* Manage customers
* Approve vendors
* Manage vendors
* Manage products
* Generate reports

---

# Functional Requirements

* User registration and login
* Vendor registration and approval
* Product management
* Product search
* Category-based browsing
* Shopping cart
* Order management
* Payment processing
* Order tracking
* Product reviews

---

# Non-Functional Requirements

* Responsive user interface
* Secure password encryption
* Fast page loading
* Mobile-friendly design
* Ability to support many concurrent users

---

# Actors

* Customer
* Vendor
* Admin
* Payment Gateway
* Email Service

---

# Core Entities (MVP)

* Users
* Seller Profiles
* Addresses
* Categories
* Products
* Vendor Products
* Carts
* Cart Items
* Orders
* Order Items
* Payments
* Reviews

---

# Core Relationships

* One User can have many Addresses.
* One Seller Profile belongs to one User.
* One Category contains many Products.
* One Product can be sold by many Vendors.
* One Vendor can sell many Products.
* One Cart belongs to one Customer.
* One Cart contains many Cart Items.
* One Order contains many Order Items.
* One Customer can place many Orders.
* One Product can receive many Reviews.

---

# Technology Stack

## Frontend

* React
* HTML
* CSS
* JavaScript

## Backend

* Java
* Spring Boot
* Spring Security
* JWT Authentication

## Database

* MySQL

## Tools

* Git
* GitHub
* Postman
* IntelliJ IDEA
* Maven

---

# Project Architecture

```text
React Frontend
        │
        ▼
REST API
        │
        ▼
Spring Boot
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
MySQL Database
```

---

# MVP Scope (First Evaluation)

* User Authentication
* Vendor Registration
* Product Management
* Product Search
* Shopping Cart
* Order Placement
* Payment Integration
* Order Tracking

---

# Future Enhancements

* Wishlist
* Notifications
* Product Variants
* AI Product Recommendation
* Sales Analytics Dashboard
* Coupons and Offers

---

# Git Commit Convention

* feat: New feature
* fix: Bug fix
* docs: Documentation updates
* refactor: Code improvement
* test: Testing
* chore: Project maintenance

---

# Current Status

Planning Phase Completed

* Problem Statement
* User Roles
* Functional Requirements
* Non-Functional Requirements
* User Stories
* Use Cases
* System Flow
* Software Architecture
* Domain Analysis
* Initial Database Design
