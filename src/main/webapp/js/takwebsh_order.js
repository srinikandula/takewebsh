/**
 * Created by njonnala on 4/12/2016.
 */
$( document ).ready(function() {
    console.log( "ready!" );
});

function createOrder() {
    var orderName = $("#orderName").val();
    var orderType = $("#orderType").val();
    var orderPrice = $("#orderPrice").val();
    var orderQuantity = $("#orderQuantity").val();
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "POST",
        url: '/api/order/create',
        data: {'ordername': orderName , 'ordertype' : orderType , 'orderprice' : orderPrice , 'orderquantity' : orderQuantity},
        success: function(data, status, req) {
            console.log("Account is created");
            $("#responseMessage").html(data);
            $("#orderName").val("");
            $("#orderType").val("");
            $("#orderPrice").val("");
            $("#orderQuantity").val("");
            loadOrders();
        },
        error:function(req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}
function loadOrders(){
    $.ajax({
        type: "GET",
        url: '/orderList',
        success: function(data) {
            $("#ordersList").html(data)
        }
    });
}

function deleteOrder(id) {
    $("#responseMessage").html("");
    $("#errorMessage").html("");
    $.ajax({
        type: "DELETE",
        url: '/api/order/deleteOrder?orderId=' + id,
        success: function (data, status, req) {
            $("#responseMessage").html(data);
            loadOrders();
        },
        error: function (req, status, message) {
            $("#errorMessage").html("Error: " + message);
        }
    });
}

function loadOrder(id){
    $("#responseMessage").html("");
    $("#orderName").val("");
    $("#orderType").val("");
    $("#orderPrice").val("");
    $("#orderQuantity").val("");
    $.ajax({
        type : "GET",
        url : 'api/order/load?orderId=' +id,
        success : function(data){
            console.log(data)
            $("#loadMyOrder").html(data)

        }
    })
}