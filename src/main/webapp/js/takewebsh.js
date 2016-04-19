/**
 * Created by skandula on 4/11/16.
 */
$( document ).ready(function() {
    console.log( "ready!" );
});

function createAccount() {
    var accountId = $("#accountId").val();
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var balance = $("#balance").val();
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    if(accountId == null || accountId.trim().length == 0) { //create
        $.ajax({
            type: "POST",
            url: '/api/account/create',
            data: {'fName': firstName, 'lName': lastName, 'balance': balance},
            success: function (data, status, req) {
                console.log("Account is created");
                $("#responseMessage").html(data);
                $("#firstName").val("");
                $("#lastName").val("");
                $("#balance").val("");
                loadAccounts();
            },
            error: function (req, status, message) {
                $("#errorMessage").html("Error: " + message);
            }
        });
    }else {
        $.ajax({
            type: "POST",
            url: '/api/account/update/'+accountId,
            data: {'firstName': firstName, 'lastName': lastName, 'balance': balance},
            success: function (data, status, req) {
                console.log("Account is Updated");
                $("#responseMessage").html(data);
                $("#accountId").val("");
                $("#firstName").val("");
                $("#lastName").val("");
                $("#balance").val("");
                loadAccounts();
            },
            error: function (req, status, message) {
                $("#errorMessage").html("Error: " + message);
            }
        });
    }
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

function loadAccount(id) {
    $.ajax({
        type: "GET",
        url: '/api/account/'+id,
        success: function(account) {
            console.log(account)
            $("#accountId").val(account.id);
            $("#firstName").val(account.firstName);
            $("#lastName").val(account.lastName);
            $("#balance").val(account.balance);
        }
    });
}

function loadAccounts(){
    $.ajax({
        type: "GET",
        url: '/api/account/list',
        success: function(data) {
            console.log(data)
            var accounts = data;
            var output ="<table border='1'><tbody>";
                for(var i=0; i<data.length;i++){
                    var account = data[i];
                    output += "<tr>" +
                        "<td>"+account.id+"</td>" +
                        "<td>"+account.firstName+"</td>" +
                        "<td>"+account.lastName+"</td>" +
                        "<td>"+account.balance+"</td>" +
                        "<td><button onclick='loadAccount("+account.id+")'>Lookup</button></td>" +
                        "<td><button onclick='deleteAccount("+account.id+")'>Delete</button></td>" +
                        "</tr>";
                }
            output += "</tbody></table>"
            $("#accounts").html(output);
        }
    });
}