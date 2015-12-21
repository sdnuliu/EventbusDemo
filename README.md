# EventbusDemo
## Eventbus使用说明

### 1. 简单项目集成
		下载EventBus库：
		EvnetBus的下载地址：https://github.com/greenrobot/EventBus.git 		
		将EventBus.jar放入自己工程的libs目录即可
		定义一个事件，这个事件一旦被EventBus分发出去就是代表某一件事情发生了，这个事件就是某个观察者关心的事情(不需要继承任何类)
		定义观察者，然后将该观察者注册到EventBus
		由EventBus分发事件，告知观察者某一件事情发生了
		使用完成后从EventBus中反注册观察者。
		
###2. 四种订阅函数
		在EventBus中的观察者通常有四种订阅函数（就是某件事情发生被调用的方法）
		1、onEvent
		2、onEventMainThread
		3、onEventBackground	
		4、onEventAsync
		这四种订阅函数都是使用onEvent开头的，它们的功能稍有不同,在介绍不同之前先介绍两个概念：
		告知观察者事件发生时通过EventBus.post函数实现，这个过程叫做事件的发布，观察者被告知事件发生叫做事件的接收，是通过下面的订阅函数实现的。


		onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
		onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，所以在onEvnetMainThread方法中是不能执行耗时操作的。
		onEvnetBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，那么onEventBackground函数直接在该子线程中执行。
		onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.

###3. 改变优先级
		可以改变事件分发的顺序通过设置一个优先级在观察者注册到EventBus的时候
		int priority = 1;
		EventBus.getDefault().register(this, priority);
		默认priorty为0

		