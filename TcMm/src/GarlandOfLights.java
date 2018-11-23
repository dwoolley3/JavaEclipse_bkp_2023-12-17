import java.io.*;
import java.util.*;

public class GarlandOfLights {
    public int[] create(int H, int W, String[] lights) {
        int[] ret = new int[H*W];
        Arrays.fill(ret, -1);
        boolean[] used = new boolean[H*W];
        
        //    0c 1a 
        // 0d 2b 5b 
        // 5b    3d 1b
        // 5d       5a
        // 3c 4a 4b 2c
        
        ret[ 1] =  7; used[ 7] = true; // 0c
        ret[ 2] =  6; used[ 6] = true; // 1a
        
        ret[ 5] = 14; used[14] = true; // 0d
        ret[ 6] = 24; used[24] = true; // 2b
        ret[ 7] =  0; used[ 0] = true; // 5b
        
        ret[10] = 18; used[18] = true; // 5b
        ret[12] = 17; used[17] = true; // 3d
        ret[13] = 16; used[16] = true; // 1b
        
        ret[15] = 23; used[23] = true; // 5d
        ret[18] =  2; used[ 2] = true; // 5a
        
        ret[20] =  8; used[ 8] = true; // 3c
        ret[21] =  5; used[ 5] = true; // 4a
        ret[22] = 19; used[19] = true; // 4b
        ret[23] = 15; used[15] = true; // 2c
        
        int ind = 0;
        for (int i = 0; i < H*W; ++i) {
            if (used[i])
                continue;
            while (ret[ind] != -1)
                ind++;
            ret[ind] = i;
        }
        return ret;
    }
    // -------8<------- end of solution submitted to the website -------8<-------
    public static void main(String[] args) {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        String[] lights = new String[H*W];
        for (int i = 0; i < H*W; ++i) {
            lights[i] = br.readLine();
        }

        GarlandOfLights gl = new GarlandOfLights();
        int[] ret = gl.create(H, W, lights);

        System.out.println(ret.length);
        for (int i = 0; i < ret.length; ++i) {
            System.out.println(ret[i]);
        }
    }
    catch (Exception e) {}
    }
}
