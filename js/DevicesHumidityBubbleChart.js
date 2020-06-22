var ctxBc = document.getElementById('deviceHumidityBubbleChart').getContext('2d');
var bubbleChart = new Chart(ctxBc, {
	type : 'bubble',
	data : {
		datasets : [ {
			label : 'Humidity',
			data : [ {
				x : 1,
				y : 55.0,
				r : 5
			}, {
				x : 2,
				y : 44.0,
				r : 5
			} ],
			backgroundColor : "rgba(0, 10, 130, .7)",
			hoverBackgroundColor : "rgba(0, 10, 130, .7)"
		}, {
			label : 'Humidity Alert',
			data : [ {
				x : 0,
				y : 60,
				r : 5
			} ],
			backgroundColor : "rgba(255,0,0)",
			hoverBackgroundColor : "rgba(255,0,0)"
		} ]
	}
})