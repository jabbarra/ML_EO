package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Log4j2
public class MainTestPrecision {

    public static void main(String[] args) {
        testAlgoritmoAlinear();
        testAlinearconOrigen();

        testAlinearsinOrigen();

        crearFileAreas();

//		se usa algoritmo para allinear
        obtenerClimaSequia();

//		se usa el area
        getPeridoSequia();
        getPeridoLLuvia();
        getPeridoIdeal();


    }


    private static void testAlinearconOrigen() {

        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));


        while (dia <= ultimoDia) {
            Double anguloRad = Math.toRadians(1);
            fAngulo = new BigDecimal(anguloRad.toString());
            anguloRad = Math.toRadians(3);
            bAngulo = new BigDecimal(anguloRad.toString());
            anguloRad = Math.toRadians(5);
            vAngulo = new BigDecimal(anguloRad.toString());

            Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
            Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
            Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

            FuncionCuadratica recta = new FuncionCuadratica(fp, p0);

            BigDecimal yaux = recta.getValorY(bp.getX());
            if (MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)) {
//				log.info("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//				log.info("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString()+"\n");
                yaux = recta.getValorY(vp.getX());
                if (MatematicaUtils.esSemejante(yaux, vp.getY(), 0.5)) {
                    log.info("F eje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                    log.info("B eje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                    log.info("V eje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
                }
            }

            dia++;
        }

    }

    private static void testAlinearsinOrigen() {
        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));

        while (dia <= ultimoDia) {
            Double anguloRad = Math.toRadians(1);
            fAngulo = new BigDecimal(anguloRad.toString());
            anguloRad = Math.toRadians(3);
            bAngulo = new BigDecimal(anguloRad.toString());
            anguloRad = Math.toRadians(5);
            vAngulo = new BigDecimal(anguloRad.toString());

            Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
            Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
            Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

            FuncionCuadratica recta = new FuncionCuadratica(fp, bp);
            BigDecimal yaux = recta.getValorY(vp.getX());

            if (MatematicaUtils.esSemejante(yaux, vp.getY(), 0.5)) {
                log.info("F eje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                log.info("B eje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString() + "\n");

//				yaux = recta.getValorY(p0.getX());
//				if(esSemejante(yaux, p0, 0.5)){
//					log.info("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					log.info("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					log.info("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}else{
//					log.info("-F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					log.info("-B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					log.info("-V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
            }

            dia++;
        }

    }


    private static void obtenerClimaSequia() {

        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Double anguloRad = Math.toRadians(1);
        fAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(3);
        bAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(5);
        vAngulo = new BigDecimal(anguloRad.toString());

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));


        while (dia <= ultimoDia) {


            Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
            Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
            Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

            if (MatematicaUtils.estanAlineados(fp, bp, vp)) {
                log.info("fp eje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                log.info("bp eje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                log.info("vp eje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
//				if(MatematicaUtils.estanAlineados(fp, bp, p0)){
//					log.info("fp eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					log.info("bp eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					log.info("vp eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}else{
//					log.info("-fp eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					log.info("-bp eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					log.info("-vp eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
            }

            dia++;
        }

    }


    private static void crearFileAreas() {

        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Double anguloRad = Math.toRadians(1);
        fAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(3);
        bAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(5);
        vAngulo = new BigDecimal(anguloRad.toString());

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));


        String FILENAME = "C:\\logs\\areas.txt";
        int contador = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            while (dia <= ultimoDia) {
                Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
                Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
                Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));


                double area = Triangulo.getArea(fp, bp, vp);
                bw.write("DIA: " + dia);
                if (Triangulo.esPuntoInteriorTriangulo(fp, bp, vp, p0)) {
                    bw.write(" SOL_adentro ");
                } else {
                    bw.write(" SOL_afuera ");
                }
                bw.write(" AREA: " + area);
                bw.write(" Feje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                bw.write(" Beje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                bw.write(" Veje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
                if (-1 < area && area < 1) {
                    log.info("DIA: " + dia);
                    if (Triangulo.esPuntoInteriorTriangulo(fp, bp, vp, p0)) {
                        log.info(" SOL_adentro ");
                    } else {
                        log.info(" SOL_afuera ");
                    }
                    log.info("AREA: " + area);
                    log.info("F eje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                    log.info("B eje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                    log.info("V eje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
                    contador++;
                }


//				if(MatematicaUtils.estanAlineados(fp, bp, vp)){
//					bw.write("DIA: "+ dia);
//					bw.write(" AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
//					bw.write(" Feje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					bw.write(" Beje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					bw.write(" Veje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
//				else{
//					log.info("DIA: "+ dia);
//					log.info("AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
//					log.info("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					log.info("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					log.info("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
                dia++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        log.info("con: " + contador);

    }

    private static void testAlgoritmoAlinear() {

//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("5"));
//		p1.setY(new BigDecimal("6"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("2"));
//		p2.setY(new BigDecimal("3"));
//		
//		Punto p3 =  new Punto();
//		p3.setX(new BigDecimal("-2"));
//		p3.setY(new BigDecimal("-1"));


//		Punto a =  new Punto();
//		a.setX(new BigDecimal("-2"));
//		a.setY(new BigDecimal("-1"));
//		
//		Punto b = new Punto();
//		b.setX(new BigDecimal("2"));
//		b.setY(new BigDecimal("3"));
//		
//		Punto c = new Punto();
//		c.setX(new BigDecimal("5"));
//		c.setY(new BigDecimal("6"));

        Punto a = new Punto();
        a.setX(new BigDecimal("-2"));
        a.setY(new BigDecimal("-3"));

        Punto b = new Punto();
        b.setX(new BigDecimal("2"));
        b.setY(new BigDecimal("3"));

        Punto c = new Punto();
        c.setX(new BigDecimal("5"));
        c.setY(new BigDecimal("7.5"));

        Punto p0 = new Punto();
        p0.setX(new BigDecimal("0"));
        p0.setY(new BigDecimal("0"));


        if (MatematicaUtils.estanAlineados(b, c, a)) {
            if (MatematicaUtils.estanAlineados(b, c, p0)) {
                log.info("p1 eje x: " + c.getX().toString() + "  " + "eje y: " + c.getY().toString());
                log.info("p2 eje x: " + b.getX().toString() + "  " + "eje y: " + b.getY().toString());
                log.info("p3 eje x: " + a.getX().toString() + "  " + "eje y: " + a.getY().toString() + "\n");
            }
        }
    }


    private static void getPeridoLLuvia() {
        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Double anguloRad = Math.toRadians(1);
        fAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(3);
        bAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(5);
        vAngulo = new BigDecimal(anguloRad.toString());

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));

        double perimetro = 0;
        double perimetroMax = 0;
        double perimetroMin = 0;
        String FILENAME = "C:\\logs\\peridoLLuviasMAX.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            while (dia <= ultimoDia) {
                Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
                Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
                Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

                double area = Triangulo.getArea(fp, bp, vp);
                if (area > 0) {
                    if (Triangulo.esPuntoInteriorTriangulo(fp, bp, vp, p0)) {
                        perimetro = Triangulo.getPerimetro(fp, bp, vp);
                        if (dia == 1 || perimetroMax < perimetro) {
                            perimetroMax = Triangulo.getPerimetro(fp, bp, vp);
                        }
                        if (dia == 1 || perimetroMin > perimetro) {
                            perimetroMin = Triangulo.getPerimetro(fp, bp, vp);
                        }
                        bw.write("DIA: " + dia);
                        bw.write(" SOL_adentro ");
                        bw.write(" PERIMETRO: " + perimetro);
                        bw.write(" AREA: " + area);
                        bw.write(" Feje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                        bw.write(" Beje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                        bw.write(" Veje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");

                    }
                }
                dia++;
            }

            bw.write("perimetroMax: " + perimetroMax);
            bw.write("perimetroMin " + perimetroMin);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getPeridoSequia() {
        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Double anguloRad = Math.toRadians(1);
        fAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(3);
        bAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(5);
        vAngulo = new BigDecimal(anguloRad.toString());

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));


        String FILENAME = "C:\\logs\\peridoSequias.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            while (dia <= ultimoDia) {
                Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
                Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
                Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

                double area = Triangulo.getArea(fp, bp, vp);
                if (-1 < area && area < 1) {

                    FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

                    BigDecimal yaux = recta.getValorY(p0.getX());
                    if (MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)) {
                        bw.write("DIA: " + dia);
                        bw.write(" AREA: " + area);
                        bw.write(" Feje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                        bw.write(" Beje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                        bw.write(" Veje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
                    }
                }
                dia++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void getPeridoIdeal() {
        long dia = 1;
        long ultimoDia = 365 * 10;


        BigDecimal fRadio = new BigDecimal("500");
        BigDecimal fAngulo = new BigDecimal("1");
        BigDecimal fPeriodo = new BigDecimal("1");

        BigDecimal bRadio = new BigDecimal("2000");
        BigDecimal bAngulo = new BigDecimal("3");
        BigDecimal bPeriodo = new BigDecimal("1");

        BigDecimal vRadio = new BigDecimal("1000");
        BigDecimal vAngulo = new BigDecimal("5");
        BigDecimal vPeriodo = new BigDecimal("1");

        Double anguloRad = Math.toRadians(1);
        fAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(3);
        bAngulo = new BigDecimal(anguloRad.toString());
        anguloRad = Math.toRadians(5);
        vAngulo = new BigDecimal(anguloRad.toString());

        Punto p0 = new Punto();
        p0.setX(new BigDecimal(0));
        p0.setY(new BigDecimal(0));


        String FILENAME = "C:\\logs\\peridoIdeal.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            while (dia <= ultimoDia) {
                Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
                Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
                Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));

                double area = Triangulo.getArea(fp, bp, vp);
                if (-1 < area && area < 1) {

                    FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

                    BigDecimal yaux = recta.getValorY(p0.getX());
                    if (!MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)) {
                        bw.write("DIA: " + dia);
                        bw.write(" AREA: " + area);
                        bw.write(" Feje x: " + fp.getX().toString() + "  " + "eje y: " + fp.getY().toString());
                        bw.write(" Beje x: " + bp.getX().toString() + "  " + "eje y: " + bp.getY().toString());
                        bw.write(" Veje x: " + vp.getX().toString() + "  " + "eje y: " + vp.getY().toString() + "\n");
                    }
                }
                dia++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
