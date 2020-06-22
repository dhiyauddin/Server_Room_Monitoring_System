var ctxBc = document.getElementById('deviceBatteryBubbleChart').getContext('2d');
var bubbleChart = new Chart(ctxBc, {
	type : 'bubble',
	data : {
		datasets : [ {
			label : 'Battery',
			data : [ {
				x : 1,
				y : 58.0,
				r : 5
			}, {
				x : 2,
				y : 57.0,
				r : 5
			} ],
			backgroundColor : "rgba(75, 192, 192, 1)",
			hoverBackgroundColor : "rgba(75, 192, 192, 1)"
		}, {
			label : 'Battery Alert',
			data : [ {
				x : 0,
				y : 30,
				r : 5
			} ],
			backgroundColor : "rgba(255,0,0)",
			hoverBackgroundColor : "rgba(255,0,0)"
		} ]
	}
})