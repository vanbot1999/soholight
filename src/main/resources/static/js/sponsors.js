function fetchAndDisplayKids() {

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
document.addEventListener('DOMContentLoaded', function() {
    fetchAndDisplayKids();
    setInterval(fetchAndDisplayKids, 2000);

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

function createSponsorshipChart() {
    const data = {
        labels: ['2021', '2022', '2023'], // year
        datasets: [{
            label: 'Sponsorship Amount',
            data: [62000, 43000, 60000], // amount
            backgroundColor: [
                'rgba(75, 192, 192, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 205, 86, 0.2)',
            ],
            borderColor: [
                'rgba(75, 192, 192, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(255, 205, 86, 1)',
            ],
            borderWidth: 1
        }]
    };

    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    };

    // create the chart
    const myChart = new Chart(document.getElementById('myChart'), config);
}

// Call the function to create the chart when the document is ready
document.addEventListener('DOMContentLoaded', function() {
    createSponsorshipChart();
});x