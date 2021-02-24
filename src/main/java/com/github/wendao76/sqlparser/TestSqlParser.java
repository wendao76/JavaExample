package com.github.wendao76.sqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.StringReader;
import java.util.*;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className TestSqlParser
 * @date 2021-2-24 16:42
 */
public class TestSqlParser {
    public static void main(String[] args) throws JSQLParserException {
        Map<String, Object> permitMap = new HashMap<>(4);
        permitMap.put("org_id", "org_id_111");
        permitMap.put("zone_code", "ZZZZZZ");

        String sql =
                "SELECT a.*, b.name as hospital, c.name as dept, d.title as academic_title\n"
                        + "FROM doctor AS a\n"
                        + "LEFT OUTER JOIN hospital as b ON a.hospital_id=b.id\n"
                        + "LEFT OUTER JOIN dept as c ON a.dept_id=c.id\n"
                        + "LEFT OUTER JOIN academic_title as d ON a.academic_id=d.id\n"
                        + "WHERE (a.is_del=0)\n"
                        + "ORDER BY a.create_time DESC LIMIT ?,?";

        listALlTable(sql);
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(sql));
        PlainSelect plain = (PlainSelect) select.getSelectBody();
        Table tab = (Table) plain.getFromItem();
        String alias = tab.getAlias().getName();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Object> kv : permitMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(" AND ");
            }
            sb.append(alias).append(".").append(kv.getKey()).append("=").append(kv.getValue());
        }
        Expression where = CCJSqlParserUtil.parseCondExpression(sb.toString() + " AND " + plain.getWhere().toString());
        plain.setWhere(where);
        plain.getWhere().accept(new WhereVisitorAdapter());


        System.out.println(select.toString());

        StringBuilder sb2 = new StringBuilder();
        List<Expression> expressionList = new ArrayList<>();
        for (Map.Entry<String, Object> kv : permitMap.entrySet()) {
            AndExpression andExpression = new AndExpression(new Column(kv.getKey()), new StringValue(kv.getValue().toString()));
            expressionList.add(andExpression);
            sb2.append(andExpression);
        }
        plain.setWhere(CCJSqlParserUtil.parseCondExpression(sb2.toString()));

        System.out.println(select);
    }


    static List<String> listALlTable(String sql) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(sql);
        Select selectStatement = (Select) statement;
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List tableList = tablesNamesFinder.getTableList(selectStatement);
        for (Iterator iter = tableList.iterator(); iter.hasNext(); ) {
            String tableName = (String) iter.next();
            System.out.println(tableName);
        }
        return tableList;
    }
}
