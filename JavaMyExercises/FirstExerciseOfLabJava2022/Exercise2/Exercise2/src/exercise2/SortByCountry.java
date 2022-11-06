
package exercise2;

import java.util.*;

public class SortByCountry implements Comparator <Team>{
    @Override
    public int compare(Team a,Team b){
        return a.getCountry().compareTo(b.getCountry());
    }
}
