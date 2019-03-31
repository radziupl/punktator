<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

    <title>punktator by radziu.pl</title>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="../resources/favicon.ico" />" >

    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA==" crossorigin=""></script>


    <style>
        html, body {
            height: 100%;
            margin: 0;
        }
        #map {
            width: 100%;
            height: 100%;
        }
    </style>


</head>
<body>

<div id='map'></div>

<script>
    var points = L.layerGroup();

    var mbAttr = 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
        '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
        'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        mbUrl = 'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw';

    var grayscale   = L.tileLayer(mbUrl, {id: 'mapbox.light', attribution: mbAttr}),
        streets  = L.tileLayer(mbUrl, {id: 'mapbox.streets',   attribution: mbAttr});

    var map = L.map('map', {
        center: [51.77, 19.45],
        zoom: 13,
        layers: [streets, points]
    });

    var baseLayers = {
    };

    var overlays = {
        "Miejsca": points
    };

    L.control.layers(baseLayers, overlays).addTo(map);

    L.control.watermark = function(opts) {
        return new L.Control.Watermark(opts);
    }
</script>

</body>
</html>
