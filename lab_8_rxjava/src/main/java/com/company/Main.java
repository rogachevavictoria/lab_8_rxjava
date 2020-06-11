package com.company;

import rx.Observable;
import rx.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args)	{

        List<Integer> simpList = new ArrayList<Integer>();
        for (int j = 0; j<100;j++){if(checkSimple(j)) simpList.add(j); }
        Observable myObs = Observable.from(simpList);
        Subscriber mySub = new Subscriber() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {}

            @Override
            public void onNext(Object o) {
                System.out.print(o + " ");
            }
        };
        System.out.print("Prime numbers: ");
        myObs.subscribe(mySub);

        int n1=0,n2=1,n3,i,count=20;
        List<Integer> fibList = new ArrayList<Integer>();
        fibList.add(n1);  fibList.add(n2);
        for(i=2;i<count;++i)
        {
            n3=n1+n2;
            fibList.add(n3);
            n1=n2;
            n2=n3;
        }
        Observable myObs2 = Observable.from(fibList);
        Subscriber mySub2 = new Subscriber() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {}

            @Override
            public void onNext(Object o) {
                System.out.print(o + " ");
            }
        };
        System.out.println();
        System.out.print("Fibonacci numbers: ");
        myObs2.subscribe(mySub2);

    }
    public static boolean checkSimple(int i){
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }
}

