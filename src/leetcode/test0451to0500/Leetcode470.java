package leetcode.test0451to0500;

public class Leetcode470 {
	public int rand7() {
        return (int)Math.random() * 7 + 1;
    }
	//随机数，需要保证的是每个数出现的概论是相同的
	public int rand10() {
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if(num <= 40) return 1 + num % 10;
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if(num <= 60) return 1 + num % 10;
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if(num <= 20) return 1 + num % 10;

        }
    }
	
	/*
	 * 如果题目是给你 rand10()rand10()，让你生成 1～71～7 之间的某个数，那非常好办，我们只要不断调用 rand10()rand10() 即可，直到得到我们要的数，但是为什么可以呢？你可能会怀疑这个是不是等概率的，我们来计算一下

如果第一次就 randrand 到 1～71～7 之间的数，那就是直接命中了，概率为 \frac{1}{10} 
10
1

如果第二次命中,那么第一次必定没命中，没命中的概率为 \frac{3}{10} 
10
3
​
  ，再乘命中的概率 \frac{1}{10} 
10
1
​
  ，所以第二次命中的概率是 \frac{1}{10}*\frac{3}{10} 
10
1
 ∗ 
10
3

依次类推，我们求和，可以得到如下结果，可以知道，从 rand10()rand10() 到 rand7()rand7() 它是等概率的

从 rand7() 到 rand10()
现在要从 rand7()rand7() 到 rand10()rand10()，也要求是等概率的，那只要我们把小的数映射到一个大的数就好办了，那首先想到的办法是乘个两倍试一试，每个 rand7()rand7() 它能生成数的范围是 1～71～7，randrand 两次，那么数的范围就变为 2～142～14，哦，你可能发现没有 11 了，想要再减去个 11 来弥补，rand7()\ +\ rand7() - \ 1rand7() + rand7()− 1，其实这样是错误的做法，因为对于数字 55 这种，你有两种组合方式 (2+3\ or\ 3+2)(2+3 or 3+2)，而对于 1414，你只有一种组合方式(7+7)(7+7)，它并不是等概率的，那么简单的加减法不能使用，因为它会使得概率不一致，我们的方法是利用乘法，一般思路如下面这样构建：

\qquad\qquad\qquad\qquad\qquad\qquad\qquad (rand7() - 1)*7+rand7()(rand7()−1)∗7+rand7()

首先 rand7()-1rand7()−1 得到的数的集合为 \left\{ 0,1,2,3,4,5,6 \right\}{0,1,2,3,4,5,6}

再乘 77 后得到的集合 AA 为 \left\{ 0，7，14，21，28，35，42\right\}{0，7，14，21，28，35，42}

后面 rand7()rand7() 得到的集合B为 \left\{ 1,2,3,4,5,6,7\right\}{1,2,3,4,5,6,7}

有人可能会疑惑，你咋不乘 66，乘 55 呢？因为它不是等概率生成，只有乘 77 才能使得结果是等概率生成的，啥意思？我们得到的集合 AA 和集合 BB，利用这两个集合，得到的数的范围是 1～491～49，每个数它显然是等概率出现的，因为这两个事件是独立事件，如果你不懂什么是独立事件，你试着加加看也能体会一点。

\qquad\qquad\qquad\qquad\qquad\qquad\qquad P(AB) = P(A)*P(B)=P(AB)=P(A)∗P(B)=\frac{1}{7}\ *\ \frac{1}{7} 

 
提交发现跑的很慢,我们来想想为什么

这样的一个问题是，我们的函数会得到 1～491～49 之间的数，而我们只想得到 1～101～10 之间的数，这一部分占的比例太少了，简而言之，这样效率太低，太慢，可能要 whilewhile 循环很多次，那么解决思路就是舍弃一部分数，舍弃 41～4941～49，因为是独立事件，我们生成的 1～401～40 之间的数它是等概率的，我们最后完全可以利用 1～401～40 之间的数来得到 1～101～10 之间的数。所以，我们的代码可以改成下面这样

再优化
更进一步，这时候我们舍弃了 99 个数，舍弃的还是有点多，效率还是不高，怎么提高效率呢？那就是舍弃的数最好再少一点！因为这样能让 whilewhile 循环少转几次，那么对于大于 4040 的随机数，别舍弃呀，利用这 99 个数，再利用那个公式操作一下：

\qquad\qquad\qquad\qquad\qquad\qquad\qquad (大于40的随机数 - 40 - 1) * 7 + rand7()(大于40的随机数−40−1)∗7+rand7()

这样我们可以得到 1-631−63 之间的随机数，只要舍弃 33 个即可，那对于这 33 个舍弃的，还可以再来一轮：

\qquad\qquad\qquad\qquad\qquad\qquad\qquad (大于60的随机数 - 60 - 1) * 7 + rand7()(大于60的随机数−60−1)∗7+rand7()

这样我们可以得到 1-211−21 之间的随机数，只要舍弃 11 个即可。
	 */
}
