# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

2진수를 8진수로 바꾸는 간단한 문제입니다.

## 풀이

2<sup>1000000</sup>은 상당히 큽니다.
Python에선 잘 다룰 수 있지만 다른 언어에서는 새로운 접근 방법이 필요합니다.
팔진수 한 자리는 이진수 네 자리와 동치로 나타내집니다.
이진수를 네 자리 묶음으로 나타내 묶음별로 변환을 진행하면 됩니다.