package com.ctl.simple.service.impl;

import com.ctl.simple.mapper.WordMapper;
import com.ctl.simple.model.Word;
import com.ctl.simple.model.WordExample;
import com.ctl.simple.service.SimpleService;
import com.ctl.simple.util.RandomStudent;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ctl
 */
@Log4j2
@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    private WordMapper wordMapper;

    @Override
    public List<Word> get(String text) {
        WordExample wordExample = new WordExample();
        wordExample.createCriteria().andTextEqualTo(text);
        return wordMapper.selectByExample(wordExample);
    }

    @Override
    public void add(int count) {
        for (int i = 1; i <= count; i++) {
            Word word = new Word();
            word.setAuthor(RandomStudent.getName());
            word.setDescription(RandomStudent.getDesire());
            word.setGroupBy(RandomStudent.getQq());
            word.setType(RandomStudent.getKnowFrom());
            word.setText(RandomStudent.getSchool());
            log.info("i:" + i);
            wordMapper.insert(word);
        }

    }
}