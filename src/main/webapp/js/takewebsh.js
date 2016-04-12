/**
 * Created by skandula on 4/11/16.
 */
$( document ).ready(function() {
    console.log( "ready!" );
});

function createAccount() {
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var balance = $("#balance").val();
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "POST",
        url: '/api/account/create',
        data: {'fName':firstName, 'lName':lastName, 'balance': balance},
        success: function(data, status, req) {
            console.log("Account is created");
            $("#responseMessage").html(data);
            $("#firstName").val("");
            $("#lastName").val("");
            $("#balance").val("");
            loadAccounts();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}

function deleteAccount(id) {
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "DELETE",
        url: '/api/account/delete?id='+id,
        success: function(data, status, req) {
            $("#responseMessage").html(data);
            loadAccounts();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}

function checkAccountWithFirstName(){
    var fName = $("#firstName").val();
    $.ajax({
        type: "GET",
        url: '/api/account/hasFirstNameUsed?fNmae='+fName,
        success: function(data, status, req) {
            if(data == true){
                $("#errorMessage").html("First name is already used");
            }
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}
function loadAccounts(){
    $.ajax({
        type: "GET",
        url: '/account/list',
        success: function(data) {
            $("#accounts").html(data)
        }
    });
}