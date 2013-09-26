var Contact = function () {

    return {
        
        //Map
        initMap: function () {
			var map;
			$(document).ready(function(){
			  map = new GMaps({
				div: '#map',
				lat: 33.772935,
				lng: -84.382764
			  });
			   var marker = map.addMarker({
		            lat: 33.772935,
					lng: -84.382764,
		            title: 'Me !',
	            	infoWindow: {
	            		  content: '<p>144 Ponce De Leon Avenue</p>'
	            		}
		        });
			});
        }

    };
}();