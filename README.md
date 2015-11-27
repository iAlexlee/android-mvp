# Base on MVP Fromwork

关于**MVP**的介绍请参考：<http://kymjs.com/code/2015/11/09/01/>


## 目录
* 项目结构
* MVP实现
* 第三方库引用说明
* apk插件化实现说明
* 工具


## 项目结构
项目基于Android Studio创建，使用Gradle进行管理

![studio](http://7xlay8.com2.z0.glb.qiniucdn.com/QQ20151127-0.png)

#### Modules

- api	: 模块用于实现接口的定义与实现
- biz	: 模块依赖于api模块，用于实现业务逻辑并为view层提供方法
- model	: 模块用于定义实体
- utils	: 项目工具类模块

#### Application

- app	 	: 项目主应用，模块依赖于biz模块
- plugin	: 项目插件应用



## MVP实现

#### 使用目的

明确Activity(或Fragment)职责，将Activity(或Fragment)作为Presenter使用，把视图部分拆分出来，避免Activity(或Fragment)过于臃肿，难以维护。

#### app模块

![studio](http://7xlay8.com2.z0.glb.qiniucdn.com/QQ20151127-1.png)

- **BasePresenterActivity(BasePresenterFragment)**

	作为Presenter的基类来使用，所以Activity(或Fragment)均需要继承自该类。用于根视图的加载，处理Activity(或Fragment)生命周期。
	
- **AppViewDelegate**

	视图层基类，定义了视图初始化、获取视图组件、设置监听。
	
- **BaseActivity**

	继承自BasePresenterActivity，主要用于实现业务逻辑，无需关心视图的相关工作。
	
- **BaseView**

	继承自AppViewDelegate，实现视图的相关逻辑
	






