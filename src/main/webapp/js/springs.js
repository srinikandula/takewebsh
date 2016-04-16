/**
 * Created by devendra on 4/12/2016.
 */
$(document).ready(function() {
    console.log("ready!");
});


function createAccount() {
    var studentId = $("#studentId").val();
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    if(studentId == null || studentId.trim().length == 0) {
    $.ajax({
        type:"POST",
        url:'/api/student/create',
        data: {'fName':firstName,'lName':lastName},
        success : function(data, status, req) {
            console.log("Account Created");
            $("#responseMessage").html(data);
            $("#firstName").val("");
            $("#lastName").val("");
            loadStudents();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error:" + message);
        }
    });
} else {
        $.ajax({
            type : "POST",
            url: '/api/student/update/'+studentId,
            data : {'firstName' : firstName, 'lastName': lastName},
            success: function(data, status, req) {
            console.log("Account is updated");
            $("#responseMessage").html(data);
            $("#studentId").val("");
            $("#firstName").val("");
            $("#lastName").val("");
            loadStudents();
        },
        error: function (req, status, message) {
            $("#errorMessage").html("Error:" +message);
        }
        });
    }
}


function deleteStudent(id) {
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "DELETE",
        url: '/api/student/delete?id='+id,
        success: function(data, status, req) {
            $("#responseMessage").html(data);
            loadStudents();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error:" + message);
        }
    });
}

function checkStudentWithFirstName() {
    var fName =$("#firstName").val();
    $.ajax({
        type: "GET",
        url: 'api/student/hasFirstNameUsed?fName='+fName,
        success: function(data, status, req) {
            if(data == true){
                $("#errorMessage").html("First Name is already in use");
            }
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error:"+ message);
        }
    });
}

function loadStudent(studentId) {
   // $("responseMessage").html("");
   // $ ("#studentID").val("");
   // $("#firstName").val("");
   // $("#lastName").val("");
    $.ajax({
        type:"GET",
        url:'/api/student/'+studentId,
        success: function(student) {
            console.log(student);
            $("#studentId").val(student.studentId);
            $("#firstName").val(student.firstName);
            $("#lastName").val(student.lastName);
        }
    });
}


function loadStudents() {
    $.ajax({
        type:"GET",
        url:'/api/student/list',
        success : function(data) {
            console.log(data);
            var students = data;
            var output ="<table border ='1'><tbody>";
               for(var i=0; i<data.length;i++){
                   var student = data[i];
                   output +="<tr>" +
                       "<td>"+student.studentId+"</td>" +
                           "<td>"+student.firstName+"</td>" +
                            "<td>"+student.lastName+"</td>" +
                           "<td><button onclick ='loadStudent("+student.studentId+")'>Update</button></td>"+
                           "<td><button onclick ='deleteStudent("+student.studentId+")'>Delete</button></td>"+
                           "</tr>";
               }
                output += "</tbody></table>";
            $("#students").html(output)
        }

    });
}

