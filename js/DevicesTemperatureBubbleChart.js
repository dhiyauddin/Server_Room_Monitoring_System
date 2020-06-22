var ctxBc = document.getElementById('deviceTemperatureBubbleChart')
		.getContext('2d');
var bubbleChart = new Chart(ctxBc, {
	type : 'bubble',
	data : {
		datasets : [ {
			label : 'Temperature',
			data : [ {
				x : 1,
				y : 25.4,
				r : 5
			}, {
				x : 2,
				y : 24.4,
				r : 5
			} ],
			backgroundColor : "rgba(75, 192, 192, 1)",
			hoverBackgroundColor : "rgba(75, 192, 192, 1)"
		}, {
			label : 'Temperature Alert',
			data : [ {
				x : 0,
				y : 26,
				r : 5
			} ],
			backgroundColor : "rgba(255,0,0)",
			hoverBackgroundColor : "rgba(255,0,0)"
		} ]
	}
})