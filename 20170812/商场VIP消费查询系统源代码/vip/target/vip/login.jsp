<%@ page pageEncoding="utf-8" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>xxx</title>
    </head>

<body>
    <strong>${message}</strong>
    <form action="login.do" method="post">
        <p>
            <label>Account:<input name="account"></label>
        </p>
        <p>
            <label>Password:<input name="password"></label>
        </p>
        <p>
            <button type="submit">Login</button>
        </p>
    </form>
</body>
</html>

