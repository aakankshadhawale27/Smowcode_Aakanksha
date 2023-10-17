import java.util.Scanner;
public class que2 {  
    public static int puzzle(int H, int U, int S){
        int diff = U - S;
        int hr = (H-U)/diff;
        return hr+1;
    }
        public static void main(String[] args) {  
            Scanner sc = new Scanner(System.in);
            int H = sc.nextInt();
            int U = sc.nextInt();
            int S = sc.nextInt();
            int ans = puzzle(H, U, S); 
            System.out.println(ans);
            sc.close();
        }  
    }  
