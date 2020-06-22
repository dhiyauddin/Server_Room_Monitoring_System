var ctx = document.getElementById("dataEntryChart").getContext('2d');
	  var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	          labels: ["Rooms", "Servers", "Devices","Device - Adafruit","Device - Esp"],
	          datasets: [{
	              label: '# of Total Records',
	              data: [3, 3, 10,8,4],
	              backgroundColor: [
	                  'rgba(255, 99, 132, 0.2)',
	                  'rgba(54, 162, 235, 0.2)',
	                  'rgba(255, 206, 86, 0.2)',
	                  'rgba(75, 192, 192, 0.2)',
	                  'rgba(255, 159, 64, 0.2)'
	              ],
	              borderColor: [
	                  'rgba(255,99,132,1)',
	                  'rgba(54, 162, 235, 1)',
	                  'rgba(255, 206, 86, 1)',
	                  'rgba(75, 192, 192, 1)',
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