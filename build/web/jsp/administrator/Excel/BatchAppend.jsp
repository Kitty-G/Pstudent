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
            <form id="fileupload" action="" method="POST" enctype="multipart/form-data">
                <p>
                    XLS:  <input type="radio" name="ExcelType" value="XLS" checked="checked">
                    XLSX: <input type="radio" name="ExcelType" value="XLSX">
                </p>
                <p><input type="file" name="file" multiple></p>
            </form>
        </div>
    </body>
</html>
