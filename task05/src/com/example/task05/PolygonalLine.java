package com.example.task05;

import javax.sound.sampled.Line;

/**
 * Ломаная линия
 */
public class PolygonalLine {

    private Point[] points;
    /**
     * Устанавливает точки ломаной линии
     *
     * @param points массив точек, которыми нужно проинициализировать ломаную линию
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }

    /**
     * Добавляет точку к ломаной линии
     *
     * @param point точка, которую нужно добавить к ломаной
     */
    public void addPoint(Point point) {
        Point[] newPoints = new Point[points.length + 1];
        for (int i = 0; i< points.length; i++){
            newPoints[i] = points[i];
        }
        newPoints[points.length + 1] = point;
    }

    /**
     * Добавляет точку к ломаной линии
     *
     * @param x координата по оси абсцисс
     * @param y координата по оси ординат
     */
    public void addPoint(double x, double y) {
        Point p = new Point(x,y);
        addPoint(p);
    }

    /**
     * Возвращает длину ломаной линии
     *
     * @return длину ломаной линии
     */
    public double getLength() {
        double length = 0;
        if (points.length > 1){
            for (int i = 1; i < points.length; i++) {
                length += points[i].getLength(points[i-1]);
            }
        }
        return length;
    }

}
