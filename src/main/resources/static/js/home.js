function fetchAndDisplayKids() {
        ['2021', '2022', '2023'].forEach(year => {
            $.ajax({
                url: '/random-kids/' + year,
                type: 'GET',
                dataType: 'json',
                success: function(kids) {
                    var kidsList = $('#kids-' + year);
                    kidsList.empty();
                    kids.forEach(function(kid) {
                        var imageElement = $('<img />', {
                            src: kid.url,
                            alt: "Kid Image",
                            class: "img-fluid img-hover-zoom",
                            style: "width:100px; height:auto;",
                            'data-id': kid.id
                        }).on('load', function() {
                            $(this).addClass('loaded');
                        });

                        var kidElement = $('<div />', {
                            class: "col-md-4 text-center mb-3 kid",
                            html: imageElement,
                            click: function() {
                                window.location.href = '/workpage?imageId=' + kid.id;
                            }
                        });

                        kidElement.append('<p class="mt-auto kid-name"> - ID: ' + kid.id + ' <br>- Name: ' + kid.name + ' <br>- Age: ' + kid.age + '</p>');

                        kidsList.append(kidElement);
                    });
                },
                error: function(error) {
                    console.error('Error fetching kids for year ' + year + ':', error);
                }
            });
        });
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
        let userId = getCookie('user');
        let welcomeMessage = document.getElementById('welcomeMessage');
        let logoutButton = document.getElementById('logoutButton');
        let loginLink = document.getElementById('loginLink');
        let registerLink = document.getElementById('registerLink');
        if(userId) {
            welcomeMessage.innerHTML = 'Welcome, ' + userId;
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
}


$(document).ready(function() {
        fetchAndDisplayKids();
        setInterval(fetchAndDisplayKids, 2000);
});

// Get the #backToTopBtn element on the page.
var mybutton = document.getElementById("backToTopBtn");

// Execute the scrollFunction function when the window scrolls.
window.onscroll = function () { scrollFunction() };

function scrollFunction() {

    // Show #backToTopBtn button if the page has scrolled down more than 30 pixels
    if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
        mybutton.style.display = "block";
    }
    // Otherwise, hide the #backToTopBtn button.
    else {
        mybutton.style.display = "none";
    }
}

// Execute the topFunction function when the #backToTopBtn button is clicked.
mybutton.onclick = function () { topFunction() };

function topFunction() {

    // Smoothly scroll to the top of the page
    window.scrollTo({ top: 0, behavior: 'smooth' });
}