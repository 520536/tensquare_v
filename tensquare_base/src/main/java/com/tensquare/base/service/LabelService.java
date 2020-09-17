package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public void save(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }


    public List<Label> findAll(String id) {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     *
     * @param label
     */
    public void Update(Label label) {
        labelDao.save(label);
    }


    public void delete(String labelId) {
        labelDao.deleteById(labelId);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {

             /**
             * @param root 根对象，也就是要把条件封装到哪个对象中。where 类名=label.getId
             * @param criteriaQuery 封装的都是查询关键字，比如 group by , order by 等
             * @param cb 用来封装条件对象的，如果直接返回null，表示不需要任何条件
             * @return
             */
             
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder cb) {
                return null;
            }
        });

    }
}
