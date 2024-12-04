

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/file");
        int count = 0;
        boolean inc=false;
        boolean dec=false;
        int total=0;
        for(int i = 0; i<fileData.size();i++){
            int e =0;
            ArrayList<String>temp = fileData;
            while(e<temp.get(i).length()){
                if(temp.get(i).contains(" ")){
                    nums.add(Integer.parseInt(fileData.get(i).substring(e,temp.get(i).indexOf(" "))));
                    temp.set(i,temp.get(i).substring(temp.get(i).indexOf(" ")+1));
                }else{
                    nums.add(Integer.parseInt(temp.get(i)));
                    e=Integer.MAX_VALUE;
                }
            }
            System.out.println(nums);
            int times1=0;
            int times2=0;
            if(nums.get(0)-nums.get(1)<0){
                inc=true;
            }else{
                dec=true;
            }
            for(int h=0; h<nums.size()-1;h++){
                if(Math.abs(nums.get(h+1)-nums.get(h))<4 && Math.abs(nums.get(h+1)-nums.get(h))>0 ){
                    count++;
                }
                if(nums.get(h)-nums.get(h+1)<0 && dec){
                    times1++;
                }else if(nums.get(h)-nums.get(h+1)>0 && inc){
                    times2++;
                }
                if(times2>1) {
                    inc = false;
                }
                if(times1>1) {
                    dec = false;
                }
            }
            if(count == nums.size()-1 && (inc||dec)){
                total++;
            }
            count=0;
            inc=false;
            dec=false;
            nums=new ArrayList<>();
        }
        System.out.println(total);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

