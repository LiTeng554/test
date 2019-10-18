package cn.com.lt992.love.collection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * 导入txt数据
 *      默认一条数据对象仅占用一行，每个数据属性之间用“|+|”分隔，行末尾用“|+|”结尾
 *      例如：
 *          张三|+|18岁|+|2020-10-12|+|中国|+|
 *          李四|+|20岁|+|2020-08-09|+|中国|+|
 */
public class importTxtDataCollection {

    /**
     *
     * @param url--文件路径
     * @param charName--文件编码
     */
    public void doExcute(String url,String charName){
        try {
            String str;
            String array[];
            //读取文件
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url),charName));
            //循环读取数据进行存储
            while ((str = bufferedReader.readLine()) != null) {
                array = str.split("\\|\\+\\|");
                //数据中没有账号，而账号数据又是表主键，因此自动创建一个账号
                String account = generateAccount();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{

        }


    }

    /**
     * 自动生成默认账号
     * @return
     */
    public String generateAccount(){
        int machineId = 1;  //默认1开头
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        return machineId + String.format("%011d", hashCodeV);
    }

    public String generatePassword(){

    }
}
