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
    console.log("goto " + link);
    location.href = link;
};
