const onClick = (target) => {
    var elm = target.childNodes[1];
    location.href = "borrow?id=" + elm.innerHTML;
};