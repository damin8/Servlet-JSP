const onLoad = () => {
    console.log("remove");
    var id = document.getElementById("book-id");
    var name = document.getElementById("book-name");
    var author = document.getElementById("book-author");
    var price = document.getElementById("book-price");
    id.value = "";
};

const checkBlank = (value) => {
    var blank_pattern = /^\s+|\s+$/g;
    if (value.replace(blank_pattern, "") == "") {
        alert("공백 문자는 사용할 수 없습니다.");
        return false;
    }
    return true;
};

const checkSpecial = (value) => {
    var special_pattern = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
    if (special_pattern.test(value) == true) {
        alert("특수문자는 사용할 수 없습니다.");
        return false;
    }
    return true;
};

const checkInteger = (value) => {
    if (!(/^(\-|\+)?([0-9]+)$/.test(value) && parseInt(value) > 0)) {
        return false;
    }
    return true;
};

const handleAdd = () => {
    var id = document.getElementById("book-id").value;
    var name = document.getElementById("book-name").value;
    var author = document.getElementById("book-author").value;
    var price = document.getElementById("book-price").value;

    var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
    var blank_pattern = /[\s]/g;

    // id regx
    if (id === "") {
        document.getElementById("book-id").focus();
        return;
    }
    if (!checkInteger(id)) {
        alert("1 이상의 정수를 입력하세요");
        document.getElementById("book-id").focus();
        return;
    }

    // name regx
    if (name === "") {
        var elm = document.getElementById("book-name");
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkBlank(name)) {
        var elm = document.getElementById("book-name");
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkSpecial(name)) {
        var elm = document.getElementById("book-name");
        elm.value = "";
        elm.focus();
        return;
    }

    // author regx
    if (blank_pattern.test(author) == false && special_pattern.test(author) == false && author === "") {
        document.getElementById("book-author").focus();
        return;
    }
    if (!checkBlank(author)) {
        var elm = document.getElementById("book-author");
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkSpecial(author)) {
        var elm = document.getElementById("book-author");
        elm.value = "";
        elm.focus();
        return;
    }

    // price regx
    if (price === "") {
        document.getElementById("book-price").focus();
        return;
    }
    if (!checkBlank(price)) {
        var elm = document.getElementById("book-price");
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkSpecial(price)) {
        var elm = document.getElementById("book-price");
        elm.value = "";
        elm.focus();
        return;
    }

    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Post"); //Post 방식
    form.setAttribute("action", "/createBook"); //요청 보낼 주소

    var idInput = document.createElement("input");
    var nameInput = document.createElement("input");
    var authorInput = document.createElement("input");
    var priceInput = document.createElement("input");

    idInput.setAttribute("type", "hidden");
    idInput.setAttribute("name", "id");
    idInput.setAttribute("value", id);

    nameInput.setAttribute("type", "hidden");
    nameInput.setAttribute("name", "name");
    nameInput.setAttribute("value", name);

    authorInput.setAttribute("type", "hidden");
    authorInput.setAttribute("name", "author");
    authorInput.setAttribute("value", author);

    priceInput.setAttribute("type", "hidden");
    priceInput.setAttribute("name", "price");
    priceInput.setAttribute("value", price);

    form.appendChild(idInput);
    form.appendChild(nameInput);
    form.appendChild(authorInput);
    form.appendChild(priceInput);

    document.body.appendChild(form);

    form.submit();
};