<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Store</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        .product-container {
            display: flex;
            justify-content: center;
            gap: 20px;   /* space between products */
            flex-wrap: wrap; /* moves to next line if screen small */
        }

        .product-box {
            border: 1px solid #ccc;
            padding: 15px;
            width: 200px;
        }

        input[type="number"] {
            width: 50px;
        }
    </style>
</head>

<body>

<h2>Product Store</h2>

<div class="product-container">
    <c:forEach var="p" items="${products}">
        <div class="product-box">
            <p><strong>${p.name}</strong></p>
            <p>Price: ₹${p.price}</p>

            <form action="addToCart" method="post">
                <input type="hidden" name="product.id" value="${p.id}" />

                Quantity:
                <input type="number" name="quantity" value="1" min="1"/>

                <br/><br/>
                <button type="submit">Add to Cart</button>
            </form>
        </div>
    </c:forEach>
</div>

<br/>
<a href="viewCart">View Cart</a>

</body>
</html>