/**
 * Created by Sridhar Reddy S on 7/11/2016.
 */
$(document).ready(function(){
    loadEmployees();
    loadAccounts();
});
function loadEmployees(){
    $.ajax({
        url: "/api/employee/list",
        //data: {     },
        type: "GET",
        dataType : "json",
    }).done(function(response) {
        myEmployees(response);
        }).fail(function( xhr, status, errorThrown ) {
            alert( "Sorry, there was a problem!" );
            console.log( "Error: " + errorThrown );
            console.log( "Status: " + status );
            console.dir( xhr );
        })
}
function loadAccounts(){
    $.ajax({
        url: "/api/account/list",
        //data: {},
        type: "GET",
        dataType: "json",
    }).done(function(response) {
        myAccounts(response);
        }).fail(function( xhr, status, errorThrown ) {
                    alert( "Sorry, there was a problem!" );
                    console.log( "Error: " + errorThrown );
                    console.log( "Status: " + status );
                    console.dir( xhr );
        })
}
function myEmployees(a){
    var out="";
    var i;
    for(i=0;i<a.length;i++) {
        out += "<tr><td>"+a[i].employeeId+"</td><td>"+a[i].name+"</td><td>"+a[i].address+"</td><td>"+a[i].salary+"</td><td><button onclick='emp_info("+a[i].employeeId+")'>Load</button>&nbsp<button onclick='del_Emp_info("+a[i].employeeId+")'>Delete</button></td></tr>";
    }    
    document.getElementById("emp_table").innerHTML=out;
}
function myAccounts(a){
    var out="";
    var i;
    for(i=0;i<a.length;i++) {
        out += "<tr><td>"+a[i].id+"</td><td>"+a[i].firstName+"</td><td>"+a[i].lastName+"</td><td>"+a[i].balance+"</td><td><button onclick='Acc_info("+a[i].id+")'>Load</button>&nbsp<button onclick='del_Acc_info("+a[i].id+")'>Delete</button></td></tr>";
    }
    document.getElementById("acc_table").innerHTML=out;
}
function emp_create(){
    $.ajax({
        url: "/api/employee/create?name="+$("#emp_name").val()+"&address="+$("#emp_add").val()+"&salary="+$("#emp_sal").val() ,
        //data: {},
        type: "POST",
        //dataType: "",
    }).done(function() {
        $("#emp_id").val("");
        $("#emp_name").val("");
        $("#emp_add").val("");
        $("#emp_sal").val("");
        loadEmployees();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function acc_create(){
    $.ajax({
        url: "/api/account/create?firstName="+$("#first_name").val()+"&lastName="+$("#last_name").val()+"&balance="+$("#acc_balance").val() ,
        //data: {},
        type: "POST",
        //dataType: "",
    }).done(function() {
        $("#acc_id").val("");
        $("#first_name").val("");
        $("#last_name").val("");
        $("#acc_balance").val("");
        loadAccounts();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function del_Emp_info(c){
    $.ajax({
        url: "/api/employee/delete/?id="+c,
        //data: {},
        type: "DELETE",
        //dataType: "",
    }).done(function() {
        loadEmployees();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function del_Acc_info(c){
    $.ajax({
        url: "/api/account/delete/?id="+c,
        //data: {},
        type: "DELETE",
        //dataType: "",
    }).done(function() {
        loadAccounts();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function emp_info(c){
    $.ajax({
        url: "/api/employee/"+c,
        //data: {},
        type: "GET",
        dataType : "json",
    }).done(function(response) {
        $("#emp_id").val(response.employeeId);
        $("#emp_name").val(response.name);
        $("#emp_add").val(response.address);
        $("#emp_sal").val(response.salary);
        loadEmployees();
    }).fail(function( xhr, status, errorThrown ) {
            alert( "Sorry, there was a problem!" );
            console.log( "Error: " + errorThrown );
            console.log( "Status: " + status );
            console.dir( xhr );
        })
}
function Acc_info(c){
    $.ajax({
        url: "/api/account/"+c,
        //data: {},
        type: "GET",
        dataType : "json",
    }).done(function(response) {
        $("#acc_id").val(response.id);
        $("#first_name").val(response.firstName);
        $("#last_name").val(response.lastName);
        $("#acc_balance").val(response.balance);
        loadAccounts();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function emp_update(){
    var id=$("#emp_id").val();
    $.ajax({
        url: "/api/employee/update/"+ id +"?name="+ $("#emp_name").val()+"&address="+$("#emp_add").val()+"&salary="+$("#emp_sal").val(),
        //data: {},
        type: "PUT",
        //dataType : "json",
    }).done(function(c) {
        $("#emp_id").val(c.employeeId);
        $("#emp_name").val(c.name);
        $("#emp_add").val(c.address);
        $("#emp_sal").val(c.salary);
        loadEmployees();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}
function acc_update(){
    var id=$("#acc_id").val();
    $.ajax({
        url: "/api/account/update/"+ id +"?firstName="+ $("#first_name").val()+"&lastName="+$("#last_name").val()+"&balance="+$("#acc_balance").val(),
        //data: {},
        type: "PUT",
        //dataType : "json",
    }).done(function(c) {
        $("#acc_id").val(c.id);
        $("#first_name").val(c.firstName);
        $("#last_name").val(c.lastName);
        $("#acc_balance").val(c.balance);
        loadAccounts();
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    })
}