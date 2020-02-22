# android-tiny-mvp
【Android Tiny系列】一种全方案解决内存泄漏的MVP架构

# 详细内容：
[TinyMVP：一种全方案解决内存泄漏的MVP架构](https://blog.csdn.net/ddnosh/article/details/101664677)

# 特点
## 使用泛型
使用泛型自动生成P层和M层实例;

## 减少接口
- 为了减少接口的泛滥，只在V层和P层之间定义接口；
- P层和M层之间只存在P层对M层的单向调用；
- M层专门用来获取数据，包括异步操作和耗时操作；
- M层返回Observable类型给P层；

## 生命周期导致的内存泄漏
- P层对V层的弱引用
- RxJava之Disposable
- RxJava之RxLifecycle
- RxJava之AutoDispose（推荐）
