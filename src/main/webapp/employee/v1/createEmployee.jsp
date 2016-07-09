<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Employee</title>
    <link rel="stylesheet" href="../../js/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="../../js/jquery-1.10.2.js"></script>
    <script src="../../js/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(function() {
            $( "#tabs" ).tabs();
        });
    </script>
    <style>
        #tab1, #tab2, #tab3 {
            border: 1px solid black;
            border-collapse: collapse;
        }
        tr,td{
            padding: 5px;
        }
        #tab1 tr:nth-child(even){
            background-color: #eee;
        }
        #tab1 tr:nth-child(odd){
            background-color: #fff;
        }

        #tab2 tr:nth-child(even){
            background-color: #eee;
        }
        #tab2 tr:nth-child(odd){
            background-color: #fff;
        }

        #tab3 tr:nth-child(even){
            background-color: #eee;
        }
        #tab3 tr:nth-child(odd){
            background-color: #fff;
        }

    </style>
</head>
<body>

<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Create Account</a></li>
        <li><a href="#tabs-2">Update Account</a></li>
        <li><a href="#tabs-3">Delete Account</a></li>
    </ul>
    <div id="tabs-1">
        <p>
        <form action="create" method="post">
            <table id="tab1" align="center">
                <tr>
                    <td>
                        Employee Name:
                    </td>
                    <td>
                        <input  type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                    <td>
                        <input type="text" name="address">
                    </td>
                </tr>
                <tr>
                    <td>
                        Salary:
                    </td>
                    <td>
                        <input type="text" name="salary">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" name="reset" value="Clear">
                    </td>
                    <td>
                        <input type="submit" name="submit" value="submit">
                    </td>
                </tr>
            </table>
        </form>
        </p>
    </div>
    <div id="tabs-2">
        <form action="update" method="get">
            <table id="tab2" align="center">
                <tr>
                    <td>Id:</td>
                    <td>
                        <input type="text" name="id" >
                    </td>
                </tr>
                <tr>
                    <td>
                        Employee Name:
                    </td>
                    <td>
                        <input  type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                    <td>
                        <input type="text" name="address">
                    </td>
                </tr>
                <tr>
                    <td>
                        Salary:
                    </td>
                    <td>
                        <input type="text" name="salary">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" name="reset" value="Clear">
                    </td>
                    <td>
                        <input type="submit" name="submit" value="submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="tabs-3">
        <form action="delete" method="get">
            <table id="tab3" align="center">
                <tr>
                    <td>Id:</td>
                    <td>
                        <input type="text" name="id" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" name="reset" value="Clear">
                    </td>
                    <td>
                        <input type="submit" name="submit" value="submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>