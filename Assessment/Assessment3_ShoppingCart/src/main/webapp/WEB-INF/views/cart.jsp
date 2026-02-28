<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        .cart-item {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px auto;
            width: 50%;
        }

        .total {
            font-size: 18px;
            font-weight: bold;
            margin-top: 15px;
        }

        a {
            display: inline-block;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<h2>Your Cart</h2>

<c:forEach var="item" items="${cartItems}">
    <div class="cart-item">
        ${item.product.name} |
        Quantity: ${item.quantity} |
        Total: ₹${item.totalPrice}
    </div>
</c:forEach>

<div class="total">
    Grand Total: ₹${total}
</div>

<a href="products">Back to Products</a>

</body>
</html>