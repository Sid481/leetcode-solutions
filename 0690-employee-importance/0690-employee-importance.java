/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        boolean visited[] = new boolean[2001];
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        Employee employee = map.get(id);
        List<Integer> empList = employee.subordinates;
        dfs(id,visited,map);
        return sum;
    }
    public void dfs(int id, boolean[] visited, Map<Integer,Employee>map) {
        if(visited[id]) return;
        visited[id] = true;
        Employee employee = map.get(id);
        sum += employee.importance;
        for(int subId : employee.subordinates) {
                dfs(subId,visited,map);
            }
        }
}