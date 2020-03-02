function wrapData() {
    var data = {id: $('#id').val() || null};
    data.name = $('#beans #name').val();
    data.orgId = $('#beans #orgId').val() || null;
    data.orgName = $('#beans #orgName').val() || null;
    data.sex = $('#beans #sex').val();
    if (!data.name) {
        showAlert('请填写用户姓名！');
        return false;
    }
    return data;
}

$(function () {
    // 保存方法
    $('#btn_save').click(function () {
        var data = wrapData();
        if (data) {
            jsonPost('/person/save', data, function () {
                showInfo('保存成功!');
                window.close();
            });
        }
    });
    // 更新方法
    $('#btn_update').click(function () {
        var data = wrapData();
        if (data) {
            jsonPost('/person/update', data, function () {
                showInfo('更新成功!');
                window.close();
            });
        }
    });

    // 取消
    $('#btn_cancel').click(function () {
        window.close();
    })
});