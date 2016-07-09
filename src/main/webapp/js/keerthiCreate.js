    /**
     * Created by CrazyNaveen on 4/12/16.
     */
    $( document ).ready(function() {
        console.log( "ready!" );
    });

        /*function createEmployee() {
         var name = $("#name").val();
         var address = $("#address").val();
         var salary = $("#salary").val();
         $("#responseMessage").html("");
         $("#errorMessage").html("");
         $.ajax({
         type: "POST",
         url: "api/employee/create",
         data: {'name': name, 'address': address, 'salary': salary},
         success: function (data, status, req) {
         console.log("Employee is created successfully");
         $("#responseMessage").html(data);
         $("#name").val("");
         $("#address").val("");
         $("#salary").val("");
         loadEmployees();
         },
         error: function (req, status, message) {
         $("#errorMessage").html("Error: " + message);
         }
         });
         }*/

        function createEmployee(){
            var employeeId = $("#employeeId").val();
            var name = $("#name").val();
            var address = $("#address").val();
            var salary = $("#salary").val();
            $("#responseMessage").html("");
            $("#errorMessage").html("");
            if((employeeId == null) || (employeeId.trim().length == 0)) {//creating new employee
                $.ajax({
                        type: "POST",
                    url: "api/employee/create",
                    data: {'name': name, 'address': address, 'salary': salary},
                    success: function (data, status, req) {
                        console.log("Employee is created successfully");
                        $("#responseMessage").html(data);
                        $("#name").val("");
                        $("#address").val("");
                        $("#salary").val("");
                        loadEmployees();
                    },
                    error: function (req, status, message) {
                        $("#errorMessage").html("Error: " + message);
                    }
                });

            }else{
                $.ajax({
                    type:"POST",
                    url:"api/employee/update/"+employeeId,
                    data:{'name':name,'address':address,'salary':salary},
                    success:function(data,status,req){
                        console.log("Employee is updated");
                        $("#responseMessage").html(data);
                        $("#employeeId").val("");
                        $("#name").val("");
                        $("#address").val("");
                        $("#salary").val("");
                        loadEmployees();
                    },
                    error: function (req, status, message) {
                        $("#errorMessage").html("Error: " + message);
                    }
                });
            }
        }


        /*function loadEmployees(){
            $.ajax({
                type:"GET",
               //url:"employee/v1/employeeList",
                url:"/employee/v1/employeeListJstl",
                success:function(data){
                    $("#employees").html(data)
                }
            });
        }*/

    function deleteEmployee(employeeId) {
        $("#responseMessage").html("");
        $("#errorMessage").html("");
        $.ajax({
            type: "DELETE",
            url: '/api/employee/delete?id='+employeeId,
            success: function(data, status, req) {
                $("#responseMessage").html(data);
                loadEmployees();
            },
            error:function(req, status, message) {
                $("#errorMessage").html("Error: " + message);
            }
        });
    }

    function checkEmployeeWithName(){
        var name = $("#name").val();
        $.ajax({
            type:"GET",
            url:"api/employee/hasNameUsed?name="+name,
            success: function(data,status,req){
                if(data == true){
                    $("#errorMessage").html("Name is already used");
                }
            },
            error:function(data, status, message){
                $("#errorMessage").html("Error:"+message);
            }
        });
    }

    function loadEmployee(employeeId){
        $.ajax({
            type:"GET",
            url:"/api/employee/"+employeeId,
            success:function(employee){
                console.log(employee);
                $("#employeeId").val(employee.employeeId);
                $("#name").val(employee.name);
                $("#address").val(employee.address);
                $("#salary").val(employee.salary);
            }
        })
    }

    function loadEmployees(){
        $.ajax({
            type:"GET",
            url:"api/employee/employeeListJstl",
            success: function(data){
                console.log(data);
                var employees = data;
                var output ="<table border='1' cellspacing='2' cellpadding='2'><tbody>";
                for(var i=0; i<data.length;i++){
                    var employee = data[i];
                    output += "<tr>" +
                        "<td>"+employee.employeeId+"</td>" +
                        "<td>"+employee.name+"</td>" +
                        "<td>"+employee.address+"</td>" +
                        "<td>"+employee.salary+"</td>" +
                        "<td><button onclick='loadEmployee("+employee.employeeId+")'>Lookup</button></td>" +
                        "<td><button onclick='deleteEmployee("+employee.employeeId+")'>Delete</button></td>" +
                        "</tr>";
                }
                output += "</tbody></table>"
                $("#employees").html(output);
        }
        });
    }

