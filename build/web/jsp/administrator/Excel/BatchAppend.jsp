<%-- 
    Document   : BatchAppend
    Created on : 2016-6-5, 16:20:39
    Author     : KittyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form id="fileupload" action="../../../UploadExcelFileServlet" method="POST" enctype="multipart/form-data">
                <p><input type="file" name="file"></p>
                <p><input type="submit" name="submit" value="submit"></p>
            </form>
        </div>
    </body>
</html>
