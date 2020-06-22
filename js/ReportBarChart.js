	var ctx = document.getElementById("reportAdafruitChart").getContext('2d');
	  var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	          labels: ["Device-Adafruit"],
	          datasets: [{
	              label: '# of Total Records',
	              data: [8],
	              backgroundColor: [
	                  'rgba(255, 159, 64, 0.2)'
	              ],
	              borderColor: [
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
	  
	var ctx = document.getElementById("reportEspChart").getContext('2d');
	  var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	          labels: ["Device-Esp"],
	          datasets: [{
	              label: '# of Total Records',
	              data: [4],
	              backgroundColor: [
	                  'rgba(255, 99, 132, 0.2)'
	              ],
	              borderColor: [
	                  'rgba(255,99,132,1)'
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