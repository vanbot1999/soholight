// script.js
// 在文件的顶部定义全局变量
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


// 一个示例函数，根据增加的金额更新图表数据
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

            // 确保数据集存在
            if (!datasets || datasets.length === 0) {
                // 如果不存在，初始化一个数据集
                myChart.data.datasets = [{
                    data: [],  // 你可以根据实际需求设置初始数据
                    // 其他数据集的属性也可以在这里设置
                }];
            }

            // 获取当前图表的数据
            var currentData = myChart.data.datasets[0].data;

            // 更新数据
            var newData = updateChartDataWithIncrease(currentData, increaseAmount);

            // 调用 updateChart 函数来更新图表
            updateChart(myChart, newData);
        })
        .catch(error => console.error('Error fetching data:', error));
}
