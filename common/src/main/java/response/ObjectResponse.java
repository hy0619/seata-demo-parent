package response;

import enums.RspStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: heshouyou
 * @date: 2018-07-03 16:55
 */
@Data
@Accessors(chain = true)
public class ObjectResponse<T>  implements Serializable {

    private int status = RspStatusEnum.SUCCESS.getCode();

    private String message;
    private T data;

    public static ObjectResponse success(){
        return new ObjectResponse().setStatus(RspStatusEnum.SUCCESS.getCode())
                 .setMessage(RspStatusEnum.SUCCESS.getMessage());
    }
    public static  ObjectResponse success(Object data){
        return new ObjectResponse().setStatus(RspStatusEnum.SUCCESS.getCode())
                .setData(data)
                .setMessage(RspStatusEnum.SUCCESS.getMessage());
    }

    public static ObjectResponse fail(Object data){
        return new ObjectResponse().setStatus(RspStatusEnum.FAIL.getCode())
                .setData(data)
                .setMessage(RspStatusEnum.FAIL.getMessage());
    }

    public static ObjectResponse fail(){
        return new ObjectResponse().setStatus(RspStatusEnum.FAIL.getCode())
                .setMessage(RspStatusEnum.FAIL.getMessage());
    }
}
