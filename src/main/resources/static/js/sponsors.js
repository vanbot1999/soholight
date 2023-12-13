// script.js
//
// Define global variables at the top of the file
let myChart;
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

function fetchAndDisplayKids() {
    fetchDataAndUpdateChart(myChart);
}
function fetchAndDisplayKids(increaseAmount) {
    fetchDataAndUpdateChart(myChart, increaseAmount);
}


//chart
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
        options: { scales: { y: [{ ticks: { beginAtZero: true } }] } }
    };
    // create the chart
    myChart = new Chart(document.getElementById('myChart'), config); // Remove 'const' here
}
// Call the function to create the chart when the document is ready
document.addEventListener('DOMContentLoaded', function() {
    createSponsorshipChart();
});
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.see-more-button').forEach(function (button) {
        button.addEventListener('click', function (event) {
            event.preventDefault();
            const increaseAmount = parseInt(button.getAttribute('data-increase')) || 0;
            fetchAndDisplayKids(increaseAmount);
        });

    });
    showContent('2023');
    document.getElementById('tab2023').addEventListener('click', function () { showContent('2023'); });
    document.getElementById('tab2022').addEventListener('click', function () { showContent('2022'); });
    document.getElementById('tab2021').addEventListener('click', function () { showContent('2021'); });
});


// An example function that updates chart data based on increasing amounts
function updateChartDataWithIncrease(chartData, increaseAmount) {
    chartData[2] += increaseAmount;
    return chartData;
}

function updateChart(myChart, newData) {
    myChart.data.datasets[0].data = newData;
    myChart.update();
}

function fetchDataAndUpdateChart(myChart, increaseAmount) {
    // Make an AJAX request to fetch updated data from Spring Boot endpoint
    fetch('/fetch-sponsorship-amounts')
        .then(response => response.json())
        .then(data => {
            // Assuming newData is an array of sponsorship amounts
            var datasets = myChart.data.datasets;

            // Make sure the dataset exists
            if (!datasets || datasets.length === 0) {
                // If it does not exist, initialize a data set
                myChart.data.datasets = [{
                    data: [],
                    // Properties of other datasets can also be set here
                }];
            }

            // Get the data of the current chart
            var currentData = myChart.data.datasets[0].data;

            // update data
            var newData = updateChartDataWithIncrease(currentData, increaseAmount);

            // Call the updateChart function to update the chart
            updateChart(myChart, newData);
        })
        .catch(error => console.error('Error fetching data:', error));

}
$(document).ready(function() {
    //
    // Find the "Support" button
    var supportButton = $('.see-more-button');

    //
    // Add a click event listener to the button
    supportButton.on('click', function(event) {
        // Prevent the default behavior, that is, prevent the default click behavior of the button
        event.preventDefault();

        //
        // Get the position of the target anchor point
        var targetPosition = $('#chart').offset().top;

        //
        // Smooth scrolling using jQuery’s animate method
        $('html, body').animate({
            scrollTop: targetPosition
        }, 100);
        //100 represents the scrolling time in milliseconds
    });
});