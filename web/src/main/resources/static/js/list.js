const onClick = (target) => {
    var elm = target.childNodes[1];
    var rentNode = target.childNodes[9];
    var flag = rentNode.innerHTML;
    if (flag === "Yes") {
        location.href = "borrow?id=" + elm.innerHTML;
    } else {
        return;
    }
};