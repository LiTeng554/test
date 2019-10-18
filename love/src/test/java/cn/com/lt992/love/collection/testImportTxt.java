package cn.com.lt992.love.collection;

public class testImportTxt  {

    /**
     * 这个方法暂时废弃。 因为不是很合理， 等后续调整好文件格式再改造这个方法
     * @throws Exception
     */
    public void importTxt() throws Exception {

        System.out.printf("13");
/*

        String url = "C:\\Users\\Public\\Desktop\\新建文本文档.txt";
        String charName = "GBK";
        String str;
        StringBuffer stringBuffer = new StringBuffer();

        //读取文件
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url),charName));
        //循环取出数据
        while ((str = bufferedReader.readLine()) != null){
            stringBuffer.append(str);
        }

        //一级拆分--根据 “ // ” 拆分出每一个人
        String person[] = stringBuffer.toString().split("////");
        //二级拆分--根据 “ * ” 拆分出每一条信息
        for(int i=0;i<person.length;i++){
            Map<String ,String> map = new HashMap<>();
            String strings[] = person[i].split("\\*");
            for(int j=0;j<strings.length;j++){
                //三级拆分--根据 “ ： ” 拆分出每一条信息头和信息内容
                String s[] = strings[j].split(":");
                map.put(s[0],s[1]);
            }
        }
*/

    }
}
