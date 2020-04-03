package com.kirkzhang.wordbreak.service.serviceimpl;

import com.kirkzhang.wordbreak.service.WordBreakService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 * @ClassName WordBreakImpl
 * @Desciption word-cut service
 * @Author 2020/4/3 12:53
 * @Version 1.0
 * */


@Service
public class WordBreakImpl implements WordBreakService {

    @Resource(name = "defaultDict")
    private List<String> defaultDict ;

    @Resource(name = "userDict")
    private List<String> userDict ;


    @Override
    public String getDefaultDict(String word) {

        return  wordBreak(word, defaultDict);

    }

    @Override
    public String getUserDict(String word) {

        return wordBreak(word,userDict);
    }

    @Override
    public String getUserAndDefault(String word) {

        List<String> userAndLocalDict= new ArrayList<String>();
        userAndLocalDict.addAll(defaultDict);
        userAndLocalDict.addAll(userDict);
        List<String> finalDict =userAndLocalDict.parallelStream().distinct().collect(Collectors.toList());

        return wordBreak(word,finalDict);

    }


    private String wordBreak(String word, List<String> defaultDict) {

//        StringBuilder sb=new StringBuilder();
//        int begin=0,end;
//        int reviewStringLength =word.length();
//        while(begin<reviewStringLength){
//            end=begin+reviewStringLength;
//            if(end>reviewStringLength) end=reviewStringLength;
//            //不匹配则指针前移
//            while(begin<end&&!defaultDict.contains(word.substring(begin,end))){
//                end--;
//            }
//            //一个字
//            if(begin==end)end++;
//            sb.append(word.substring(begin,end)+"  ");
//            begin=end;
//        }

//        return sb.toString();

        StringBuilder sb=new StringBuilder();
        int right=word.length();
        int maxLen=word.length();
        int left;
        while(right>0){
            left=right-maxLen;
            if(left<0)left=0;
            //不匹配则指针后移
            while(right>left&&!defaultDict.contains(word.substring(left,right))){
                left++;
            }
            //一个字
            if(right==left)left--;
            sb.insert(0,word.substring(left,right)+"  ");
            right=left;
        }
        return sb.toString();
    }

}
