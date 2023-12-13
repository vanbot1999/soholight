function toggleMusic() {
    var music = document.getElementById('music');
    var button = document.getElementById('musicButton');

    if (music.paused) {
        music.play();
        button.classList.add("playing");
    } else {
        music.pause();
        button.classList.remove("playing");
    }
}


document.getElementById('music').addEventListener('canplaythrough', function() {
    this.play();
});


document.getElementById('music').addEventListener('ended', function() {
    document.getElementById("musicButton").classList.add("paused");
});