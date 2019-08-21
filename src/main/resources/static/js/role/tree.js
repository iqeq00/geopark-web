var setting = {
    view: {
        addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        selectedMulti: false
    },
    check: {
        enable: true
    },
    data: {
        keep: {
            parent: true
        },
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId"
        },
        key: {
            name: "menuName"
        },
        check: {
            enable: true, // 显示多选框按钮
            chkStyle: "checkbox", // 添加生效
            chkboxType: {"Y": "", "N": ""} //Y:勾选（参数：p:影响父节点），N：不勾（参数s：影响子节点）[p 和 s 为参数]
        }
    },
    edit: {
        enable: true
    }

};

var newCount = 1;

function onAsyncSuccess() {
    //获得树形图对象
    var zTree = $.fn.zTree.getZTreeObj("menuTreeData");
    //获取根节点个数,getNodes获取的是根节点的集合
    var nodeList = zTree.getNodes();
    for (var i = 0; i < nodeList.length; i++) {
        zTree.expandNode(nodeList[i], true, false, false, false);
    }
}

function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='add node' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    var btn = $("#addBtn_" + treeNode.tId);
    if (btn) btn.bind("click", function () {
        var zTree = $.fn.zTree.getZTreeObj("menuTreeData");
        zTree.addNodes(treeNode, {id: (100 + newCount), pId: treeNode.id, name: "new node" + (newCount++)});
        return false;
    });
};

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.tId).unbind().remove();
};