function fetchAndDisplayKids() {
        ['2021', '2022', '2023'].forEach(year => {
            $.ajax({
                url: '/random-kids/' + year,
                type: 'GET',
                dataType: 'json',
                success: function(kids) {
                    var kidsList = $('#kids-' + year);
                    kidsList.find('.kid').addClass('flipping-out');
                    setTimeout(function() {
                        kidsList.empty();
                        kids.forEach(function(kid) {
                            var imageElement = $('<img />', {
                                src: kid.url,
                                alt: "Kid Image",
                                class: "img-fluid img-hover-zoom loaded", // 已加载类直接添加
                                style: "width:100px; height:auto;",
                                'data-id': kid.id
                            });

                            var kidElement = $('<div />', {
                                class: "col-md-4 text-center mb-3 kid flipping-in", // 添加翻入动画类
                                click: function() {
                                    window.location.href = '/workpage?imageId=' + kid.id;
                                }
                            });

                            kidElement.append(imageElement);
                            kidElement.append('<p class="mt-auto kid-name"> - ID: ' + kid.id + ' <br>- Name: ' + kid.name + ' <br>- Age: ' + kid.age + '</p>');

                            kidsList.append(kidElement);
                        });
                    }, 500); // 这里的延时应与翻出动画的时间一致
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

//#65
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
document.addEventListener('DOMContentLoaded', function() {
    fetchAndDisplayKids();
    setInterval(fetchAndDisplayKids, 2000);

    var mybutton = document.getElementById("backToTopBtn");

    function scrollFunction() {
        if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    }

    function topFunction() {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }

    if (mybutton) {
        window.onscroll = function() { scrollFunction(); };
        mybutton.onclick = function() { topFunction(); };
    }

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

    document.getElementById('tab2023').addEventListener('click', function() { showContent('2023'); });
    document.getElementById('tab2022').addEventListener('click', function() { showContent('2022'); });
    document.getElementById('tab2021').addEventListener('click', function() { showContent('2021'); });

    showContent('2023');
});
