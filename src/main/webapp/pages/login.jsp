
<%-- <%
String msg = (String) request.getAttribute("msg");
if(msg!=null){
    out.print(msg);
}
%> --%>

${msg}

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
    }

    form {
        width: 300px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>

<form action="login" method="post">
    Username: <input type="text" name="username"><br>
    <br>Password: <input type="password" name="password"><br>
    <br><input type="submit" value="Login">
</form>
