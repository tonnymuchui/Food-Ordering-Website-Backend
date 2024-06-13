# Food Ordering Backend

Welcome to the Food Ordering Backend repository! This guide will help you understand the key components and features of our system.

## Overview

Food Ordering Backend is designed to manage various entities and provide a seamless food ordering experience. Below is a detailed description of the core entities and functionalities.

## Entities

### User
- **ID:** Auto-generated
- **Username**
- **Password**
- **Email**
- **Phone Number**
- **Address**
- **Role:** Customer or Restaurant Owner
- **Registration Date**
- **Last Login Date**

### Restaurant
- **ID:** Auto-generated
- **Name**
- **Description**
- **Cuisine Type**
- **Address**
- **Contact Information**
- **Opening Hours**
- **Ratings**
- **Image URL**
- **Registration Date**

### Menu Item
- **ID:** Auto-generated
- **Name**
- **Description**
- **Price**
- **Category**
- **Image URL**
- **Availability Status**
- **Restaurant:** Reference to Restaurant entity
- **Creation Date**

### Order
- **ID:** Auto-generated
- **Customer:** Reference to User entity
- **Restaurant:** Reference to Restaurant entity
- **Total Amount**
- **Order Status**
- **Timestamp**
- **Delivery Address**
- **Items:** List of Order Items
- **Payment:** Reference to Payment entity, if applicable

### Order Item
- **ID:** Auto-generated
- **Menu Item:** Reference to Menu Item entity
- **Quantity**
- **Subtotal**
- **Order:** Reference to Order entity

### Payment
- **ID:** Auto-generated
- **Order:** Reference to Order entity
- **Payment Method**
- **Payment Status**
- **Total Amount**
- **Payment Timestamp**

### Review/Rating
- **ID:** Auto-generated
- **Customer:** Reference to User entity
- **Restaurant:** Reference to Restaurant entity
- **Rating**
- **Review Text**
- **Timestamp**

### Promotion/Coupon
- **ID:** Auto-generated
- **Code**
- **Discount Amount**
- **Validity Period**
- **Terms and Conditions**

### Notification
- **ID:** Auto-generated
- **Recipient:** Reference to User, Restaurant, or Delivery Executive entity
- **Message**
- **Timestamp**
- **Read Status**

### Category
- **ID:** Auto-generated
- **Name**

### Address
- **ID:** Auto-generated
- **Street Address**
- **City**
- **State/Province**
- **Postal Code**
- **Country**

## Services

Backend is structured to provide robust and scalable services:

- **Service:** Defines the service contracts through interfaces.
- **Service Implementation:** Implements the services defined in the service layer.
- **Controller:** Provides RESTful APIs for interacting with the backend.

## Getting Started

To get started with the Food Ordering Backend, follow these steps:

1. Clone the repository.`https://github.com/tonnymuchui/Food-Ordering-Website-Backend/`
2. Set up your development environment.
3. Configure your database and environment variables.
4. Run the application.

## Contact

If you have any questions or need assistance, feel free to reach out:

- **Email:** tonykanyingah@gmail.com

Thank you for choosing Food Ordering Backend! I hope it meets your needs and makes your food ordering experience seamless. Happy coding!
