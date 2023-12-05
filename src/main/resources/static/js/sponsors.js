function showContent(year) {
    var contents = document.getElementsByClassName('content');
    var tabs = document.getElementsByClassName('tab');
    for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
        tabs[i].classList.remove('active-tab');
    }
    document.getElementById('content' + year).style.display = 'block';
    document.getElementById('tab' + year).classList.add('active-tab');
}