/**
 * 发送AJAX请求
 * @param serviceName: action的方法,格式为 package.class.method
 * @param 其后的参数以一对对“参数名-参数值”的方式
 * @example doService("admin.Main.changePwd", "oldpwd",1, "newpwd",2)
 */
function doService() {
    var params = doService.arguments;
    if(params.length%2 == 0) {
        alert('参数错误!');
        return;
    }
    var serviceName = params[0];
    var urlParams = '';
    urlParams = arrayToUrl(urlParams, params, 1);
    return postService(serviceName, urlParams);
}

/**
 * 发送AJAX请求
 * @private
 * @param serviceName: action的方法,格式为 package.class.method
 * @param urlParams: ajax请求的URL参数
 * @example postService("admin.Main.changePwd", "oldpwd=1&newpwd=2")
 */
function postService(serviceName, urlParams)
{
    var jsonObject;
    $.ajax({
        type: "POST",
        url: serviceName,
        data: urlParams,
        dataType: "json",
        async: false,
        success: function(json)
        {
            if(json.success){
                jsonObject = json.message;
            }else{
                //执行失败
                alert(json.message);
                jsonObject = null;
            }

        }
    });
    return jsonObject;
}