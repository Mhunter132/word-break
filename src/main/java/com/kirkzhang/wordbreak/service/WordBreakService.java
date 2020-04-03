package com.kirkzhang.wordbreak.service;

import java.util.List;

public interface WordBreakService {


    String getDefaultDict(String word);

    String getUserDict(String word);

    String getUserAndDefault(String word);

}
