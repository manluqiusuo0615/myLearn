#数据结构课堂笔记
##计算
###第一节 
Computer science should be called Computing science,
for the same reason why surgery is not called knife science.
###第二节 绳索计算机及其算法  
输入：任给直线l及其上一点A
输出：经过A做l的一条垂线
算法：取12段等长的绳索，首尾连接成环，从A点起，
将4段绳索沿l伸直并固定于B，沿着另一个方向找到第
3段绳索的终点c,移动点c，将剩余的3+5段绳索拉直。
![Image text]( https://github.com/manluqiusuo0615/myLearn/blob/master/src/img/ssjsj.png)
其实就是勾三股四玄五原理
###第三节 尺规计算机  
输入：任给平面上线段AB
输出：将其三等分
算法：从A发出一条与AB不重合的射线P
在p上取AC=CD=DE，连接EB,
经过D做EB平行线，交于AB与F
经过C做EB平行线，交于AB与G
![Image text]( https://github.com/manluqiusuo0615/myLearn/blob/master/src/img/cgjs.png)
其实就是平行等比原理
###第四节 算法  
计算=信息处理
借助某种工具，遵循一定规则，以明确而机械的形式进行
计算模型=计算机=信息处理工具
所谓算法，即特定计算模型下，旨在解决特定问题的指令序列   
 输入    待处理的信息（问题）  
 输出    经处理的信息（答案）  
正确性   的确可以解决指定的问题  
确定性   任一算法都可以描述为一个由基本操作组成的序列  
可行性   每一基本操作都可实现，且在常数时间内完成  
有穷性   对于任何输入，经有穷次基本操作，都可以得到输出  
###第五节 有穷性  
序列Hailstone(n) = {1}                  n<=1  
序列Hailstone(n) = {n}UHailstone(n/2)   n偶  
序列Hailstone(n) = {n}UHailstone(3n+2)  n奇  
