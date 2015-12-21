
package test.eventbus.nqsky.com.eventbusdemo;


import java.util.List;

public class Event {
    /** 列表加载事件 */
    public static class ItemListEvent {
        private List<DummyContent.DummyItem> items;

        public ItemListEvent(List<DummyContent.DummyItem> items) {
            this.items = items;
        }

        public List<DummyContent.DummyItem> getItems() {
            return items;
        }
    }

    
}
