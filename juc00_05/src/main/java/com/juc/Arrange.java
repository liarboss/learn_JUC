package com.juc;

import java.util.*;
/**
 * 对给定数组元素(无重复)进行排列
 *
 * @author ansel
 *
 * @date 2020/5/26 1:23 PM
 */
public class Arrange {
    public static void main(String[] args) {
        String[] array = new String[] {"我", "爱", "编", "码"};
        List arrayList = Arrays.asList(array);
        Set<String> resultSet = new HashSet<>();
        getCombination(arrayList, resultSet);
        System.out.println("组合数 = " + resultSet.size());
        System.out.println("所有组合 : " + resultSet);
        Set<String> arrayCombResult = new HashSet<>();
        Iterator<String> iterator = resultSet.iterator();
        while (iterator.hasNext()){
            List arrList = Arrays.asList(iterator.next().split(","));
            getArrange(arrList, arrList.size(), arrayCombResult, null);
        }
        System.out.println("排列数 = " + arrayCombResult.size());
        System.out.println("所有排列 : " + arrayCombResult);
    }
    /**
     * 循环递归获取给定数组元素(无重复)的全排列
     *
     * @param oriList 原始数组
     * @param oriLen 原始数组size
     * @param arrayCombResult 数组排列结果集，可传null或空Set
     * @param preList 记录排列参数，可传null或空List
     * @return 排列结果
     */
    public static Set<String> getArrange(List oriList, int oriLen, Set<String> arrayCombResult, List preList){
        if (oriList == null){
            return arrayCombResult;
        }
        if (arrayCombResult == null){
            arrayCombResult = new HashSet<>();
        }
        if (preList == null){
            preList = new ArrayList();
        }
        for (int i = 0; i < oriList.size(); i++){
            while(preList.size() > 0 && oriList.size() + preList.size() > oriLen){
                preList.remove(preList.size() - 1);
            }
            List arrList = new ArrayList(oriList);
            preList.add(arrList.get(i));
            arrList.remove(i);
            if (arrList.isEmpty()){
                arrayCombResult.add(getStrFromList(preList));
            }else {
                getArrange(arrList, oriLen, arrayCombResult, preList);
            }
        }
        return arrayCombResult;
    }
    /**
     * 循环递归获取给定数组元素(无重复)的所有组合
     *
     * @param oriList 原始数组
     * @param resultSet 元素组合结果，可传null或空set
     * @return 组合结果
     */
    public static Set<String> getCombination(List oriList, Set<String> resultSet) {
        if (oriList == null) {
            return resultSet;
        }
        if (resultSet == null){
            resultSet = new HashSet<>();
        }
        for (int i = 0; i < oriList.size(); i++) {
            List copyList = new ArrayList(oriList);
            resultSet.add(getStrFromList(copyList));
            List removeIList = new ArrayList();
            copyList.remove(i);
            removeIList.addAll(copyList);
            getCombination(removeIList, resultSet);
        }
        return resultSet;
    }
    /**
     * 将数组元素转化为逗号分隔的字符串
     *
     * @param oriList 原始数组
     * @return 字符串
     */
    public static String getStrFromList(List oriList){
        StringBuffer result = new StringBuffer();
        if (oriList == null){
            return result.toString();
        } else {
            for (int i = 0; i < oriList.size(); i++){
                result.append(oriList.get(i));
                if (i != (oriList.size() - 1)){
                    result.append(",");
                }
            }
        }
        return result.toString();
    }
}
