const handleAdd = () => {
    var id = document.getElementById("book-id").value;
    var name = document.getElementById("book-name").value;
    var author = document.getElementById("book-author").value;
    var price = document.getElementById("book-price").value;

    if (id === "") {
        document.getElementById("book-id").focus();
        return;
    }

    if (name === "") {
        document.getElementById("book-name").focus();
        return;
    }

    if (author === "") {
        document.getElementById("book-author").focus();
        return;
    }

    if (price === "") {
        document.getElementById("book-price").focus();
        return;
    }

    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Post"); //Post 방식
    form.setAttribute("action", "/user/signup"); //요청 보낼 주소

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
