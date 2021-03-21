// 2021 3 21

/*
    겹치는 시간 찾기 문제

    ex)
    Input 
    3
    12:00 ~ 15:23
    14:00 ~ 17:00
    05:00 ~ 23:59
    
    Output
    stTime:14:00, edTime:15:23
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        SimpleDateFormat dateForm = new SimpleDateFormat("HH:mm");

        int size = Integer.parseInt(input);
        Date arr[][] = new Date[size][2];
        String array[] = new String[0];
        for (int i = 0; i < size; i++) {
            input = br.readLine();
            array = input.split(" ~ ");
            arr[i][0] = dateForm.parse(array[0]);
            arr[i][1] = dateForm.parse(array[1]);
        }

        String stTime = "";
        String edTime = "";
        Arrays.sort(arr, (o1, o2)->{
            if(o1[0].compareTo(o2[0])>0){
                return 1;
            }
            else {
                return -1;
            }
        });
        stTime = dateForm.format(arr[size-1][0]);


        Arrays.sort(arr, (o1, o2)->{
            if(o1[1].compareTo(o2[1])>0){
                return 1;
            }
            else {
                return -1;
            }
        });
        edTime = dateForm.format(arr[0][1]);

        if(arr[size-1][0].getTime() > arr[0][1].getTime()){
            System.out.println("-1");
        }
        else {
            System.out.println("stTime:"+stTime+", edTime:"+edTime);
        }
    }
}
