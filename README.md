# Food Ordering Backend

Welcome to the Food Ordering Backend repository! This README provides an overview of the entities and functionalities of our system.

## Entities

1. **User:**
    - Auto-generated ID
    - Username
    - Password
    - Email
    - Phone Number
    - Address
    - Role (Customer or Restaurant Owner)
    - Registration Date
    - Last Login Date

2. **Restaurant:**
    - Auto-generated ID
    - Name
    - Description
    - Cuisine Type
    - Address
    - Contact Information
    - Opening Hours
    - Ratings
    - Image URL
    - Registration Date

3. **Menu Item:**
    - Auto-generated ID
    - Name
    - Description
    - Price
    - Category
    - Image URL
    - Availability Status
    - Restaurant (reference to Restaurant entity)
    - Creation Date

4. **Order:**
    - Auto-generated ID
    - Customer (reference to User entity)
    - Restaurant (reference to Restaurant entity)
    - Total Amount
    - Order Status
    - Timestamp
    - Delivery Address
    - Items (list of Order Items)
    - Payment (reference to Payment entity, if applicable)

5. **Order Item:**
    - Auto-generated ID
    - Menu Item (reference to Menu Item entity)
    - Quantity
    - Subtotal
    - Order (reference to Order entity)

6. **Payment:**
    - Auto-generated ID
    - Order (reference to Order entity)
    - Payment Method
    - Payment Status
    - Total Amount
    - Payment Timestamp

7. **Review/Rating:**
    - Auto-generated ID
    - Customer (reference to User entity)
    - Restaurant (reference to Restaurant entity)
    - Rating
    - Review Text
    - Timestamp

8. **Promotion/Coupon:**
    - Auto-generated ID
    - Code
    - Discount Amount
    - Validity Period
    - Terms and Conditions

9. **Notification:**
    - Auto-generated ID
    - Recipient (reference to User, Restaurant, or Delivery Executive entity)
    - Message
    - Timestamp
    - Read Status

10. **Category:**
    - Auto-generated ID
    - Name

11. **Address:**
    - Auto-generated ID
    - Street Address
    - City
    - State/Province
    - Postal Code
    - Country

## Contact Information

You can reach us via:

- Email: tonykanyingah@gmail.com

## Services

- **service:** Contains interfaces defining service contracts.
- **service-implementation:** Implements services defined in the service layer.
- **controller:** Provides RESTful APIs for interacting with the backend.

Thank you for choosing our Food Ordering Backend solution! If you have any questions or need assistance, feel free to reach out. Happy coding!