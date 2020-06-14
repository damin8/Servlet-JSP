
const handleSearch = () => {
    var elm = document.getElementById("input-borrow");
    var text = elm.value;
    if (text === "") {
        elm.value = "";
        elm.focus();
        return;
    }

    if (!checkInteger(text)) {
        elm.value = "";
        elm.focus();
        return;
    }

    if (!checkBlank(text)) {
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkSpecial(text)) {
        console.log("특수문자");
        elm.value = "";
        elm.focus();
        return;
    }

    location.href = "borrow?id=" + text;
};

const handleBorrow = (target) => {
    var parent = target.parentNode;
    var child = parent.childNodes[1].innerHTML;

    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Post"); //Post 방식
    form.setAttribute("action", "/borrowBook"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "id");
    hiddenField.setAttribute("value", child);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
};
