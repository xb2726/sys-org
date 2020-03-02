// 查询用户信息
function loadPerson() {
    // 获取查询条件
    var condition = {
        orgName: $('#orgName').val() || null,
        name: $('#name').val() || null
    };

    jsonPost('/person/query', condition, function (o) {
        // 往table写入数据
        $('.table>tbody>tr').remove();
        $.each(o, function (index, person) {
            $('.table>tbody').append('<tr>' +
                '<td>' + (index + 1) + '</td>' +
                '<td>' + person.name + '</td>' +
                '<td>' + (person.sex || '') + '</td>' +
                '<td>' + (person.orgName || '') + '</td>' +
                '<td>' +
                '<a class="btn btn-info b_update" data-id="' + person.id + '">更新</a>' +
                '<a class="btn btn-danger b_delete" data-id="' + person.id + '">删除</a>' +
                '</td>' +
                '</tr>'
            );
        });
    });
}

$(function () {

    // 页面加载完成后加载用户信息
    loadPerson();
    // 编辑按钮
    $('tbody').on('click', 'tr>td>a.b_update', function (e) {
        var dom = $(e.target);
        var id = dom.attr('data-id');
        window.open('/person/modify?id=' + id);
    });

    //  删除按钮
    $('tbody').on('click', 'tr>td>a.b_delete', function (e) {
        var dom = $(e.target);
        var id = dom.attr('data-id');
        layer.confirm('是不是真的要删除？', {
            btn: ['确定删除', '取消'] //按钮
        }, function () {
            showLoading();
            $.post('/person/delete?id=' + id)
                .success(function () {
                    closeLoading();
                    showInfo('删除成功！');
                    // 重新加载数据
                    loadPerson();
                });
        });
    });

    // 查询按钮被点击
    $('#btn_query').click(loadPerson);

    // 新建按钮被点击
    $('#btn_add').click(function () {
        window.open('/person/add');
    })
});