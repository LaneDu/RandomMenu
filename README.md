### 缘起

中午一起去吃饭，都是十人左右，附近只有一家炒饭饭店，总是去这家店吃，每天中午吃什么是一个国际问题

某天吃饭的时候，讨论点什么菜，我提议可以做个系统。于是就在三月五号开始简单搭建一个系统。

我个人的想法三月五号，一天搞定，不去考虑代码的风格，异常，封装等，直接速成，毕竟这个不准备维护什么的。

实际上花费了周末两天时间才完成，包括测试修改Bug三小时

### 介绍

为了解决世纪难题---中午吃什么而开发出的一套随机点菜系统

可以根据菜的类型和个数及价格上限来随机出一份今日菜单

帮助选择困难症治愈点餐不纠结综合症

以后再也不担心女友问吃什么了（咦！我女朋友呢！原来我没有女朋友呀！）

### 一、系统需求

1. 最好图形化界面，方便操作
2. 最好饭店可扩展，菜单可添加
3. 最好随机点菜的种类要多样性
4. 最好有价格上限，人均

### 二、系统方案

#### 后端技术选型

JDK 11

MyBatis Plus

Spring Boot

MySQL

#### 前端技术选型

因为我的前端水平一般，只会简单Java script、JQuery、Html、CSS、Bootstrap 并不会 Vue、NodeJS等

我想要速成，就只有去看看前端有什么好的，几个小时的速成框架，当然知名的有很多都是Vue相关的，而我是打算以后花时间系统的去学习下Vue，现在只是想速成。而前几天看过3y的一篇公众号文章

[austin前端选型](https://mp.weixin.qq.com/s/CQirEDrxaglKxe8XJzi9jA)

他是采用的是一款百度开发的前端低代码JSON结构的框架叫做amis，几小时速成，那我也用这个。

[什么是 amis](https://aisuda.bce.baidu.com/amis/zh-CN/docs/index)

花了几个小时，看了下文档，基本上CRUD页面展示都可以做了

### 三、系统实现

#### 整体代码图

其中config包和webapp文件是多余的，目前没有用到登录功能

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313201436-hs1gk18.png)

#### 前端展示效果

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220306210619-57osw0c.png)

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313202534-fw2ph48.png)

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313202600-8xqhwcv.png)


#### 核心算法逻辑

核心算法就是随机点菜了，根据价格上限、肉、蛋、素、汤的个数来随机一份菜单出来

首先不考虑价格上限，随机出来一份菜单

然后判断总价格是否达到价格上限

若超过价格上限

找出价格最高的菜

判断菜的类型

若是肉菜（素蛋汤同样）

肉菜剩余菜单价格低于该价格的随机选择一个，移除剩余菜单中该菜

总价格减去上一个价格加上该菜价格

再次判断总价格是否大于上限

一直循环，若找不到比该肉价格更低的肉，则移除该菜，该菜的数量低于要求

知道价格满足价格上限，输出菜单、总价和人均

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313204357-hkb9oyr.png)

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220306210525-7di1lq2.png)<br />

**算法优化点**

可以判断价格上限与总价格的差值，在低于移除菜该差值的菜单里面选择一个就可以了，循环次数大大降低

不过刚想到的就先不优化了。

### 四、附加功能

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313211007-9sk44l0.png)

只需要在html页面末尾添加下面的代码就可以了

```html

<!--博客宠物-->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>

<!--博客宠物-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome/css/font-awesome.min.css">
<script src="https://cdn.jsdelivr.net/gh/lanedu/live2d-widget@master/v3/autoload.js"></script>

<script>
    if (screen.width >= 100) {
        Promise.all([
            loadExternalResource(live2d_path + "waifu.css", "css"),
            loadExternalResource(live2d_path + "live2d.min.js", "js"),
            loadExternalResource(live2d_path + "waifu-tips.js", "js")
        ]).then(() => {
            initWidget({
                waifuPath: live2d_path + "waifu-tips.json",
                apiPath: "https://live2d.fghrsh.net/api/",
                //cdnPath: "https://cdn.jsdelivr.net/gh/fghrsh/live2d_api/"
            });
        });
    }
</script>
<!-- <script src="https://myhkw.cn/api/player/demo" id="myhk" key="demo" m="1"></script> -->
<!--音乐播放器，如果不需要删除以下几行即可,id是网页版网易云歌单id -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/aplayer@1/dist/APlayer.min.css">
<script src="https://cdn.jsdelivr.net/npm/aplayer@1/dist/APlayer.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/meting@2.0.1/dist/Meting.min.js"></script>
<meting-js id="606641571" server="netease" type="playlist" theme="#339981" fixed="true"
           preload="auto" autoplay="false" loop="all" order="random" volume="0.3"></meting-js>
```

#### Live2d

![image.png](https://b3logfile.com/siyuan/1619927307428/assets/image-20220313213336-fgrmftp.png)

去年8月5号，思源笔记添加模板的时候添加的

[思源模板 Me 添加动态二次元角色 + 音乐播放器介绍](https://zhuanlan.zhihu.com/p/396791500)

[https://github.com/lanedu/live2d](https://github.com/lanedu/live2d)

#### 播放器

歌单为网易云找的一个古风歌单

[https://music.163.com/#/playlist?id=606641571](https://music.163.com/#/playlist?id=606641571)

### 结语

因为不准备维护，且准备一天速成的项目

没有添加分页、排序、查询、异常、历史表、状态、权重等等

感兴趣的可以fork 添加一些功能之后 pull request

欢迎大家 star，以后可以有机会装B，跟女朋友说，我半天给你开发出一套点餐系统了

GitHub地址为

[随机点菜系统](https://github.com/LaneDu/RandomMenu)

演示访问地址为（可能需要1分钟才能打开）

[随机点菜系统演示地址](http://81.68.211.196:8071/hello/index)