document.addEventListener('DOMContentLoaded', (event) => {
    var music = document.getElementById('music');
    var buttonImg = document.getElementById('musicButton').querySelector('img');

    if (music.autoplay && music.readyState >= 3) {
        buttonImg.classList.add("playing");
    }
});

function toggleMusic() {
    var music = document.getElementById('music');
    var buttonImg = document.getElementById('musicButton').querySelector('img');

    if (music.paused) {
        music.play();
        buttonImg.classList.add("playing");
    } else {
        music.pause();
        buttonImg.classList.remove("playing");
    }
}

