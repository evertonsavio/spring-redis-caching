package dev.evertonsavio.redisspring.fib.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    //have a strategy for cache evict
    @Cacheable(value = "math:fib", key = "#index")
    public int getFib(int index, String name){
        System.out.println("Calculating fib for " + index + " .Name: " + name);
        return this.fib(index);
    }

    //PUT POST PATCH DELETE TO EVICT
    @CacheEvict(value = "math:fib", key = "#index")
    public void clearCache(int index){
        System.out.println("clearing hash key: " + index);
    }

    @Scheduled(fixedRate = 10_000)
    @CacheEvict(value = "math:fib", allEntries = true)
    public void clearCache(){
        System.out.println("clearing all fib keys");
    }

    private int fib(int index){
        if(index < 2){
            return index;
        }
        return fib(index - 1) + fib(index -2);
    }

}
