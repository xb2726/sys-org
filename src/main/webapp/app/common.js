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
        data: JSON.stringify(object || {}),
        success: function (o) {
            closeLoading();
            callback(o);
        }
    });
}

var page = 0;
var total = 0;

function getPageUrl(url) {
    var limit = $('#page_limit').val();
    var start = page * limit;
    if (urljsonPost.indexOf('?') > 0) {
        url += '&start=' + start + '&limit=' + limit;
        return url;
    }
    url += '?start=' + start + '&limit=' + limit;
    return url;
}

function setPage(total) {
    $('#page_total').html(total);
    $('#page_current').html(page + 1);
    var limit = +$('#page_limit').val();
    $('#page_nums').html(Math.ceil(total / limit));
}


$(function () {
    // 点击下一页
    $('#page_next').click(function () {
        page++;
        loadPerson();
    });

    // 点击上一页
    $('#page_prev').click(function () {
        if (page > 0) {
            page--;
            loadPerson();
        }
    });

    // 点击首页
    $('#page_start').click(function () {
        page = 0;
        loadPerson();
    });

    // 点击尾页
    $('#page_end').click(function () {
        // 当前总条数/limit
        var limit = +$('#page_limit').val();
        page = Math.floor(total / limit);
        loadPerson();
    });

    // 下拉框改变
    if ($('#page_limit')[0]) {
        $('#page_limit').change(loadPerson);
    }
});
