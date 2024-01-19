import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestEntity {

    private String assistOrgId1;
    private String assistOrgName1;
    private String assistOrgId2;
    private String assistOrgName2;
    private String assistOrgId3;
    private String assistOrgName3;

    public String getAssistOrgId1() {
        return assistOrgId1;
    }

    public void setAssistOrgId1(String assistOrgId1) {
        this.assistOrgId1 = assistOrgId1;
    }

    public String getAssistOrgName1() {
        return assistOrgName1;
    }

    public void setAssistOrgName1(String assistOrgName1) {
        this.assistOrgName1 = assistOrgName1;
    }

    public String getAssistOrgId2() {
        return assistOrgId2;
    }

    public void setAssistOrgId2(String assistOrgId2) {
        this.assistOrgId2 = assistOrgId2;
    }

    public String getAssistOrgName2() {
        return assistOrgName2;
    }

    public void setAssistOrgName2(String assistOrgName2) {
        this.assistOrgName2 = assistOrgName2;
    }

    public String getAssistOrgId3() {
        return assistOrgId3;
    }

    public void setAssistOrgId3(String assistOrgId3) {
        this.assistOrgId3 = assistOrgId3;
    }

    public String getAssistOrgName3() {
        return assistOrgName3;
    }

    public void setAssistOrgName3(String assistOrgName3) {
        this.assistOrgName3 = assistOrgName3;
    }

    public static void main(String[] args) {
        List<TestEntity> list = new LinkedList<>();
        // 根据 AssistOrgId1 分组
        Map<String, List<TestEntity>> listMap =
            list.stream().collect(Collectors.groupingBy(TestEntity::getAssistOrgId1));
        // 声明返回结果

        // 封装返回结果
        for (Map.Entry<String, List<TestEntity>> id1EntrySet : listMap.entrySet()) {
            // 构造返回结果，封装跟节点属性

            // 根据 AssistOrgId2 分组
            Map<String, List<TestEntity>> id2Map =
                id1EntrySet.getValue().stream().collect(Collectors.groupingBy(TestEntity::getAssistOrgId2));
            // 封装 AssistOrgId2 属性

            // 遍历 id2Map.values()，封装 AssistOrgId3 属性

        }

    }
}
