package cn.org.nf404.slide.common.model.request;

import cn.org.nf404.slide.common.utils.JsonHelper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @since 2019/2/25 下午1:40
 */
@SuppressWarnings("unused")
public abstract class AbstractRequest implements Serializable {
    private static final long serialVersionUID = 6315771537568073609L;

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private String remoteIp;

    public void checkParam() {
    }

    public OperationType getOperationType() {
        return from(this);
    }

    public Map<String, Object> toMap() {
        return JsonHelper.toMap(this);
    }


    private static OperationType from(AbstractRequest request) {
        Class<? extends AbstractRequest> aClass = request.getClass();
        String simpleName = aClass.getSimpleName();
        boolean isWrite = simpleName.indexOf("update") > 0
                || simpleName.indexOf("write") > 0
                || simpleName.indexOf("create") > 0
                || simpleName.indexOf("del") > 0
                || simpleName.indexOf("remove") > 0;


        return new OperationType() {

            @Override
            public String getDescription() {
                return simpleName;
            }

            @Override
            public String name() {
                return simpleName;
            }

            @Override
            public boolean isWrite() {
                return isWrite;
            }
        };
    }
}
