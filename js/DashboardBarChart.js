var ctx = document.getElementById("myChart").getContext('2d');
	  var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	          labels: ["Rooms", "Servers", "Devices"],
	          datasets: [{
	              label: '# of Quantity',
	              data: [3, 3, 10],
	              backgroundColor: [
	                  'rgba(255, 99, 132, 0.2)',
	                  'rgba(54, 162, 235, 0.2)',
	                  'rgba(255, 159, 64, 0.2)'
	              ],
	              borderColor: [
	                  'rgba(255,99,132,1)',
	                  'rgba(54, 162, 235, 1)',
	                  'rgba(255, 159, 64, 1)'
	              ],
	              borderWidth: 1
	          }]
	      },
	      options: {
	          scales: {
	              yAxes: [{
	                  ticks: {
	                      beginAtZero:true
	                  }
	              }]
	          }
	      }
	  });