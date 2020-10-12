package cn.org.nf404.slide.common.model.request;

/**
 * @author dx DingXing
 * @since 2020-01-01
 */
@SuppressWarnings("unused")
public interface OperationType {


    /**
     * 获得操作描述
     *
     * @return 操作描述
     */
    String getDescription();

    /**
     * 操作名
     *
     * @return 操作名
     */
    String name();

    /**
     * 是否写方法
     *
     * @return 是否写方法
     */
    boolean isWrite();
}
