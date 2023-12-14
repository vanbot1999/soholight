function getCookie(name) {
    let cookieArray = document.cookie.split(';');
    for(let i = 0; i < cookieArray.length; i++) {
        let cookiePair = cookieArray[i].split('=');
        if(name == cookiePair[0].trim()) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
    return null;
}

window.onload = function() {
    console.log("dqn")
    let username = getCookie('user');
    let welcomeMessage = document.getElementById('welcomeMessage');
    let logoutButton = document.getElementById('logoutButton');
    let dropmenu = document.getElementById('dropmenu');
    let registerLink = document.getElementById('registerLink');
    if(username) {
        welcomeMessage.innerHTML = 'Welcome, ' + username;
        logoutButton.style.display = 'inline-block';
        dropmenu.style.display = 'none';
        registerLink.style.display = 'none';


    } else {

        logoutButton.style.display = 'none';
        dropdownmenu.style.display = 'inline';
        dropmenu.style.display = 'inline';
    }
};


$('#logoutButton').click(function() {
    $.post('/logout', function(data, status) {
        if (status === 'success') {


            $('#logoutButton').hide();
            window.location = '/Adminlogin';
        } else {
            console.error('Logout failed');
        }
    });
});
