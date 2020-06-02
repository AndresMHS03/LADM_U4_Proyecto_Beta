package com.example.ladm_u4_proyecto_andresh

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity): View(p){
    //
    var pelotaPlayer=0//1 si es la raqueta1, 2 si es la raqueta2
    var puntosP1 = 0
    var puntosP2 = 0
    var bloques = 30
    //
    var puntero = p

    var raqueta1 = FiguraGeometrica(400,1500,50,200)
    var raqueta2 = FiguraGeometrica(0,1500,50,200)
    var pelotita = FiguraGeometrica(600,900,10)

    var ladrillo11 = FiguraGeometrica(50,300,50,200)
    var ladrillo12 = FiguraGeometrica(50,351,50,200)
    var ladrillo13 = FiguraGeometrica(50,402,50,200)
    var ladrillo14 = FiguraGeometrica(50,453,50,200)
    var ladrillo15 = FiguraGeometrica(50,504,50,200)
    var ladrillo16 = FiguraGeometrica(50,555,50,200)

    var ladrillo21 = FiguraGeometrica(251,300,50,200)
    var ladrillo22 = FiguraGeometrica(251,351,50,200)
    var ladrillo23 = FiguraGeometrica(251,402,50,200)
    var ladrillo24 = FiguraGeometrica(251,453,50,200)
    var ladrillo25 = FiguraGeometrica(251,504,50,200)
    var ladrillo26 = FiguraGeometrica(251,555,50,200)

    var ladrillo31 = FiguraGeometrica(451,301,50,200)
    var ladrillo32 = FiguraGeometrica(451,352,50,200)
    var ladrillo33 = FiguraGeometrica(451,403,50,200)
    var ladrillo34 = FiguraGeometrica(451,454,50,200)
    var ladrillo35 = FiguraGeometrica(451,505,50,200)
    var ladrillo36 = FiguraGeometrica(451,556,50,200)

    var ladrillo41 = FiguraGeometrica(651,301,50,200)
    var ladrillo42 = FiguraGeometrica(651,352,50,200)
    var ladrillo43 = FiguraGeometrica(651,403,50,200)
    var ladrillo44 = FiguraGeometrica(651,454,50,200)
    var ladrillo45 = FiguraGeometrica(651,505,50,200)
    var ladrillo46 = FiguraGeometrica(651,556,50,200)

    var ladrillo51 = FiguraGeometrica(851,301,50,200)
    var ladrillo52 = FiguraGeometrica(851,352,50,200)
    var ladrillo53 = FiguraGeometrica(851,403,50,200)
    var ladrillo54 = FiguraGeometrica(851,454,50,200)
    var ladrillo55 = FiguraGeometrica(851,505,50,200)
    var ladrillo56 = FiguraGeometrica(851,556,50,200)



    var punteroFiguraGeometrica : FiguraGeometrica?= null

    override fun onDraw(c: Canvas?) {
        super.onDraw(c)
        var paint = Paint()

        c!!.drawColor(Color.BLACK)

        paint.style =Paint.Style.FILL
        paint.color = Color.DKGRAY
        raqueta1.pintar(c,paint)
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.LTGRAY
        raqueta2.pintar(c,paint)
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        pelotita.pintar(c,paint)

        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.YELLOW
        ladrillo11.pintar(c,paint)
        ladrillo12.pintar(c,paint)
        ladrillo13.pintar(c,paint)
        ladrillo14.pintar(c,paint)
        ladrillo15.pintar(c,paint)
        ladrillo16.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        ladrillo21.pintar(c,paint)
        ladrillo22.pintar(c,paint)
        ladrillo23.pintar(c,paint)
        ladrillo24.pintar(c,paint)
        ladrillo25.pintar(c,paint)
        ladrillo26.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        ladrillo31.pintar(c,paint)
        ladrillo32.pintar(c,paint)
        ladrillo33.pintar(c,paint)
        ladrillo34.pintar(c,paint)
        ladrillo35.pintar(c,paint)
        ladrillo36.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        ladrillo41.pintar(c,paint)
        ladrillo42.pintar(c,paint)
        ladrillo43.pintar(c,paint)
        ladrillo44.pintar(c,paint)
        ladrillo45.pintar(c,paint)
        ladrillo46.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.MAGENTA
        ladrillo51.pintar(c,paint)
        ladrillo52.pintar(c,paint)
        ladrillo53.pintar(c,paint)
        ladrillo54.pintar(c,paint)
        ladrillo55.pintar(c,paint)
        ladrillo56.pintar(c,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")

        when(event.action){
            MotionEvent.ACTION_DOWN->{//--------------------------------------Tocar
                //Revisar quien esta en el area
                if(raqueta1.estaEnArea(event)){
                    punteroFiguraGeometrica=raqueta1
                    puntero.setTitle("Tocaste la raqueta 1")
                }
            /*    if(cuadrado.estaEnArea(event)){
                    punteroFiguraGeometrica = cuadrado
                    puntero.setTitle("TOCASTE CUADRADO")
                }
                if(rectangulo.estaEnArea(event)){
                    punteroFiguraGeometrica = rectangulo
                    puntero.setTitle("TOCASTE RECTANGULO")
                }
                if(circulo2.estaEnArea(event)){
                    punteroFiguraGeometrica = circulo2
                    puntero.setTitle("TOCASTE CIRCULO2")
                }
                if(icono.estaEnArea(event)){
                    punteroFiguraGeometrica = icono
                    puntero.setTitle("TOCASTE LA CUCARACHA D:")
                    sonido.start()
                }*/
            }
            MotionEvent.ACTION_MOVE->{//--------------------------------------------Se mueve
                if(punteroFiguraGeometrica!=null){
                    punteroFiguraGeometrica!!.arrastrar(event)
                    if(punteroFiguraGeometrica==raqueta1){//pregunto si a quien arrasto es el circulo
                        if(punteroFiguraGeometrica!!.colisionB(pelotita)){
                            //circulo 1 hizo colision
                            puntero.setTitle("Circulo1 toco cuadrado :D")

                        }
                        if(punteroFiguraGeometrica!!.colisionB(raqueta2)){
                            puntero.setTitle("Raqueta 1 toco a la Raqueta 2")
                        }

                    }
                 /*   if(punteroFiguraGeometrica==circulo2){
                        if(punteroFiguraGeometrica!!.colision(circulo)){
                            puntero.setTitle("el circulo2 toco al circulo1 D:")
                        }
                    }*/
                }

            }//----------------------------------------------------------------Soltar
            MotionEvent.ACTION_UP->{
                punteroFiguraGeometrica=null
            }
        }
        invalidate()
        return true
    }

    fun darPuntos(){
        if (pelotaPlayer==1){
            puntosP1+=1
        }else{
            if (pelotaPlayer==2){
                puntosP2+=1
            }
        }
    }

    fun animarCirculo(){
        pelotita.rebote(width,height)

        /*if(pelotita.colision(raqueta1)==1){//1 vertical, 2 horizontal
            pelotita.incY
            pelotaPlayer=1
        }
        if(pelotita.colision(raqueta1)==2){//1 vertical, 2 horizontal
            pelotita.incY
            pelotaPlayer=1
        }*/
        ////////////////////////////////////////////////Raqueta1
       if(raqueta1.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            pelotaPlayer=1
        }
        if(pelotita.colisionB(raqueta1)==true){
            pelotita.incY=pelotita.incY*-1
            pelotaPlayer=1
        }
        /////////////////////////////////////////////////Raqueta2
        if(pelotita.colisionB(raqueta2)==true){
            pelotita.incY=pelotita.incY*-1
            pelotaPlayer=2
        }
        if(raqueta2.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            pelotaPlayer=2
        }
        //////////////////////////////////////////////////Ultima fila de ladrillos Ladrillos
        if(pelotita.colisionB(ladrillo16)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo16.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo16.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo16.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo26)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo26.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo26.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo26.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo36)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo36.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo36.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo36.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo46)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo46.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo46.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo46.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo56)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo56.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo56.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo56.desaparecer()
            darPuntos()
            bloques-=1
        }
        ///////////////////////////////////////////////////////////////////quinta fila de ladrillos

        if(pelotita.colisionB(ladrillo15)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo15.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo15.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo15.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo25)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo25.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo25.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo25.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo35)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo35.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo35.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo35.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo45)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo45.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo45.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo45.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo55)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo55.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo55.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo55.desaparecer()
            darPuntos()
            bloques-=1
        }

        ///////////////////////////////////////////////////////////////////Cuarta Fila
        if(pelotita.colisionB(ladrillo14)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo14.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo14.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo14.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo24)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo24.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo24.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo24.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo34)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo34.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo34.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo34.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo44)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo44.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo44.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo44.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo54)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo54.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo54.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo54.desaparecer()
            darPuntos()
            bloques-=1
        }

        ///////////////////////////////////////////////////////////////////tercera Fila

        if(pelotita.colisionB(ladrillo13)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo13.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo13.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo13.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo23)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo23.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo23.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo23.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo33)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo33.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo33.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo33.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo43)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo43.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo43.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo43.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo53)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo53.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo53.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo53.desaparecer()
            darPuntos()
            bloques-=1
        }

        ///////////////////////////////////////////////////////////////////Segunda Fila
        if(pelotita.colisionB(ladrillo12)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo12.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo12.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo12.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo22)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo22.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo22.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo22.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo32)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo32.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo32.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo32.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo42)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo42.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo42.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo42.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo52)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo52.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo52.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo52.desaparecer()
            darPuntos()
            bloques-=1
        }

        ///////////////////////////////////////////////////////////////////Primera Fila
        if(pelotita.colisionB(ladrillo11)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo11.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo11.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo11.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo21)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo21.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo21.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo21.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo31)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo31.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo31.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo31.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo41)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo41.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo41.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo41.desaparecer()
            darPuntos()
            bloques-=1
        }

        if(pelotita.colisionB(ladrillo51)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo51.desaparecer()
            darPuntos()
            bloques-=1
        }
        if(ladrillo51.colisionB(pelotita)==true){
            pelotita.incY=pelotita.incY*-1
            ladrillo51.desaparecer()
            darPuntos()
            bloques-=1
        }
        ///////////////////////////////////////////////////////////////////


        invalidate()
    }

}