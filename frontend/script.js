var xmlHttp = new XMLHttpRequest();

    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
        	var listOfCars = JSON.parse(xmlHttp.responseText);
        	var htmlToBeAdded = "";
        for(i = 0; i< listOfCars.length; i++)
        {
        	htmlToBeAdded += "<img src='"+listOfCars[i].location+"'/> <br/>"
        }
        document.getElementById('jimbob').innerHTML = htmlToBeAdded;
    }
    xmlHttp.open("GET", "http://localhost:8080/CarAppApi/webapi/myresource", true); // true for asynchronous 
    xmlHttp.send(null);

