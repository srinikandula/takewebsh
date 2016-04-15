/**
 * Created by CrazyNaveen on 4/12/16.
 */
$( document ).ready(function() {
    console.log( "ready!" );
});

function createEmployee() {
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

}

    function loadEmployees(){
        $.ajax({
            type:"GET",
           //url:"employee/v1/employeeList",
            url:"/employee/v1/employeeListJstl",
            success:function(data){
                $("#employees").html(data)
            }
        });
    }

function deleteEmployee(employeeId) {
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "DELETE",
        url: 'api/employee/delete?id='+employeeId,
        success: function(data, status, req) {
            $("#responseMessage").html(data);
            loadEmployees();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}




