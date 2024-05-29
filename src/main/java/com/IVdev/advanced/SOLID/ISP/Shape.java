package com.IVdev.advanced.SOLID.ISP;

//принцип разделения говорит о том, что лучше создать несколько узкоспециализированных интерфейсов
//и реализовывать нужные методы в нескольких классах, чем один с  несколькими, которые будут
//висеть в дочерних классах как лишний код
public interface Shape {
    void draw();
//    void drawLine();
//    void drawCircle();
//    void DrawRectangle();
}
