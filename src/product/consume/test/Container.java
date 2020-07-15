package product.consume.test;

import java.util.List;

/**
 * @author : lb
 * @date : 2020/7/15 18:15
 * @description :
 */
public class Container {

    List<Integer> container;

    Integer max_num;

    Container(List<Integer> container, Integer max_num){
        this.container = container;
        this.max_num = max_num;
    }
}
