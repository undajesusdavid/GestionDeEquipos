package com.undabits.persistence.adapters.mysql;

import com.undabits.persistence.adapters.IAdapter;
import com.undabits.persistence.engines.mysql.builders.*;
import com.undabits.persistence.engines.mysql.QueryProcessing;
import com.undabits.persistence.result_structuring.QueryResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MysqlAdapter implements IAdapter {
    private QueryProcessing mysql;
    public MysqlAdapter(Map<String,String> params) {
        this.mysql = new QueryProcessing(params);
    }
    @Override
    public QueryResult insert(String table, Map<String, Object> data) {
        QueryBuilder queryInsert = new InsertBuilder(table,data);
        return this.mysql.insert(queryInsert.getQueryString());
    }

    @Override
    public QueryResult multipleInsert(String table, List<Map<String,Object>> dataList) {
        QueryBuilder queryMultInsert = new InsertBuilder(table,dataList);
        return this.mysql.insert(queryMultInsert.getQueryString());
    }

    @Override
    public QueryResult getAll(String table) {
        SelectBuilder queryBuilder = new SelectBuilder(table);
        return this.mysql.select(queryBuilder.getQueryString());
    }
    @Override
    public QueryResult update(String table, String id, Map<String, Object> data) {
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        QueryBuilder queryUpdate = new UpdateBuilder(table,data,conditions);
        return this.mysql.update(queryUpdate.getQueryString());
    }
    @Override
    public QueryResult delete(String table, String id) {
        Map<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        QueryBuilder queryDelete = new DeleteBuilder(table,conditions);
        return this.mysql.delete(queryDelete.getQueryString());
    }
    @Override
    public QueryResult getOne(String table, String id) {
        HashMap<String,Object> conditions = new HashMap<>();
        conditions.put("id",id);
        QueryBuilder querySelect = new SelectBuilder(table,conditions);
        return this.mysql.select(querySelect.getQueryString());
    }

}
