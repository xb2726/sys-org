function showLoading() {
    layer.load(1, {shade: false});
}

function showAlert(content) {
    layer.alert(content, {
        closeBtn: 0
    });
}

function showInfo(content) {
    layer.msg(content);
}

function closeLoading() {
    layer.closeAll();
}


function jsonPost(url, object, callback) {
    showLoading();
    $.ajax({
        type: "post",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(object||{}),
        success: function (o) {
            closeLoading();
            callback(o);
        }
    });
}