# MVP模式

1.
项目结构的组织方式是按照功能进行分模块的

2.
mvp分层的好处是：层与层之间的耦合性低，模块的复用性高，可维护性更好，每层可以单独存在，这样可测性更好。
数据流的走向可以是：view-->presenter-->model-->presenter-->view,这种数据流一般出现的场景是用户在界面触发了一个事件的情形下
数据流的走向也可以是：model-->presenter-->view，这种数据流一般出现于比如通过长链接接收消息的场景。
不管数据流是怎样的一个流动走向，始终有一个原则是：数据流不能跨层流动，即层与层不能跨层通信。view和model不能直接访问

3.
Model
model是整个应用或界面的数据加工处理厂，所谓数据加工厂就是对数据的获取，数据的解析，数据的存储，数据的分发，数据的增删改查等操作。
意思就是凡是涉及到数据操作都是在model进行的，所以model不仅仅只是实体类的集合，同时还包含关于数据的各种处理操作。
数据的数据源有三种：内存，磁盘（文件或数据库等），网络。
presenter从model中取数据，model接收presenter传递的数据后扔给三个数据源去处理。
所以model会把解析好的数据提供给上层，上层对于数据的来源完全是透明的，上层完全不需要关心数据到底是来自内存，还是磁盘甚至是网络。
同理上层只需要的把数据扔给model，上层唯一做的事情就是愉快的等待处理结果。

Presenter
首先presenter是处于mvp的中间层，在view和model中起一个承上启下的作用。
presenter会把view交给自己的命令进行一定的校验等操作交给model处理，会把model处理的结果交给view。
presenter不仅起一个桥梁的作用，它还会把业务逻辑代码给包揽下来。这样就可以减轻Activity的负担了，让Activity全心全意做它的view工作。
mvp中presenter负责对view进行刷新，比如从model获取的数据，presenter会根据获取的数据成功与否来通知view应该是显示成功界面还是失败界面。
这样就让Activity变的更轻了，这时候的presenter就有点主持人，掌控者的味道了。
presenter会持有这2种线程:ui线程,普通线程。刷新view时，它切换为ui线程进行刷新，从model取数据切换为普通线程。
presenter从model中获取的数据就是解析好的数据，不需要出现解析数据的代码。

View
mvp中的view是很省心的，比如更新view，接收数据。这些操作它都不需要操心，也不需要知道数据到底来自哪里，给我啥我显示啥就可以了。
一个view可以同时拥有多个presenter，也可以只有一个presenter。Activity，Fragment是作为view来使用的,各种Adapter是放在view层的。