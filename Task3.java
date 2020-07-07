import java.awt.*;

public class Task3 {

    public static void main(String[] args) {

        int red = 193;
        int green = 255;
        int blue = 183;
        float[] hsl = new float[3];

        float hue = Color.RGBtoHSB(red, green, blue, hsl)[0];
        float saturation = Color.RGBtoHSB(red, green, blue, hsl)[1]*100;
        float brightness = Color.RGBtoHSB(red, green, blue, hsl)[2]*100;

        System.out.println("Hue: "+ hue +"\n"+"Saturation: "+ saturation+"\n"+"Brightness: "+ brightness);


    }


}
