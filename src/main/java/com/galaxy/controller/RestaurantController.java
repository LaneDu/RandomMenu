package com.galaxy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.galaxy.model.Menu;
import com.galaxy.model.Restaurant;
import com.galaxy.model.TodayMenu;
import com.galaxy.service.MenuService;
import com.galaxy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lane
 * @date 2022年03月05日 下午12:41
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private MenuService menuService;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * /restaurant/selectList
     * @author lane
     * @date 2022/3/5 下午3:37
     * @return java.lang.String
     */

    @RequestMapping(value = "/selectList",method = {RequestMethod.GET})
    @ResponseBody
    public JSONObject selectList2(){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectData = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("msg","success");
        List<Restaurant> restaurants = restaurantService.selectList();
        JSONArray items= JSONArray.parseArray(JSON.toJSONString(restaurants));
        jsonObjectData.put("items", items);
        jsonObjectData.put("total",restaurants.size());
        jsonObject.put("data",jsonObjectData);

        return jsonObject;

    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Restaurant insert( @RequestBody Restaurant restaurant){

        restaurantService.insert(restaurant);

        return restaurant ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Restaurant update (@RequestBody  Restaurant restaurant){

        restaurantService.updateById(restaurant);
        return restaurant ;
    }



    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Restaurant delete (@RequestBody Restaurant restaurant){

        restaurantService.delete(restaurant);
        return restaurant ;
    }


    @RequestMapping(value = "/random",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Menu update (@RequestBody TodayMenu todayMenu ){
        System.out.println( "点菜时间："+simpleDateFormat.format(new Date()));
        Integer meatNum = todayMenu.getMeatNum();
        Integer vegetableNum = todayMenu.getVegetableNum();
        Integer eggNum = todayMenu.getEggNum();
        Integer soupNum = todayMenu.getSoupNum();
        Integer maxTotalPrice = todayMenu.getMaxPrice();
        Integer personNum = todayMenu.getPersonNum();
        List<Menu> menus = menuService.selectListByRid(todayMenu.getId());
        //总的里面菜类
        List<Menu> meatMenus =new ArrayList<>();
        List<Menu> eggMenus =new ArrayList<>();
        List<Menu> vegetableMenus =new ArrayList<>();
        List<Menu> soupMenus =new ArrayList<>();
        //随机菜单里面的
        List<Menu> meatMenus1 =new ArrayList<>();
        List<Menu> eggMenus1 =new ArrayList<>();
        List<Menu> vegetableMenus1 =new ArrayList<>();
        List<Menu> soupMenus1 =new ArrayList<>();
        for (int i = 0; i < menus.size(); i++) {
            String type = menus.get(i).getType();
            if ("肉".equals(type)){
                meatMenus.add(menus.get(i));
            }else  if("蛋".equals(type)){
                eggMenus.add(menus.get(i));

            }else  if("素".equals(type)){
                vegetableMenus.add(menus.get(i));

            }else  if("汤".equals(type)){
                soupMenus.add(menus.get(i));

            }
        }
        List<Menu> menus0 = new ArrayList<>();
        List<Menu> menus1 = new ArrayList<>();

        if (meatNum!=null&&meatNum!=0&&meatMenus.size()>0){
            meatMenus1 = randomList(meatMenus, meatNum);
             menus0.addAll(meatMenus1);
        }
        if (eggNum!=null&&eggNum!=0&&eggMenus.size()>0){
            eggMenus1 = randomList(eggMenus, eggNum);
            menus0.addAll(eggMenus1);
        }
        if (vegetableNum!=null&&vegetableNum!=0&&vegetableMenus.size()>0){
            vegetableMenus1 = randomList(vegetableMenus, vegetableNum);
            menus0.addAll(vegetableMenus1);
        }
        if (soupNum!=null&&soupNum!=0&&soupMenus.size()>0){
            soupMenus1 = randomList(soupMenus, soupNum);
            menus0.addAll(soupMenus1);
        }
        Double maxPriceOne = 0d;
        Double totalPrice = 0d;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <menus0.size() ;i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(menus0.get(i).getName());
            totalPrice = this.add(totalPrice,menus0.get(i).getPrice());
            sb.append("\n");
        }
        String todayMenu1 = sb.toString();
        //当总价格超过上限
        if (maxTotalPrice!=null && totalPrice>maxTotalPrice&&menus0.size()>0) {
            int j=1;
            Random random = new Random();
            while (maxTotalPrice != null && totalPrice > maxTotalPrice) {

                List<Menu> menusRemain =  new ArrayList<>();
                //降序
                menus0.sort(Comparator.reverseOrder());
                Menu menu = menus0.get(0);
                System.out.println("第"+j+++"轮循环后菜价格为："+totalPrice+"" +
                        "移除的菜为："+menu);
                Menu menu1 = null;
                String type = menu.getType();
                if ("肉".equals(type)) {
                    menusRemain = listrem(meatMenus, meatMenus1);
                    menusRemain.add(menu);

                    //升序
                    menusRemain.sort(Comparator.naturalOrder());
                    //降序
//                  menusRemain.sort(Comparator.reverseOrder());
                    int i = menusRemain.indexOf(menu);
                    if (i>0){
                        menu1 = menusRemain.get(random.nextInt( i));
                        //已经选过的
                        meatMenus1.add(menu1);
                    }

                } else if ("蛋".equals(type)) {
                    menusRemain = listrem(eggMenus, eggMenus1);

                    menusRemain.add(menu);
                    //升序
                    menusRemain.sort(Comparator.naturalOrder());
                    //降序
//                  menusRemain.sort(Comparator.reverseOrder());
                    int i = menusRemain.indexOf(menu);

                    //随机选择价格低的一个
                    if (i>0){
                        menu1 = menusRemain.get(random.nextInt(i));
                        //已经选过的
                        eggMenus1.add(menu1);
                    }


                } else if ("素".equals(type)) {
                    menusRemain = listrem(vegetableMenus, vegetableMenus1);

                    menusRemain.add(menu);
                    //升序
                    menusRemain.sort(Comparator.naturalOrder());
                    //降序
//                  menusRemain.sort(Comparator.reverseOrder());
                    int i = menusRemain.indexOf(menu);

                    //随机选择价格低的一个
                    if (i>0){
                        menu1 = menusRemain.get(random.nextInt(i));
                        //已经选过的
                        vegetableMenus1.add(menu1);
                    }

                } else if ("汤".equals(type)) {
                    menusRemain = listrem(soupMenus, soupMenus1);

                    menusRemain.add(menu);
                    //升序
                    menusRemain.sort(Comparator.naturalOrder());
                    //降序
//                  menusRemain.sort(Comparator.reverseOrder());
                    int i = menusRemain.indexOf(menu);

                    //随机选择价格低的一个
                    if (i>0){
                        menu1 = menusRemain.get(random.nextInt(i));
                        //已经选过的
                        soupMenus1.add(menu1);
                    }
                }
                if (menu1==null){
                    totalPrice =this.subDouble(totalPrice,menu.getPrice());
                    //移除旧的，添加新的
                    menus0.remove(menu);
                }else {
                    //移除旧的，添加新的
                    menus0.remove(menu);
                    menus0.add(menu1);
                    totalPrice =this.subDouble(totalPrice,menu.getPrice());
                    totalPrice =this.add(totalPrice,menu1.getPrice());

                }

            }
            //重新更新菜单
            StringBuffer sb2 = new StringBuffer();
            for (int i = 0; i <menus0.size() ;i++) {
                sb2.append(i+1);
                sb2.append(". ");
                sb2.append(menus0.get(i).getName());
//                totalPrice = this.add(totalPrice,menus0.get(i).getPrice());
                sb2.append("\n");
            }
            todayMenu1 = sb2.toString();
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(todayMenu.getId());
        restaurant.setMenu(todayMenu1);
        if (personNum!=null&&personNum!=0){
            restaurant.setAveragePrice(div(totalPrice,personNum,2));
            restaurant.setPersonNum(Long.valueOf(personNum));
        }
        restaurant.setTotalPrice(totalPrice);
        restaurantService.updateTodayMenu(restaurant);
        return new Menu() ;
    }

    public List<Menu> randomList(List<Menu> list,Integer num){
        List<Menu> list1 = new ArrayList<>();
        list1.addAll(list);
        Random random = new Random();
        //若对象size大于6，则随机去除6个对象，并按照原来的顺序排列
        while(list1!=null&&list1.size() > num&&list1.size()>0) {
            //随机取一个对象
            Menu target = list1.get(random.nextInt(list1.size()));
            for(Menu object : list1) {
                if(object.getId() == target.getId()) {
                    //将取出的那个对象删除
                    list1.remove(target);
                    break;
                }
            }
        }
        return list1;
    }

    /**
     * 求和
     * @author lane
     * @date 2022/3/6 下午5:28
     * @param value1
     * @param value2 Please change caller according to com.intellij.openapi.project.IndexNotReadyException documentation
     */

        public  Double add(Double value1, Double value2) {
        if (value1==null){value1=0d;}
        if (value2==null){value2=0d;}
        BigDecimal b1 = new BigDecimal(Double.toString(value1));

        BigDecimal b2 = new BigDecimal(Double.toString(value2));

        return b1.add(b2).doubleValue();

    }
    /**
     * 减法运算
     * @param m1
     * @param m2
     * @return
     */
    public  double subDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

    /**
     *
     *   除法运算
     *   @param   m1
     *   @param   m2
     *   @param   scale
     *   @return
     */
    public double div(double m1, double m2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public Menu maxPriceMenu(List<Menu> list){

        list.sort(Comparator.reverseOrder());

        return list.get(0);
    }

    /***　
     * 这是目前我了解到速度最快的一种*
      * @author lane
      * @date 2022/3/6 下午6:01
      * @param
      * @return null
      */
    @SuppressWarnings("unchecked")
    public  List<Menu> listrem(List<Menu> listA,List<Menu> listB){
        HashSet hs1 = new HashSet(listA);
        HashSet hs2 = new HashSet(listB);
        hs1.removeAll(hs2);
        List<Menu> listC = new ArrayList<Menu>();
        listC.addAll(hs1);
        return listC;
    }



}
