# Base on MVP Fromwork

关于**MVP**的介绍请参考：<http://kymjs.com/code/2015/11/09/01/>


## 目录
* 项目结构
* MVP使用说明
* 第三方库引用说明
* apk插件化实现说明
* 工具


### 项目结构

项目基于Android Studio创建，使用Gradle进行管理

#### Modules

- api: 模块用于实现接口的定义与实现
- biz: 模块依赖于api模块，用于实现业务逻辑并为view层提供方法
- model: 模块用于定义实体
- utils: 项目工具类模块

#### Application

- app: 项目主应用
- plugin: 项目插件应用