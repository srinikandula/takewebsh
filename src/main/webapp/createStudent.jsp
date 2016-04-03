<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="js/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(function() {
            $( "#tabs" ).tabs();
        });
    </script>
</head>
<body>

<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Create Account</a></li>
        <li><a href="#tabs-2">Update</a></li>
        <li><a href="#tabs-3">Delete</a></li>
    </ul>
    <div id="tabs-1">
        <p>

        <form action="student" method="post">
            <table>
                <tr>
                    <td>First Name : </td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td>Last Name : </td>
                    <td> <input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"/></td>
                </tr>
            </table>
        </form>
        </p>
    </div>
    <div id="tabs-2">

    </div>
    <div id="tabs-3">
        <p>
        <form action="delete" method="post">
        <table>
            <tr>
                <td>ID : </td>
                <td><input type="text" name="ID"></td>
            </tr>
        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
        </table>
        </p>
    </div>
</div>




</body>
</html>