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
    let loginLink = document.getElementById('loginLink');
    let registerLink = document.getElementById('registerLink');
    if(username) {
        welcomeMessage.innerHTML = 'Welcome, ' + username;
        logoutButton.style.display = 'inline-block';
        loginLink.style.display = 'none';
        registerLink.style.display = 'none';
    } else {
        welcomeMessage.innerHTML = 'Please Sign in';
        logoutButton.style.display = 'none';
        loginLink.style.display = 'inline';
        registerLink.style.display = 'inline';
    }
};


$('#logoutButton').click(function() {
    $.post('/logout', function(data, status) {
        if (status === 'success') {

            $('#welcomeMessage').html('Please Sign in');
            $('#logoutButton').hide();
            window.location = '/Adminlogin';
        } else {
            console.error('Logout failed');
        }
    });
});
