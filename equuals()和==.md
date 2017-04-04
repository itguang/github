
# equals 和 == 的问题

## str.equals(String string)

## obj == obj


```java
        // System.out.println(request.getSession().getAttribute("picCode"));
        //
        // System.out.println(formBean.getPicCode());

        if (!request.getSession().getAttribute("picCode").equals(formBean
                .getPicCode())) {

```