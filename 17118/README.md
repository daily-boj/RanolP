# 17118 갓 소수



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/17118">
        <img src="https://static.solved.ac/tier_small/21.svg" height="16px"/>
        Diamond V, 17118 갓 소수
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석



<a href="https://twitter.com/PSing_Pirim/status/1227445455887458304">

> <table><tr><td><img src="https://pbs.twimg.com/profile_images/1227442623327150080/QYE5fpZ2_normal.png" alt="PSing_Pirim"></td><td><b>PS하는 피림이</b><br>@PSing_Pirim</td></tr></table>
> 
> 구데기 문제를 접한 피림이
>
> ![Image](https://pbs.twimg.com/media/EQjDISIXUAMZg6o?format=png&name=small)

</a>



## 풀이

이 문제의 구데기성은 크게 두 부분으로 나눌 수 있습니다.

### p 구하기

예제를 통해 p를 역산해 구할 수 있다고 합니다. 하지만 저는 굳이 그러고 싶지 않습니다.
키파한테 물어보고 p가 몇인지 알아냈습니다.
직접 구하고 싶다면 [구데기컵 에디토리얼](https://github.com/jh05013/ghudegy_cup/blob/master/2nd-editorial.md#-%EA%B0%93-%EC%86%8C%EC%88%98)을 참고하세요.

### -2초



<a href="https://twitter.com/PSing_Pirim/status/1229983360555999232">

> <table><tr><td><img src="https://pbs.twimg.com/profile_images/1227442623327150080/QYE5fpZ2_normal.png" alt="PSing_Pirim"></td><td><b>PS하는 피림이</b><br>@PSing_Pirim</td></tr></table>
> 
> 17118번 문제의 말도 안 되는 구데기성에 기겁하는 피림이
>
> ![Image](https://pbs.twimg.com/media/ERHHV6ZUUAI9wpP?format=png&name=small)

</a>



네! -2초입니다! 놀랍다!
백준에서 Ruby 2.7이나 C# 6.0, F# 등의 언어는 시간 제한 배수가 없고 추가만 5초인 언어입니다.
이런 언어를 통해 풀어야만 -2초의 벽을 극복할 수 있습니다.

### 드디어 풀 수 있다

문제의 정의대로 LCG를 구할 수도 있겠지만 그래야 할까요?
저는 저걸 <img src="https://latex.codecogs.com/svg.latex?O(1)" alt="O(1)" style="max-width:100%;" >로 구하고 싶었습니다.
<img src="https://latex.codecogs.com/svg.latex?x_k%20%3D%20ax_%7Bk-1%7D%20%2B%20b" alt="x_k = ax_{k-1} + b" style="max-width:100%;" >를 적절히 전개하면 다음과 같은 식을 얻을 수 있습니다.

<img src="https://latex.codecogs.com/svg.latex?x_k%20%3D%20a%5Ekx_0%20%2B%20b%20%5Csum%5Climits_%7Bi%20%3D%200%7D%5E%7Bk%20-%201%7D%7Ba%5Ei%7D%20%5Cbmod%20N" alt="x_k = a^kx_0 + b \sum\limits_{i = 0}^{k - 1}{a^i} \bmod N" style="max-width:100%;" >

여기서, 우리는 k=N=p임을 알고, x_0=n이므로

<img src="https://latex.codecogs.com/svg.latex?a%5Epn%20%2B%20b%20%5Csum%5Climits_%7Bi%20%3D%200%7D%5E%7Bp%20-%201%7D%7Ba%5Ei%7D%20%5Cbmod%20p" alt="a^pn + b \sum\limits_{i = 0}^{p - 1}{a^i} \bmod p" style="max-width:100%;" >

이고, a, b는 문제에서 주어졌으므로,
<img src="https://latex.codecogs.com/svg.latex?a%5Ep" alt="a^p" style="max-width:100%;" >, <img src="https://latex.codecogs.com/svg.latex?b%20%5Csum%5Climits_%7Bi%20%3D%200%7D%5E%7Bp%20-%201%7D%7Ba%5Ei%7D%20%5Cbmod%20p" alt="b \sum\limits_{i = 0}^{p - 1}{a^i} \bmod p" style="max-width:100%;" >를 [미리](https://www.wolframalpha.com/) [구할 수](evaluate_sigma.py) 있습니다.

그렇게 구한 값을 하드코딩하면 <img src="https://latex.codecogs.com/svg.latex?O(1)" alt="O(1)" style="max-width:100%;" >! 최고다!



<a href="https://twitter.com/PSing_Pirim/status/1229231091837358085">

> <table><tr><td><img src="https://pbs.twimg.com/profile_images/1227442623327150080/QYE5fpZ2_normal.png" alt="PSing_Pirim"></td><td><b>PS하는 피림이</b><br>@PSing_Pirim</td></tr></table>
> 
> 문제를 풀어서 세상 행복한 피림이
>
> ![Image](https://pbs.twimg.com/media/EQ8bKOLUUAA0XV0?format=png&name=small)

</a>


