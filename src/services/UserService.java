package services;

import com.google.gson.Gson;
import vo.User;

import java.io.*;

public class UserService {

    private  String path="D:\\json";

    public  boolean   addDB(User user){
        System.out.println("002");
        File file = new File(path+File.separator+user.getUser()+".json");
        System.out.println(file.getPath());
        if (file.exists()){
            return false;
        }
        Gson gson = new Gson();
        String dbgson = gson.toJson(user);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(dbgson);
            fw.flush();
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }


    public User loginUser(User user){
        File file = new File(path+File.separator+user.getUser()+".json");
        if (!file.exists()){
            return null;
        }

        try {
            Gson gson = new Gson();
            User dbuser = gson.fromJson(new FileReader(file), User.class);
            if (dbuser.getPwd().equals(user.getPwd())){
                return user;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean  jugeUser(String name){
        File file = new File(path+File.separator+name+".json");
        Gson gson = new Gson();
        System.out.println(file.getName());
        try {
            FileReader fr = new FileReader(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file.exists();
    }

}
