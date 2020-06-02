package com.example.ladm_u4_proyecto_andresh

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica(){

    var x = 0f
    var y = 0f
    var tipo = 1 //1 Rectangulo 2 Circulo  3 Bitmao
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX =5
    var incY = 5
    var bitmap : Bitmap?=null
    var dirRebote =0 //1 Horizontal,2 Vertical

    constructor(x:Int,y:Int,alto:Int,ancho:Int):this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.alto = alto.toFloat()
        this.ancho = ancho.toFloat()//Constructor de rectuangulo
    }

    constructor(x:Int,y:Int,radio:Int):this(){//constructor del circulo
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio=radio.toFloat()
        this.tipo = 2

        ancho = this.radio*2    //tratar el circulo como un cuadrado
        alto= ancho

    }

    constructor(x:Int, y:Int, imagen:Bitmap):this(){
        bitmap=imagen
        this.x=x.toFloat()
        this.y=y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.width.toFloat()
        this.tipo=3
    }//imagen

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            2->{
                c.drawCircle(x+radio,y+radio,radio,p)
            }
            3 ->{
                c.drawBitmap(bitmap!!,x,y,p)
            }
        }
    }

    fun estaEnArea(event: MotionEvent):Boolean{
        if(event.x>= x && event.x <= x+ancho){
            if(event.y >= y && event.y <=y+alto) {
                return true
            }
        }
        return false
    }

    fun estaEnArea(posX:Float,posY:Float):Boolean{
        if(posX>= x && posX <= x+ancho){
            if(posY >= y && posY <=y+alto) {
                return true
            }
        }
        return false
    }

    fun estaEnArea2(posX:Float,posY:Float): Int{
        if(posX>= x && posX <= x+ancho && posY == y){//si pega arriba del objeto

            return 1//cambio vertical
        }
        if(posX>= x && posX <= x+ancho && posY == y+alto){//si pega abajo del objeto

            return 1//cambio vertical
        }
        if(posY >= y && posY <=y+alto && posX == x) {//si pega a la izq del objeto

            return 2//cambio horizontal
        }
        if(posY >= y && posY <=y+alto && posX == x+ancho) {//si pega a la der del objeto
            return 2//cambioHorizontal
        }

        return 0}


    fun rebote(ancho:Int, alto:Int){
        x+= incX
        if(x<= -100||x>=ancho){
            incX*=-1
        }
        y+=incY
        if(y<=-100||y>=alto){
            incY*=-1
        }
    }

    fun arrastrar(event:MotionEvent){
        x = event.x-(ancho/2)
        y = event.y-(alto/2)
    }

    fun colision(objetoB: FiguraGeometrica):Int{
        //---------------------------------------------------Caso 1 inferior dereche
        if (objetoB.estaEnArea2(x+ancho,y+alto)==1){
            return 1
        }
        if (objetoB.estaEnArea2(x+ancho,y+alto)==2){
            return 2
        }
        ////////////////////////////////////////////////////////////Caso2 Inferior Izquierda
        if (objetoB.estaEnArea2(x,y+alto)==1){
            return 1
        }
        if (objetoB.estaEnArea2(x,y+alto)==2){
            return 2
        }
        ////////////////////////////////////////////////////////////Caso3 superior derecha
        if (objetoB.estaEnArea2(x+ancho,y)==1){
            return 1
        }
        if (objetoB.estaEnArea2(x+ancho,y)==2){
            return 2
        }
        /////////////////////////////////////////////////////////////////Caso4 superior izquierda
        if (objetoB.estaEnArea2(x,y)==1){
            return 1
        }
        if (objetoB.estaEnArea2(x,y)==2){
            return 2
        }
        /*caso5*/

        return 0

    }

    fun colisionB(objetoB: FiguraGeometrica):Boolean{
        //Caso 1
        if (objetoB.estaEnArea(x+ancho,y+alto)){
            return true
        }
        //Caso2
        if (objetoB.estaEnArea(x,y+alto)){
            return true
        }
        //Caso3
        if (objetoB.estaEnArea(x+ancho,y)){
            return true
        }
        //Caso4
        if (objetoB.estaEnArea(x,y)){
            return true
        }
        return false
    }

    fun desaparecer(){
        x=-50f
        y=-100f
    }
}