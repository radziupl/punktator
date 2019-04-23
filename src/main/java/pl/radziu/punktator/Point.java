package pl.radziu.punktator;

import javax.validation.constraints.NotNull;

public class Point {

    private Integer id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    public Point(Integer id, String name, String description, Double latitude, Double longitude){
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {return description; }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }





}
