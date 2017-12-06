function LoginCheck() {
    var username = $("input[name='username']").val()
    var password = $("input[name='password']").val()

    $.post("/App/LoginCheck", "username=" + username + "&password=" + password, Loginback, "text")

}

// private String status;  //状态码
// private String message; //消息
// private Object data;
function Loginback(data) {
    var data = JSON.parse(data);
    if (data.status == "200") {
        alert(data.message)
    } else {
        alert(data.message)
    }


}

$("input[name='username']").blur(function () {

    alert("11")
    var username = $("input[name='username']").val()


})