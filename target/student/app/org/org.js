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

var currentNode = null;
var setting = {
    data: {
        simpleData: {
            enable: true,
            pIdKey: 'parentId'
        }
    },
    callback: {
        onClick: function (event, treeId, treeNode) {
            var id = treeNode.id;
            currentNode = treeNode;
            showLoading();
            $('.table>tbody>tr').remove();
            $.get('/org/find?id=' + id)
                .success(function (o) {
                    layer.closeAll();
                    $('.table>tbody').append('<tr>' +
                        '<td>1</td>' +
                        '<td>' + o.name + '</td>' +
                        '<td>' + (o.parentName || '') + '</td>' +
                        '<td>' + (o.description || '') + '</td>' +
                        '<td></td>' +
                        '</tr>')
                });
        }
    }
};

function loadOrgTree(callback) {
    $.get('/org/tree').success(function (o) {
        callback(o);
    });
}

var ztreeObject = null;

$(document).ready(function () {
    // 加载org的树形数据
    loadOrgTree(function (o) {
        ztreeObject = $.fn.zTree.init($("#orgTree"), setting, o);
        ztreeObject.expandAll(true);
    })
});

$(function () {
    // 编辑按钮被点击
    $('#btn_edit').click(function () {
        // 当前被选中的节点是谁？
        if (!currentNode) {
            showAlert('请选择要被编辑的组织机构！');
            return;
        }
        // 显示panel
        $('#panel-edit').show();
        $('#beans #orgName').val(currentNode.name);
        $('#beans #parentId').val(currentNode.parentId || null);
        $('#beans #parentName').val(currentNode.parentName || null);
        $('#beans #description').val(currentNode.description || null);
    });

    // 取消按钮
    $('#btn_cancel').click(function () {
        // 显示panel
        $('#panel-edit').hide();
    });

    // 保存按钮
    $('#btn_save').click(function () {
        var data = {id: currentNode.id};
        data.name = $('#beans #orgName').val();
        data.parentId = $('#beans #parentId').val() || null;
        data.parentName = $('#beans #parentName').val();
        data.description = $('#beans #description').val();
        showLoading();
        $.ajax({
            type: "post",
            url: "/org/update",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (o) {
                closeLoading();
                showInfo('更新成功！');
                // 关闭panel
                $('#panel-edit').hide();
                loadOrgTree(function (o) {
                    ztreeObject = $.fn.zTree.init($("#orgTree"), setting, o);
                    ztreeObject.expandAll(true);

                })

            }
        });

    });

    $('#btn_delete').click(function () {
        layer.confirm('是不是真的要删除？', {
            btn: ['确定删除', '取消'] //按钮
        }, function () {
            showLoading();
            $.post('/org/delete?id=' + currentNode.id)
                .success(function () {
                    closeLoading();
                    showInfo('删除成功！');
                    // 重新加载数据
                    loadOrgTree(function (o) {
                        ztreeObject.removeNode(currentNode);
                        currentNode = null;
                    })
                });
        });
    });
});