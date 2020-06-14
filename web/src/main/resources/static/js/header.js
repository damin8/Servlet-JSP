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
        alert("0 이상의 정수만 입력하세요");
        return false;
    }
    return true;
};

const handleScroll = () => {
    const { innerHeight } = window;
    const { scrollHeight } = document.body;
    // IE에서는 document.documentElement 를 사용.
    const scrollTop = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop;
    // 스크롤링 했을때, 브라우저의 가장 밑에서 100정도 높이가 남았을때에 실행하기위함.
    if (scrollHeight - innerHeight - scrollTop < 10) {
        if (!isLoading) {
            console.log("Almost Bottom Of This Browser");
            setIsLoading(true);
        }
    }
};
const scrollToTop = () => {
    var body = document.getElementsByTagName("body")[0];
    window.scroll({
        behavior: "smooth",
        left: 0,
        top: body.offsetTop,
    });
};
const scrollToList = () => {
    var feed = document.querySelector("#list").offsetTop;
    window.scroll({
        behavior: "smooth",
        left: 0,
        top: feed,
    });
};
const scrollToBorrow = () => {
    var feed = document.querySelector("#borrow").offsetTop;
    window.scroll({
        behavior: "smooth",
        left: 0,
        top: feed,
    });
};

const goToLink = (link) => {
    location.href = link;
};

const search = () => {
    var s_box = document.getElementsByClassName("serach-field")[0];
    var n_box = document.getElementById("nav-menu");
    s_box.style.display = "block";
    n_box.style.display = "none";
};

const nav = () => {
    var s_box = document.getElementsByClassName("serach-field")[0];
    var n_box = document.getElementById("nav-menu");
    var input = document.getElementById("search-input");
    input.value = "";
    s_box.style.display = "none";
    n_box.style.display = "block";
};

const searchSumbit = () => {
    var elm = document.getElementById("search-input");
    var input = document.getElementById("search-input").value;
    var option = document.getElementById("search-option");
    var optValue = option.options[option.selectedIndex].value;

    if (!checkBlank(input)) {
        elm.value = "";
        elm.focus();
        return;
    }
    if (!checkSpecial(input)) {
        elm.value = "";
        elm.focus();
        return;
    }

    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Get"); //Post 방식
    form.setAttribute("action", "/list"); //요청 보낼 주소

    var input1 = document.createElement("input");
    input1.setAttribute("type", "hidden");
    input1.setAttribute("name", "searchContent");
    input1.setAttribute("value", input);

    var input2 = document.createElement("input");
    input2.setAttribute("type", "hidden");
    input2.setAttribute("name", "option");
    input2.setAttribute("value", optValue);

    form.appendChild(input1);
    form.appendChild(input2);

    document.body.appendChild(form);
    form.submit();
};

const init = () => {
    nav();
};