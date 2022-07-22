### 测试代码高亮

```java
/**
* 查询评价 分页
*
* @param params 查询参数
* @return 评价 分页
*/
public PageResult<FuneralDiscuss> selectFuneralDiscussPageResult(FuneralDiscussPageDto params) {
    IPage<FuneralDiscuss> page = baseMapper.selectPage(params.buildPage(), commonWrapper(params));
    for (FuneralDiscuss record : page.getRecords()) {
        if (UserContext.getCurrentUser()!=null){
            AuthUser currentUser = Objects.requireNonNull(UserContext.getCurrentUser());
            FuneralSupportDiscuss one = funeralSupportDiscussService.getOne(new LambdaQueryWrapper<FuneralSupportDiscuss>()
                                                                            .eq(FuneralSupportDiscuss::getDiscussId, record.getId())
                                                                            .eq(FuneralSupportDiscuss::getUserId, currentUser.getId()));
            if (ObjectUtil.isNotEmpty(one)) {
                record.setIsAppreciate(1);
            }
            Member member = memberService.getById(record.getUserId());
            record.setUsername(member.getNickName());
            record.setFace(member.getFace());
        }
    }
    return new PageResult<FuneralDiscuss>(page);
}
```

